package ProductManagerFX.src.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import com.company.gestionproduits.config.AppConfig;
import com.company.gestionproduits.util.DatabaseInitializer;

import java.util.Objects;

public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {

      DatabaseInitializer.initializeDatabase();
        
         Parent root = FXMLLoader.load(Objects.requireNonNull(
            getClass().getResource("/view/main.fxml")
        ));
        
        Scene scene = new Scene(root, 1200, 700);
        scene.getStylesheets().add(
            Objects.requireNonNull(
                getClass().getResource("/css/main.css")
            ).toExternalForm()
        );
        
         primaryStage.setTitle("Gestion de Produits v2.0");
        primaryStage.getIcons().add(new Image(
            Objects.requireNonNull(
                getClass().getResource("/images/logo.png")
            ).toString()
        ));
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(1000);
        primaryStage.setMinHeight(600);
        
        primaryStage.setOnCloseRequest(event -> {
            AppConfig.saveWindowState(
                primaryStage.getWidth(),
                primaryStage.getHeight()
            );
        });
        
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        AppConfig.loadConfiguration();
        
        launch(args);
    }
}