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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.victor.projetodiogo.R;

public class TaskListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        Intent teste = getIntent();
        String message = teste.getStringExtra("message");
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

        FloatingActionButton newTaskList = (FloatingActionButton) findViewById(R.id.newTaskListButton);
        newTaskList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TaskListActivity.this.createDialog();
            }
        });
    }

    private void createDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialog = inflater.inflate(R.layout.dialog_layout, null);
        dialogBuilder.setView(dialog);

        EditText editText = (EditText) dialog.findViewById(R.id.dialog_edit_text);
        TextView textView = (TextView) dialog.findViewById(R.id.dialog_text_view);

        dialogBuilder.setCancelable(true);
        editText.setHint("Nome da lista de tarefas");
        textView.setText("Nova lista de tarefas");
        dialogBuilder.setNegativeButton("Cancelar", null);
        dialogBuilder.setPositiveButton("Criar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

    }
}
