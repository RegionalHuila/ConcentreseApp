package com.example.worldskills.concentreseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NivelesActivity extends AppCompatActivity implements View.OnClickListener {
Button nivelFacil,nivelMedio,nivelDificil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveles);
        nivelFacil = (Button)findViewById(R.id.btnNivelesFacil);



        nivelFacil.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnNivelesFacil:
                Intent intentFacil = new Intent(getApplicationContext(),Juego_ST_Facil.class);
                startActivity(intentFacil);
        }
    }
}
