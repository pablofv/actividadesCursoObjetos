<%-- 
    Document   : facturasAltas
    Created on : 11 jul. 2022, 19:42:52
    Author     : Legion
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="ar.org.centro8.curso.java.proyecto.entities.Factura"%>
<%@page import="ar.org.centro8.curso.java.proyecto.utils.text.validator.TextValidator"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
  try{
        System.out.println("Esto es ITEMFACTURA");
        String fechaFactura = request.getParameter("fecha").replace("T", " "); // El control me devuelve la fecha en la forma yyyy-MM-ddTHH:mm
        Date fecha2 = new Factura().getFechaComoFecha(fechaFactura, "yyyy-MM-dd HH:mm");
        int idColegio = Integer.parseInt(request.getParameter("colegio"));
        System.out.println(idColegio);
      /*  if(fechaFactura != null && idColegio > 0){
            Factura factura = new Factura(fechaFactura, idColegio);
            new ColegioRepository(Connector.getConnection()).save(colegio);
            out.println("<div class = 'info'> se guardó el colegio id: " + colegio.getId() +"</div>");
        }else{
            out.println("<div class = 'error'> Falta completar parámetros </div>");
        }*/
  } catch (Exception e) {
        System.out.println("*********************");
        System.out.println(e);
        System.out.println("*********************");
        if(request.getParameter("titulo") != null){
            out.println("<div class = 'info'> No se pudo guardar el colegio </div>");
        }
  }
%>
