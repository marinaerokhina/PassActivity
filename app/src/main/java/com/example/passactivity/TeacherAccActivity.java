package com.example.passactivity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TeacherAccActivity extends AppCompatActivity {
    String l;
    TextView login, password, status, name, surname, grade, age, warning;
    String p, st, n, s, g;
    int a;
    DataBaseAdapter dataBaseAdapter;
    Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acc);
        l = getIntent().getStringExtra("PersonLogin");
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
        warning.setText("@string/warning_change_params");
    }
}
