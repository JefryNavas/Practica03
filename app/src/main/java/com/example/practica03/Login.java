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
    }

    public void cargarVista(View vista){
        Intent menu = new Intent(this, Menu.class);
        startActivity(menu);
    }

}