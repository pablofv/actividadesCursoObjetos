package ar.org.centro8.activadad2.java.actividad2.entities;

public class Moto extends Vehiculo{
    private String cilindrada;

    public Moto(String marca, String modelo, Double precio, String cilindrada) {
        super(marca, modelo, precio);
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        return "Moto " + super.toString() + " // Cilindrada:" + cilindrada + "]";
    }
    
}
