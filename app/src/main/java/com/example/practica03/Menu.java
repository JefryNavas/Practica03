package com.example.practica03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void cargarComprar(View vista){
        Intent comprar = new Intent(this, Comprar.class);
        startActivity(comprar);
    }
    public void cargarVender(View vista){
        Intent vender = new Intent(this, Vender.class);
        startActivity(vender);
    }
}