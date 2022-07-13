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
        <label class="label">Buscar por Número:</label>
        <input type="text" name="buscarTitulo" class="input" />
    </form>
    <form id="f_tabla">
        <%@include file="jsp/cursosTabla.jsp" %>
    </form>
</body>