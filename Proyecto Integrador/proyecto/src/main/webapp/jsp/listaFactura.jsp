<%-- 
    Document   : listaFactura
    Created on : 11 jul. 2022, 19:33:28
    Author     : Legion
--%>

<%@page import="ar.org.centro8.curso.java.proyecto.repositorios.jdbc.ColegioRepository"%>
<%@page import="ar.org.centro8.curso.java.proyecto.entities.Colegio"%>
<%@page import="ar.org.centro8.curso.java.proyecto.connections.Connector"%>
<%@page import="ar.org.centro8.curso.java.proyecto.repositorios.jdbc.FacturaRepository"%>
<%@page import="ar.org.centro8.curso.java.proyecto.entities.Factura"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    
    for (Factura f:new FacturaRepository(Connector.getConnection()).getAll()){
        System.out.println("********************************");
        Colegio colegio = new ColegioRepository(Connector.getConnection()).getById(f.getIdColegio());
        out.println("<option value = " + f.getId() + ">" + f.getId() + " " + f.getFechaFactura() + " " + colegio.getNombre()
                     + "</option>");
        System.out.println("********************************");
    }
%>