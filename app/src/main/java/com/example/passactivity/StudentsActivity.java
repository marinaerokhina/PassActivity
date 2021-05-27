package com.example.passactivity;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
//Еще класс студентов
public class StudentsActivity extends AppCompatActivity {
    String g;
    int k=0;
    ListView listView;
    DataBaseAdapter adapter;
    List<Person> personList;
    ArrayAdapter<Person> personAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);
        g = getIntent().getStringExtra("Grade");
        listView = findViewById(R.id.students);
        personList = new ArrayList<Person>();
        try {
            adapter = new DataBaseAdapter(this);
            adapter.open();
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
                Toast.makeText(this, R.string.grade_error, Toast.LENGTH_LONG).show();
                adapter.close();
            }
        }catch (SQLException e) {

        }
    }
    protected void onDestroy() {
        super.onDestroy();
        adapter.close();
    }
}

