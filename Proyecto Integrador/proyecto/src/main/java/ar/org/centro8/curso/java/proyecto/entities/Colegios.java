package ar.org.centro8.curso.java.proyecto.entities;

public class Colegios {
    private int id;
    private String nombre;
    private String direccion;
    
    public Colegios(int id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }
    public Colegios(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }
    @Override
    public String toString() {
        return "Colegios [direccion=" + direccion + ", id=" + id + ", nombre=" + nombre + "]";
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
