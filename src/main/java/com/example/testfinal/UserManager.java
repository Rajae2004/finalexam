package com.example.testfinal;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private final String FILE_PATH = "users.txt";
    private Map<String, User> users = new HashMap<>();

    // Constructor
    public UserManager() {
        loadUsers();
    }

    public void loadUsers() {
        // Load users from the file when the application starts
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(":");
                    if (parts.length == 6) {
                        String username = parts[0];
                        String password = parts[1];
                        double weight = parseDouble(parts[2]);
                        double height = parseDouble(parts[3]);
                        String sex = parts[4];
                        double desiredWeight = parseDouble(parts[5]);

                        User user = new User(username, password, weight, height, sex, desiredWeight);
                        users.put(username, user);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean addUser(User user) {
        if (isUsernameTaken(user.getUsername())) {
            return false; // Username already exists
        }

        // Add user to the in-memory map
        users.put(user.getUsername(), user);

        // Save user to the file
        saveUsersToFile();
        return true;
    }

    public User getUserByUsername(String username) {
        return users.get(username); // Retrieve user from the in-memory map
    }

    private boolean isUsernameTaken(String username) {
        return users.containsKey(username);
    }

    public boolean validateUser(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }

    private void saveUsersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (User user : users.values()) {
                String userData = String.format("%s:%s:%f:%f:%s:%f",
                        user.getUsername(),
                        user.getPassword(),
                        user.getWeight(),
                        user.getHeight(),
                        user.getSex(),
                        user.getDesiredWeight()
                );
                writer.write(userData);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private double parseDouble(String value) {
        try {
            value = value.replace(",", ".");
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0.0;
        }
    }
}




