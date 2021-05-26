package com.example.passactivity;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class TeachersActivity extends AppCompatActivity {
    String g;
    int k=0, l=0;
    ListView listView;
    DataBaseAdapter adapter;
    List<Person> personList;
    ArrayList<String> gradeList;
    ArrayAdapter<Person> personAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers);
        g = getIntent().getStringExtra("PersonGrade");
        listView = findViewById(R.id.teachers);
        personList = new ArrayList<Person>();
       /* gradeList = new ArrayList<String>();*/
        try {
            adapter = new DataBaseAdapter(this);
            adapter.open();
           /* List<Person> personList = adapter.getPersons();
            for (int i = 0; i < personList.size(); i++) {
                gradeList = personList.get(i).getGrades();
                l=0;
                for (int j = 0; j < gradeList.size(); j++) {
                    if (gradeList.get(j).equals(g)){
                        l++;
                    } else {
                        gradeList.remove(j);
                    }
                }
                if (l!=0){
                    k++;
                } else {
                    personList.remove(i);
                }
            }*/

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
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}