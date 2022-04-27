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
        //esteVehiculo es el propio objeto
        //vehiculoParametro es el objeto que recibe por parámetro, contra el cual se comparará

        String esteVehiculo =          (this.getMarca().toLowerCase() + "," +     this.getModelo().toLowerCase() + "," +     this.precioConFormato());
        String vehiculoParametro = (vehiculo.getMarca().toLowerCase() + "," + vehiculo.getModelo().toLowerCase() + "," + vehiculo.precioConFormato());
        //return esteVehiculo.compareTo(vehiculoParametro)*-1;
        return esteVehiculo.compareTo(vehiculoParametro);
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

    public String precioConFormato(){
        //Voy a crear la máscara aquí, para que este método devuelva el precio con el formato establecido, y no haya que cambiar el formato en otros lugares
        DecimalFormat df = new DecimalFormat("000,000,000.00"); //Voy a considerar hasta un precio de 999 millones
        return df.format(this.getPrecio()).toLowerCase(); //Obtenemos el precio, el aplicamos el formato y lo pasamos a minúsculas
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }



    
    
}
