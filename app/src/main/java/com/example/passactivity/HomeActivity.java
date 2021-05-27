package com.example.passactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
//Класс-переход для пользовтелей со статусом Student
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
//Переход на класс с информацией о пользователе
    public void openAccount(View view) {
       Intent intent = new Intent(HomeActivity.this, AccActivity.class);
       intent.putExtra("PersonLogin", l);
       startActivity(intent);
    }
//Переход на класс с таблицей
    public void openInfo(View view) {
        Intent intent = new Intent(HomeActivity.this, InfoActivity.class);
        intent.putExtra("PersonLogin", l);
        startActivity(intent);
    }

}

