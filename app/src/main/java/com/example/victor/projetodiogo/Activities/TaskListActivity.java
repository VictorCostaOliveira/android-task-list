package com.example.victor.projetodiogo.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        TextView texteView = (TextView) findViewById(R.id.teste);
        texteView.setText("Texto legal");
    }
}
