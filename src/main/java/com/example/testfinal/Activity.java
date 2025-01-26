package com.example.testfinal;


public class Activity {

    private String name;
    private int duration;
    private double caloriesBurned;
    private String date;

    public Activity(String name, int duration, double caloriesBurned, String date) {
        this.name = name;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public double getCaloriesBurned() {
        return caloriesBurned;
    }

    public String getDate() {
        return date;
    }
}

