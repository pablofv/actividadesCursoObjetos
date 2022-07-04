package ar.org.centro8.curso.java.proyecto.repositorios.jdbc;

import java.util.List;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


import ar.org.centro8.curso.java.proyecto.entities.Factura;
import ar.org.centro8.curso.java.proyecto.repositorios.interfaces.I_FacturaRepository;

public class FacturaRepository implements I_FacturaRepository{
    private Connection conn;
    
    public FacturaRepository(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Factura> getAll() {
        List<Factura> list = new ArrayList<>();
        LocalDateTime ldt;
        String fecha;
        try (ResultSet rs = conn.createStatement().executeQuery("select * from facturas")){
            while(rs.next()){
                // System.out.println("xxxxx");
                // System.out.println(rs.getDate("fechaFactura"));
                // System.out.println(rs.getTime("fechaFactura"));
                fecha = rs.getDate("fechaFactura").toString() + "T" + rs.getTime("fechaFactura").toString();
                // System.out.println(fecha);
                 ldt=LocalDateTime.parse(fecha);

                // ldt=LocalDateTime.of(rs.getDate("fechaFactura").getYear() + 1900,
                //                      rs.getDate("fechaFactura").getMonth() + 1,
                //                      rs.getDate("fechaFactura").getDate(),
                //                      rs.getTime("fechaFactura").getHours(),
                //                      rs.getTime("fechaFactura").getMinutes(),
                //                      rs.getTime("fechaFactura").getSeconds());
                // System.out.println(ldt);
                list.add(new Factura(
                                    rs.getInt("id"),
                                    ldt,
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
/*
 *public void save(Colegio colegio) {
        if (colegio == null){
            return;
        }
        try (PreparedStatement ps = conn.prepareStatement(
            "insert into colegios(nombre, direccion) values (?, ?)",
            PreparedStatement.RETURN_GENERATED_KEYS);) {
                ps.setString(1, colegio.getNombre());
                ps.setString(2,colegio.getDireccion());
                ps.execute();
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next())
                    colegio.setId(rs.getInt(1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
 */
    // @Override
    // public void save(Factura factura) {
    //     if(factura == null){
    //         return;
    //     }
    //     Date fecha;
    //     try (PreparedStatement ps = conn.prepareStatement(
    //         "insert into facturas(fechaFactura, totalFacturado, idColegio) values (?, ?, ?)",
    //         PreparedStatement.RETURN_GENERATED_KEYS);) {
    //             fecha = new java.util.Date(
    //                                         factura.getFechaFactura().getYear(),
    //                                         factura.getFechaFactura().getMonthValue(), 
    //                                         factura.getFechaFactura().getDayOfMonth(), 
    //                                         factura.getFechaFactura().getHour(), 
    //                                         factura.getFechaFactura().getMinute(),
    //                                         factura.getFechaFactura().getSecond()
    //                                         );
    //             ps.setDate(1, new java.sql.Date());
    //             ps.setTime(arg0, arg1);
    //     } catch (Exception e) {
    //         //TODO: handle exception
    //     }
        
    // }

    @Override
    public void remove(Factura factura) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(Factura factura) {
        // TODO Auto-generated method stub
        
    }
}

