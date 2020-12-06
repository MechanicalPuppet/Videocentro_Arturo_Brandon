<%-- 
    Document   : capturaInventarearVideojuego
    Created on : 6/12/2020, 01:31:15 PM
    Author     : R2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INVENTARIO</title>
    </head>
    <body>
        <div>INVENTARIAR INVENTARIO</div>


        <nav>
            <ul>

                <li><a href="control?tarea=inventarear">Inventarear</a></li>
                <li><a href="control?tarea=desinventarear">Desinventarear</a></li>
                <li><a href="control?tarea=consultarInventario">Consultar inventario de videojuego</a></li>

            </ul>

        </nav>

        <article>
            
            <h1> ¡Ingresa la cantidad de existencia del videojuego!</h1>
            <form action="inventarear">
                <ul>
                    <li><input type="number" name="numCatalogo" readonly="readonly" value="<%=session.getAttribute("numCatalogo")%>"/></li>
                    <li><input type="text" name="titulo" readonly="readonly" value="<%= session.getAttribute("titulo") %>"/> </li>
                    <li><input type="text" name="genero" readonly="readonly" value="<%=session.getAttribute("genero") %>"/> </li>
                    <li><input type="text" name="clasificacion" readonly="readonly" value="<%=session.getAttribute("clasificacion") %>"/> </li>
                    <li><input type="text" name="consola" readonly="readonly" value="<%=session.getAttribute("consola") %>"/> </li>
                    <li><input type="text" name="fabricante" readonly="readonly" value="<%=session.getAttribute("fabricante") %>"/> </li>
                    <li><input type="number" name="version" readonly="readonly" value="<%=session.getAttribute("version") %>"/> </li>
                    <li><input type="number" name="existencia" placeholder="Existencia"/> </li>
                    <li><input type="submit" value ="Inventarear videojuego" />
                </ul>
            </form>

        </article>
    </body>
</html>
