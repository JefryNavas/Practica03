package com.example.practica03;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class cotizarFragment extends Fragment {

    Concesionario cotizar = new Concesionario();
    public Button btn_continuar;
    public EditText precio,anio;
    int pre,ani;

    public cotizarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_cotizar, container, false);
        // Inflate the layout for this fragment

        precio = root.findViewById(R.id.precio_cotizar);
        anio = root.findViewById(R.id.anio_cotizar);



        btn_continuar = root.findViewById(R.id.btn_continuar);

        btn_continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cotizar.auto = new Concesionario(Integer.parseInt(precio.getText().toString()),Integer.parseInt(anio.getText().toString()));
                cargarConsulta();
            }
        });

        return root;



    }

    public void cargarConsulta(){
        Intent comprar = new Intent(getContext(), Cotizar.class);
        startActivity(comprar);
    }
}