package controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Clase principal de la aplicación que maneja la ventana y las escenas.
 * Contiene variables globales para el usuario y la clave de acceso.
 * Practica 02 - Construccion y Evolucion de Software
 * @author Manuel Cruz
 * @since 2025-10-04
 * @version 1.0
 */

public class App extends Application 
{
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException 
    {
        scene = new Scene(loadFXML("primary"), 1200, 985);
        stage.setTitle("Login");
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Cambia la escena actual por la escena especificada en fxml.
     * El titulo de la ventana cambia al especificado en title.
     * El tamaño de la ventana cambia al especificado en height y width.
     * @throws IOException
     * @param fxml
     * @param title
     * @param height
     * @param width
     */
    public static void setRoot(String fxml, String title, Double height, Double width) throws IOException 
    {
        ((Stage) scene.getWindow()).setTitle(title);
        scene.getWindow().centerOnScreen();
        scene.getWindow().setHeight(height);
        scene.getWindow().setWidth(width);
        scene.setRoot(loadFXML(fxml));
    }
    
    /**
     * Cambia la escena actual por la escena especificada en fxml.
     * El titulo de la ventana no cambia.
     * El tamaño de la ventana no cambia.
     * @throws IOException
     * @param fxml
     * @param title
     */
    public static void setRoot(String fxml, String title) throws IOException 
    {
        ((Stage) scene.getWindow()).setTitle(title);
        scene.getWindow().centerOnScreen();
        scene.setRoot(loadFXML(fxml));
    }    
    
    /**
     * Cambia la escena actual por la escena especificada en fxml.
     * El titulo de la ventana no cambia.
     * El tamaño de la ventana no cambia.
     * @throws IOException
     * @param fxml
     * @param title
     */
    public static void setRoot(String fxml) throws IOException 
    {
        scene.getWindow().centerOnScreen();
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException 
    {
        FXMLLoader fxmlLoader = new FXMLLoader
        (
            App.class.getResource("/views/" + fxml + ".fxml")
        );
        return fxmlLoader.load();
    }

    public static void main(String[] args) 
    {
        launch();
    }
}