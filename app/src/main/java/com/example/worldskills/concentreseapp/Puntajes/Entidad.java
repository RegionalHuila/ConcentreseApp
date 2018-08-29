package com.example.worldskills.concentreseapp.Puntajes;

public class Entidad {

    public String nombreJugador;
    public int puntaje;

    public Entidad(String nombreJugador, int puntaje) {
        this.nombreJugador = nombreJugador;
        this.puntaje = puntaje;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
