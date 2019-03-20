package com.example.davidschriver.recyclerassignment.model;

import java.util.LinkedList;

public class Recipe {
    public Recipe(String name, String description, String image, String ingredients, String directions) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.ingredients = ingredients;
        this.directions = directions;
    }

    public String name;
    public String description;
    public String image;
    public String ingredients;
    public String directions;


    //Have to get the recipies somehow.
    public static LinkedList<Recipe> getRecipes()
    {
        return DataProvider.getRecipes();
    }

    //This could come in handy. This method is used to display objects in lists
    @Override
    public String toString()
    {
        return name;
    }
}