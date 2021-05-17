package com.example.passactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ChoiceActivity  extends AppCompatActivity {
    String g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        g=getIntent().getStringExtra("Grade");
    }

    public void ShowStudentsList(View view) {
        Toast.makeText(this, "@string/temp_text", Toast.LENGTH_LONG).show();
    }

    public void ChangeGrade(View view) {
        Toast.makeText(this, "@string/temp_text", Toast.LENGTH_LONG).show();
    }
}
