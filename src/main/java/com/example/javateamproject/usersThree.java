package com.example.javateamproject;

import java.time.LocalDate;

public class usersThree {
    int id;

    LocalDate date;

    String name;

    String role;

    public usersThree(int id, LocalDate date, String name, String role) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
