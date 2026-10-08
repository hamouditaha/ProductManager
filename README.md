# Product Manager (JavaFX)

[![CI](https://github.com/hamouditaha/ProductManager/actions/workflows/ci.yml/badge.svg)](https://github.com/hamouditaha/ProductManager/actions/workflows/ci.yml)

Desktop application for managing a product catalogue, built with **JavaFX**, **FXML** and **CSS**, following the MVC pattern.

![Java](https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk&logoColor=white)
![JavaFX](https://img.shields.io/badge/JavaFX-17-007396)
![Maven](https://img.shields.io/badge/Maven-C71A36?logo=apachemaven&logoColor=white)

## Features

- ➕ Add, ✏️ edit and 🗑️ delete products (name, price in MAD), with input validation
- 📋 Product list: selecting an item fills in the form
- 📊 Live statistics: number of products, total value and average price
- 🎨 Interface defined in FXML and styled with CSS

## Structure

```
src/main/
├── java/com/productmanager/
│   ├── ProductApplication.java          Entry point (loads the FXML view)
│   ├── Product.java                     Model
│   └── controller/ProductController.java
└── resources/
    ├── product-view.fxml                View
    └── styles.css
```

## Run

**Requirements:** Java 17+ and Maven. JavaFX is downloaded automatically by Maven.

```bash
mvn javafx:run
```
