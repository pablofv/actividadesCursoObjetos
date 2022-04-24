package ar.org.centro8.activadad2.java.actividad2.entities;

public class Auto extends Vehiculo{
    private int nroPuertas;

    public Auto(String marca, String modelo, Double precio, int nroPuertas) {
        super(marca, modelo, precio);
        this.nroPuertas = nroPuertas;
    }

    @Override
    public String toString() {
        return "Auto " + super.toString() + " // Puertas:" + nroPuertas + "]";
    }

    
    
}
