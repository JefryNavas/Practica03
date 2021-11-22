package com.example.practica03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    private EditText nombre,cedula,codigo,user,password,confimar;
    private Button btn_save;
    public Usuario usuario = new Usuario();
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        context=this;
        nombre = (EditText)findViewById(R.id.txt_nombre);
        cedula = (EditText)findViewById(R.id.txt_cedula);
        codigo = (EditText)findViewById(R.id.txt_codigo);
        user = (EditText)findViewById(R.id.txt_userlogin);
        password = (EditText)findViewById(R.id.txt_psw);
        confimar = (EditText)findViewById(R.id.txt_psw2);
        btn_save = findViewById(R.id.btn_save);
        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nombre.getText().toString();
                String us = user.getText().toString();
                String pass = password.getText().toString();
                String cpass = confimar.getText().toString();


                if(name.equalsIgnoreCase("")){
                    nombre.setHint("Ingresa tu nombre");//it gives user to hint
                    nombre.setError("Ingresa tu nombre");
                }else if(cedula.getText().toString().trim().equals("")){
                    cedula.setHint("Ingresa tu C.I");//it gives user to hint
                    cedula.setError("Ingresa tu C.I");
                }
                else if(codigo.getText().toString().trim().equals("")){
                    codigo.setHint("Ingresa tu C.I");//it gives user to hint
                    codigo.setError("Ingresa tu C.I");
                }
                else if(us.equalsIgnoreCase("")){
                    user.setHint("Ingresa tu usuario");//it gives user to hint
                    user.setError("Ingresa tu usuario");
                }

                else if(pass.length()<8 &&!isValidPassword(pass)){
                    password.setHint("Contraseña no válida");//it gives user to hint
                    password.setError("Debe contener mínimo 8 caracteres, con especial, y número obligatorio");
                }
                else if(!cpass.equalsIgnoreCase(pass)){
                    confimar.setHint("Debe coincidir con la contraseña");//it gives user to hint
                    confimar.setError("Contraseñas no similares");
                }
                else{
                    long ci = Long.parseLong(cedula.getText().toString());
                    int cod = Integer.parseInt(codigo.getText().toString());
                    if(registrarUsuario(name,ci,cod,us,pass)){
                        Toast.makeText(context, "Usuario Registrado Correctamente", Toast.LENGTH_SHORT).show();
                        codigo.getText().clear();
                        nombre.getText().clear();
                        cedula.getText().clear();
                        password.getText().clear();
                        confimar.getText().clear();
                        user.getText().clear();
                    }
                }
            }
        });
        UserBD();
    }


    public boolean registrarUsuario(String nombre, long cedula, int codigo,String user, String psw){
        Usuario aux;
        aux = new Usuario();
        aux.setNombre(nombre);
        aux.setCedula(cedula);
        aux.setCodigo(codigo);
        aux.setUser(user);
        aux.setPassword(psw);
        aux.setCodigo(codigo);
        usuario.usuariolist.add(aux);
        return true;
    }

    public void UserBD(){
        Usuario aux;
        aux = new Usuario();
        aux.setNombre("Administrador");
        aux.setCedula(1722122783);
        aux.setCodigo(2406);
        aux.setUser("admin");
        aux.setPassword("admin-sistema123");
        aux.setCodigo(2406);
        usuario.usuariolist.add(aux);
    }


    public static boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }

    public void irLogin(View vista){
        Intent go = new Intent(this, Login.class);
        startActivity(go);
    }
}