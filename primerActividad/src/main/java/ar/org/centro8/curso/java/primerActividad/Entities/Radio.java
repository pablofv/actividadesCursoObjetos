package ar.org.centro8.curso.java.primerActividad.Entities;

public class Radio {

    String marca;

    public Radio(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Radio [marca=" + marca + "]";
    }
}
