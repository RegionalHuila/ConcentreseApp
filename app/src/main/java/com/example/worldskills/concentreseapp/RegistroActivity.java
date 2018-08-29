package com.example.worldskills.concentreseapp;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {


    EditText etNombreUno,etNombreDos;
    Button btnIngresar;
    SharedPreferences preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etNombreUno = (EditText)findViewById(R.id.etJugadorUno);
        etNombreDos = (EditText) findViewById(R.id.etJugadorDos);
        btnIngresar = (Button)findViewById(R.id.btnRegistroIngresar);
        preferencias = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        final SharedPreferences.Editor valores = preferencias.edit();

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(etNombreUno.getText().toString().trim()) && !TextUtils.isEmpty(etNombreDos.getText().toString().trim())){
                    valores.putString("JUGADORUNO",etNombreUno.getText().toString());
                    valores.putString("JUGADORdOS",etNombreDos.getText().toString());

                }else{
                    Toast.makeText(getApplicationContext(),"Ingrese un nombre",Toast.LENGTH_LONG).show();
                }
            }
        });





    }
}
