<%-- 
    Document   : listaProductos
    Created on : 8 jul. 2022, 20:15:48
    Author     : Legion
--%>

<%@page import="ar.org.centro8.curso.java.proyecto.connections.Connector"%>
<%@page import="java.sql.Connection"%>
<%@page import="ar.org.centro8.curso.java.proyecto.repositorios.jdbc.ProductoRepository"%>
<%@page import="ar.org.centro8.curso.java.proyecto.entities.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    
    for (Producto p:new ProductoRepository(Connector.getConnection()).getAll()){
        System.out.println("Productos********************************");
        out.println("<option value = " + p.getId() + ">" + p.getId() + " " +p.getNombre().toLowerCase()
                     + "</option>");
        System.out.println("********************************");
    }
%>
