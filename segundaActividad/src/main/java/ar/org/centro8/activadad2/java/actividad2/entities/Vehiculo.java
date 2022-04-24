package ar.org.centro8.activadad2.java.actividad2.entities;

import java.text.DecimalFormat;

public abstract class Vehiculo implements Comparable<Vehiculo> {
    private String marca;
    private String modelo;
    private Double precio;
    
    //Constructor
    public Vehiculo(String marca, String modelo, Double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    @Override
    public String toString() {
        //Modelo de ejmplo de salida
        //Marca: Peugeot // Modelo: 206 // Puertas: 4 // Precio: $200.000,00
        return "Marca: " + marca + " // Modelo: " + modelo;
    }

    public int compareTo(Vehiculo vehiculo){
        //Marca, modelo y precio
        //thisVehiculo es el propio objeto
        //paraVehiculo es el objeto que recibe por parámetro, contra el cual se comparará

        DecimalFormat df=new DecimalFormat("###,###.00");
        String thisVehiculo = (this.getMarca()+","+this.getModelo()+","+df.format(this.getPrecio())).toLowerCase();
        String paraVehiculo = (vehiculo.getMarca()+","+vehiculo.getModelo()+","+df.format(vehiculo.getPrecio())).toLowerCase();
        //return thisVehiculo.compareTo(paraVehiculo)*-1;
        return thisVehiculo.compareTo(paraVehiculo);

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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }



    
    
}
