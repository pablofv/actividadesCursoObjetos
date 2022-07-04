package ar.org.centro8.curso.java.proyecto.repositorios.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ar.org.centro8.curso.java.proyecto.entities.ItemFactura;
import ar.org.centro8.curso.java.proyecto.repositorios.interfaces.I_ItemFacturaRepository;

public class ItemFacturaRepository implements I_ItemFacturaRepository{
    private Connection conn;
    
    public ItemFacturaRepository(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void save(ItemFactura itemFactura) {
        if(itemFactura == null){
            return;
        }
        try (PreparedStatement ps = conn.prepareStatement(
            "insert into itemfacturas(idFactura, idProducto, cantidadProducto, precioUnitario) " +
                              "values (?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);){
                ps.setInt(1, itemFactura.getIdFactura());
                ps.setInt(2, itemFactura.getIdProducto());
                ps.setDouble(3, itemFactura.getCantidadProducto());
                ps.setDouble(4, itemFactura.getPrecioUnitario());
                ps.execute();
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next())
                    itemFactura.setId(rs.getInt(1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void remove(ItemFactura itemFactura) {
        if(itemFactura == null){
            return;
        }
        try(PreparedStatement ps = conn.prepareStatement("delete from itemfacturas where id = ?")) {
            ps.setInt(1, itemFactura.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void update(ItemFactura itemFactura) {
        if(itemFactura == null){
            return;
        }
        try (PreparedStatement ps = conn.prepareStatement(
            "update itemfacturas set idFactura = ?, idProducto = ?, cantidadProducto = ?, precioUnitario = ? where id = ?")) {
                ps.setInt(1, itemFactura.getIdFactura());
                ps.setInt(2, itemFactura.getIdProducto());
                ps.setDouble(3, itemFactura.getCantidadProducto());
                ps.setDouble(4, itemFactura.getPrecioUnitario());
                ps.setInt(5, itemFactura.getId());
                ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<ItemFactura> getAll() {
        List<ItemFactura> list = new ArrayList<>();
        try (ResultSet rs = conn.createStatement().executeQuery("select * from itemfacturas")) {
            while(rs.next()){
                list.add(new ItemFactura(rs.getInt("id"),
                                         rs.getInt("idFactura"),
                                         rs.getInt("idProducto"),
                                         rs.getInt("cantidadProducto"),
                                         rs.getInt("precioUnitario"))
                        );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
