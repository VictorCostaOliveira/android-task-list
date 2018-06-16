package com.example.victor.projetodiogo.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.victor.projetodiogo.Model.User;
import com.example.victor.projetodiogo.R;
import com.example.victor.projetodiogo.utils.DbOperations;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Button saveUserButton = (Button) findViewById(R.id.saveUserButton);
        saveUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText userNameEditText = (EditText) findViewById(R.id.inputNome);
                EditText userEmailEditText = (EditText) findViewById(R.id.inputEmail);
                EditText userPasswordEditText = (EditText) findViewById(R.id.inputPassword);
                String userName = userNameEditText.getText().toString();
                String userEmail = userEmailEditText.getText().toString();
                String userPassword = userPasswordEditText.getText().toString();

                final User newUser = new User(userName, userPassword, userEmail);

                DbOperations dbOperations = new DbOperations(CadastroActivity.this);
                if (inputValid(userName, userEmail, userPassword)) {
                    dbOperations.saveUser(newUser, new DbOperations.DBOperationsCallBack() {
                        @Override
                        public void savedUser(final Boolean success) {
                            CadastroActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (success) {
                                        Intent goToTaskList = new Intent(CadastroActivity.this, TaskListActivity.class);
                                        startActivity(goToTaskList);
                                        finish();
                                        goToTaskList.putExtra("message", "Bem vindo " + newUser.getUsername());
//                                        Toast.makeText(CadastroActivity.this, "Usuario cadastrado", Toast.LENGTH_LONG).show();
                                    }else {
                                        Toast.makeText(CadastroActivity.this, "Algo deu errado", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }

                        @Override
                        public void userExists(final Boolean exists, final User user) {
                            CadastroActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (exists) {
                                        Toast.makeText(CadastroActivity.this, "Usuario já existe!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                    });
                }else {
                    Toast.makeText(CadastroActivity.this, "Campo não podem ficar em branco", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private boolean inputValid(String nome, String email, String senha) {
        return (!nome.isEmpty() || !nome.equals("")) && (!email.isEmpty() && !email.equals("")) && (!senha.isEmpty() && !senha.equals(""));
    }
}
