package com.example.worldskills.concentreseapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.os.SystemClock;
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
    TextView tvJugador1, tvJugador2, tvpuntoJugador1, tvpuntoJugador2;
    Chronometer cronometroTiempo;
    Boolean turno = true;
    View imagenSeleccionada1 = null, imagenSeleccionada2 = null;
    int parejasCorrectas = 0;
    int puntajeJugador1, puntajeJugador2;
    int random;
    String jugador1, jugador2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego__st__facil);

        //INSTANCIO VARIABLES

        iv00 = (ImageView)findViewById(R.id.iv00);
        iv01 = (ImageView)findViewById(R.id.iv00);
        iv10 = (ImageView)findViewById(R.id.iv00);
        iv11 = (ImageView)findViewById(R.id.iv00);
        iv20 = (ImageView)findViewById(R.id.iv00);
        iv21 = (ImageView)findViewById(R.id.iv00);
        iv30 = (ImageView)findViewById(R.id.iv00);
        iv31 = (ImageView)findViewById(R.id.iv00);
        tvJugador1 = (TextView)findViewById(R.id.tvJugador1);
        tvJugador2 = (TextView)findViewById(R.id.tvJugador2);
        tvpuntoJugador1 = (TextView)findViewById(R.id.tvPuntosJugador1);
        tvpuntoJugador2 = (TextView)findViewById(R.id.tvPuntosJugador2);
        cronometroTiempo = (Chronometer)findViewById(R.id.cronometroTiempo);

        jugador1 = tvJugador1.getText().toString();
        jugador2 = tvJugador1.getText().toString();


        //METODO PARA SORTEAR EL PRIMER TURNO
        primerturno();



    }

    private void primerturno() {
        //CREO ARRAYLIST CON JUGADORES
        final ArrayList<String> jugadores = new ArrayList<>();

        //AGREGO OBJETOS
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        //RANDOM PARA ELEGIR ALEATORIAMENTE EL PRIMER JUGADOR
        random = (int) (Math.random()*jugadores.size());

        if(random == 0){

            //CAMBIO LOS COLORES DE LOS TEXTVIEWS
            tvJugador1.setTextColor(Color.BLACK);
            tvpuntoJugador1.setTextColor(Color.BLACK);
            tvJugador1.setTextColor(Color.GRAY);
            tvpuntoJugador2.setTextColor(Color.GRAY);

            //ALERT DIALOG QUE AVISA EL TURNO
            AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
            builder.setMessage(R.string.dialog_message)
                    .setTitle(R.string.dialog_title);
            AlertDialog dialog = builder.create();

            //INICIO EL CRONOMETRO
            cronometroTiempo.setBase(SystemClock.elapsedRealtime());
            cronometroTiempo.start();
        }else{
            tvJugador1.setTextColor(Color.GRAY);
            tvpuntoJugador1.setTextColor(Color.GRAY);
            tvJugador1.setTextColor(Color.BLACK);
            tvpuntoJugador2.setTextColor(Color.BLACK);
            AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
            builder.setMessage(R.string.dialog_message)
                    .setTitle(R.string.dialog_title);
            AlertDialog dialog = builder.create();
            cronometroTiempo.setBase(SystemClock.elapsedRealtime());
            cronometroTiempo.start();
        }
    }
}
