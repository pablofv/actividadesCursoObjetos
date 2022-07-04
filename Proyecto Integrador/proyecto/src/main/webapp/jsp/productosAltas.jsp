<%-- 
    Document   : productosAltas
    Created on : 1 jul. 2022, 20:17:29
    Author     : win_virtual
--%>

<%@page import="ar.org.centro8.curso.java.proyecto.connections.Connector"%>
<%@page import="ar.org.centro8.curso.java.proyecto.repositorios.jdbc.ProductoRepository"%>
<%@page import="ar.org.centro8.curso.java.proyecto.entities.Producto"%>
<%@page import="ar.org.centro8.curso.java.proyecto.utils.text.validator.TextValidator"%>
<%@page import="ar.org.centro8.curso.java.proyecto.enums.Unidad"%>
<%@page import="ar.org.centro8.curso.java.proyecto.enums.TipoProducto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  try {
        String nombre = request.getParameter("nombre");
        String marca = request.getParameter("marca");
        TipoProducto tipoProducto = TipoProducto.valueOf(request.getParameter("tipoProducto"));
        double precioCosto = Double.valueOf(request.getParameter("precioCosto"));
        Unidad unidad = Unidad.valueOf(request.getParameter("unidad"));
        double cantidadPorUnidad = Double.valueOf(request.getParameter("cantidadUnidad"));
        if(new TextValidator(nombre).length(3, 50) &&
           new TextValidator(marca).length(3, 50)){
           Producto producto = new Producto(nombre, marca, tipoProducto, precioCosto, unidad, cantidadPorUnidad);
           out.println(producto.toString());
           new ProductoRepository(Connector.getConnection()).save(producto);
           out.println("<div class='info'>se guardo el curso id: " + producto.getId() + "</div>");
        }else{
            out.println("<div class='error'>Falta completar parámetros</div>");
        }
      } catch (Exception e) {
            System.out.println("****************************************************");
            System.out.println(e);
            System.out.println("****************************************************");
            if(request.getParameter("nombre") !=null){
                out.println("<div class='error'>No se pudo guardar el curso</div>");
            }
      }
%>
