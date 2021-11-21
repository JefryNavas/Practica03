package com.example.practica03;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class Vender extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout mDrawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vender);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        getSupportFragmentManager().beginTransaction().add(R.id.content,new registrarFragment()).commit();
        setTitle("Registrar");

        setSupportActionBar(toolbar);

        toggle = setUpDrawerToggle();
        mDrawerLayout.addDrawerListener(toggle);


        navigationView.setNavigationItemSelectedListener(this);
    }
    private ActionBarDrawerToggle setUpDrawerToggle(){
     return new ActionBarDrawerToggle(this,
             mDrawerLayout,
             toolbar,
             R.string.drawer_open,
             R.string.drawer_close);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        selectItemNav(item);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    private void selectItemNav(MenuItem item) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        switch (item.getItemId()){
            case R.id.nav_registar:
                ft.replace(R.id.content,new registrarFragment()).commit();
                break;
            case R.id.nav_consultar:
                ft.replace(R.id.content,new consultarFragment()).commit();
                break;
            case R.id.nav_actualizar:
                ft.replace(R.id.content,new actualizarFragment()).commit();
                break;
            case R.id.nav_eliminar:
                ft.replace(R.id.content,new eliminarFragment()).commit();
                break;
            case R.id.nav_cotizar:
                ft.replace(R.id.content,new cotizarFragment()).commit();
                break;
        }
        setTitle(item.getTitle());
        mDrawerLayout.closeDrawers();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}