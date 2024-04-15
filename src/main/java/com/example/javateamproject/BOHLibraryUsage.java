package com.example.javateamproject;

import FinalInterTeamServices.BOH.BOHDataAccessor;
import FinalInterTeamServices.BOH.BOHFinalInterface;
import model.Ingredient;

import java.util.List;

 public class BOHLibraryUsage {
    public static void main(String[] args) {
        // Create an instance of the BOHDataAccessor
        BOHFinalInterface bohDataAccessor = new BOHDataAccessor();

        // Get the stock levels
        List<Ingredient> stockLevels = bohDataAccessor.getStockLevels();

        // Print the stock levels
        for (Ingredient ingredient : stockLevels) {
            System.out.println("Ingredient ID: " + ingredient.getIngredientID());
            System.out.println("Name: " + ingredient.getName());
            System.out.println("Cost: " + ingredient.getCost());
            System.out.println("Quantity: " + ingredient.getQuantity());
            System.out.println("Threshold: " + ingredient.getThreshold());
            System.out.println();
        }
    }
}

