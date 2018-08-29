package com.example.worldskills.concentreseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnPlay,btnConfig,btnInfo,btnPuntajes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnPlay = (Button)findViewById(R.id.btnMenuPlay);
        btnConfig = (Button)findViewById(R.id.btnMenuConfiguraciones);
        btnInfo = (Button)findViewById(R.id.btnMenuInformacion);
        btnPuntajes = (Button)findViewById(R.id.btnMenuPunatajes);

        btnPlay.setOnClickListener(this);
        btnPuntajes.setOnClickListener(this);
        btnInfo.setOnClickListener(this);
        btnConfig.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnMenuPlay:
               Intent intentPlay = new Intent(getApplicationContext(),NivelesActivity.class);
               startActivity(intentPlay);
        }

    }
}
