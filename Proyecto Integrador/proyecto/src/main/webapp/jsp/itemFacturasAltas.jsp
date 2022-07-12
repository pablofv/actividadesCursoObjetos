<%-- 
    Document   : itemFacturasAltas
    Created on : 11 jul. 2022, 20:51:21
    Author     : Legion
--%>

<%@page import="ar.org.centro8.curso.java.proyecto.connections.Connector"%>
<%@page import="ar.org.centro8.curso.java.proyecto.repositorios.jdbc.ItemFacturaRepository"%>
<%@page import="ar.org.centro8.curso.java.proyecto.entities.ItemFactura"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  try{
        int idFactura = Integer.parseInt(request.getParameter("factura"));
        int idProducto = Integer.parseInt(request.getParameter("producto"));
        double cantidadProducto = Double.parseDouble(request.getParameter("cantidadProducto"));
        double precioUnitario = Double.parseDouble(request.getParameter("precioUnitario"));
        if(idFactura > 0 && idProducto > 0 && cantidadProducto > 0 && precioUnitario > 0){
            ItemFactura itemFactura = new ItemFactura(idFactura, idProducto, cantidadProducto, precioUnitario);
            System.out.println(itemFactura);
            //new ItemFacturaRepository(Connector.getConnection()).save(itemFactura);
            out.println("<div class = 'info'> se guardó la factura id: " + itemFactura.getId() +"</div>");
        }else{
            out.println("<div class = 'error'> Falta completar parámetros </div>");
        }
  } catch (Exception e) {
        System.out.println("*********************");
        System.out.println(e);
        System.out.println("*********************");
        if(request.getParameter("titulo") != null){
            out.println("<div class = 'info'> No se pudo guardar la factura </div>");
        }
  }
%>
