package com.example.passactivity;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
//Это был класс, кторый выводил список классов для учителя, но над реализацией еще надо полумать

public class GradesActivity extends AppCompatActivity {
  /*  String l;
    ListView listgrades;
    SQLiteDatabase db;
    ArrayList<Person> persons = new ArrayList<>();
    ArrayList<String> grades = new ArrayList<>();
    DataBaseAdapter dataBaseAdapter;
    Person person;
    ArrayAdapter<Person> personAdapter;
    DataBaseHelper dataBaseHelper;
    ArrayAdapter<String> gradeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades);
        l=getIntent().getStringExtra("Login");
        dataBaseHelper = new DataBaseHelper(getApplicationContext());
        dataBaseHelper.create_db();
        try {
            dataBaseAdapter = new DataBaseAdapter(this);
            dataBaseAdapter.open();
            db = dataBaseHelper.open();
            persons = (ArrayList<Person>) dataBaseAdapter.getPersons();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < persons.size(); i++) {
            if(l.equals(persons.get(i).getLogin())){
                person=persons.get(i);
            }
        }
        listgrades = findViewById(R.id.Grades);
        grades = person.getGrades();
        gradeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,grades);
        listgrades.setAdapter(gradeAdapter);
        listgrades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Grade = gradeAdapter.getItem(position);
                Intent intent = new Intent(getApplicationContext(), ChoiceActivity.class);/*EditGradeActivity.class);*/
 /*               intent.putExtra("Grade", Grade);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }*/
}
