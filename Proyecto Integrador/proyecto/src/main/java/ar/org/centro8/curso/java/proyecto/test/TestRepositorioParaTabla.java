package ar.org.centro8.curso.java.proyecto.test;

import java.sql.Connection;

import ar.org.centro8.curso.java.proyecto.connections.Connector;
import ar.org.centro8.curso.java.proyecto.repositorios.interfaces.I_TablaMostrarFacturasRepository;
import ar.org.centro8.curso.java.proyecto.repositorios.jdbc.TablaMostrarFacturasRepository;

public class TestRepositorioParaTabla {
    public static void main(String[] args) {
        Connection conn= Connector.getConnection();
        I_TablaMostrarFacturasRepository itmfr = new TablaMostrarFacturasRepository(conn);
        
        System.out.println("\nTodos\n");
        itmfr.getAll().forEach(System.out::println);
    }
}
