package com.example.passactivity;

import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class LoginActivity extends AppCompatActivity {
    TextView textview;
    EditText login;
    EditText password;
    Button btn;
    String LOGIN;
    String PASSWORD;
    String l;
    String p;
    DataBaseAdapter dataBaseAdapter;
    List<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        textview = findViewById(R.id.textview);
        btn = findViewById(R.id.btn);
        login = findViewById(R.id.Login);
        password = findViewById(R.id.Password);
        personList = new ArrayList<>();

    }

    public void CheckPerson(View view) {
        l = login.getText().toString();
        p = password.getText().toString();
        personList = dataBaseAdapter.getPersons();
        for (int i = 0; i <personList.size() ; i++) {


            if (l.equals(personList.get(i).getLogin()) && p.equals(personList.get(i).getPassword())) {
                Toast.makeText(this, R.string.log_success, Toast.LENGTH_LONG).show();
                if (personList.get(i).getStatus().equals(R.string.status3)){
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                intent.putExtra("PersonLogin", l);
                startActivity(intent);
                } else if (personList.get(i).getStatus().equals(R.string.status1)){
                    Intent intent = new Intent(LoginActivity.this, TeacherHomeActivity.class);
                    intent.putExtra("PersonLogin", l);
                    startActivity(intent);
                } else if(personList.get(i).getStatus().equals(R.string.status2)){
                    Intent intent = new Intent(LoginActivity.this, AdminHomeActivity.class);
                    intent.putExtra("PersonLogin", l);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, R.string.log_error3, Toast.LENGTH_LONG).show();
                }
            } else if (l == null || p == null) {
                textview.setText(R.string.log_error1);
            } else {
                textview.setText(R.string.log_error2);
            }
        }
    }


    public void onRegistrate(View view) {
        Intent intent = new Intent(LoginActivity.this, RegistActivity.class);
        startActivity(intent);
    }
}