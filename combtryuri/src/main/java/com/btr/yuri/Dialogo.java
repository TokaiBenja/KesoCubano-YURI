package com.btr.yuri;

public class Dialogo {
    private Personaje personaje;
    private String texto;

    public Dialogo(Personaje personaje, String texto){
        this.personaje = personaje;
        this.texto = texto;
    }

    public Personaje getPersonaje(){
        return personaje;
    }

    public String getTexto(){
        return texto;
    }
    
}
