package com.example.worldskills.concentreseapp.BaseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.annotation.ElementType;

public class AyudaBaseDatos extends SQLiteOpenHelper {

    public static final String NOMBRE_BASE_DATOS = "emparejapp.db";
    public static final int VERSION_bASE_DATOS = 1;

    private static final String CREAR_TABLA =
            "CREATE TABLE " + TablaDatos.LectorEntrada.NOMBRE_TABLA + " (" +
                    TablaDatos.LectorEntrada._ID + " INTEGER PRIMARY KEY," +
                    TablaDatos.LectorEntrada.COLUMNA_JUGADOR + " TEXT," +
                    TablaDatos.LectorEntrada.COLUMNA_PUNTAJE + " )";

    private static final String ELIMINAR_TABLA =
            "DROP TABLE IF EXISTS " + TablaDatos.LectorEntrada.NOMBRE_TABLA;

    public AyudaBaseDatos(Context context) {
        super(context, NOMBRE_BASE_DATOS, null, VERSION_bASE_DATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREAR_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(ELIMINAR_TABLA);
            onCreate(db);
    }
}
