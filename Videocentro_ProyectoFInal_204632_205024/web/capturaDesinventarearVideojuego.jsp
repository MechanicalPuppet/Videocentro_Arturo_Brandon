<%-- 
    Document   : capturaDesinventarearVideojuego.jsp
    Created on : 6/12/2020, 02:12:20 PM
    Author     : R2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="estilos/estilosIndex.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INVENTARIO</title>
    </head>
    <body>
        <div>DESINVENTARIAR INVENTARIO</div>


        <nav>
            <ul>

                <li><a href="control?tarea=inventarear">Inventarear</a></li>
                <li><a href="control?tarea=desinventarear">Desinventarear</a></li>
                <li><a href="control?tarea=consultarInventario">Consultar inventario de videojuego</a></li>

            </ul>

        </nav>

        <article>
            
            <h1> ¡Ingresa la cantidad de existencia a quitar del videojuego!</h1>
            <form action="desinventarear">
                <ul>
                    <li><input type="number" name="numCatalogo" readonly="readonly" value="<%=session.getAttribute("numCatalogo")%>"/></li>
                    <li><input type="text" name="titulo" readonly="readonly" value="<%= session.getAttribute("titulo") %>"/> </li>
                    <li><input type="text" name="genero" readonly="readonly" value="<%=session.getAttribute("genero") %>"/> </li>
                    <li><input type="text" name="clasificacion" readonly="readonly" value="<%=session.getAttribute("clasificacion") %>"/> </li>
                    <li><input type="text" name="consola" readonly="readonly" value="<%=session.getAttribute("consola") %>"/> </li>
                    <li><input type="text" name="fabricante" readonly="readonly" value="<%=session.getAttribute("fabricante") %>"/> </li>
                    <li><input type="number" name="version" readonly="readonly" value="<%=session.getAttribute("version") %>"/> </li>
                    <li><input type="number" name="existencia" placeholder="Existencia a quitar" min="1" max="9999999999" required/> </li>
                    <li><input type="submit" value ="Desinventarear videojuego" />
                </ul>
            </form>

        </article>
    </body>
</html>
