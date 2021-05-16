package com.example.passactivity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class AccActivity extends AppCompatActivity {
    String l;
    TextView login, password, status, name, surname, grade, age, warning;
    String p, st, n, s, g;
    int a;
    DataBaseAdapter dataBaseAdapter;
    List<Person> personList;
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
        personList = new ArrayList<>();
        personList = dataBaseAdapter.getPersons();
        for (int i = 0; i <personList.size() ; i++) {
            if (l.equals(personList.get(i).getLogin())) {
                p = personList.get(i).getPassword();
                st = personList.get(i).getStatus();
                n = personList.get(i).getName();
                s = personList.get(i).getSurname();
                g = personList.get(i).getGrade();
                a = personList.get(i).getAge();
            }
        }
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
