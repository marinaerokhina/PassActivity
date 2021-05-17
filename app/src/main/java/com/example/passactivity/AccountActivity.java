package com.example.passactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AccountActivity extends AppCompatActivity {
    String l;
    EditText login, password, status, name, surname, grade, age;
    String p, st, n, s, g;
    int a;
    DataBaseAdapter dataBaseAdapter;
    Person person;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        l=getIntent().getStringExtra("login");
        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        status = findViewById(R.id.status);
        grade = findViewById(R.id.grade);
        age = findViewById(R.id.age);
        person = dataBaseAdapter.getPerson(l);
        p = person.getPassword();
        st = person.getStatus();
        n = person.getName();
        s = person.getSurname();
        g = person.getGrade();
        a = person.getAge();
        login.setText(l);
        password.setText(p);
        name.setText(n);
        surname.setText(s);
        status.setText(s);
        grade.setText(g);
        age.setText(a);
    }

    public void SaveAll(View view) {
        l=login.getText().toString();
        p=password.getText().toString();
        n=name.getText().toString();
        s=surname.getText().toString();
        st=status.getText().toString();
        g=grade.getText().toString();
        a=Integer.parseInt(age.getText().toString());
        person.setLogin(l);
        person.setPassword(p);
        person.setName(n);
        person.setSurname(s);
        person.setStatus(st);
        person.setGrade(g);
        person.setAge(a);
    }

    public void ShowGradeList(View view) {
        Intent intent = new Intent(getApplicationContext(), GradesActivity.class);
        intent.putExtra("Login", l);
        startActivity(intent);
    }

    public void ShowStudentsList(View view) {
        /*Intent intent = new Intent(getApplicationContext(), StudActivity.class);
        intent.putExtra("Login", l);
        startActivity(intent);*/
    }
}
