package com.example.passactivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.passactivity.DataBaseAdapter;
import com.example.passactivity.LoginActivity;
import com.example.passactivity.Person;
import com.example.passactivity.R;
//Класс регистрации персоны
public class RegistActivity extends AppCompatActivity {
    EditText name, surname, status, login, password, age, grade;
    DataBaseAdapter dbAdapter;
    Person person;
    //final  static String LOG_TAG = "MYLOG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        name = findViewById(R.id.Name);
        surname = findViewById(R.id.Surname);
        status = findViewById(R.id.Status);
        login = findViewById(R.id.Login);
        password = findViewById(R.id.Password);
        age = findViewById(R.id.Age);
        grade = findViewById(R.id.Grade);
        dbAdapter= new DataBaseAdapter(this);
        dbAdapter.open();
    }
//Метод регистрации персоны
    public void onRegistration(View view) {
        String Name = name.getText().toString();
        String Password = password.getText().toString();
        String Surname = surname.getText().toString();
        String Status = status.getText().toString();
        String Login = login.getText().toString();
        String Grade = grade.getText().toString();
        String Age = age.getText().toString();

        person = new Person();
        try {
            person.setLogin(Login);
            person.setPassword(Password);
            person.setName(Name);
            person.setSurname(Surname);
            person.setStatus(Status);
            person.setGrade(Grade);
            person.setAge(Age);
        } catch (Exception e){
            Toast.makeText(this, R.string.reg_error, Toast.LENGTH_LONG).show();
        }
      /*  if (Name != null) {
            person.setName(Name);
            cnt++;
        } else {
            Toast.makeText(this, "@string/name_error", Toast.LENGTH_LONG).show();
        }
        if (Surname != null) {
            person.setSurname(Surname);
            cnt++;
        } else {
            Toast.makeText(this, "@string/surname_error", Toast.LENGTH_LONG).show();
        }

        if (Status.equals("@string/status1") || Status.equals("@string/status2") || Status.equals("@string/status")) {
            person.setStatus(Status);
            cnt++;
        } else {
            Toast.makeText(this, "@string/status_error", Toast.LENGTH_LONG).show();
        }
        if (Login != null) {
            person.setLogin(Login);
            cnt++;
        } else {
            Toast.makeText(this, "@string/login_error", Toast.LENGTH_LONG).show();
        }
        if (Password != null) {
            person.setPassword(Password);
            cnt++;
        } else {
            Toast.makeText(this, "@string/password_error", Toast.LENGTH_LONG).show();
        }
        if (Age <= 0) {
            Toast.makeText(this, "@string/age_error1", Toast.LENGTH_LONG).show();
        } else if (age1 != null) {
            person.setAge(Age);
            cnt++;
        } else {
            Toast.makeText(this, "@string/age_error2", Toast.LENGTH_LONG).show();
        }
        if ((Integer.parseInt(Grade) <= 0)&&(Integer.parseInt(Grade) > 11)) {
            Toast.makeText(this, "@string/grade_error1", Toast.LENGTH_LONG).show();
        } else if ((Status.equals("@string/status1") || Status.equals("@string/status2"))&& (Grade ==null )){
            person.setGrade(null);
            cnt++;
        } else if ((Status.equals("@string/status3")) && (Grade != null)) {
            person.setGrade(Grade);
            cnt++;
        } else {
            Toast.makeText(this, "@string/grade_error2", Toast.LENGTH_LONG).show();
        }*/
        //Log.d(LOG_TAG,);
        Toast.makeText(this, "PERSON " + person.toString(), Toast.LENGTH_LONG).show();
        Toast.makeText(this, R.string.reg_success, Toast.LENGTH_LONG).show();
        if (person.getStatus().equals(getResources().getString(R.string.status1))){
            dbAdapter.insert(person);
            Intent intent = new Intent(RegistActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        } else if (person.getStatus().equals(getResources().getString(R.string.status3))){
            dbAdapter.insert(person);
            Intent intent = new Intent(RegistActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        } else {


            dbAdapter.insert(person);
            Intent intent = new Intent(RegistActivity.this, ConfirmActivity.class);
            intent.putExtra("Person", person.getLogin());
            startActivity(intent);
            finish();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbAdapter.close();
    }
}