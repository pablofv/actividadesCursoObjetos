package ar.org.centro8.curso.java.proyecto.entities;

import java.util.Date;

public class Facturas {
    private int id;
    private Date fechaFactura;
    private double totalFacturado;
    private int idColegio;
    public Facturas(int id, Date fechaFactura, double totalFacturado, int idColegio) {
        this.id = id;
        this.fechaFactura = fechaFactura;
        this.totalFacturado = totalFacturado;
        this.idColegio = idColegio;
    }
    public Facturas(Date fechaFactura, int idColegio) {
        this.fechaFactura = fechaFactura;
        this.idColegio = idColegio;
    }
    @Override
    public String toString() {
        return "Facturas [fechaFactura=" + fechaFactura + ", id=" + id + ", idColegio=" + idColegio + ", totalFacturado="
                + totalFacturado + "]";
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public int getIdColegio() {
        return idColegio;
    }
    public void setIdColegio(int idColegio) {
        this.idColegio = idColegio;
    }
}
