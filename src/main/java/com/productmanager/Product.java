package com.productmanager;

import java.util.Objects;

public class Product {
    private String name;
    private double price;
    
    // Constructeur par défaut
    public Product() {
        this("", 0.0);
    }
    
    // Constructeur avec paramètres
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    // Getters et Setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    // Méthode toString
    @Override
    public String toString() {
        return String.format("%s - %.2f DH", name, price);
    }
    
    // Méthode equals pour comparaison
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return Double.compare(product.price, price) == 0 &&
               Objects.equals(name, product.name);
    }

    // hashCode doit être cohérent avec equals
    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
