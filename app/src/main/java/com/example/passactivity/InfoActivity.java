package com.example.passactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {
    String l, req;
    ListView listView;
    EditText request;
    Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        listView = findViewById(R.id.list);
        request = findViewById(R.id.search_space);
        search = findViewById(R.id.bts_search);
        l = getIntent().getStringExtra("PersonLogin");
    }

    public void SearchPersons(View view) {
        req=request.getText().toString();
    }
}
