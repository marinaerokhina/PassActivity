package com.example.passactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
//Это тоже класс-переход
public class ChoiceActivity  extends AppCompatActivity {
    String g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        g=getIntent().getStringExtra("Grade");
    }
//Это переход к классу со списком студентов
    public void ShowStudentsList(View view) {
        Toast.makeText(this, R.string.temp_text, Toast.LENGTH_LONG).show();
    }
//Это была возможность перейти в класс изменения списка классов
    public void ChangeGrade(View view) {
        Toast.makeText(this, R.string.temp_text, Toast.LENGTH_LONG).show();
    }
}
