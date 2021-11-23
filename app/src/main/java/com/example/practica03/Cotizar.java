package com.example.practica03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Cotizar extends AppCompatActivity {
    Concesionario cotizar = new Concesionario();
    String precio,anio;
    public TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cotizar);
        res = findViewById(R.id.resultado_cotizar);
        precio = String.valueOf(cotizar.auto.getPrecio());
        anio = String.valueOf(cotizar.auto.getAnio());




        res.setText(""+precio+"    "+anio);
    }


}