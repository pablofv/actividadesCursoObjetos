<%-- 
    Document   : itemFactura
    Created on : 11 jul. 2022, 10:44:30
    Author     : Legion
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="jsp/head.jsp" %>
    </head>
    <body>
        <%@include file = "jsp/menu.jsp"%>
        <h1>Alta de productos de la factura</h1>
        <div class = "form">
            <form>
                <table>
                    <tr>
                        <td><label class = "label">  Elija la factura: </label></td>
                        <td>
                            <select name = "factura:" class "input2">
                                <%@include file = "jsp/listaFactura.jsp" %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label class = "label"> id Producto: </label></td>
                        <td>
                            <select name = "producto:" class "input2">
                                <%@include file = "jsp/listaProducto.jsp" %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label class = "label"> Cantidad de Producto: </label></td>
                        <td><input type = "text" class = "input" name = "cantidadProducto"> </td>
                    </tr>
                    <tr>
                        <td><label class = "label"> Precio Unitario: </label></td>
                        <td><input type = "text" class = "input" name = "precioUnitario"> </td>
                    </tr>
                    <td><input class = "button" type ="reset"  value ="Borrar"  /></td>
                    <td><input class = "button" type ="submit" value ="Guardar" /></td>
                </table>
            </form>
        </div>
    </body>
</html>


