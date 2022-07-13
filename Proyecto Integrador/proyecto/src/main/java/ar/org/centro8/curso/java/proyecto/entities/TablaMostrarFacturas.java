/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.org.centro8.curso.java.proyecto.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Legion
 */
public class TablaMostrarFacturas {
    private Date fechaFactura;
    private double totalFacturado;
    private String nombreEscuela;
    private String nombreProducto;
    private double cantidadProducto;
    private double precioUnitario;
    private double totalFacturadoEnElItem;

    //Constructor vacio
    public TablaMostrarFacturas(){};
    
    public TablaMostrarFacturas(Date fechaFactura, double totalFacturado, String nombreEscuela, String nombreProducto,
            double cantidadProducto, double precioUnitario, double totalFacturadoEnElItem) {
        this.fechaFactura = fechaFactura;
        this.totalFacturado = totalFacturado;
        this.nombreEscuela = nombreEscuela;
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.precioUnitario = precioUnitario;
        this.totalFacturadoEnElItem = totalFacturadoEnElItem;
    }

    public TablaMostrarFacturas(String fechaFactura, String mascara, double totalFacturado, String nombreEscuela, String nombreProducto,
            double cantidadProducto, double precioUnitario, double totalFacturadoEnElItem) throws ParseException {
        this.fechaFactura = this.getFechaComoFecha(fechaFactura, mascara);
        this.totalFacturado = totalFacturado;
        this.nombreEscuela = nombreEscuela;
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.precioUnitario = precioUnitario;
        this.totalFacturadoEnElItem = totalFacturadoEnElItem;
    }

    @Override
    public String toString() {
        return "TablaMostrarFacturas [cantidadProducto=" + cantidadProducto + ", fechaFactura=" + fechaFactura
                + ", nombreEscuela=" + nombreEscuela + ", nombreProducto=" + nombreProducto + ", precioUnitario="
                + precioUnitario + ", totalFacturado=" + totalFacturado + ", totalFacturadoEnElItem="
                + totalFacturadoEnElItem + "]";
    }
    public Date getFechaFactura() {
        return fechaFactura;
    }
    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }
    public double getTotalFacturado() {
        return totalFacturado;
    }
    public void setTotalFacturado(double totalFacturado) {
        this.totalFacturado = totalFacturado;
    }
    public String getNombreEscuela() {
        return nombreEscuela;
    }
    public void setNombreEscuela(String nombreEscuela) {
        this.nombreEscuela = nombreEscuela;
    }
    public String getNombreProducto() {
        return nombreProducto;
    }
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public double getCantidadProducto() {
        return cantidadProducto;
    }
    public void setCantidadProducto(double cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }
    public double getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    public double getTotalFacturadoEnElItem() {
        return totalFacturadoEnElItem;
    }
    public void setTotalFacturadoEnElItem(double totalFacturadoEnElItem) {
        this.totalFacturadoEnElItem = totalFacturadoEnElItem;
    }
    public String getFechaComoCadera(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.getFechaFactura());
    }
    public Date getFechaComoFecha(String fechaString, String mascara) throws ParseException{
        Date fecha = new SimpleDateFormat(mascara).parse(fechaString);
        return fecha;
    }
}
