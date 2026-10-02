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
import javafx.scene.layout.StackPane;
import javafx.geometry.Pos;
import javafx.application.Platform;


public class App extends Application{

    @Override
    public void start(Stage escenario) throws Exception {
        // TODO Auto-generated method stub

        Image icono = new Image(getClass().getResourceAsStream("/icon.png"));
        ImageView pantalla_principal = new ImageView("/maintitle.jpeg");
        pantalla_principal.setFitWidth(800);
        pantalla_principal.setFitHeight(600);
        Button btnjugar = new Button("JUGAR");
        Label lblmensaje = new Label();
        lblmensaje.setStyle("-fx-font-size: 18px; -fx-text-fill: #462525; -fx-weight: bold;");
        VBox ctexto = new VBox(lblmensaje);
        ctexto.setMaxWidth(290);
        ctexto.setMaxHeight(30);
        ctexto.setVisible(false);
        ctexto.setStyle("-fx-background-color: #ffffff; -fx-border-color: #9c1880");
        btnjugar.setOnAction(e -> {
            lblmensaje.setText("BIENVENIDO A BOCCHI THE ROCK!");
            ctexto.setVisible(true);
        });


        Button btnsalir = new Button("SALIR");
        btnsalir.setOnAction(e -> Platform.exit());
        VBox contenedorBotones = new VBox(15, btnjugar, btnsalir);
        contenedorBotones.setAlignment(Pos.CENTER);

        StackPane root = new StackPane();
        root.getChildren().addAll(pantalla_principal ,contenedorBotones, ctexto);
        

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