package com.example.practica03;


import android.os.Bundle;


import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class registrarFragment extends Fragment {

    public EditText marca,modelo,anio,km,precio,codigo,cilindraje,pais,propietarios;
    public Concesionario auto = new Concesionario();
    public Button bn_guardar;
    public RadioButton rb1,rb2;



    public registrarFragment() {    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        View root = inflater.inflate(R.layout.fragment_registrar, container, false);

        //Datos
        marca = root.findViewById(R.id.marca_auto);
        modelo = root.findViewById(R.id.modelo_auto);
        anio = root.findViewById(R.id.anio_auto);
        km = root.findViewById(R.id.km_auto);
        precio = root.findViewById(R.id.precio_auto);
        codigo = root.findViewById(R.id.codigo_auto);
        cilindraje = root.findViewById(R.id.cilindraje_auto);
        pais = root.findViewById(R.id.pais_auto);
        rb1 = root.findViewById(R.id.auto_nuevo);
        rb2 = root.findViewById(R.id.auto_usado);
        propietarios = root.findViewById(R.id.propietarios_auto);

        bn_guardar = root.findViewById(R.id.btn_guardar);

        bn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String estado="";
                if (rb1.isChecked()) {estado = "Nuevo";}
                else if (rb2.isChecked()) estado = "Usado";

                if(agregarAuto(Integer.parseInt(codigo.getText().toString()),
                        marca.getText().toString(),
                        modelo.getText().toString(),
                        Integer.parseInt(anio.getText().toString()),
                        Integer.parseInt(precio.getText().toString()),
                        Integer.parseInt(cilindraje.getText().toString()),
                        pais.getText().toString(),
                        estado,
                        Integer.parseInt(km.getText().toString()),
                        Integer.parseInt(propietarios.getText().toString()))){
                    Toast.makeText(getContext(), "Vehículo registrado correctamente", Toast.LENGTH_SHORT).show();

                };



            }
        });
        AutosBD();
        return root;

    }
    public boolean agregarAuto(int codigo,
                            String marca,
                            String modelo,
                            int anio,
                            int precio,
                            int cilindraje,
                            String pais,
                            String estado,
                            int km,
                            int propietarios){
        Concesionario aux;
        aux = new Concesionario();
        aux.setCodigo(codigo);
        aux.setMarca(marca);
        aux.setModelo(modelo);
        aux.setAnio(anio);
        aux.setPrecio(precio);
        aux.setCilindraje(cilindraje);
        aux.setPais(pais);
        aux.setEstado(estado);
        aux.setKm(km);
        aux.setPropietarios(propietarios);
        auto.coches.add(aux);

        return true;
    }

    public void AutosBD(){
        Concesionario aux,aux1,aux2,aux3,aux4,aux5,aux6;
        aux = new Concesionario();
        aux1 = new Concesionario();
        aux2 = new Concesionario();
        aux3 = new Concesionario();
        aux4 = new Concesionario();
        aux5 = new Concesionario();
        aux6 = new Concesionario();
        aux.setCodigo(12345);
        aux.setMarca("Haval");
        aux.setModelo("H6");
        aux.setAnio(2020);
        aux.setPrecio(26000);
        aux.setCilindraje(2000);
        aux.setPais("China");
        aux.setEstado("Usado");
        aux.setKm(30000);
        aux.setPropietarios(1);
        auto.coches.add(aux);
        aux1.setCodigo(1234);
        aux1.setMarca("Kia");
        aux1.setModelo("Sportage");
        aux1.setAnio(2012);
        aux1.setPrecio(18000);
        aux1.setCilindraje(2000);
        aux1.setPais("Korea");
        aux1.setEstado("Usado");
        aux1.setKm(113000);
        aux1.setPropietarios(1);
        auto.coches.add(aux1);
        aux2.setCodigo(123);
        aux2.setMarca("Hyundai");
        aux2.setModelo("Tucson");
        aux2.setAnio(2022);
        aux2.setPrecio(33000);
        aux2.setCilindraje(2200);
        aux2.setPais("Korea");
        aux2.setEstado("Nuevo");
        aux2.setKm(0);
        aux2.setPropietarios(0);
        auto.coches.add(aux2);
        aux3.setCodigo(12);
        aux3.setMarca("Mazda");
        aux3.setModelo("CX-5");
        aux3.setAnio(2022);
        aux3.setPrecio(40000);
        aux3.setCilindraje(2500);
        aux3.setPais("Japón");
        aux3.setEstado("Nuevo");
        aux3.setKm(0);
        aux3.setPropietarios(0);
        auto.coches.add(aux3);
        aux4.setCodigo(12345678);
        aux4.setMarca("Chery");
        aux4.setModelo("Tiggo 8 Pro");
        aux4.setAnio(2022);
        aux4.setPrecio(30000);
        aux4.setCilindraje(2000);
        aux4.setPais("China");
        aux4.setEstado("Nuevo");
        aux4.setKm(0);
        aux4.setPropietarios(1);
        auto.coches.add(aux4);
        aux5.setCodigo(12345987);
        aux5.setMarca("Nissan");
        aux5.setModelo("Qashqai");
        aux5.setAnio(2019);
        aux5.setPrecio(28000);
        aux5.setCilindraje(2000);
        aux5.setPais("Japón");
        aux5.setEstado("Usado");
        aux5.setKm(20000);
        aux5.setPropietarios(1);
        auto.coches.add(aux5);
        aux6.setCodigo(12345);
        aux6.setMarca("Chevrolet");
        aux6.setModelo("Captiva");
        aux6.setAnio(2021);
        aux6.setPrecio(31000);
        aux6.setCilindraje(2000);
        aux6.setPais("Estados Unidos");
        aux6.setEstado("Usado");
        aux6.setKm(2000);
        aux6.setPropietarios(1);
        auto.coches.add(aux6);
    }
}