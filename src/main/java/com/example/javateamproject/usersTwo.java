package com.example.javateamproject;

public class usersTwo {
    int id;
    String foodName;

    int idTwo;

    int prepTime;

    public usersTwo(int id, String foodName, int idTwo, int prepTime) {
        this.id = id;
        this.foodName = foodName;
        this.idTwo = idTwo;
        this.prepTime = prepTime;
    }

    public int getId() {
        return id;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getIdTwo() {
        return idTwo;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setIdTwo(int idTwo) {
        this.idTwo = idTwo;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }
}
