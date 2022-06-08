package ar.org.centro8.curso.java.proyecto.connections;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    private static String driver = "org.mariadb.jdbc.Driver";
    private static String url = "jdbc:mariadb://localhost:3306/distribuidora";
    private static String user = "root";
    private static String pass = "";
    private static Connection conn = null; //Importar de java.sql para que sea genérico a cualquier tipo de conexión, si lo traigo de mariadb, solo puedo usar ese tipo de base
    
    private Connector() {
    }

    public static Connection getConnection(){
        try{
            if(conn == null || conn.isClosed()){
                Class.forName(driver); // Con esto registro el driver, es para java 8
                conn = DriverManager.getConnection(url, user, pass);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return conn;
    }
}