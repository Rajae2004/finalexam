package com.example.testfinal;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class MealsController {

    @FXML
    private ListView<Meal> mealsListView;

    @FXML
    private Label mealDetailsLabel;

    @FXML
    private Button viewMealDetailsButton;

    @FXML
    private Hyperlink mealDetailsLink;

    @FXML
    private Button backButton;  // Nouveau bouton de retour

    private String goal;

    // Méthode pour configurer l'objectif
    public void setGoal(String goal) {
        this.goal = goal;
        loadMeals();
    }

    // Méthodes pour gérer l'objectif
    @FXML
    private void chooseGoalLoseWeight() {
        setGoal("Perdre du poids");
    }

    @FXML
    private void chooseGoalGainWeight() {
        setGoal("Prendre du poids");
    }

    @FXML
    private void chooseGoalMaintainWeight() {
        setGoal("Rester stable");
    }

    // Charger les repas selon l'objectif
    private void loadMeals() {
        ObservableList<Meal> meals = FXCollections.observableArrayList();

        if ("Perdre du poids".equals(goal)) {
            meals.add(new Meal("Salade de poulet", 350, "https://cookidoo.fr/recipes/recipe/fr-FR/r770068", "https://www.example.com/salade.jpg"));
            meals.add(new Meal("Salade au poulet grillé", 400, "https://www.lesrecettesdecaty.com/fr/recettes/plats-principaux/poulet/salade-au-poulet-grille/", "https://www.example.com/saladegrille.jpg"));
            meals.add(new Meal("Omelette aux légumes", 300, "https://fr.chatelaine.com/recettes/oeufs/omelette-aux-legumes/", "https://www.example.com/omelette.jpg"));
            meals.add(new Meal("Smoothie vert", 250, "https://www.francoislambert.one/blogs/recettes/smoothie-vert-facile-modulable-pour-tous-les-jours", "https://www.example.com/smoothie.jpg"));
            meals.add(new Meal("Soupe de légumes", 200, "https://www.lefourgon.com/blog/5-recettes-soupe-de-legumes", "https://www.example.com/soupe.jpg"));
        } else if ("Prendre du poids".equals(goal)) {
            meals.add(new Meal("Acai Bowl tropical", 500, "https://cookieandkate.com/tropical-acai-bowl-recipe/", "https://www.example.com/acai.jpg"));
            meals.add(new Meal("Riz au poulet et légumes", 600, "https://cuisine.journaldesfemmes.fr/recette/356509-riz-au-poulet-et-legumes", "https://www.example.com/rizpoulet.jpg"));
            meals.add(new Meal("Pâtes à la bolognaise maison", 650, "https://www.grandfrais.com/recettes/pates-a-la-bolognaise-maison", "https://www.example.com/pates.jpg"));
            meals.add(new Meal("Tacos au boeuf braisé et fromage", 700, "https://www.ricardocuisine.com/recettes/9697-tacos-au-boeuf-braise-et-au-fromage-quesabirria", "https://www.example.com/tacos.jpg"));
            meals.add(new Meal("Pancakes aux myrtilles", 400, "https://www.healthyfoodcreation.fr/pancakes-myrtilles/", "https://www.example.com/pancakes.jpg"));
        } else {
            meals.add(new Meal("Salade de quinoa et légumes grillés", 400, "https://www.stefanofaita.com/recettes/salade-de-quinoa-et-legumes-grilles/", "https://www.example.com/quinoa.jpg"));
            meals.add(new Meal("Sandwich Atlantique", 500, "http://www.paul-gabon.com/fr/nos-produits/24-le-sandwich-atlantique.html", "https://www.example.com/sandwichatlantic.jpg"));
            meals.add(new Meal("Wrap au poulet kebab et légumes rôtis", 550, "https://www.demotivateur.fr/food/recette/wrap-au-poulet-kebab-et-aux-legumes-rotis-787", "https://www.example.com/wrap.jpg"));
            meals.add(new Meal("Bowl fraîcheur au riz long", 350, "https://kissmychef.com/recettes/plats/bowl-fraicheur-au-riz-long/", "https://www.example.com/bowl.jpg"));
            meals.add(new Meal("Tartines à l’avocat et à l'œuf", 350, "https://www.ricardocuisine.com/recettes/8381-tartines-a-l-avocat-et-a-l-uf", "https://www.example.com/tartines.jpg"));
        }

        mealsListView.setItems(meals);
        mealsListView.setCellFactory(param -> new MealCell());
    }

    // Afficher les détails du repas sélectionné
    @FXML
    private void viewMealDetails() {
        Meal selectedMeal = mealsListView.getSelectionModel().getSelectedItem();
        if (selectedMeal != null) {
            // Afficher les détails dans le Label
            mealDetailsLabel.setText("Nom: " + selectedMeal.getName() + "\nCalories: " + selectedMeal.getCalories() + "\nRecette: " + selectedMeal.getUrl());
            mealDetailsLabel.setVisible(true);

            // Configurer le lien cliquable
            mealDetailsLink.setText("Voir la recette");
            mealDetailsLink.setVisible(true);

            // Action quand l'utilisateur clique sur le lien
            mealDetailsLink.setOnAction(event -> {
                try {
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create(selectedMeal.getUrl()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    // Méthode pour le bouton de retour
    @FXML
    private void goBack() {
        try {
            // Fermer la fenêtre actuelle
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();

            // Charger et afficher la scène DashboardPage.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DashboardPage.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage mainStage = new Stage();
            mainStage.setScene(scene);
            mainStage.setTitle("Dashboard");
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Classe pour afficher les éléments de la liste avec leur nom, calories et image
    private class MealCell extends javafx.scene.control.ListCell<Meal> {
        @Override
        protected void updateItem(Meal meal, boolean empty) {
            super.updateItem(meal, empty);
            if (empty || meal == null) {
                setText(null);
                setGraphic(null);
            } else {
                setText(meal.getName() + " - " + meal.getCalories() + " Cal");
                ImageView imageView = new ImageView(new Image(meal.getImageUrl()));
                imageView.setFitWidth(50);
                imageView.setFitHeight(50);
                setGraphic(imageView);
            }
        }
    }
}













