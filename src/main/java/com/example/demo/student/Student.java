package com.example.demo.student;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Student {

    protected String id;
    protected String username;
    protected int age;
    protected String email;
    protected Date dateOfBirth;

    public Student(){

    }

    public Student(String username,String email,int age,Date DOB){
        this.username = username;
        this.email = email;
        this.age = age;
        this.dateOfBirth = DOB;
    }

    public Student(
            @JsonProperty("userID") String userID,
            @JsonProperty("username") String username,
            @JsonProperty("email") String email,
            @JsonProperty("age") int age,
            @JsonProperty("DOB") Date DOB) {
        this.id = userID;
        this.username = username;
        this.email = email;
        this.age = age;
        this.dateOfBirth = DOB;
    }




}
