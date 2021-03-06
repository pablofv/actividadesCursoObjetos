package ar.org.centro8.activadad2.java.actividad2.entities;

import java.text.DecimalFormat;

public class Auto extends Vehiculo{
    private int nroPuertas;

    public Auto(String marca, String modelo, double precio, int nroPuertas) {
        super(marca, modelo, precio);
        this.nroPuertas = nroPuertas;
    }

    @Override
    public String toString() {
        //Modelo de ejmplo de salida
        //Marca: Peugeot // Modelo: 206 // Puertas: 4 // Precio: $200.000,00
        return super.toString() + " // Puertas: " + nroPuertas + " // Precio: $" + this.precioConFormato();//dejo this para consultar si hay alguna diferencia con super, ambos funcionaron
    }

    
    
}
