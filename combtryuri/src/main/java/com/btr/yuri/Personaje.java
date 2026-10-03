package com.btr.yuri;

public class Personaje {

    private String nombre;
    private String imagen;


    public Personaje(String nombre, String imagen){
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getNombre(){
        return nombre;
    }

    public String getImagen(){
        return imagen;
    }
    
}
