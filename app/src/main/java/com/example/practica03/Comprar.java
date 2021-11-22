package com.example.practica03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Calendar;

public class Comprar extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner dropdown, dropdown2, dropdown3;
    private EditText marca,modelo,year,km,valor,owners;
    private TextView res;
    private  static  final String[] items = new String[]{"Excelente", "Regular", "Mala"};
    private Switch sw1, sw2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar);

        marca = (EditText)findViewById(R.id.txt_marca);
        modelo = (EditText)findViewById(R.id.txt_modelo);
        year = (EditText)findViewById(R.id.txt_year);
        year.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "2021")});
        valor = (EditText)findViewById(R.id.txt_precio);
        km = (EditText)findViewById(R.id.txt_km);
        owners = (EditText)findViewById(R.id.txt_owners);
        owners.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "50")});
        sw1 = findViewById(R.id.swt_choques);
        sw2 = findViewById(R.id.sw_ac);
        dropdown = findViewById(R.id.spn_tapi);
        dropdown.setOnItemSelectedListener(this);
        dropdown2 = findViewById(R.id.spn_pintura);
        dropdown3 = findViewById(R.id.spn_carro);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        dropdown2.setAdapter(adapter);
        dropdown3.setAdapter(adapter);
        res = (TextView) findViewById(R.id.txt_resultado);


    }



    private int transformar(String value){
        int res;
        if(value =="Excelente"){
            res = 1;
        }else if(value =="Regular"){
            res =2;
        }else{
            res = 3;
        }
        return res;
    }
    int vtap,vpint,vcar;

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(adapterView.getId()==R.id.spn_tapi){
            String val = adapterView.getItemAtPosition(i).toString();
            vtap = transformar(val);
        }
        if(adapterView.getId()==R.id.spn_pintura){
            String val = adapterView.getItemAtPosition(i).toString();
            vpint = transformar(val);
        }
        if(adapterView.getId()==R.id.spn_carro){
            String val = adapterView.getItemAtPosition(i).toString();
            vcar = transformar(val);
        }


    }
    double npreciot,npreciop,nprecioc;
    private void calculosSpinner(){
        double venta = Double.parseDouble(valor.getText().toString());
        if(vtap==1){
            npreciot = (venta*0.01)+venta;
        }else if(vtap==2){
            npreciot = venta-(venta*0.015);
        }else{
            npreciot = venta-(venta*0.03);
        }

        if(vpint==1){
            npreciop = (venta*0.02)+venta;
        }else if(vpint==2){
            npreciop = venta-(venta*0.02);
        }else{
            npreciop = venta-(venta*0.1);
        }

        if(vcar==1){
            nprecioc = (venta*0.02)+venta;
        }else if(vcar==2){
            nprecioc = venta-(venta*0.02);
        }else{
            nprecioc = venta-(venta*0.1);
        }
    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void calcular(View vista){
        int cyear = Calendar.getInstance().get(Calendar.YEAR);
        int yr = Integer.parseInt(year.getText().toString());
        double venta = Double.parseDouble(valor.getText().toString());
        int kil = Integer.parseInt(km.getText().toString());
        int own = Integer.parseInt(owners.getText().toString());
        int rango = cyear-yr;
        Boolean switchState = sw1.isChecked();
        Boolean switchState2 = sw2.isChecked();
        double desyear=0,deskm=0,desown=0,deschoques=0,descac=0;
        if(rango>10){
            res.setText("El auto supera los 10 años no se puede comprar");
        }else{
             desyear = (venta*0.015)*rango;
             if(kil>80000){
                 deskm = venta*0.025;
             }
             if(own>1){
                 desown = (venta*0.02)*own;
             }
             calculosSpinner();
             double montot = npreciot - venta;
             double montop = npreciop - venta;
             double montoc = nprecioc - venta;
             if(switchState){
                 deschoques = venta*0.15;
             }
             if(switchState2){
                 descac = venta*0.005;
             }

             double pfinal = venta-desyear-deskm-deschoques-descac-desown+(montot)+(montop)+(montoc);

            res.setText("Debes Ofrecer: $"+pfinal+" por este auto");



        }
    }
}