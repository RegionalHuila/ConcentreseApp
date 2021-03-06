package com.example.worldskills.concentreseapp;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class Juego_ST_Medio extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Integer> arregloImagenes = new ArrayList<Integer>();
    ImageView iv00, iv01, iv10, iv11, iv20, iv21, iv30, iv31, iv40, iv41, iv50, iv51, imgTemporal1, imgTemporal2;
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
        setContentView(R.layout.activity_juego__st__medio);

        //INSTANCIO VARIABLES

        iv00 = (ImageView)findViewById(R.id.iv00);
        iv01 = (ImageView)findViewById(R.id.iv01);
        iv10 = (ImageView)findViewById(R.id.iv10);
        iv11 = (ImageView)findViewById(R.id.iv11);
        iv20 = (ImageView)findViewById(R.id.iv20);
        iv21 = (ImageView)findViewById(R.id.iv21);
        iv30 = (ImageView)findViewById(R.id.iv30);
        iv31 = (ImageView)findViewById(R.id.iv31);
        iv40 = (ImageView)findViewById(R.id.iv40);
        iv41 = (ImageView)findViewById(R.id.iv41);
        iv50 = (ImageView)findViewById(R.id.iv50);
        iv51 = (ImageView)findViewById(R.id.iv51);
        tvJugador1 = (TextView)findViewById(R.id.tvJugador1);
        tvJugador2 = (TextView)findViewById(R.id.tvJugador2);
        tvpuntoJugador1 = (TextView)findViewById(R.id.tvPuntosJugador1);
        tvpuntoJugador2 = (TextView)findViewById(R.id.tvPuntosJugador2);
        cronometroTiempo = (Chronometer)findViewById(R.id.cronometroTiempo);

        //LEEMOS LOS TEXTVIEWS PARA COLOCAR LOS NOMBRES EN VARIABLES
        SharedPreferences sf = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        tvJugador1.setText(sf.getString("JUGADORUNO", "NO HAY"));
        tvJugador2.setText(sf.getString("JUGADORDOS", "NO HAY"));
        jugador1 = tvJugador1.getText().toString();
        jugador2 = tvJugador2.getText().toString();
        tvpuntoJugador1.setText("0");
        tvpuntoJugador2.setText("0");

        //METODO PARA SORTEAR EL PRIMER TURNO
        primerturno();

        //METODO PARA LLENAR EL ARRAYLIST
        arregloImagenes();

        //ASIGNAR IMAGENES A LOS IMAGEVIEWS
        asignarImagenes();

        iv00.setOnClickListener(this);
        iv01.setOnClickListener(this);
        iv10.setOnClickListener(this);
        iv11.setOnClickListener(this);
        iv20.setOnClickListener(this);
        iv21.setOnClickListener(this);
        iv30.setOnClickListener(this);
        iv31.setOnClickListener(this);
        iv40.setOnClickListener(this);
        iv41.setOnClickListener(this);
        iv50.setOnClickListener(this);
        iv51.setOnClickListener(this);

    }

    private void arregloImagenes() {
        arregloImagenes.add(R.drawable.homero);
        arregloImagenes.add(R.drawable.marge);
        arregloImagenes.add(R.drawable.lisa);
        arregloImagenes.add(R.drawable.milhouse);
        arregloImagenes.add(R.drawable.homero);
        arregloImagenes.add(R.drawable.marge);
        arregloImagenes.add(R.drawable.lisa);
        arregloImagenes.add(R.drawable.milhouse);
        arregloImagenes.add(R.drawable.moe);
        arregloImagenes.add(R.drawable.moe);
        arregloImagenes.add(R.drawable.bart);
        arregloImagenes.add(R.drawable.bart);

    }

    private void asignarImagenes() {
        iv00.setTag(asignarImagenesAleatorias());
        iv01.setTag(asignarImagenesAleatorias());
        iv10.setTag(asignarImagenesAleatorias());
        iv11.setTag(asignarImagenesAleatorias());
        iv20.setTag(asignarImagenesAleatorias());
        iv21.setTag(asignarImagenesAleatorias());
        iv30.setTag(asignarImagenesAleatorias());
        iv31.setTag(asignarImagenesAleatorias());
        iv40.setTag(asignarImagenesAleatorias());
        iv41.setTag(asignarImagenesAleatorias());
        iv50.setTag(asignarImagenesAleatorias());
        iv51.setTag(asignarImagenesAleatorias());
    }

    private Object asignarImagenesAleatorias() {
        int imagenSeleccionada = 0;

        Collections.shuffle(arregloImagenes);
        int indiceAleatorio = (int) (Math.random()*arregloImagenes.size());
        imagenSeleccionada = arregloImagenes.get(indiceAleatorio);
        arregloImagenes.remove(indiceAleatorio);
        return imagenSeleccionada;
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
            tvJugador2.setTextColor(Color.GRAY);
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
            tvJugador2.setTextColor(Color.BLACK);
            tvpuntoJugador2.setTextColor(Color.BLACK);
            AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
            builder.setMessage(R.string.dialog_message)
                    .setTitle(R.string.dialog_title);
            AlertDialog dialog = builder.create();
            cronometroTiempo.setBase(SystemClock.elapsedRealtime());
            cronometroTiempo.start();
        }
    }

    @Override
    public void onClick(View view) {
        //VERIFICO QUE LOS VIEWS ESTEN EN NULL
        if(imagenSeleccionada1 != null && imagenSeleccionada2 != null){
            return;
        }

        //CREO UN IMAGEVIEW TEMPORAL CON EL VALOR ID DEL VIEW
        final ImageView imgtempo1 = (ImageView)findViewById(view.getId());

        //CREO UN RECURSO TEMPORAL PARA TOMAR EL TAG DEL VIEW
        int recursoImagenTempo1 = (int) view.getTag();

        //UTILIZO EL RECURSO
        imgtempo1.setImageResource(recursoImagenTempo1);

        //VALIDO CUANDO ELIJAN UNA IMAGEN
        if(imagenSeleccionada1 == null){

            //IMAGENSELECCIONADA1 SE CONVIERTE EN LA IMAGEN (VIEW)
            imagenSeleccionada1 = view;

            //NO DEJAMOS QUE LA VUELVAN A PRESIONAR
            imgtempo1.setEnabled(true);
        }else{
            //IMAGENSELECCIONADA1 SE CONVIERTE EN LA IMAGEN (VIEW)
            imagenSeleccionada2 = view;

            //ASIGNO A LAS IMAGENES TEMPORALES LAS IMAGENES SELECCIONADAS
            imgTemporal1 = (ImageView)findViewById(imagenSeleccionada1.getId());
            imgTemporal2 = (ImageView)findViewById(imagenSeleccionada2.getId());

            ////NO DEJAMOS QUE LA VUELVAN A PRESIONAR
            imagenSeleccionada1.setEnabled(true);

            //LAS CONVERTIMOS EN ENTERO PARA QUE SE PUEDAN COMPARAR
            int rsc1 = (int) imgTemporal1.getTag();
            int rsc2 = (int) imgTemporal2.getTag();

            //VALIDAMOS SI SON IGUALES
            if(rsc1 == rsc2){

                //SE ESCUCHA EL SONIDO GANO
                MediaPlayer bien = MediaPlayer.create(getApplicationContext(),R.raw.gano);
                bien.start();

                //METODO PARA AUMENTAR EL PUNTAJE
                ponerPuntaje();

                //METODO PARA SUMAR LA PAREJA CORRECTA
                parejasCorrectas();

                //MOSTRAMOS LAS IMAGENES SELECCIONADAS
                imgTemporal1.setVisibility(View.VISIBLE);
                imgTemporal2.setVisibility(View.VISIBLE);

                //COUNTDOWNTINMER PARA QUE SE DEMORE UN SEGUNDO EN DESAPERECER
                CountDownTimer voltear = new CountDownTimer(1000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {

                        //SE COLOCAN INVISIBLES
                        imgTemporal1.setVisibility(View.INVISIBLE);
                        imgTemporal2.setVisibility(View.INVISIBLE);

                        //LAS IMAGENES ESTAN VACIAS DE NUEVO
                        imagenSeleccionada1 = null;
                        imagenSeleccionada2 = null;

                    }
                }.start();

            }else{
                MediaPlayer mal = MediaPlayer.create(getApplicationContext(),R.raw.mal);
                mal.start();
                quitarPuntaje();
                imgTemporal1.setVisibility(View.VISIBLE);
                imgTemporal2.setVisibility(View.VISIBLE);
                CountDownTimer voltear = new CountDownTimer(1000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        imgTemporal1.setImageResource(R.drawable.concentrese_icono);
                        imgTemporal2.setImageResource(R.drawable.concentrese_icono);
                        imagenSeleccionada1 = null;
                        imagenSeleccionada2 = null;

                    }
                }.start();
                turno = false;
                siguienteTurno();

            }
        }

    }

    private void siguienteTurno() {


        if(turno = false){
            //SE VALIDA QUE VALOR ESTA EL RANDOM 0 = JUGADOR1 / 1 = JUGADOR2
            if(random == 0){
                tvJugador1.setTextColor(Color.GRAY);
                tvpuntoJugador1.setTextColor(Color.GRAY);
                tvJugador2.setTextColor(Color.BLACK);
                tvpuntoJugador2.setTextColor(Color.BLACK);
                turno = true;
                Toast.makeText(getApplicationContext(), "Sigue "+jugador2 ,Toast.LENGTH_SHORT ).show();
                random = 1;

            }else{
                tvJugador1.setTextColor(Color.BLACK);
                tvpuntoJugador1.setTextColor(Color.BLACK);
                tvJugador2.setTextColor(Color.GRAY);
                tvpuntoJugador2.setTextColor(Color.GRAY);
                turno = true;
                random = 0;
                Toast.makeText(getApplicationContext(), "Sigue "+jugador1 ,Toast.LENGTH_SHORT ).show();
            }
        }else{
            if(random == 0){
                tvJugador1.setTextColor(Color.GRAY);
                tvpuntoJugador1.setTextColor(Color.GRAY);
                tvJugador2.setTextColor(Color.BLACK);
                tvpuntoJugador2.setTextColor(Color.BLACK);
                turno = false;
                random = 1;
                Toast.makeText(getApplicationContext(), "Sigue "+jugador2 ,Toast.LENGTH_SHORT ).show();

            }else{
                tvJugador1.setTextColor(Color.BLACK);
                tvpuntoJugador1.setTextColor(Color.BLACK);
                tvJugador2.setTextColor(Color.GRAY);
                tvpuntoJugador2.setTextColor(Color.GRAY);
                turno = false;
                random = 0;
                Toast.makeText(getApplicationContext(), "Sigue "+jugador1 ,Toast.LENGTH_SHORT ).show();
            }
        }


    }

    private void parejasCorrectas() {
        parejasCorrectas++;
        if(parejasCorrectas == 6){
            cronometroTiempo.stop();
            puntajeJugador1 = Integer.parseInt(tvpuntoJugador1.getText().toString());
            puntajeJugador2 = Integer.parseInt(tvpuntoJugador2.getText().toString());
            if(puntajeJugador1 > puntajeJugador2){
                Toast.makeText(getApplicationContext(), "El ganador fue "+jugador1 ,Toast.LENGTH_SHORT ).show();
            }else{
                Toast.makeText(getApplicationContext(), "El ganador fue "+jugador1 ,Toast.LENGTH_SHORT ).show();
            }
        }

    }

    private void ponerPuntaje() {
        if(random == 0){
            puntajeJugador1 += 100;
            tvpuntoJugador1.setText(""+puntajeJugador1);
        }else if(random == 1){
            puntajeJugador2 += 100;
            tvpuntoJugador2.setText(""+puntajeJugador2);
        }
    }

    private void quitarPuntaje() {
        if(random == 0){
            if(puntajeJugador1 !=  0){
                puntajeJugador1 -= 2;
                tvpuntoJugador1.setText(""+puntajeJugador1);
            }else{
                puntajeJugador1 -= 0;
                tvpuntoJugador1.setText(""+puntajeJugador1);
            }

        }else if(random == 1){
            if(puntajeJugador2 !=  0){
                puntajeJugador2 -= 2;
                tvpuntoJugador2.setText(""+puntajeJugador2);
            }else{
                puntajeJugador2 -= 0;
                tvpuntoJugador2.setText(""+puntajeJugador2);
            }
        }
    }
}
