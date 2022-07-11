<%-- 
    Document   : facturasAltas
    Created on : 11 jul. 2022, 19:42:52
    Author     : Legion
--%>

<%@page import="ar.org.centro8.curso.java.proyecto.repositorios.jdbc.FacturaRepository"%>
<%@page import="ar.org.centro8.curso.java.proyecto.connections.Connector"%>
<%@page import="java.util.Date"%>
<%@page import="ar.org.centro8.curso.java.proyecto.entities.Factura"%>
<%@page import="ar.org.centro8.curso.java.proyecto.utils.text.validator.TextValidator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
  try{
        System.out.println("Esto es ITEMFACTURA");
        // El control me devuelve la fecha en la forma yyyy-MM-ddTHH:mm
        Date fechaFactura = new Factura().getFechaComoFecha(request.getParameter("fecha").replace("T", " "), "yyyy-MM-dd HH:mm");
        int idColegio = Integer.parseInt(request.getParameter("colegio"));
        System.out.println(idColegio);
        if(fechaFactura != null && idColegio > 0){
            Factura factura = new Factura(fechaFactura, idColegio);
            new FacturaRepository(Connector.getConnection()).save(factura);
            out.println("<div class = 'info'> se guardó la factura id: " + factura.getId() +"</div>");
        }else{
            out.println("<div class = 'error'> Falta completar parámetros </div>");
        }
  } catch (Exception e) {
        System.out.println("*********************");
        System.out.println(e);
        System.out.println("*********************");
        if(request.getParameter("titulo") != null){
            out.println("<div class = 'info'> No se pudo guardar el colegio </div>");
        }
  }
%>
