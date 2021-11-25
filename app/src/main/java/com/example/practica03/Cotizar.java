package com.example.practica03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Calendar;

public class Cotizar extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Concesionario cotizar = new Concesionario();
    String precio,anio;
    private Spinner dropdown;
    private EditText entrada;
    private TextView res;
    private  static  final String[] items = new String[]{"12", "24", "48","60"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cotizar);
        res = findViewById(R.id.resultado_cotizar);
        precio = String.valueOf(cotizar.auto.getPrecio());
        anio = String.valueOf(cotizar.auto.getAnio());
        entrada = findViewById(R.id.txt_entrada);
        dropdown = findViewById(R.id.spn_cuotas);
        dropdown.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        //res.setText(""+precio+"    "+anio);
        findViewById(R.id.btn_cotizar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String etd = entrada.getText().toString();
                int etdint = Integer.parseInt(etd) ;
                double prec = Double.parseDouble(precio.toString());
                double tenp = prec*0.1;


                if(etd.equalsIgnoreCase("")){
                    entrada.setHint("Ingresa el Valor de la entrada");//it gives user to hint
                    entrada.setError("Ingresa la Entrada");
                }
                else if(etdint<tenp){
                    entrada.setHint("Entrada muy baja");//it gives user to hint
                    entrada.setError("La entrada debe ser al menos el 10% del valor del auto");
                }
                else{
                    calcular(view);
                }
            }
        });
    }


    private int transformar(String value){
        int res = Integer.parseInt(value);
       return res;

    }

    int valcuo;
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(adapterView.getId()==R.id.spn_cuotas){
            String val = adapterView.getItemAtPosition(i).toString();
            valcuo = transformar(val);
        }

    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void calcular(View vista){

        double ent = Double.parseDouble(entrada.getText().toString());
        double pauto = Double.parseDouble(precio.toString());
        DecimalFormat df = new DecimalFormat("#.##");
        int ncoutas = valcuo;
        double interes = 0.15;
        double pfinal = pauto-ent;
        double cuota = (pfinal+(pfinal*interes)*(ncoutas/12))/ncoutas;
        res.setText("Las coutas mensuales serán de: $"+df.format(cuota)+" por "+ncoutas+" meses");

    }


}