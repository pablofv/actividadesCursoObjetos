package ar.org.centro8.curso.java.proyecto.repositorios.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.org.centro8.curso.java.proyecto.entities.Factura;
import ar.org.centro8.curso.java.proyecto.repositorios.interfaces.I_FacturaRepository;

public class FacturaRepository implements I_FacturaRepository {
    private Connection conn;
    
    public FacturaRepository(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void save(Factura factura) {
        if(factura == null){
            return;
        }
        try (PreparedStatement ps = conn.prepareStatement(
            "insert into facturas(fechaFactura, totalFacturado, idColegio) values (?, ?, ?)",
            PreparedStatement.RETURN_GENERATED_KEYS);){
                // ps.setString(1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(factura.getFechaFactura()));
                ps.setString(1, factura.getFechaComoCadera());
                ps.setDouble(2, factura.getTotalFacturado());
                ps.setInt(3, factura.getIdColegio());
                ps.execute();
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next())
                    factura.setId(rs.getInt(1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void remove(Factura factura) {
        if(factura == null){
            return;
        }
        try(PreparedStatement ps = conn.prepareStatement("delete from facturas where id = ?")) {
            ps.setInt(1, factura.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void update(Factura factura) {
        if(factura == null){
            return;
        }
        try (PreparedStatement ps = conn.prepareStatement(
                "update facturas set fechaFactura = ?, totalFacturado = ?, idColegio = ? where id = ?")) {
                ps.setString(1, factura.getFechaComoCadera());
                ps.setDouble(2, factura.getTotalFacturado());
                ps.setInt(3, factura.getIdColegio());
                ps.setInt(4, factura.getId());
                ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Dos sdf para formatear el valor como fecha y como horas y luego unirlos en un string
    SimpleDateFormat sdfDias = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdfHoras = new SimpleDateFormat("HH:mm:ss");
    //String que concatena la fecha y la hora
    String stringFechaConHora;
    //Fecha en base al string
    Date fechaConHora;

    @Override
    public List<Factura> getAll() {
        List<Factura> list = new ArrayList<>();
        try (ResultSet rs = conn.createStatement().executeQuery("select * from facturas")){
            while(rs.next()){
                //Genero la fecha como una cadena con la forma yyyy-mm-dd hh:mi:ss
                stringFechaConHora = sdfDias.format(rs.getDate("fechaFactura")) + " " + sdfHoras.format(rs.getTime("fechaFactura"));
                //Y ahora genero una variable Date con las horas además de los días
                fechaConHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(stringFechaConHora);
                list.add(new Factura(
                                    rs.getInt("id"),
                                    fechaConHora,
                                    rs.getDouble("totalFacturado"),
                                    rs.getInt("idColegio")
                        )
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
