package com.example.testfinal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import java.io.IOException;

public class ChatbotController {

    @FXML
    private TextArea chatArea;

    @FXML
    private TextField userInputField;

    @FXML
    private Button sendButton;

    @FXML
    private Button backButton;

    // Fonction pour envoyer un message et obtenir une réponse
    @FXML
    public void sendMessage(ActionEvent event) {
        String userMessage = userInputField.getText();

        if (!userMessage.trim().isEmpty()) {
            // Afficher le message de l'utilisateur
            chatArea.appendText("Vous: " + userMessage + "\n");

            // Appeler un chatbot pour la réponse
            String response = getChatbotResponse(userMessage);

            // Afficher la réponse du chatbot
            chatArea.appendText("Chatbot: " + response + "\n");

            // Vider le champ de texte
            userInputField.clear();
        }
    }

    private String getChatbotResponse(String userMessage) {
        userMessage = userMessage.toLowerCase();

        if (userMessage.contains("stress")) {
            return "Le stress peut être réduit par des exercices de respiration profonde ou par la pratique de la méditation 🧘‍♀️. Vous pouvez aussi essayer le yoga pour détendre votre corps 🌱. N'oubliez pas, prenez soin de vous! 💪";
        } else if (userMessage.contains("repas") || userMessage.contains("nutrition")) {
            return "Je vous recommande des repas équilibrés avec des protéines 💪, des légumes 🥦 et des glucides complexes 🍞. Une alimentation saine est la clé du bien-être! ✨";
        } else if (userMessage.contains("exercice") || userMessage.contains("entrainement")) {
            return "L'exercice physique peut aider à améliorer votre humeur 😄 et à réduire le stress. Commencez avec des exercices simples comme la marche 🚶‍♀️, le yoga 🧘‍♂️, ou la natation 🏊‍♀️. Vous êtes sur la bonne voie! 🚀";
        } else if (userMessage.contains("poids")) {
            return "Si vous souhaitez perdre ou prendre du poids ⚖️, il est essentiel de suivre un plan alimentaire adapté 🥗 et de faire de l'exercice régulièrement. Un professionnel de la santé peut vous aider à établir un programme personnalisé. Vous allez y arriver! 💥";
        } else if (userMessage.contains("sommeil")) {
            return "Pour améliorer votre sommeil 💤, essayez d'établir une routine régulière ⏰, de limiter l'usage d'écrans avant de dormir 📱🚫, et d'éviter les repas lourds le soir 🍽️. Reposez-vous bien, demain est un autre jour! 🌙";
        } else if (userMessage.contains("bonjour") || userMessage.contains("salut")) {
            return "Bonjour! 😊 Comment puis-je vous aider aujourd'hui? Vous êtes prêt à attaquer la journée! 💪";
        } else {
            return "Désolé, je n'ai pas compris votre question. Pouvez-vous reformuler? 🤔 Mais ne vous inquiétez pas, on va trouver une solution ensemble! 👍";
        }
    }


    // Permet de gérer l'appui sur la touche "Entrée" pour envoyer le message
    @FXML
    public void handleKeyPress(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            sendMessage(null);  // Appeler la fonction d'envoi du message
        }
    }

    // Méthode pour revenir au dashboard
    @FXML
    public void goBack(ActionEvent event) {
        try {
            // Charger la vue du dashboard
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/testfinal/DashboardPage.fxml"));
            Parent root = loader.load();

            // Changer la scène
            Stage stage = (Stage) backButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Erreur", "Impossible de revenir à la fenêtre précédente.", Alert.AlertType.ERROR);
        }
    }

    // Méthode pour afficher une alerte en cas d'erreur
    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}





