package ar.org.centro8.activadad2.java.actividad2.entities;

import java.text.DecimalFormat;

public class Moto extends Vehiculo{
    private String cilindrada;

    public Moto(String marca, String modelo, Double precio, String cilindrada) {
        super(marca, modelo, precio);
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        DecimalFormat df=new DecimalFormat("###,###.00");
        //Modelo de ejmplo de salida
        //Marca: Yamaha // Modelo: YBR // Cilindrada: 160c // Precio: $80.500,50
        return super.toString() + " // Cilindrada: " + cilindrada + " // Precio: $" + df.format(super.getPrecio());
    }
    
}
