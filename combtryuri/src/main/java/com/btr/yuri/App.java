package com.btr.yuri;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

//Si es el profesor y esta viendo esto, use IA para únicamente ordenar el código, puede ver en anteriores commits que está todo a mano, y en este commit se hizo uso de la IA para ordenar la estructura del código sin cambiar nada más.

public class App extends Application {

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
            escenario.setScene(iniciarJuego());
            tmfondo.stop();
            btfondo.play();

            ctexto.setVisible(true);
        });

        btnjugar.setStyle("-fx-background-color: #ffffff; -fx-border-color: #c74bc1");
        btnjugar.setScaleX(1.8);
        btnjugar.setScaleY(1.8);

        Button btnsalir = new Button("SALIR");
        btnsalir.setStyle("-fx-background-color: #ffffff; -fx-border-color: #c74bc1");
        btnsalir.setScaleX(1.8);
        btnsalir.setScaleY(1.8);
        btnsalir.setOnAction(e -> Platform.exit());

        VBox contenedorBotones = new VBox(30, btnjugar, btnsalir);
        contenedorBotones.setAlignment(Pos.BOTTOM_CENTER);

        String rutaAudio = getClass().getResource("/maintheme.mp3").toExternalForm();
        Media temaprincipal = new Media(rutaAudio);
        tmfondo = new MediaPlayer(temaprincipal);

        String rutaAudio2 = getClass().getResource("/bgmusic.mp3").toExternalForm();
        Media tema2 = new Media(rutaAudio2);
        btfondo = new MediaPlayer(tema2);
        btfondo.setCycleCount(MediaPlayer.INDEFINITE);

        Label version = new Label();
        version.setText("Versión 0.1");
        version.setStyle("-fx-background-color: #ffffff; -fx-border-color: #1b1414");

        tmfondo.setCycleCount(MediaPlayer.INDEFINITE);
        tmfondo.setVolume(0.5);
        tmfondo.play();

        StackPane root = new StackPane();

        pantalla_principal.fitWidthProperty().bind(root.widthProperty());
        pantalla_principal.fitHeightProperty().bind(root.heightProperty());

        root.getChildren().addAll(
            pantalla_principal,
            titulo,
            version,
            contenedorBotones,
            ctexto
        );

        root.setMargin(contenedorBotones, new Insets(0, 0, 60, 0));
        root.setAlignment(titulo, Pos.TOP_LEFT);
        root.setMargin(titulo, new Insets(-105, 0, 0, -30));
        root.setAlignment(version, Pos.BOTTOM_LEFT);

        Scene scene = new Scene(root, 800, 600);

        escenario.getIcons().add(icono);
        escenario.setTitle("Bocchi The Rock: Snapshot 0.1");
        escenario.setScene(scene);
        escenario.show();
    }



    public Scene iniciarJuego() {
        Label texto = new Label("Que pasa peruano!");
        texto.setStyle("-fx-text-fill: #ffffff; -fx-font-size: 24px");
        ImageView fondo1 = new ImageView("/cfbg.jpg");
        ImageView dgbox = new ImageView("/dialogebox.png");
        ImageView char1 = new ImageView("/char1v2.png");

        StackPane juego = new StackPane();
        juego.getChildren().addAll(fondo1, char1, dgbox, texto);
        juego.setAlignment(texto, Pos.BOTTOM_LEFT);
        juego.setMargin(texto, new Insets(0, 0, 100, 10));
        dgbox.fitWidthProperty().bind(juego.widthProperty());
        juego.setAlignment(char1, Pos.BOTTOM_CENTER);
        juego.setMargin(char1, new Insets(0, 0, -100, 0));
        juego.setAlignment(dgbox, Pos.BOTTOM_CENTER);
        fondo1.fitHeightProperty().bind(juego.heightProperty());
        fondo1.fitWidthProperty().bind(juego.widthProperty());

        Scene escena_juego = new Scene(juego, 800, 600);

        return escena_juego;
    }

    public static void main(String[] args) {
        launch(args);
    }

}

