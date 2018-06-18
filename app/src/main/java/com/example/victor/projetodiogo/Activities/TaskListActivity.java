package com.example.victor.projetodiogo.Activities;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.victor.projetodiogo.Adapters.TaskListAdapter;
import com.example.victor.projetodiogo.Model.TaskList;
import com.example.victor.projetodiogo.Model.User;
import com.example.victor.projetodiogo.R;
import com.example.victor.projetodiogo.utils.DbOperations;

import org.json.JSONStringer;

import java.util.List;

import static android.widget.AdapterView.*;

public class TaskListActivity extends AppCompatActivity {
    ListView listView;
    TaskListAdapter listAdapter;
    DbOperations dbOperations;
    User currentUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        setCurrentUser();
        listView = (ListView) findViewById(R.id.task_list);
        FloatingActionButton newTaskList = (FloatingActionButton) findViewById(R.id.newTaskListButton);
        newTaskList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TaskListActivity.this.createDialog();
            }
        });
//        Colocar isso no adapter
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                adapterView.getItemAtPosition(0);
            }
        });
    }

    private void createDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialog = inflater.inflate(R.layout.dialog_layout, null);
        dialogBuilder.setView(dialog);

        final EditText editText = (EditText) dialog.findViewById(R.id.dialog_edit_text);
        TextView textView = (TextView) dialog.findViewById(R.id.dialog_text_view);

        dialogBuilder.setCancelable(true);
        editText.setHint("Ex: Lista de compras, tarefas de casa ...");
        textView.setText("Nova lista de tarefas");
        dialogBuilder.setNegativeButton("Cancelar", null);
        dialogBuilder.setPositiveButton("Criar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String taskListName = editText.getText().toString();

                final TaskList taskList = new TaskList(taskListName, TaskListActivity.this.currentUser.getUid());
                dbOperations = new DbOperations(TaskListActivity.this);
                dbOperations.saveTaskList(taskList, new DbOperations.DBOperationTaskListCallBack() {
                    @Override
                    public void taskListSaved(final Boolean success) {
                        TaskListActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (success) {
                                    listAdapter.add(taskList);
                                }
                            }
                        });
                    }

                    @Override
                    public void getAllTaskLists(List<TaskList> taskLists) {}
                });
            }
        });
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

    }

    private void getAllTasks() {

        dbOperations = new DbOperations(this);
        dbOperations.getUserTaskLists(this.currentUser.getUid(), new DbOperations.DBOperationTaskListCallBack() {
            @Override
            public void taskListSaved(Boolean success) {}

            @Override
            public void getAllTaskLists(final List<TaskList> taskLists) {
                TaskListActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (taskLists != null) {
                            listAdapter = new TaskListAdapter(TaskListActivity.this, 1, taskLists);
                            listView.setAdapter(listAdapter);
                        }
                    }
                });
            }
        });
    }

    private void setCurrentUser() {
        Intent intent = getIntent();
        String userEmail = intent.getStringExtra("email");
        String userPassword = intent.getStringExtra("password");

        dbOperations = new DbOperations(this);
        dbOperations.queryAuthenticatedUser(userEmail, userPassword, new DbOperations.DBOperationsCallBack() {
            @Override
            public void savedUser(Boolean success) {
            }

            @Override
            public void userExists(final Boolean exists, final User user) {
                TaskListActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (exists) {
                            currentUser = user;
                            TaskListActivity.this.getAllTasks();
                        } else {
                            String teste = "Legal";
                        }
                    }
                });
            }
        });
    }
}
