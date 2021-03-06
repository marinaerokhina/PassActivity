package com.example.passactivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DataBaseAdapter {
    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase database;
//При объявлении адаптера также объявляется хелпер
    public DataBaseAdapter(Context context) {
        dataBaseHelper = new DataBaseHelper(context.getApplicationContext());
    }
//метод открытия адаптера и хелпера
    public DataBaseAdapter open() {
        database = dataBaseHelper.open();
        return this;
    }
//Метод, обратный вышеописанному методу
    public void close() {
        dataBaseHelper.close();
    }
//Метод, возвращающий количество записей в таблице
    public long getCount() {
        return DatabaseUtils.queryNumEntries(database, DataBaseHelper.TABLE);
    }
//Метод, возвращающий поля таблицу у одной персоны
    private Cursor getAllElements() {
        String[] columns = new String[]{DataBaseHelper.COLUMN_LOGIN, DataBaseHelper.COLUMN_PASSWORD, DataBaseHelper.COLUMN_NAME, DataBaseHelper.COLUMN_SURNAME,
                DataBaseHelper.COLUMN_STATUS, DataBaseHelper.COLUMN_GRADE, DataBaseHelper.COLUMN_AGE};
        return database.query(DataBaseHelper.TABLE, columns, null, null, null, null, null);
    }
//Метод добавления персоны в таблицу
    public long insert(Person person) {
        ContentValues cv = new ContentValues();
        cv.put(DataBaseHelper.COLUMN_LOGIN, person.getLogin());
        cv.put(DataBaseHelper.COLUMN_PASSWORD, person.getPassword());
        cv.put(DataBaseHelper.COLUMN_NAME, person.getName());
        cv.put(DataBaseHelper.COLUMN_SURNAME, person.getSurname());
        cv.put(DataBaseHelper.COLUMN_STATUS, person.getStatus());
        cv.put(DataBaseHelper.COLUMN_GRADE, person.getGrade());
        cv.put(DataBaseHelper.COLUMN_AGE, person.getAge());
        return database.insert(DataBaseHelper.TABLE, null, cv);
    }
//Метод удаления персоны из таблицы
    public long delete(String personLogin) {
        String whereClause = "login = ?";
        String[] whereArgs = new String[]{String.valueOf(personLogin)};
        return database.delete(DataBaseHelper.TABLE, whereClause, whereArgs);
    }
//Метод обновления значений полей у персоны
    public long update(Person person) {
        String whereClause = DataBaseHelper.COLUMN_LOGIN + "=" + String.valueOf(person.getLogin());
        ContentValues cv = new ContentValues();
        cv.put(DataBaseHelper.COLUMN_NAME, person.getName());
        cv.put(DataBaseHelper.COLUMN_SURNAME, person.getSurname());
        cv.put(DataBaseHelper.COLUMN_STATUS, person.getStatus());
        cv.put(DataBaseHelper.COLUMN_GRADE, person.getGrade());
        cv.put(DataBaseHelper.COLUMN_AGE, person.getAge());
        return database.update(DataBaseHelper.TABLE, cv, whereClause, null);
    }
//Метод, возвращающий массив персон из таблицы
    public List<Person> getPersons() {
        ArrayList<Person> persons  = new ArrayList<>();
        Cursor cursor = getAllElements();
        while (cursor.moveToNext()) {
            String login = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_LOGIN));
            String password = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_PASSWORD));
            String name = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_NAME));
            String surname = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_SURNAME));
            String status = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_STATUS));
            String grade = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_GRADE));
            String age = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_AGE));
            persons.add(new Person(login, password, name, surname, status, grade, age));
        }
        cursor.close();
        return  persons;
    }
//Метод, возвращаюший одну персону из таблицы
    public Person getPerson(String login) {
        Person person = null;
        String query = String.format("SELECT * FROM %s WHERE %s=?", DataBaseHelper.TABLE, DataBaseHelper.COLUMN_LOGIN);
        Cursor cursor = database.rawQuery(query, new String[]{String.valueOf(login)});
        if (cursor.moveToFirst()) {
            //String login = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_LOGIN));;
            String name = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_NAME));
            String surname = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_SURNAME));
            String password = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_PASSWORD));
            String status = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_STATUS));
            String grade = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_GRADE));
            String age = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_AGE));

            person = new Person(login, password, name, surname, status, grade, age);
        }
        cursor.close();
        return  person;
    }
}