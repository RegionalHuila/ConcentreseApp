package com.example.worldskills.concentreseapp.BaseDatos;

import android.provider.BaseColumns;

public final class TablaDatos {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private TablaDatos() {}

    /* Inner class that defines the table contents */
    public static class LectorEntrada implements BaseColumns {
        public static final String NOMBRE_TABLA = "usuarios";
        public static final String COLUMNA_JUGADOR = "jugador";
        public static final String COLUMNA_PUNTAJE = "puntaje";
    }
}