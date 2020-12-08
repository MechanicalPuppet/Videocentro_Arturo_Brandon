<%-- 
    Document   : capturaClaveVideojuegoDesinventarear
    Created on : 6/12/2020, 02:09:22 PM
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
            
            <h1> ¡Ingresa la clave de tu videojuego al cual deseas consultar su inventario!</h1>
            <form action="obtenVideojuegoDesinventarear">
                <ul>
                    <li><input type="number" name="numCatalogo" placeholder="Num. Catálogo" min="1" max="9999999999" required/></li>
                    <li><input type="submit" value ="Capturar id" />
                </ul>
            </form>

        </article>
    </body>
</html>
