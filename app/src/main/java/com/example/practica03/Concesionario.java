package com.example.practica03;

import java.util.ArrayList;

public class Concesionario {
    static ArrayList<Concesionario> coches = new ArrayList();
    static Concesionario coche_encontrado;
    public Concesionario(){}


    private int codigo;
    private String marca;
    private String modelo;
    private String pais;
    private String estado;
    private int anio;
    private int precio;
    private int cilindraje;
    private int Km;
    private int propietarios;

    public Concesionario(int codigo,String marca,String modelo,String pais,String estado,int anio,int precio,int cilindraje,
                         int km,int propietarios){
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.pais = pais;
        this.estado = estado;
        this.anio = anio;
        this.precio = precio;
        this.cilindraje = cilindraje;
        this.Km = km;
        this.propietarios = propietarios;
    }

    public int getKm() {
        return Km;
    }

    public void setKm(int Km) {
        this.Km = Km;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public int getPropietarios() {
        return propietarios;
    }

    public void setPropietarios(int propietarios) {
        this.propietarios = propietarios;
    }
}
