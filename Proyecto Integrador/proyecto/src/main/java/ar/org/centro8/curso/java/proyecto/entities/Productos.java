package ar.org.centro8.curso.java.proyecto.entities;

import ar.org.centro8.curso.java.proyecto.enums.TipoProducto;
import ar.org.centro8.curso.java.proyecto.enums.Unidad;

public class Productos {
    private int id;
    private String nombre;
    private String marca;
    private TipoProducto tipoProducto;
    private double precioCosto;
    private Unidad unidad;
    private double cantidadPorUnidad;
    public Productos(int id, String nombre, String marca, TipoProducto tipoProducto, double precioCosto, Unidad unidad,
            double cantidadPorUnidad) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.tipoProducto = tipoProducto;
        this.precioCosto = precioCosto;
        this.unidad = unidad;
        this.cantidadPorUnidad = cantidadPorUnidad;
    }
    public Productos(String nombre, String marca, TipoProducto tipoProducto, double precioCosto, Unidad unidad,
            double cantidadPorUnidad) {
        this.nombre = nombre;
        this.marca = marca;
        this.tipoProducto = tipoProducto;
        this.precioCosto = precioCosto;
        this.unidad = unidad;
        this.cantidadPorUnidad = cantidadPorUnidad;
    }
    @Override
    public String toString() {
        return "Productos [cantidadPorUnidad=" + cantidadPorUnidad + ", id=" + id + ", marca=" + marca + ", nombre="
                + nombre + ", precioCosto=" + precioCosto + ", tipoProducto=" + tipoProducto + ", unidad=" + unidad
                + "]";
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
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }
    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
    public double getPrecioCosto() {
        return precioCosto;
    }
    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }
    public Unidad getUnidad() {
        return unidad;
    }
    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }
    public double getCantidadPorUnidad() {
        return cantidadPorUnidad;
    }
    public void setCantidadPorUnidad(double cantidadPorUnidad) {
        this.cantidadPorUnidad = cantidadPorUnidad;
    }
    
}
