package com.example.save_information_firebase;

public class User {

    String name, lastName, city;

    public User(String name, String lastName, String city) {
        this.name = name;
        this.lastName = lastName;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }
}
