package com.btr.yuri;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.image.*;
import javafx.stage.Stage;

public class App extends Application{

    @Override
    public void start(Stage escenario) throws Exception {
        // TODO Auto-generated method stub

        Image icono = new Image(getClass().getResourceAsStream("/icon.png"));
        
        Label lblNombreApp = new Label("LOREM IPSUM DOLOR");
        VBox root = new VBox(15, lblNombreApp);
        Scene scene = new Scene(root, 800, 600);
        escenario.getIcons().add(icono);
        escenario.setTitle("Bocchi The Rock: Snapshot 0.1");
        escenario.setScene(scene);
        escenario.show();
        
    }


    public static void main(String[] args) {
        launch(args);
        
    }
}