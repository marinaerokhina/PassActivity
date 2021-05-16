package com.example.passactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

public class EditCodeActivity extends AppCompatActivity {
    EditText editCode;
    String code;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_code);
        editCode = findViewById(R.id.edit);
    }

    public void SaveCode(View view) {
        code=editCode.getText().toString();
        ConfirmCode confirmCode = new ConfirmCode();
        confirmCode.setCode(code);
    }
}
