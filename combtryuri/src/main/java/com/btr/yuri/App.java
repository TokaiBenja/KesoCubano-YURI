package com.btr.yuri;

// Base obligatoria para cualquier app gráfica de JavaFX; da acceso al ciclo de vida de la aplicación.
import javafx.application.Application;

// Permite definir márgenes y rellenos (padding) alrededor de las cajas o elementos.
import javafx.geometry.Insets;

// La "escena" o lienzo interno donde se colocan todos los componentes visuales.
import javafx.scene.Scene;

// Control visual para crear botones interactivos
import javafx.scene.control.Button;

//Control visual para mostrar texto estático en la pantalla
import javafx.scene.control.Label;

// Campo de texto para que el usuario escriba
import javafx.scene.control.TextField;

// Layout para organizar elementos en una fila horizontal
import javafx.scene.layout.HBox;

// Layout para organizar elementos en una columna vertical
import javafx.scene.layout.VBox;

// Carga todas las herramientas para manejar imágenes
import javafx.scene.image.*;

// Representa la ventana principal del sistema operativo.
import javafx.stage.Stage;

// Layout que apila elementos unos encima de otros
import javafx.scene.layout.StackPane;

// Permite definir alineaciones (centro, izquierda, derecha, etc.)
import javafx.geometry.Pos;

// Contiene métodos de control de la plataforma JavaFX, como cerrar la app de forma limpia
import javafx.application.Platform;


public class App extends Application{

    // El método start es el punto de entrada principal donde se construye y dibuja la interfaz visual
    @Override
    public void start(Stage escenario) throws Exception {

        // Busca y carga la imagen /icon.png desde los recursos del proyecto para usarla como icono de la ventana.
        Image icono = new Image(getClass().getResourceAsStream("/icon.png"));
        // Crea un visor visual (ImageView) para mostrar la imagen de fondo /maintitle.jpeg
        ImageView pantalla_principal = new ImageView("/maintitle.jpeg");
        // Ajustan el tamaño de la imagen de fondo a 800 píxeles de ancho por 600 píxeles de alto.
        pantalla_principal.setFitWidth(800);
        pantalla_principal.setFitHeight(600);
        // Crea el botón interactivo con el texto "JUGAR"
        Button btnjugar = new Button("JUGAR");
        // Crea una etiqueta vacía donde se escribirá el texto del mensaje
        Label lblmensaje = new Label();
        // Aplica estilos tipo CSS a la etiqueta: texto de 18px, color marrón oscuro (#462525) y letra negrita
        lblmensaje.setStyle("-fx-font-size: 18px; -fx-text-fill: #462525; -fx-weight: bold;");
        // Crea un contenedor vertical (ctexto) para envolver la etiqueta del mensaje
        VBox ctexto = new VBox(lblmensaje);
        // Crea un contenedor vertical (ctexto) para envolver la etiqueta del mensaje
        ctexto.setMaxWidth(290);
        ctexto.setMaxHeight(30);
        // Oculta el cuadro del mensaje inicialmente para que no se vea al abrir el juego
        ctexto.setVisible(false);
        // Aplica fondo blanco y un borde de color púrpura/rosado (#9c1880)
        ctexto.setStyle("-fx-background-color: #ffffff; -fx-border-color: #9c1880");
        // Define el evento al hacer clic en "JUGAR": cambia el texto a "BIENVENIDO A BOCCHI THE ROCK!" 
        // y vuelve visible el contenedor ctexto
        btnjugar.setOnAction(e -> {
            lblmensaje.setText("BIENVENIDO A BOCCHI THE ROCK!");
            ctexto.setVisible(true);
        });

        // Crea el botón con el texto "SALIR"
        Button btnsalir = new Button("SALIR");
        // Asigna la acción de cerrar la aplicación completamente al hacer clic
        btnsalir.setOnAction(e -> Platform.exit());
        // Organiza el botón JUGAR y SALIR verticalmente, dejando un espacio de 15 píxeles entre ellos
        VBox contenedorBotones = new VBox(15, btnjugar, btnsalir);
        // Centra los botones en medio del contenedor
        contenedorBotones.setAlignment(Pos.CENTER);
        // Crea un contenedor apilado (como capas de una hamburguesa)
        StackPane root = new StackPane();
        // Agrega los elementos por capas: la imagen de fondo abajo, los botones al medio y el mensaje al frente.
        root.getChildren().addAll(pantalla_principal ,contenedorBotones, ctexto);
        
        // Crea la escena principal con un tamaño fijo de 800x600 píxeles pasando el contenedor root
        Scene scene = new Scene(root, 800, 600);
        // Le asigna el icono cargado previamente a la ventana
        escenario.getIcons().add(icono);
        // Establece el título de la ventana del sistema operativo
        escenario.setTitle("Bocchi The Rock: Snapshot 0.1");
        // Asigna la escena al escenario (Stage) y lo despliega en pantalla
        escenario.setScene(scene);
        escenario.show();
        
    }

    // El punto de entrada ejecutable estándar que arranca el ciclo de vida del framework JavaFX invocando launch()
    public static void main(String[] args) {
        launch(args);
        
    }
}