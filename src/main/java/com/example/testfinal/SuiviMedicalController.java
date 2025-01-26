package com.example.testfinal;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class SuiviMedicalController {

    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField timeField;
    @FXML
    private TextField descriptionField;
    @FXML
    private ListView<String> rendezvousListView;
    @FXML
    private Label messageLabel;

    private static final String FILE_PATH = "rendezvous.txt";

    // Méthode pour ajouter un rendez-vous
    @FXML
    private void handleAddRendezvous(ActionEvent event) {
        String date = datePicker.getValue().toString();
        String time = timeField.getText();
        String description = descriptionField.getText();

        if (date.isEmpty() || time.isEmpty() || description.isEmpty()) {
            messageLabel.setText("Tous les champs doivent être remplis.");
            messageLabel.setVisible(true);
            return;
        }

        String rendezvous = date + "," + time + "," + description;
        appendRendezvousToFile(rendezvous);
        loadRendezvousFromFile();  // Recharger la liste
    }

    // Méthode pour ajouter un rendez-vous dans le fichier texte
    private void appendRendezvousToFile(String rendezvous) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(rendezvous);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour charger les rendez-vous depuis le fichier
    private void loadRendezvousFromFile() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));
            rendezvousListView.getItems().clear();
            rendezvousListView.getItems().addAll(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour charger les rendez-vous lors du démarrage
    public void initialize() {
        loadRendezvousFromFile();
    }

    // Méthode pour retourner au Dashboard
    @FXML
    private void handleReturn(ActionEvent event) {
        try {
            // Charger le fichier FXML du Dashboard
            Parent root = FXMLLoader.load(getClass().getResource("DashboardPage.fxml")); // Assurez-vous que le fichier 'DashboardPage.fxml' est correct
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}








