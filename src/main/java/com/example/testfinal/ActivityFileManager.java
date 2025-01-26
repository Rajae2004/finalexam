
package com.example.testfinal;

import java.io.*;
import java.util.*;

public class ActivityFileManager {

    public static void saveActivity(Activity activity, String username) throws IOException {
        File file = new File(username + "_activities.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(activity.getName() + "," + activity.getDuration() + "," + activity.getCaloriesBurned() + "," + activity.getDate());
            writer.newLine();
        }
    }

    public static List<Activity> loadActivities(String username) throws IOException {
        File file = new File(username + "_activities.txt");
        List<Activity> activities = new ArrayList<>();
        if (!file.exists()) return activities;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                int duration = Integer.parseInt(parts[1]);
                double calories = Double.parseDouble(parts[2]);
                String date = parts[3];
                activities.add(new Activity(name, duration, calories, date));
            }
        }
        return activities;
    }
}

