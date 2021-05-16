package com.example.passactivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class TeacherAccActivity extends AppCompatActivity {
    String l;
    TextView login, password, status, name, surname, age, warning;
    String p, st, n, s;
    int a;
    ListView listgrades;
    ArrayList<String> grades = new ArrayList<>();
    DataBaseAdapter dataBaseAdapter;
    Person person;
    ArrayAdapter<String> gradeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teaheracc);
        l = getIntent().getStringExtra("PersonLogin");
        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        status = findViewById(R.id.status);
        listgrades = findViewById(R.id.grades);
        age = findViewById(R.id.age);
        warning = findViewById(R.id.warning);
        person = dataBaseAdapter.getPerson(l);
        p = person.getPassword();
        st = person.getStatus();
        n = person.getName();
        s = person.getSurname();
        a = person.getAge();
        grades = person.getGrades();
        gradeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,grades);
        login.setText(l);
        password.setText(p);
        name.setText(n);
        surname.setText(s);
        status.setText(s);
        listgrades.setAdapter(gradeAdapter);
        age.setText(a);
        warning.setText("@string/warning_change_params");
    }
}
