package com.example.testfinal;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class RegisterController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField weightField;
    @FXML
    private TextField heightField;
    @FXML
    private ComboBox<String> sexComboBox;
    @FXML
    private TextField desiredWeightField;

    private final UserManager userManager = new UserManager();

    @FXML
    private void initialize() {
        // Initialisation des choix du ComboBox
        sexComboBox.getItems().addAll("Homme", "Femme");
    }

    @FXML
    private void register() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        double weight = Double.parseDouble(weightField.getText());
        double height = Double.parseDouble(heightField.getText());
        String sex = sexComboBox.getValue(); // Récupération de la sélection du sexe
        double desiredWeight = Double.parseDouble(desiredWeightField.getText());

        // Create a new user
        User user = new User(username, password, weight, height, sex, desiredWeight);

        // Try to add the user
        if (userManager.addUser(user)) {
            showAlert(Alert.AlertType.INFORMATION, "Registration Successful", "User registered successfully!");
            clearFields();
        } else {
            showAlert(Alert.AlertType.ERROR, "Registration Failed", "Username already exists!");
        }
    }

    @FXML
    private void goToLogin() throws Exception {
        Stage stage = (Stage) usernameField.getScene().getWindow();
        SceneSwitcher.switchScene(stage, "login.fxml");
    }

    private void clearFields() {
        usernameField.clear();
        passwordField.clear();
        weightField.clear();
        heightField.clear();
        sexComboBox.getSelectionModel().clearSelection();
        desiredWeightField.clear();
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}


