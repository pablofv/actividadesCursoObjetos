package ar.org.centro8.curso.java.proyecto.entities;

public class ItemFactura {
    private int id;
    private int idFactura;
    private int idProducto;
    private double cantidadProducto;
    private double precioUnitario;
    
    public ItemFactura() {
    }
    public ItemFactura(int idFactura, int idProducto, double cantidadProducto, double precioUnitario) {
        this.idFactura = idFactura;
        this.idProducto = idProducto;
        this.cantidadProducto = cantidadProducto;
        this.precioUnitario = precioUnitario;
    }
    public ItemFactura(int id, int idFactura, int idProducto, double cantidadProducto, double precioUnitario) {
        this.id = id;
        this.idFactura = idFactura;
        this.idProducto = idProducto;
        this.cantidadProducto = cantidadProducto;
        this.precioUnitario = precioUnitario;
    }
    @Override
    public String toString() {
        return "ItemFactura [cantidadProducto=" + cantidadProducto + ", id=" + id + ", idFactura=" + idFactura
                + ", idProducto=" + idProducto + ", precioUnitario=" + precioUnitario + "]";
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdFactura() {
        return idFactura;
    }
    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }
    public int getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
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
}
