package com.example.passactivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class TeacherAccActivity extends AppCompatActivity {
    String l;
    TextView login, password, status, name, surname, age, warning;
    String p, st, n, s;
    String a;
    ListView listgrades;
    ArrayList<String> grades = new ArrayList<>();
    DataBaseAdapter dataBaseAdapter;
    Person person;
    ArrayAdapter<String> gradeAdapter;
    DataBaseHelper dataBaseHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teaheracc);
        l = getIntent().getStringExtra("PersonLogin");
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
        warning.setText(R.string.warning_change_params);
        listgrades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Grade = gradeAdapter.getItem(position);
                Intent intent = new Intent(getApplicationContext(), StudentsActivity.class);
                intent.putExtra("Grade", Grade);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dataBaseAdapter.close();
        db.close();
    }
}
