package com.example.practica03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class actualizarVehiculo extends AppCompatActivity {

    Concesionario coche = new Concesionario();

    public EditText marca,modelo,anio,km,precio,codigo,cilindraje,pais,propietarios;
    public RadioButton rb1,rb2;
    public Button btn_actualizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizarvehiculo);
        marca = findViewById(R.id.marca_auto);
        modelo = findViewById(R.id.modelo_auto);
        anio = findViewById(R.id.anio_auto);
        km = findViewById(R.id.km_auto);
        precio = findViewById(R.id.precio_auto);
        codigo = findViewById(R.id.codigo_auto);
        cilindraje = findViewById(R.id.cilindraje_auto);
        pais = findViewById(R.id.pais_auto);
        rb1 = findViewById(R.id.auto_nuevo);
        rb2 = findViewById(R.id.auto_usado);
        propietarios = findViewById(R.id.propietarios_auto);
        btn_actualizar = findViewById(R.id.btn_actualizar);

        if (coche.coche_encontrado.getCodigo() != 0){
            marca.setText(coche.coche_encontrado.getMarca());
            modelo.setText(coche.coche_encontrado.getModelo());
            anio.setText(String.valueOf(coche.coche_encontrado.getAnio()));
            precio.setText(String.valueOf(coche.coche_encontrado.getPrecio()));
            cilindraje.setText(String.valueOf(coche.coche_encontrado.getCilindraje()));
            pais.setText(coche.coche_encontrado.getPais());
            km.setText(String.valueOf(coche.coche_encontrado.getKm()));
            propietarios.setText(String.valueOf(coche.coche_encontrado.getPropietarios()));


        } else {
            cargarConsulta();
        }


        btn_actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editarVehiculo();
                cargarConsulta();
            }
        });

    }
    public void cargarConsulta(){
        Intent comprar = new Intent(this, Vender.class);
        startActivity(comprar);
    }
    public void editarVehiculo(){
        String estado="";
        if (rb1.isChecked()) {estado = "Nuevo";}
        else if (rb2.isChecked()) estado = "Usado";

        for (int i = 0; i < coche.coches.size(); i++) {
            if (coche.coche_encontrado.getCodigo() == coche.coches.get(i).getCodigo()){
                coche.coches.get(i).setMarca(marca.getText().toString());
                coche.coches.get(i).setModelo(modelo.getText().toString());
                coche.coches.get(i).setAnio(Integer.parseInt(anio.getText().toString()));
                coche.coches.get(i).setPrecio(Integer.parseInt(precio.getText().toString()));
                coche.coches.get(i).setCilindraje(Integer.parseInt(cilindraje.getText().toString()));
                coche.coches.get(i).setPais(pais.getText().toString());
                coche.coches.get(i).setEstado(estado);
                coche.coches.get(i).setKm(Integer.parseInt(km.getText().toString()));
                coche.coches.get(i).setPropietarios(Integer.parseInt(propietarios.getText().toString()));
            }
        }

    }
}