package com.example.testfinal;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Recipe {
    private SimpleStringProperty name;
    private SimpleStringProperty url;
    private SimpleIntegerProperty calories;

    public Recipe(String name, String url, int calories) {
        this.name = new SimpleStringProperty(name);
        this.url = new SimpleStringProperty(url);
        this.calories = new SimpleIntegerProperty(calories);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public String getUrl() {
        return url.get();
    }

    public void setUrl(String url) {
        this.url.set(url);
    }

    public SimpleStringProperty urlProperty() {
        return url;
    }

    public int getCalories() {
        return calories.get();
    }

    public void setCalories(int calories) {
        this.calories.set(calories);
    }

    public SimpleIntegerProperty caloriesProperty() {
        return calories;
    }
}



