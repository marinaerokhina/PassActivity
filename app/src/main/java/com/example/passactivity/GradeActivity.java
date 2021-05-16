package com.example.passactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class GradeActivity extends AppCompatActivity {
    EditText edit;
    ArrayList<String> gradeList;
    DataBaseAdapter adapter;
    String l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);
        edit=findViewById(R.id.add);
        gradeList = new ArrayList<>();
        l = getIntent().getStringExtra("Person");
    }

    public void AddGrade(View view) {
        String grade;
        grade=edit.getText().toString();
        if (grade != null){
            gradeList.add(grade);
        } else {
            Toast.makeText(this, "@string/grades_error", Toast.LENGTH_LONG).show();
        }
    }

    public void FinishAdd(View view) {
        Person person = adapter.getPerson(l);
        person.setGrades(gradeList);
        Toast.makeText(this, "@string/grades_success", Toast.LENGTH_LONG).show();
        Intent intent = new Intent (GradeActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}