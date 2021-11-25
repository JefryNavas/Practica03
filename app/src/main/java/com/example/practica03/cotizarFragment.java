package com.example.practica03;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.InputFilter;
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
        anio.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "2021")});



        btn_continuar = root.findViewById(R.id.btn_continuar);

        btn_continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String prec = precio.getText().toString();
                String year = anio.getText().toString();

                if(prec.equalsIgnoreCase("")){
                    precio.setHint("Ingresa el precio");//it gives user to hint
                    precio.setError("Ingresa el precio del auto");
                }
                else if(year.equalsIgnoreCase("")){
                    anio.setHint("Ingresa el Año del auto");//it gives user to hint
                    anio.setError("Ingresa el Año del auto");
                }else{

                    cotizar.auto = new Concesionario(Integer.parseInt(precio.getText().toString()),Integer.parseInt(anio.getText().toString()));
                    cargarConsulta();
                }

            }
        });

        return root;



    }

    public void cargarConsulta(){
        Intent comprar = new Intent(getContext(), Cotizar.class);
        startActivity(comprar);
    }
}