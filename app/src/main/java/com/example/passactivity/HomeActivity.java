package com.example.passactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    String l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        l = getIntent().getStringExtra("PersonLogin");
    }
   /* public void openTable(View view) {
        Intent intent = new Intent(HomeActivity.this,TableActivity.class);
        startActivity(intent);
    }*/

    public void openAccount(View view) {
       Intent intent = new Intent(HomeActivity.this, InfoActivity.class);
       intent.putExtra("PersonLogin", l);
       startActivity(intent);
    }

    public void openInf(View view) {
        Intent intent = new Intent(HomeActivity.this, InfActivity.class);
        intent.putExtra("PersonLogin", l);
        startActivity(intent);
    }

}

