package com.example.testfinal;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml")); // Vérifier le chemin
        Scene scene = new Scene(loader.load());

        // Ajouter le fichier CSS à la scène
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle("Health Management System - Login");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}










