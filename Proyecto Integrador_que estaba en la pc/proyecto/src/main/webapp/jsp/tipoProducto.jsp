<%-- 
    Document   : tipoProducto
    Created on : 1 jul. 2022, 21:29:30
    Author     : win_virtual
--%>

<%@page import="ar.org.centro8.curso.java.proyecto.enums.TipoProducto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    for(TipoProducto t: TipoProducto.values()){
        out.println("<option value = '" + t + "'>" + t.toString().toLowerCase()
                     + "</option>");
    }
%>