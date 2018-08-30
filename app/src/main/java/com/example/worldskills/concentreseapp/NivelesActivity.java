package com.example.worldskills.concentreseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class NivelesActivity extends AppCompatActivity  {

Button nivelFacil,nivelMedio,nivelDificil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveles);
        nivelFacil = (Button) findViewById(R.id.btnNivelesFacil);
        nivelMedio = (Button) findViewById(R.id.btnNivelesMedio);
        nivelDificil = (Button) findViewById(R.id.btnNivelesDificil);

        nivelDificil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent nivelFacil = new Intent(NivelesActivity.this,Juego_ST_Dificil.class);
                startActivity(nivelFacil);
            }
        });
        nivelFacil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent nivelFacil = new Intent(NivelesActivity.this,Juego_ST_Facil.class);
                startActivity(nivelFacil);

            }
        });
        nivelMedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nivelMedio = new Intent(NivelesActivity.this,Juego_ST_Medio.class);
                startActivity(nivelMedio);

            }
        });


    }
    }

