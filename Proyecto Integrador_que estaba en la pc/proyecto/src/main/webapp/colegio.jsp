<%-- 
    Document   : colegio
    Created on : 29 jun. 2022, 20:18:53
    Author     : centr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <%@include file="jsp/head.jsp" %>
    </head>
    <body>
        <%@include file = "jsp/menu.jsp"%>
        <h1>Mantenimiento de Colegios</h1>
        <div class= "form">
            <form method='POST'>
                <table>
                    <tr>
                        <td><label class = "label"> Nombre: </label></td>
                        <td><input type = "text" class = "input" name = "nombre" <!-- required minlength="3" maxlength="20" --> </td>
                    </tr>
                    <tr>
                        <td><label class = "label"> Dirección: </label></td>
                        <td><input type = "text" class = "input" name = "direccion" <!-- required minlength="3" maxlength="20" --> </td>
                    </tr>
                    <tr>
                        <td><input class = "button" type ="reset"  value ="Borrar"  /></td>
                        <td><input class = "button" type ="submit" value ="Guardar" /></td>
                    </tr>
                </table>
            </form>
            <%@include file="jsp/colegiosAltas.jsp" %>
        </div>
    </body>
</html>