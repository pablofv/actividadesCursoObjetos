package ar.org.centro8.curso.java.proyecto.repositorios.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import ar.org.centro8.curso.java.proyecto.entities.Producto;
import ar.org.centro8.curso.java.proyecto.repositorios.interfaces.I_ProductoRepository;

public class ProductoRepository implements I_ProductoRepository {
    private Connection conn;
    
    public ProductoRepository(Connection conn) {
        this.conn = conn;
    }
    @Override
    public void save(Producto producto) {
        if (producto == null){
            return;
        }
        try (PreparedStatement ps = conn.prepareStatement(
            "insert into productos(nombre, marca, tipoProducto, precioCosto, unidad, cantidadPorUnidad) values (?, ?, ?, ?, ?, ?)",
            PreparedStatement.RETURN_GENERATED_KEYS);) {
                ps.setString(1, producto.getNombre());
                ps.setString(2,producto.getMarca());
                ps.setString(3, producto.getTipoProducto().toString());
                ps.setDouble(4, producto.getPrecioCosto());
                ps.setString(5, producto.getUnidad().toString());
                ps.setDouble(6, producto.getCantidadPorUnidad());
                ps.execute();
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next())
                    producto.setId(rs.getInt(1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @Override
    public void remove(Producto producto){
        if (producto == null){
            return;
        }
        try(PreparedStatement ps = conn.prepareStatement("delete from productos where id = ?")){
            ps.setInt(1, producto.getId());
            ps.execute();
        } catch (Exception e){
            System.out.println(e);
        }
    };
    @Override
    public void update(Producto producto){
        if(producto == null){
            return;
        }
        try (PreparedStatement ps = conn.prepareStatement("update productos set nombre = ?, marca = ?," +
            "tipoProducto = ?, precioCosto = ?, unidad = ?, cantidadPorUnidad = ? where id = ?")) {
                ps.setString(1, producto.getNombre());
                ps.setString(2,producto.getMarca());
                ps.setString(3, producto.getTipoProducto().toString());
                ps.setDouble(4, producto.getPrecioCosto());
                ps.setString(5, producto.getUnidad().toString());
                ps.setDouble(6, producto.getCantidadPorUnidad());
                ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void update(Colegio colegio) {
        if (colegio == null){
            return;
        }
        try (PreparedStatement ps = conn.prepareStatement(
                "update colegios set nombre = ?, direccion = ? where id = ?")) {
                ps.setString(1, colegio.getNombre());
                ps.setString(2, colegio.getDireccion());
                ps.setInt(3, colegio.getId());
                ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    List<Producto>getAll();
}
