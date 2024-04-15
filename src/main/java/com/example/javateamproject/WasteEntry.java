package com.example.javateamproject;

import java.time.LocalDate;

public class WasteEntry {
    private int wasteID;
    private int ingredientsID;
    private double quantity;
    private String reason;
    private LocalDate dateLogged;

    public WasteEntry(int wasteID, int ingredientsID, double quantity, String reason, LocalDate dateLogged) {
        this.wasteID = wasteID;
        this.ingredientsID = ingredientsID;
        this.quantity = quantity;
        this.reason = reason;
        this.dateLogged = dateLogged;

    }
    // Getter methods
    public int getWasteID() {
        return wasteID;
    }

    public int getIngredientID() {
        return ingredientsID;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getReason() {
        return reason;
    }

    public LocalDate getDateLogged() {
        return dateLogged;
    }
}

