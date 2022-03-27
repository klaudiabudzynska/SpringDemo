package com.example.demo;

public class UserEntity {
    public long Id;
    public String Name;
    public int Age;

    public UserEntity(long id, String name) {
        Id = id;
        Name = name;
    }

    public UserEntity(long id, String name, int age) {
        Id = id;
        Name = name;
        Age = age;
    }
}
