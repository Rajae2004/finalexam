package com.example.testfinal;

public class User {
    private String username;
    private String password;
    private double weight;
    private double height;
    private String sex;
    private double desiredWeight;

    public User(String username, String password, double weight, double height, String sex, double desiredWeight) {
        this.username = username;
        this.password = password;
        this.weight = weight;
        this.height = height;
        this.sex = sex;
        this.desiredWeight = desiredWeight;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getDesiredWeight() {
        return desiredWeight;
    }

    public void setDesiredWeight(double desiredWeight) {
        this.desiredWeight = desiredWeight;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", sex='" + sex + '\'' +
                ", desiredWeight=" + desiredWeight +
                '}';
    }
}

