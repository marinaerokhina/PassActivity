package com.example.passactivity;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class TeacherInfoActivity extends AppCompatActivity {
    String l, req;
    ListView listView;
    EditText request;
    Button search;
    DataBaseAdapter dbAdapter;
    List<Person> personList;
    SQLiteDatabase db;
    ArrayAdapter<Person> personAdapter;
    DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacherinfo);
        listView = findViewById(R.id.list);
        request = findViewById(R.id.search_space);
        search = findViewById(R.id.bts_search);
        l = getIntent().getStringExtra("PersonLogin");
        personList = new ArrayList<Person>();
        dataBaseHelper = new DataBaseHelper(getApplicationContext());
        dataBaseHelper.create_db();

    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            DataBaseAdapter adapter = new DataBaseAdapter(this);
            adapter.open();
            db = dataBaseHelper.open();
            List<Person> personList = adapter.getPersons();
            personAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, personList);
            listView.setAdapter(personAdapter);
            adapter.close();
        } catch (SQLException e) {
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }

    public void SearchPersons(View view) {
        req=request.getText().toString();
        int k=0;
        try {
            DataBaseAdapter adapter = new DataBaseAdapter(this);
            adapter.open();
            db = dataBaseHelper.open();
            List<Person> personList = adapter.getPersons();
            for (int i = 0; i < personList.size(); i++) {
                if (req.equals(personList.get(i).getName()) || req.equals(personList.get(i).getSurname()) || req.equals(personList.get(i).getStatus()) || req.equals(personList.get(i).getGrade())) {
                    k++;
                } else {
                    personList.remove(i);
                }
            }
            if (k>0) {
                Toast.makeText(this, R.string.search_success, Toast.LENGTH_LONG).show();
                personAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, personList);
                listView.setAdapter(personAdapter);
                adapter.close();

            } else {
                Toast.makeText(this, R.string.search_error, Toast.LENGTH_LONG).show();
                adapter.close();
            }
        }catch (SQLException e) {
        }
    }
}
