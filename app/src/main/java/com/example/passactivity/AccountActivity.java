package com.example.passactivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AccountActivity extends AppCompatActivity {
    String l;
    EditText login, password, status, name, surname, grade, age;
    String p, st, n, s, g;
    String a;
    DataBaseAdapter dataBaseAdapter;
    Person person;
    DataBaseHelper dataBaseHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        l=getIntent().getStringExtra("login");
        dataBaseAdapter= new DataBaseAdapter(this);
        dataBaseHelper = new DataBaseHelper(getApplicationContext());
        dataBaseHelper.create_db();
        dataBaseAdapter.open();
        db = dataBaseHelper.open();
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
        a=age.getText().toString();
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dataBaseAdapter.close();
        db.close();
    }
}
