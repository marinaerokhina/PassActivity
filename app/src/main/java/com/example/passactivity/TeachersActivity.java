package com.example.passactivity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TeachersActivity extends AppCompatActivity {
    String g;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers);
        g = getIntent().getStringExtra("PersonGrade");
    }
}
