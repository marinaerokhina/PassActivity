package com.example.passactivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class InfActivity extends AppCompatActivity {
    String l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        l = getIntent().getStringExtra("PersonLogin");
    }
}
