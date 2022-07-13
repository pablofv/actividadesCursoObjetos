/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.org.centro8.curso.java.proyecto.repositorios.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import ar.org.centro8.curso.java.proyecto.entities.TablaMostrarFacturas;
import ar.org.centro8.curso.java.proyecto.repositorios.interfaces.I_TablaMostrarFacturasRepository;

/**
 *
 * @author Legion
 */
public class TablaMostrarFacturasRepository implements I_TablaMostrarFacturasRepository{
    private Connection conn;
    
    public TablaMostrarFacturasRepository(Connection conn) {
        this.conn = conn;
    }

    /* 
        Se crea una clase para depositar el select de varias tablas, y mediante un repositorio, poder
        crear una tabla y mostrarla en un formulario con la función htmlTable.
     * @see ar.org.centro8.curso.java.proyecto.repositorios.interfaces.I_TablaMostrarFacturasRepository#getAll()
     */
    @Override
    public List<TablaMostrarFacturas>getAll(){
        List<TablaMostrarFacturas> list = new ArrayList<>();
        try (ResultSet rs = conn.createStatement().executeQuery("select fechaFactura, f.totalFacturado, c.nombre nombreEscuela, " +
                                                                "p.nombre nombreProducto, ifa.cantidadProducto, ifa.precioUnitario, ifa.cantidadProducto * ifa.precioUnitario" +
                                                                "from facturas f join itemfacturas ifa on f.id = ifa.idFactura" +
                                                                                "join productos p on ifa.idProducto = p.id" +
                                                                                "join colegios c on f.idColegio = c.id" +
                                                                "where f.id = " + 1 +
                                                                "order by f.id, ifa.id")){
            while(rs.next()){
                list.add(
                    new TablaMostrarFacturas(rs.getString("fechaFactura"),
                                             "mascara",
                                             rs.getDouble("totalFacturado"),
                                             rs.getString("nombreEscuela"),
                                             rs.getString("nombreProducto"),
                                             rs.getDouble("cantidadProducto"),
                                             rs.getDouble("precioUnitario"),
                                             rs.getDouble("totalFacturadoEnElItem")
                                            )
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
