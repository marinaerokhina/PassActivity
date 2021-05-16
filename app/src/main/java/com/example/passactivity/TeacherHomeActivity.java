package com.example.passactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class TeacherHomeActivity extends AppCompatActivity {
    String l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teaherhome);
        l = getIntent().getStringExtra("PersonLogin");
    }

    public void openTeacherAccount(View view) {
        Intent intent = new Intent(TeacherHomeActivity.this, TeacherAccActivity.class);
        intent.putExtra("PersonLogin", l);
        startActivity(intent);
    }

    public void openTeacherInfo(View view) {
        Intent intent = new Intent(TeacherHomeActivity.this, TeacherInfoActivity.class);
        intent.putExtra("PersonLogin", l);
        startActivity(intent);
    }
}
