package com.example.passactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
//Класс, предназначенный для подтверждения регистрации администратора
public class ConfirmActivity extends AppCompatActivity {
    EditText edit;
    String admin_code, editcode;
    String l;
    int k=0;
    DataBaseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        edit=findViewById(R.id.codeconf);
        l = getIntent().getStringExtra("Person");
        ConfirmCode confirmCode = new ConfirmCode();
        admin_code = confirmCode.getCode();
    }
//Метод проверки введенного кода и переход в активность входа в аккаунт при правильности введения кода
    public void ConfirmPerson(View view) {
        editcode= edit.getText().toString();
        if (editcode.equals(admin_code)){
            Toast.makeText(this, R.string.conf_success, Toast.LENGTH_LONG).show();
            k++;
            Intent intent = new Intent(ConfirmActivity.this, LoginActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, R.string.conf_error, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (k==0){
            adapter.delete(l);
        }
    }
}
