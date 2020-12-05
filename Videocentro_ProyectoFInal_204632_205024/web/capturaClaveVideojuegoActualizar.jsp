<%-- 
    Document   : editarVideojuego
    Created on : 4/12/2020, 07:37:50 PM
    Author     : Jbran
--%>

<%@page import="java.util.List"%>
<%@page import="persistencia.PersistenciaBD"%>
<%@page import="interfaces.IPersistencia"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <nav>
            <ul>
                
                <li><a href="control?tarea=agregarVideojuego">¡Agregar videojuego!</a></li>
                <li><a href="control?tarea=editarVideojuego">¡Editar videojuego!</a></li>
                <li><a href="control?tarea=eliminarVideojuego">¡Eliminar videojuego!</a></li>
                <li><a href="control?tarea=consultarVideojuegos">¡Consultar videojuegos!</a></li>
                 <li><a href="control?tarea=consultarVideojuegosTitulo">¡Consultar videojuegos por titulo!</a></li>
                 <li><a href="control?tarea=consultarVideojuegosGenero">¡Consultar videojuegos por genero!</a></li>
            </ul>
            
        </nav>
        
        <article>
            <h1> ¡Ingresa la clave de tu videojuego a editar!</h1>
            <form action="obtenVideojuegoActualizar">
                <ul>
                    <li><input type="number" name="numCatalogo" placeholder="Num. Catálogo"/></li>
                    <li><input type="submit" value ="Capturar id" />
                </ul>
                </form>
         
    
            
            
            <script>
             
                </script>
            
        </article>
    </body>
</html>
