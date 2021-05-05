package com.example.passactivity;

import android.widget.EditText;

public class Person {
    private String Login;
    private String Password;
    private String Name;
    private String Surname;
    private String Status;
    private String Grade;
    private int Age;

    public Person(String login, String password, String name, String surname, String status, String grade, int age) {
        Login = login;
        Password = password;
        Name = name;
        Surname = surname;
        Status = status;
        Grade = grade;
        Age = age;
    }

    public Person() {
    }

    public void setName(String name) {
        Name = name;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public String getStatus() {
        return Status;
    }

    public String getLogin() {
        return Login;
    }

    public String getPassword() {
        return Password;
    }

    public int getAge() {
        return Age;
    }

    public String getGrade() {
        return Grade;
    }
}
