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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;



public class App extends Application{

    private MediaPlayer tmfondo;
    private MediaPlayer btfondo;

    @Override
    public void start(Stage escenario) throws Exception {
        // TODO Auto-generated method stub

        Image icono = new Image(getClass().getResourceAsStream("/icon.png"));
        ImageView pantalla_principal = new ImageView("/maintitle.jpeg");

        Button btnjugar = new Button("JUGAR");
        Label lblmensaje = new Label();
        lblmensaje.setStyle("-fx-font-size: 18px; -fx-text-fill: #462525; -fx-weight: bold;");
        ImageView titulo = new ImageView("/title.png");
        titulo.setFitWidth(350);
        titulo.setPreserveRatio(true);
        VBox ctexto = new VBox(lblmensaje);
        ctexto.setMaxWidth(290);
        ctexto.setMaxHeight(30);
        ctexto.setVisible(false);
        ctexto.setStyle("-fx-background-color: #ffffff; -fx-border-color: #9c1880");
        btnjugar.setOnAction(e -> {
            lblmensaje.setText("BIENVENIDO A BOCCHI THE ROCK!");
            tmfondo.stop();
            btfondo.play();

            ctexto.setVisible(true);
        });


        Button btnsalir = new Button("SALIR");
        btnsalir.setOnAction(e -> Platform.exit());
        VBox contenedorBotones = new VBox(10, btnjugar, btnsalir);
        contenedorBotones.setAlignment(Pos.BOTTOM_CENTER);

        String rutaAudio = getClass().getResource("/maintheme.mp3").toExternalForm();
        Media temaprincipal = new Media(rutaAudio);
        tmfondo = new MediaPlayer(temaprincipal);
        String rutaAudio2 = getClass().getResource("/btrtheme.mp3").toExternalForm();
        Media tema2 = new Media(rutaAudio2);
        btfondo = new MediaPlayer(tema2);


        tmfondo.setCycleCount(MediaPlayer.INDEFINITE);
        tmfondo.setVolume(0.5);
        tmfondo.play();

        StackPane root = new StackPane();
        pantalla_principal.fitWidthProperty().bind(root.widthProperty());
        pantalla_principal.fitHeightProperty().bind(root.heightProperty());
        root.getChildren().addAll(pantalla_principal, titulo,contenedorBotones, ctexto);
        root.setMargin(contenedorBotones, new Insets(0, 0, 60, 0));
        root.setAlignment(titulo, Pos.TOP_LEFT);
        root.setMargin(titulo, new Insets(-105, 0, 0, -30));
        

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