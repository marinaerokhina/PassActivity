package com.example.passactivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class AdminHomeActivity extends AppCompatActivity {
    String l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminhome);
        l = getIntent().getStringExtra("PersonLogin");
    }
}
