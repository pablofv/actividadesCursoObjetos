package ar.org.centro8.curso.java.proyecto.test;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import ar.org.centro8.curso.java.proyecto.connections.Connector;
import ar.org.centro8.curso.java.proyecto.repositorios.interfaces.I_FacturaRepository;
import ar.org.centro8.curso.java.proyecto.repositorios.jdbc.FacturaRepository;

public class TestDate {
    // public static void main(String[] args) {
    //     // Date d = new Date(122, 5, 15, 21, 16, 11);
    //     // //Calendar calendar = Calendar.getInstance(); // Obtiene una instancia de Calendar
    //     // //calendar.setTime(d); // Asigna la fecha al Calendar
    //     // Calendar calendar = Calendar.getInstance();
    //     // calendar.setTime(d);

    //     // System.out.println("getDate: " + (1900 + d.getYear())  + "/" + d.getMonth()   + "/" + d.getDate());
    //     // System.out.println("getTime: " +         d.getHours()  + ":" + d.getMinutes() + ":" + d.getSeconds());
    //     // System.out.println(calendar.getTime());
    //     Connection conn= Connector.getConnection();
    //     I_FacturaRepository fr = new FacturaRepository(conn);
    //     fr.getAll().forEach(System.out::println);

    //     // Date date=new Date();
    //     // System.out.println(date);

    //     // LocalDateTime ldt=LocalDateTime.of(2022, 6, 22, 20, 20, 25);
    //     // System.out.println(ldt);

    //     //java.sql.Date d=new java.sql.Date();
    // }
    public static void main(String[] args) throws IllegalArgumentException {
        Date date = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        String formattedDate = simpleDateFormat.format(date);

        java.sql.Date date1 = java.sql.Date.valueOf(formattedDate);

        System.out.println("SQL Date: " + date1);
    }
}
