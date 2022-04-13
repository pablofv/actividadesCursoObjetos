package ar.org.centro8.curso.java.primerActividad.Entities;

import java.text.DecimalFormat;

public abstract class Vehiculo {
    //siempre tiene estos 3 atributos
    private String color;
    private String marca;
    private String modelo;

    //eventualmente puede tener precio
    private double precio;
    private Radio radio;

    @Override
    public String toString() {
        DecimalFormat objetoDF = new DecimalFormat("###,###.00");
        String precioDF = objetoDF.format(precio);
        return "Vehiculo{" + "color=" + color + ", marca=" + marca + ", modelo=" + modelo + ", radio=" + radio + ", precio=" + precioDF + '}';
    }

    //Constructor
    public Vehiculo(String color, String marca, String modelo) {
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
    }

    //getter y setter
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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

    //Agregamos una radio, si bien el auto nuevo se crea con radio, luego se le puede cambiar, y al auto antiguo
    //se lo puede crear sin radio, pero luego se le puede agregar, así que es el mismo comportamiento.
    //No se considera que ese agregar sea único, que sería que una vez puesta una radio, no se puede volver a cambiar.
    public void asignarUnaRadio(String nombre){
        this.radio = new Radio(nombre);
    }
}
