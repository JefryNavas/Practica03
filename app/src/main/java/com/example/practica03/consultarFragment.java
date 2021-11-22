package com.example.practica03;


import android.content.Intent;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class consultarFragment extends Fragment {
    Concesionario encontrado = new Concesionario();
    Concesionario coche = new Concesionario();
    LinearLayout columna_vertical;
    public EditText buscar;
    public Button btn_buscar;
    public TextView res;
    public Concesionario auto = new Concesionario();
    public consultarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_consultar, container, false);
        columna_vertical = root.findViewById(R.id.colmnuna_vertical);


        btn_buscar = root.findViewById(R.id.btn_buscar);

        btn_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscar = root.findViewById(R.id.buscar);
                if (buscarVehiculo(Integer.parseInt(buscar.getText().toString()))){
                    auto.coche_encontrado = new Concesionario(encontrado.getCodigo(),encontrado.getMarca(),encontrado.getModelo(),encontrado.getPais(),encontrado.getEstado(),encontrado.getAnio(),encontrado.getPrecio(),
                            encontrado.getCilindraje(),encontrado.getKm(),encontrado.getPropietarios());

                    cargarConsulta();
                } else {
                    Toast.makeText(getContext(), "No hay vehículo", Toast.LENGTH_SHORT).show();
                }
            }
        });
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        params.setMargins(700,200,0,0);
        for (int i = 0;i<auto.coches.size();i++){
            Button btn_eliminar = new Button(getContext());
            CardView cv = new CardView(getContext());
            TextView tv_dinamico = new TextView(getContext());
            tv_dinamico.setTextSize(20);

            tv_dinamico.setText("Codigo: "+auto.coches.get(i).getCodigo()+
                    "\nMarca: "+auto.coches.get(i).getMarca()+
                    "\nModelo: "+auto.coches.get(i).getModelo()+
                    "\nAño: "+auto.coches.get(i).getAnio()+
                    "\nPrecio: "+auto.coches.get(i).getPrecio()+
                    "\nCilindraje: "+auto.coches.get(i).getCilindraje()+
                    "\nPaís de Origen: "+auto.coches.get(i).getPais()+
                    "\nEstado: "+auto.coches.get(i).getEstado()+
                    "\nKilometraje: "+auto.coches.get(i).getKm()+
                    "\nDueños: "+auto.coches.get(i).getPropietarios());
            cv.setRadius(15);
            cv.setPadding(25, 25, 25, 25);
            cv.setMaxCardElevation(30);
            cv.setCardElevation(6);
            cv.setUseCompatPadding(true);
            btn_eliminar.setText("Eliminar");
            btn_eliminar.setLayoutParams(params);
            Eliminar(btn_eliminar,auto.coches.get(i).getCodigo());
            cv.addView(btn_eliminar);
            cv.addView(tv_dinamico);


            columna_vertical.addView(cv);
        }
        int cont = auto.coches.size();
        Toast.makeText(getContext(), "Tamaño: "+cont, Toast.LENGTH_SHORT).show();
        return root;
    }

    public boolean buscarVehiculo(int num){

        for (int i = 0; i < auto.coches.size(); i++) {
            if (num == auto.coches.get(i).getCodigo()){
                encontrado = auto.coches.get(i);
                return true;
            }
        }


        return false;
    }
    public Concesionario buscarVehiculo2(int num){

        for (int i = 0; i < auto.coches.size(); i++) {
            if (num == auto.coches.get(i).getCodigo()){
                encontrado = auto.coches.get(i);
                return encontrado;
            }
        }
        return null;

    }

    public void cargarConsulta(){
        Intent comprar = new Intent(getContext(), actualizarVehiculo.class);
        startActivity(comprar);
    }
    public void cargarConsulta2(){
        Intent comprar = new Intent(getContext(), Vender.class);
        startActivity(comprar);
    }

    public void Eliminar(Button eliminar,int cod){

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coche = buscarVehiculo2(cod);
                auto.coches.remove(coche);
                Toast.makeText(getContext(), "Eliminado", Toast.LENGTH_SHORT).show();
                cargarConsulta2();
            }
        });
    }


}