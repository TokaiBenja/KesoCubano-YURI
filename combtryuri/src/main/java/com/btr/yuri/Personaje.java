package com.btr.yuri;

public class Personaje {

    private String nombre;
    private String imagen;
    private double posiciony;


    public Personaje(String nombre, String imagen, double posiciony){
        this.nombre = nombre;
        this.imagen = imagen;
        this.posiciony = posiciony;
    }

    public double getPosicionY(){
        return posiciony;
    }

    public String getNombre(){
        return nombre;
    }

    public String getImagen(){
        return imagen;
    }
    
}
