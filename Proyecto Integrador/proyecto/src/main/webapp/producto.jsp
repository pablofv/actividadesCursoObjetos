<%-- 
    Document   : producto
    Created on : 29 jun. 2022, 20:13:37
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
    <h1>Alta de Productos</h1>
    <div class = "form">
        <form>
            <table>
                <tr>
                    <td><label class = "label">Nombre:</label></td>
                    <td><input type = "text" class = "input" name= "nombre" /></td>
                </tr>
                <tr>
                    <td><label class = "label">Marca:</label></td>
                    <td><input type = "text" class = "input" name= "marca" /></td>
                </tr>
                <tr>
                    <td><label class = "label">Tipo de producto: (enum)</label></td>
                    <!-- CARNES, VERDURAS, PANIFICADOS, FRUTAS, LACTEOS, BEBIDAS -> Las opciones del enumerado-->
                    <td>
                        <select name = "tipoProducto" class = "input2">
                            <%@include file = "jsp/tipoProducto.jsp"%>
                        </select>
                    </td>
                    <!-- comment <td><input type = "text" class = "input" name= "tipoProducto" /></td> -->  
                </tr>
                <tr>
                    <td><label class = "label">Precio de costo:</label></td>
                    <td><input type = "text" class = "input" name= "precioCosto" /></td>
                </tr>
                <tr>
                    <td><label class = "label">Unidad: (enum)</label></td>
                    <td>
                        <select name = "unidad" class = "input2">
                            <%@include file = "jsp/unidad.jsp"%>
                        </select>
                    </td>
                    <!--<td><input type = "text" class = "input" name= "unidad" /></td>-->
                </tr>
                <tr>
                    <td><label class = "label">Cantidad por unidad:</label></td>
                    <td><input type = "text" class = "input" name= "cantidadUnidad" /></td>
                </tr>
                <tr>
                    <td><input class = "button" type ="reset"  value ="Borrar"  /></td>
                    <td><input class = "button" type ="submit" value ="Guardar" /></td>
                </tr>
            </table>
        </form>
       <%@include file="jsp/productosAltas.jsp" %>
    </div>
</body>
</html>