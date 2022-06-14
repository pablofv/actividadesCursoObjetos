package ar.org.centro8.curso.java.proyecto.test;

import java.sql.Connection;

import ar.org.centro8.curso.java.proyecto.connections.Connector;
import ar.org.centro8.curso.java.proyecto.entities.Colegio;
import ar.org.centro8.curso.java.proyecto.repositorios.interfaces.I_ColegioRepository;
import ar.org.centro8.curso.java.proyecto.repositorios.jdbc.ColegioRepository;

public class TestRepository {
    public static void main(String[] args) {
        Connection conn= Connector.getConnection();
        I_ColegioRepository cr = new ColegioRepository(conn);

         Colegio colegio = new Colegio("JI Nº902 Alfonsina Storni", "Capdevilla 5905, Villa Ballester, Provincia Bs.As.");
        // cr.save(colegio);

        colegio = cr.getById(4);
        colegio.setNombre("Jardín de infantes nº902");
        //cr.update(colegio);

        // Mostrar todos
        System.out.println("\nTodos\n");
        cr.getAll().forEach(System.out::println);

        //Buscar por dirección
        System.out.println("\nBuscando por dirección:\n");
        cr.getLikeDireccion("Simon").forEach(System.out::println);
        cr.getLikeDireccion("Alsina").forEach(System.out::println);
        cr.getLikeDireccion("Rawson").forEach(System.out::println);

        //Buscar por nombre
        System.out.println("\nBuscando por nombre:\n");
        cr.getLikeNombre("68").forEach(System.out::println);
        cr.getLikeNombre("47").forEach(System.out::println);
        cr.getLikeNombre("502").forEach(System.out::println);

        //Borramos un colegio
        cr.remove(cr.getById(5));
        //cr.remove(cr.getLikeDireccion("908"));
    }
}
