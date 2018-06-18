package com.example.victor.projetodiogo.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.victor.projetodiogo.Model.User;
import com.example.victor.projetodiogo.R;
import com.example.victor.projetodiogo.utils.DbOperations;
import com.facebook.stetho.Stetho;

public class MainActivity extends AppCompatActivity {
    EditText emailEditText;
    EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Stetho.initializeWithDefaults(this);
    }

    public void goToCadastro(View view) {
        Intent goCadastro = new Intent(this, CadastroActivity.class);
        startActivity(goCadastro);
    }

    public void login(View view) {
        emailEditText = (EditText) findViewById(R.id.emailEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        DbOperations dbOperations = new DbOperations(this);
        String userEmail = emailEditText.getText().toString();
        String userPassword = passwordEditText.getText().toString();
        dbOperations.queryAuthenticatedUser(userEmail, userPassword, new DbOperations.DBOperationsCallBack() {
            @Override
            public void savedUser(Boolean success) {
            }

            @Override
            public void userExists(final Boolean exists, final User user) {
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (exists) {
                            Intent goToTaskList = new Intent(MainActivity.this, TaskListActivity.class);
                            goToTaskList.putExtra("userId", user.getEmail());
                            goToTaskList.putExtra("password", user.getEncryptedPassword());
                            startActivity(goToTaskList);
                            finish();
                        }else {
                            Toast.makeText(MainActivity.this, "Email ou senha não cadastrado", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
