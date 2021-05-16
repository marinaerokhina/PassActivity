package com.example.passactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdminHomeActivity extends AppCompatActivity {
    String l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminhome);
        l = getIntent().getStringExtra("PersonLogin");
    }

    public void openAdminAccount(View view) {
        Toast.makeText(this, "@string/temp_text", Toast.LENGTH_LONG).show();
    }

    public void openAdminInf(View view) {
        Toast.makeText(this, "@string/temp_text", Toast.LENGTH_LONG).show();
    }

    public void editConfirmCode(View view) {
        Intent intent = new Intent(AdminHomeActivity.this, EditCodeActivity.class);
        startActivity(intent);
    }
}
