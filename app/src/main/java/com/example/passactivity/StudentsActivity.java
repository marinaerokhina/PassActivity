package com.example.passactivity;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class StudentsActivity extends AppCompatActivity {
    String g;
    int k=0;
    ListView listView;
    EditText request;
    DataBaseAdapter dbAdapter;
    List<Person> personList;
    SQLiteDatabase db;
    ArrayAdapter<Person> personAdapter;
    DataBaseHelper dataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);
        g = getIntent().getStringExtra("Grade");
        listView = findViewById(R.id.list);
        request = findViewById(R.id.search_space);
        personList = new ArrayList<Person>();
        dataBaseHelper = new DataBaseHelper(getApplicationContext());
        dataBaseHelper.create_db();
        try {
            DataBaseAdapter adapter = new DataBaseAdapter(this);
            adapter.open();
            db = dataBaseHelper.open();
            List<Person> personList = adapter.getPersons();
            for (int i = 0; i < personList.size(); i++) {
               if (personList.get(i).getGrade().equals(g)){
                   k++;
               } else {
                   personList.remove(i);
               }
            }
            if (k>0) {
                personAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, personList);
                listView.setAdapter(personAdapter);
                adapter.close();

            } else {
                Toast.makeText(this, "@string/grade_error", Toast.LENGTH_LONG).show();
                adapter.close();
            }
        }catch (SQLException e) {
        }
    }
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
}

