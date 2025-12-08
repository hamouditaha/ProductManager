package com.productmanager.controller;

import com.productmanager.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ProductController {
    
    @FXML private TextField nameField;
    @FXML private TextField priceField;
    @FXML private ListView<Product> productListView;
    @FXML private Label messageLabel;
    @FXML private Label totalLabel;
    @FXML private Label averageLabel;
    @FXML private Label countLabel;
    
    private ObservableList<Product> products;
    
    @FXML
    public void initialize() {
        // Initialiser la liste observable
        products = FXCollections.observableArrayList();
        productListView.setItems(products);
        
        // Permettre la sélection multiple
        productListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        // Ajouter un écouteur pour la sélection
        productListView.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> {
                if (newValue != null) {
                    nameField.setText(newValue.getName());
                    priceField.setText(String.valueOf(newValue.getPrice()));
                }
            }
        );
        
        // Ajouter des produits d'exemple
        addSampleProducts();
        updateStats();
    }
    
    @FXML
    private void addProduct() {
        try {
            String name = nameField.getText().trim();
            String priceText = priceField.getText().trim();
            
            if (name.isEmpty() || priceText.isEmpty()) {
                showMessage("Veuillez remplir tous les champs!", AlertType.WARNING);
                return;
            }
            
            double price = Double.parseDouble(priceText);
            
            if (price <= 0) {
                showMessage("Le prix doit être positif!", AlertType.WARNING);
                return;
            }
            
            Product product = new Product(name, price);
            products.add(product);
            
            clearFields();
            updateStats();
            showMessage("Produit ajouté avec succès!", AlertType.INFORMATION);
            
        } catch (NumberFormatException e) {
            showMessage("Format de prix invalide!", AlertType.ERROR);
        }
    }
    
    @FXML
    private void updateProduct() {
        Product selectedProduct = productListView.getSelectionModel().getSelectedItem();
        
        if (selectedProduct == null) {
            showMessage("Veuillez sélectionner un produit à modifier!", AlertType.WARNING);
            return;
        }
        
        try {
            String name = nameField.getText().trim();
            String priceText = priceField.getText().trim();
            
            if (name.isEmpty() || priceText.isEmpty()) {
                showMessage("Veuillez remplir tous les champs!", AlertType.WARNING);
                return;
            }
            
            double price = Double.parseDouble(priceText);
            
            if (price <= 0) {
                showMessage("Le prix doit être positif!", AlertType.WARNING);
                return;
            }
            
            selectedProduct.setName(name);
            selectedProduct.setPrice(price);
            
            // Rafraîchir la ListView
            productListView.refresh();
            
            clearFields();
            updateStats();
            showMessage("Produit modifié avec succès!", AlertType.INFORMATION);
            
        } catch (NumberFormatException e) {
            showMessage("Format de prix invalide!", AlertType.ERROR);
        }
    }
    
    @FXML
    private void deleteProduct() {
        Product selectedProduct = productListView.getSelectionModel().getSelectedItem();
        
        if (selectedProduct == null) {
            showMessage("Veuillez sélectionner un produit à supprimer!", AlertType.WARNING);
            return;
        }
        
        products.remove(selectedProduct);
        clearFields();
        updateStats();
        showMessage("Produit supprimé avec succès!", AlertType.INFORMATION);
    }
    
    @FXML
    private void clearFields() {
        nameField.clear();
        priceField.clear();
        productListView.getSelectionModel().clearSelection();
        messageLabel.setText("");
    }
    
    private void updateStats() {
        int count = products.size();
        double total = products.stream().mapToDouble(Product::getPrice).sum();
        double average = count > 0 ? total / count : 0;
        
        countLabel.setText(String.format("Nombre: %d", count));
        totalLabel.setText(String.format("Total: %.2f DH", total));
        averageLabel.setText(String.format("Moyenne: %.2f DH", average));
    }
    
    private void addSampleProducts() {
        products.addAll(
            new Product("Ordinateur Portable", 8500.00),
            new Product("Souris Sans Fil", 199.99),
            new Product("Clavier Mécanique", 450.50),
            new Product("Écran 24\"", 1200.00),
            new Product("Casque Audio", 350.75)
        );
    }
    
    private void showMessage(String message, AlertType type) {
        messageLabel.setText(message);
        
        Alert alert = new Alert(type);
        alert.setTitle("Gestion des Produits");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }
}