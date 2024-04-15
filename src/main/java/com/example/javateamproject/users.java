package com.example.javateamproject;

import java.time.LocalDate;


public class users{
    int id;

    String foodName;

    String description;

    String name;

    String status;

    public users(int id, String foodName, String description, String name, String status) {
        this.id = id;
        this.foodName = foodName;
        this.description = description;
        this.name = name;
        this.status = status;
    }


    public int getId() {
        return id;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}