package com.example.testfinal;



import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    private final UserManager userManager = new UserManager();

    @FXML
    private void login() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Valider si les identifiants sont corrects
        if (userManager.validateUser(username, password)) {
            showAlert(Alert.AlertType.INFORMATION, "Login Successful", "Welcome back, " + username + "!");
            try {
                // Rediriger vers le dashboard après une connexion réussie
                goToDashboard();
            } catch (IOException e) {
                showAlert(Alert.AlertType.ERROR, "Error", "Failed to load the dashboard!");
                e.printStackTrace();
            }
        } else {
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid username or password!");
        }
    }

    @FXML
    private void goToRegister() throws Exception {
        Stage stage = (Stage) usernameField.getScene().getWindow();
        SceneSwitcher.switchScene(stage, "register.fxml");
    }

    // Méthode pour rediriger vers le tableau de bord
    private void goToDashboard() throws IOException {
        Stage stage = (Stage) usernameField.getScene().getWindow();
        SceneSwitcher.switchScene(stage, "dashboardPage.fxml"); // Changer ici pour 'dashboardPage.fxml'
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}






