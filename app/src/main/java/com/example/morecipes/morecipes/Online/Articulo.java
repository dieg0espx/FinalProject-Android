package com.example.morecipes.morecipes.Online;

public class Articulo {

    private String dishname;
    private String ingredients;
    private String steps;

    public Articulo() {

    }

    public Articulo(String dishname, String ingredients, String steps) {
        this.dishname = dishname;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public String getDishname() {
        return dishname;
    }

    public void setDisname(String disname) {
        this.dishname = disname;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }
}
