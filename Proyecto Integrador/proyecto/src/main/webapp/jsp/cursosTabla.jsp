<%-- 
    Document   : cursosTabla
    Created on : 13 jul. 2022, 00:07:32
    Author     : Legion
--%>

<%@page import="ar.org.centro8.curso.java.proyecto.repositorios.jdbc.ProductoRepository"%>
<%@page import="ar.org.centro8.curso.java.proyecto.entities.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="ar.org.centro8.curso.java.proyecto.connections.Connector"%>
<%@page import="ar.org.centro8.curso.java.proyecto.repositorios.jdbc.ColegioRepository"%>
<%@page import="ar.org.centro8.curso.java.proyecto.entities.Colegio"%>
<%@page import="ar.org.centro8.curso.java.proyecto.utils.html.HtmlTable"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    /*
    Connection conn = Connector.getConnection();
    System.out.println("CONN!!!!!!: " + conn);
    List<ResultSet> list = new ArrayList<>();
    try (ResultSet rs = conn.createStatement().executeQuery("select * from colegios")){
        while(rs.next()){
            list.add(
                rs
                );
        }
    } catch (Exception e) {
        System.out.println(e);
    }
    System.out.println("La lista!!!!!! con for");
    for(ResultSet e:list){
        while(e.next()){
            System.out.println("El bucle while "+e.getInt("id"));
        }
        System.out.println("El bucle for "+e);
    }
    */
    
    out.println(
        new HtmlTable<Producto>()
            .getTable(
                new ProductoRepository(Connector.getConnection()).getAll()
            )
        ); 
%>
