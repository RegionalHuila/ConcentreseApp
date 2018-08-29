package com.example.worldskills.concentreseapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Juego_ST_Facil extends Activity {

    //DECLARO LAS VARIABLES

    ArrayList<Integer> arregloImagenes = new ArrayList<Integer>();
    ImageView iv00, iv01, iv10, iv11, iv20, iv21, iv30, iv31, imgTemporal1, imgTemporal2;
    TextView tvJugador1, tvJugador2;
    Chronometer cronometroTiempo;
    Boolean turno = true;
    View imagenSeleccionada1 = null, imagenSeleccionada2 = null;
    int parejasCorrectas = 0;
    int puntajeJugador1, puntajeJugador2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego__st__facil);

    }
}
