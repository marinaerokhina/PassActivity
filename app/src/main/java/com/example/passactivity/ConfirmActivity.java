package com.example.passactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmActivity extends AppCompatActivity {
    EditText edit;
    String admin_code="ADmIniSTRAtor", editcode;
    String l;
    DataBaseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        edit=findViewById(R.id.codeconf);
        l = getIntent().getStringExtra("Person");
    }

    public void ConfirmPerson(View view) {
        editcode= edit.getText().toString();
        if (editcode.equals(admin_code)){
            Toast.makeText(this, "@string/conf_success", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(ConfirmActivity.this, LoginActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "@string/conf_error", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        adapter.delete(l);
    }
}
