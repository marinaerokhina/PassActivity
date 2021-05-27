package com.example.passactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
//Класс с несколькими кнопками перехода в другие активности
public class AdminHomeActivity extends AppCompatActivity {
    String l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminhome);
        l = getIntent().getStringExtra("PersonLogin");
    }
//Переход в класс-аккаунт администратора
    public void openAdminAccount(View view) {
        Intent intent = new Intent(getApplicationContext(), AccountActivity.class);
        startActivity(intent);
    }
//Переход в класс с общей таблицей
    public void openAdminInf(View view) {
        Intent intent = new Intent(getApplicationContext(), TableActivity.class);
        startActivity(intent);
    }
//Переход в класс изменения кода подтверждения регистрации администратора
    public void editConfirmCode(View view) {
        Intent intent = new Intent(AdminHomeActivity.this, EditCodeActivity.class);
        startActivity(intent);
    }
}
