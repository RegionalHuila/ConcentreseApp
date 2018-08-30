package com.example.worldskills.concentreseapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.worldskills.concentreseapp.BaseDatos.AyudaBaseDatos;
import com.example.worldskills.concentreseapp.BaseDatos.TablaDatos;

import java.util.ArrayList;
import java.util.List;

public class PuntajeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntaje);

    }
}
