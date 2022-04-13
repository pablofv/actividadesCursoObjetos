package ar.org.centro8.curso.java.primerActividad.Entities;

public class Nuevo extends Vehiculo {

    public Nuevo(String color, String marca, String modelo, String nombreRadio) {
        super(color, marca, modelo);
        super.asignarUnaRadio(nombreRadio);
    }
}
