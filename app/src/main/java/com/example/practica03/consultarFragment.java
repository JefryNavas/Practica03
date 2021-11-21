package com.example.practica03;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AndroidViewModel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class consultarFragment extends Fragment {

    LinearLayout columna_vertical;
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

        for (int i = 0;i<auto.coches.size();i++){

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
            cv.addView(tv_dinamico);

            columna_vertical.addView(cv);
        }

        return root;
    }

}