<%-- 
    Document   : colegiosAltas
    Created on : 29 jun. 2022, 21:07:43
    Author     : centr
--%>

<%@page import="ar.org.centro8.curso.java.proyecto.utils.text.validator.TextValidator"%>
<%@page import="ar.org.centro8.curso.java.proyecto.connections.Connector"%>
<%@page import="ar.org.centro8.curso.java.proyecto.repositorios.jdbc.ColegioRepository"%>
<%@page import="ar.org.centro8.curso.java.proyecto.entities.Colegio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
  try{
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        if(new TextValidator(nombre).length(3, 20) && new TextValidator(direccion).length(3, 20)){
            Colegio colegio = new Colegio(nombre, direccion);
            new ColegioRepository(Connector.getConnection()).save(colegio);
            out.println("<div class = 'info'> se guardó el colegio id: " + colegio.getId() +"</div>");
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
