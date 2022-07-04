<%-- 
    Document   : unidad
    Created on : 1 jul. 2022, 21:43:02
    Author     : win_virtual
--%>

<%@page import="ar.org.centro8.curso.java.proyecto.enums.Unidad"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    for(Unidad u: Unidad.values()){
        out.println("<option value = '" + u + "'>" + u.toString().toLowerCase()
                     + "</option>");
    }
%>
