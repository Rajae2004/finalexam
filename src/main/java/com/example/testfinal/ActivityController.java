package com.example.testfinal;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;  // Assurez-vous que Stage est bien importé
import java.io.IOException;
import java.util.List;


import java.io.IOException;
import java.util.List;

public class ActivityController {

    @FXML
    private TextField activityNameField;
    @FXML
    private TextField durationField;
    @FXML
    private TextField caloriesField;
    @FXML
    private ListView<String> activitiesListView;
    @FXML
    private Button addActivityButton;
    @FXML
    private Button viewActivitiesButton;
    @FXML
    private Button backButton;
    @FXML
    private Button showProgressButton;
    @FXML
    private LineChart<Number, Number> progressChart;
    @FXML
    private NumberAxis xAxis;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private Label motivationMessage; // Lier le Label du message de motivation

    private String username = "exampleUser"; // Set this to the current user's username

    @FXML
    private void addActivity() {
        String name = activityNameField.getText().trim();
        String durationText = durationField.getText().trim();
        String caloriesText = caloriesField.getText().trim();

        if (name.isEmpty() || durationText.isEmpty() || caloriesText.isEmpty()) {
            showAlert("Erreur", "Tous les champs doivent être remplis.", Alert.AlertType.ERROR);
            return;
        }

        try {
            int duration = Integer.parseInt(durationText);
            double calories = Double.parseDouble(caloriesText);

            Activity newActivity = new Activity(name, duration, calories, java.time.LocalDate.now().toString());
            ActivityFileManager.saveActivity(newActivity, username);

            showAlert("Activité ajoutée", "L'activité a été ajoutée avec succès !", Alert.AlertType.INFORMATION);
            activityNameField.clear();
            durationField.clear();
            caloriesField.clear();
        } catch (NumberFormatException e) {
            showAlert("Erreur", "Veuillez entrer des valeurs valides pour la durée et les calories.", Alert.AlertType.ERROR);
        } catch (IOException e) {
            showAlert("Erreur", "Impossible d'enregistrer l'activité.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void showProgress() {
        try {
            List<Activity> activities = ActivityFileManager.loadActivities(username);

            double totalCaloriesBurned = 0;
            for (Activity activity : activities) {
                totalCaloriesBurned += activity.getCaloriesBurned();
            }

            double weightLost = totalCaloriesBurned / 7700;
            XYChart.Series<Number, Number> series = new XYChart.Series<>();
            series.setName("Progression");

            series.getData().add(new XYChart.Data<>(0, 0));
            series.getData().add(new XYChart.Data<>(totalCaloriesBurned, weightLost));

            progressChart.getData().clear();
            progressChart.getData().add(series);

            motivationMessage.setText("Continuez comme ça ! Vous êtes sur la bonne voie ! 💪");
        } catch (IOException e) {
            showAlert("Erreur", "Impossible de charger les activités.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void viewActivities() {
        try {
            List<Activity> activities = ActivityFileManager.loadActivities(username);
            ObservableList<String> activityNames = FXCollections.observableArrayList();

            for (Activity activity : activities) {
                activityNames.add(activity.getName() + " - " + activity.getCaloriesBurned() + " calories");
            }

            activitiesListView.setItems(activityNames);
        } catch (IOException e) {
            showAlert("Erreur", "Impossible de charger les activités.", Alert.AlertType.ERROR);
        }
    }


    @FXML
    private void goBack() {
        try {
            // Charger le fichier FXML de la page Dashboard
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DashboardPage.fxml"));
            Parent root = loader.load();

            // Obtenir la scène actuelle à partir du bouton Retour
            Stage stage = (Stage) backButton.getScene().getWindow();

            // Remplacer la scène actuelle par celle de DashboardPage.fxml
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            // Afficher une alerte si le fichier FXML ne peut pas être chargé
            showAlert("Erreur", "Impossible de revenir à la fenêtre Dashboard.", Alert.AlertType.ERROR);
        }
    }


    private void showAlert(String title, String content, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}






