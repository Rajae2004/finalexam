package com.example.testfinal;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DashboardController {

    @FXML
    private Button manageActivitiesButton;
    @FXML
    private Button viewMealsButton;
    @FXML
    private Button medicalTrackingButton;
    @FXML
    private Button chatbotButton;
    @FXML
    private Button createAccountButton; // Nouveau bouton pour créer un compte

    // Méthode pour gérer la navigation vers la page des activités
    @FXML
    private void manageActivities() {
        Stage stage = (Stage) manageActivitiesButton.getScene().getWindow();
        try {
            SceneSwitcher.switchScene(stage, "ActivityPage.fxml");
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Erreur", "Impossible d'ouvrir la page de gestion des activités.");
        }
    }

    // Méthode pour gérer la navigation vers la page de consultation des repas
    @FXML
    private void viewMeals() {
        Stage stage = (Stage) viewMealsButton.getScene().getWindow();
        try {
            SceneSwitcher.switchScene(stage, "mealChoicePage.fxml");
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Erreur", "Impossible d'ouvrir la page de consultation des repas.");
        }
    }

    // Méthode pour afficher un message temporaire pour le suivi médical
    @FXML
    private void medicalTracking() {
        Stage stage = (Stage) medicalTrackingButton.getScene().getWindow();
        try {
            SceneSwitcher.switchToSuiviMedical(stage);  // Appel à la méthode de SceneSwitcher
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Erreur", "Impossible de rediriger vers le suivi médical.");
        }
    }

    // Méthode pour gérer la navigation vers la page du chatbot
    @FXML
    private void openChatbot() {
        Stage stage = (Stage) chatbotButton.getScene().getWindow();
        try {
            SceneSwitcher.switchScene(stage, "chatbotPage.fxml");
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Erreur", "Impossible d'ouvrir la page du chatbot.");
        }
    }

    // Méthode pour gérer la déconnexion et revenir à la page de connexion
    @FXML
    private void logout() {
        Stage stage = (Stage) manageActivitiesButton.getScene().getWindow();
        try {
            SceneSwitcher.switchScene(stage, "login.fxml");
            showAlert(Alert.AlertType.INFORMATION, "Déconnexion", "Vous avez été déconnecté avec succès.");
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Erreur", "Une erreur est survenue pendant la déconnexion.");
        }
    }

    // Méthode pour gérer la navigation vers la page de création de compte
    @FXML
    private void createAccount() {
        Stage stage = (Stage) createAccountButton.getScene().getWindow();
        try {
            SceneSwitcher.switchScene(stage, "register.fxml"); // Page d'inscription
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Erreur", "Impossible d'ouvrir la page de création de compte.");
        }
    }

    // Méthode utilitaire pour afficher des alertes d'informations ou d'erreurs
    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}










