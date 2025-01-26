package com.example.testfinal;

public class Meal {
    private String name;
    private int calories;
    private String url;
    private String imageUrl;

    public Meal(String name, int calories, String url, String imageUrl) {
        this.name = name;
        this.calories = calories;
        this.url = url;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public String getUrl() {
        return url;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}

