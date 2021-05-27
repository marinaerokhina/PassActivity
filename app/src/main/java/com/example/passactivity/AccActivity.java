package com.example.passactivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
//Класс-аккаунт, показывает данные пользователя
public class AccActivity extends AppCompatActivity {
    String l;
    TextView login, password, status, name, surname, grade, age, warning;
    String p, st, n, s, g;
    String a;
    DataBaseAdapter dataBaseAdapter;
    Person person;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acc);
        l = getIntent().getStringExtra("PersonLogin");
        dataBaseAdapter= new DataBaseAdapter(this);
        dataBaseAdapter.open();
        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        status = findViewById(R.id.status);
        grade = findViewById(R.id.grade);
        age = findViewById(R.id.age);
        warning = findViewById(R.id.warning);
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
        warning.setText(R.string.warning_change_params);
    }

    public void ShowTeacherList(View view) {
        /*Intent intent = new Intent (getApplicationContext(), TeachersActivity.class);
        intent.putExtra("PersonGrade", g);
        startActivity(intent);*/
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        dataBaseAdapter.close();
    }
}