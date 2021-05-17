package com.example.passactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GradesActivity extends AppCompatActivity {
    String l;
    ListView listgrades;
    ArrayList<String> grades = new ArrayList<>();
    DataBaseAdapter dataBaseAdapter;
    Person person;
    ArrayAdapter<String> gradeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades);
        l=getIntent().getStringExtra("Login");
        listgrades = findViewById(R.id.Grades);
        grades = person.getGrades();
        gradeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,grades);
        listgrades.setAdapter(gradeAdapter);
       /* listgrades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Grade = gradeAdapter.getItem(position);
                Intent intent = new Intent(getApplicationContext(), EditGradeActivity.class);
                intent.putExtra("Grade", position);
                startActivity(intent);
            }
        });*/
    }
}
