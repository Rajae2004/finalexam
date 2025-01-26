package com.example.testfinal;

public class UserSession {
    private static String currentUser;

    public static String getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(String username) {
        currentUser = username;
    }

    public static void clearCurrentUser() {
        currentUser = null;
    }
}

