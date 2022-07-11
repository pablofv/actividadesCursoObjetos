<%-- 
    Document   : colegio
    Created on : 4 jul. 2022, 20:23:01
    Author     : win_virtual
--%>

<%@page import="ar.org.centro8.curso.java.proyecto.connections.Connector"%>
<%@page import="java.sql.Connection"%>
<%@page import="ar.org.centro8.curso.java.proyecto.repositorios.jdbc.ColegioRepository"%>
<%@page import="ar.org.centro8.curso.java.proyecto.entities.Colegio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    
    for (Colegio c:new ColegioRepository(Connector.getConnection()).getAll()){
        System.out.println("********************************");
        out.println("<option value = " + c.getId() + ">" + c.getNombre().toLowerCase()
                     + "</option>");
        System.out.println("********************************");
    }
%>
