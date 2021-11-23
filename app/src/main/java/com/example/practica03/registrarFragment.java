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
    public int cont=0;



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
                String mar = marca.getText().toString();
                String mod = modelo.getText().toString();
                String country = pais.getText().toString();


                if(codigo.getText().toString().trim().equals("")){
                    codigo.setHint("Ingresa el código del auto");//it gives user to hint
                    codigo.setError("Ingresa el código del auto");
                }
                else if(mar.equalsIgnoreCase("")){
                    marca.setHint("Ingresa la Marca");//it gives user to hint
                    marca.setError("Ingresa la Marca");
                }
                else if(mod.equalsIgnoreCase("")){
                    modelo.setHint("Ingresa el Modelo");//it gives user to hint
                    modelo.setError("Ingresa el Modelo");
                }
                else if(anio.getText().toString().trim().equals("")){
                    anio.setHint("Ingresa el Año");//it gives user to hint
                    anio.setError("Ingresa el Año");
                }

                else if(precio.getText().toString().trim().equals("")){
                    precio.setHint("Ingresa el valor de venta");//it gives user to hint
                    precio.setError("Ingresa el valor de venta");
                }
                else if(cilindraje.getText().toString().trim().equals("")){
                    cilindraje.setHint("Ingresa el Cilindraje");//it gives user to hint
                    cilindraje.setError("Ingresa el Cilindraje");
                }
                else if(country.equalsIgnoreCase("")){
                    pais.setHint("Ingresa el país de origen");//it gives user to hint
                    pais.setError("Ingresa el país de origen");
                }
                else if(km.getText().toString().trim().equals("")){
                    km.setHint("Ingresa el Kilometraje");//it gives user to hint
                    km.setError("Ingresa el Kilometraje");
                }
                else if(propietarios.getText().toString().trim().equals("")){
                    propietarios.setHint("Ingresa el Nro de Dueños");//it gives user to hint
                    propietarios.setError("Nro de Dueños");
                }
                else{
                    if(agregarAuto(Integer.parseInt(codigo.getText().toString()),
                            mar, mod,
                            Integer.parseInt(anio.getText().toString()),
                            Integer.parseInt(precio.getText().toString()),
                            Integer.parseInt(cilindraje.getText().toString()),
                            country,
                            estado,
                            Integer.parseInt(km.getText().toString()),
                            Integer.parseInt(propietarios.getText().toString()))){
                        Toast.makeText(getContext(), "Vehículo registrado correctamente", Toast.LENGTH_SHORT).show();
                        codigo.getText().clear();
                        marca.getText().clear();
                        modelo.getText().clear();
                        anio.getText().clear();
                        precio.getText().clear();
                        cilindraje.getText().clear();
                        pais.getText().clear();
                        km.getText().clear();
                        propietarios.getText().clear();
                        rb1.setChecked(false);
                        rb2.setChecked(false);
                    };
                }







            }
        });

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


}