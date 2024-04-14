package com.example.javateamproject;

import java.time.LocalDate;

public class users {

    int id;

    LocalDate weekStartDate;

    String name;


    public users(int id, LocalDate weekStartDate, String name) {
        this.id = id;
        this.weekStartDate = weekStartDate;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public LocalDate getWeekStartDate() {
        return weekStartDate;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWeekStartDate(LocalDate weekStartDate) {
        this.weekStartDate = weekStartDate;
    }

    public void setName(String name) {
        this.name = name;
    }
}
