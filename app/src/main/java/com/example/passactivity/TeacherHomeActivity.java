package com.example.passactivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class TeacherHomeActivity extends AppCompatActivity {
    String l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teaherhome);
        l = getIntent().getStringExtra("PersonLogin");
    }
}
