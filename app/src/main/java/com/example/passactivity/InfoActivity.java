package com.example.passactivity;

import android.content.Intent;
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
//Класс с таблицей и возможностью поиска
public class InfoActivity extends AppCompatActivity {
    String l, req;
    ListView listView;
    EditText request;
    Button search;
    DataBaseAdapter adapter;
    List<Person> personList;
    ArrayAdapter<Person> personAdapter;
    DataBaseAdapter dataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        listView = findViewById(R.id.list);
        request = findViewById(R.id.search_space);
        search = findViewById(R.id.bts_search);
        l = getIntent().getStringExtra("PersonLogin");
        personList = new ArrayList<Person>();
        dataBaseAdapter= new DataBaseAdapter(this);
        dataBaseAdapter.open();

    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            adapter = new DataBaseAdapter(this);
            adapter.open();
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
        dataBaseAdapter.close();
    }
//Метод поиска персон по запросу. Запрос выполняется, если слово в запросе полностью соответствует данным в запросе
    public void SearchPersons(View view) {
        req=request.getText().toString();
        int k=0;
        try {
            adapter = new DataBaseAdapter(this);
            adapter.open();
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