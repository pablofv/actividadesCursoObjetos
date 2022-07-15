<%-- 
    Document   : pruebaTabla
    Created on : 12 jul. 2022, 21:03:26
    Author     : Legion
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <%@include file="jsp/head.jsp" %>
</head>
<body>
    <%@include file="jsp/menu.jsp" %>
    <h1>Tabla</h1>
    <form id="f_buscar">
        <label class="label">Buscar por Número de Factura:</label>
        <input type="text" name="buscarTitulo" class="input" />
        <td><input class = "button" type ="submit" value ="Buscar" /></td>
        <%@include file="jsp/cursosTabla.jsp" %>
</body>