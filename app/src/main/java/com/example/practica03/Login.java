package com.example.practica03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    public Usuario usuario = new Usuario();
    private EditText user,password;
    private Button login;
    private Context context;
    public Concesionario auto = new Concesionario();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context=this;
        user = (EditText)findViewById(R.id.txt_userlogin);
        password = (EditText)findViewById(R.id.txt_password);
        login = findViewById(R.id.btn_login);
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String us = user.getText().toString();
                String pass = password.getText().toString();
                int position =0;
                for (int i = 0;i<usuario.usuariolist.size();i++){
                    String ius = usuario.usuariolist.get(i).getUser();
                    if(ius.equals(us)){
                        position = i;
                    }
                }
                String passpos = usuario.usuariolist.get(position).getPassword();



                if(passpos.equals(pass)){
                    Toast.makeText(context, "Login Correcto", Toast.LENGTH_SHORT).show();
                    cargarVista(view);


                }else{
                    password.setHint("Validación incorrecta");//it gives user to hint
                    password.setError("El usuario o la contraseña son erroneos");
                }

            }
        });
        AutosBD();
    }

    public void cargarVista(View vista){
        Intent menu = new Intent(this, Menu.class);
        startActivity(menu);
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
        aux.setCodigo(1);
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