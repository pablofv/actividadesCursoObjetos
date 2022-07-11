<%-- 
    Document   : factura
    Created on : 1 jul. 2022, 20:03:38
    Author     : win_virtual
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="jsp/head.jsp" %>
    </head>
    <body>
        <%@include file = "jsp/menu.jsp"%>
        <h1>Alta de Facturas</h1>
        <div class = "form">
            <table>
                <tr>
                    <td><label class = "label">Fecha:</label></td>
                    <td><input type = "datetime-local" name="fecha"></td>
                </tr>
                <tr>
                    <td><label class = "label">Colegio:</label></td>
                    <td>
                        <select name = "colegio" class "input2">
                            <%@include file = "jsp/listaColegio.jsp" %>
                        </select>
                    </td>
                </tr>
                <td><input class = "button" type ="reset"  value ="Borrar"  /></td>
                <td><input class = "button" type ="submit" value ="Guardar" /></td>
            </table>
        </div>
    </body>
</html>
