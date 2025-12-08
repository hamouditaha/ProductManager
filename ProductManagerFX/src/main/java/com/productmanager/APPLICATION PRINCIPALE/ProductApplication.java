package com.productmanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProductApplication extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Charger le fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/product-view.fxml"));
        Parent root = loader.load();
        
        // Configurer la scène
        Scene scene = new Scene(root, 800, 600);
        
        // Configurer la fenêtre
        primaryStage.setTitle("Gestion des Produits - JavaFX");
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(700);
        primaryStage.setMinHeight(500);
        
        // Afficher la fenêtre
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}