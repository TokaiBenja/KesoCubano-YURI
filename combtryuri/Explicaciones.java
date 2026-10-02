package com.btr.yuri;

// Base obligatoria para cualquier aplicación gráfica de JavaFX; gestiona el ciclo de vida de la aplicación.
import javafx.application.Application;

// Contiene métodos de control de la plataforma JavaFX, como cerrar la aplicación de forma limpia.
import javafx.application.Platform;

// Permite definir alineaciones de los componentes (centro, izquierda, derecha, etc.).
import javafx.geometry.Pos;

// La "escena" o lienzo interno donde se colocan todos los nodos y componentes visuales.
import javafx.scene.Scene;

// Control visual para crear botones interactivos.
import javafx.scene.control.Button;

// Control visual para mostrar texto estático en la pantalla.
import javafx.scene.control.Label;

// Clases para la carga (Image) y renderizado visual (ImageView) de archivos de imagen.
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// Contenedor que apila elementos unos encima de otros en capas z-index.
import javafx.scene.layout.StackPane;

// Layout contenedor para organizar elementos en una columna vertical.
import javafx.scene.layout.VBox;

// Representa la ventana principal asignada por el sistema operativo.
import javafx.stage.Stage;

public class Explicaciones extends Application {

    // El método start es el punto de entrada principal donde se construye y dibuja la interfaz gráfica.
    @Override
    public void start(Stage escenario) throws Exception {

        // Carga la imagen del icono de la ventana desde el directorio de recursos (resources).
        Image icono = new Image(getClass().getResourceAsStream("/icon.png"));
        
        // Crea el elemento visual para mostrar la imagen de fondo cargada desde los recursos del proyecto.
        ImageView pantalla_principal = new ImageView(new Image(getClass().getResourceAsStream("/maintitle.jpeg")));
        
        // Ajusta la resolución del visor de imagen de fondo a 800 píxeles de ancho por 600 de alto.
        pantalla_principal.setFitWidth(800);
        pantalla_principal.setFitHeight(600);

        // Crea una etiqueta vacía donde se asignará dinámicamente el mensaje de bienvenida.
        Label lblmensaje = new Label();
        
        // Aplica estilos CSS a la etiqueta: texto de 18px, color marrón oscuro (#462525) y letra negrita.
        lblmensaje.setStyle("-fx-font-size: 18px; -fx-text-fill: #462525; -fx-font-weight: bold;");

        // Crea un contenedor vertical (ctexto) que actuará como cuadro de diálogo para la etiqueta.
        VBox ctexto = new VBox(lblmensaje);
        
        // Restringe las dimensiones máximas de la caja de diálogo.
        ctexto.setMaxWidth(290);
        ctexto.setMaxHeight(30);
        
        // Oculta la caja de diálogo inicialmente para que no sea visible al iniciar el juego.
        ctexto.setVisible(false);
        
        // Aplica fondo blanco y un borde de color púrpura (#9c1880) al cuadro de texto.
        ctexto.setStyle("-fx-background-color: #ffffff; -fx-border-color: #9c1880;");

        // Crea el botón interactivo con el texto "JUGAR".
        Button btnjugar = new Button("JUGAR");
        
        // Define la acción al hacer clic en "JUGAR": asigna el texto y hace visible el cuadro ctexto.
        btnjugar.setOnAction(e -> {
            lblmensaje.setText("BIENVENIDO A BOCCHI THE ROCK!");
            ctexto.setVisible(true);
        });

        // Crea el botón con el texto "SALIR".
        Button btnsalir = new Button("SALIR");
        
        // Asigna la acción de cerrar la aplicación de JavaFX completamente al hacer clic.
        btnsalir.setOnAction(e -> Platform.exit());

        // Organiza los botones en columna vertical dejando un espaciado interno de 15 píxeles entre ellos.
        VBox contenedorBotones = new VBox(15, btnjugar, btnsalir);
        
        // Centra la posición de los botones en el medio de su contenedor.
        contenedorBotones.setAlignment(Pos.CENTER);

        // Crea el contenedor principal de capas superpuestas (StackPane).
        StackPane root = new StackPane();
        
        // Agrega los elementos por capas: la imagen al fondo, los botones en el medio y el mensaje al frente.
        root.getChildren().addAll(pantalla_principal, contenedorBotones, ctexto);

        // Instancia la escena asignándole el contenedor raíz y fijando el tamaño en 800x600 píxeles.
        Scene scene = new Scene(root, 800, 600);
        
        // Asigna el icono a la barra de título de la ventana.
        escenario.getIcons().add(icono);
        
        // Establece el título de la ventana del sistema operativo.
        escenario.setTitle("Bocchi The Rock: Snapshot 0.1");
        
        // Asigna la escena al escenario principal (Stage) y lo despliega en pantalla.
        escenario.setScene(scene);
        escenario.show();
    }

    // Punto de entrada ejecutable estándar que arranca la aplicación invocando launch().
    public static void main(String[] args) {
        launch(args);
    }
}