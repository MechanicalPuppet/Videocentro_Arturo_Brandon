<%-- 
    Document   : editarVideojuego
    Created on : 4/12/2020, 09:23:31 PM
    Author     : Jbran
--%>

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
            <h1> ¡Edita tu videojuego!</h1>
            <form action="editarVideojuego">
                <ul>
                    <!-- USO REQUEST O SESSION AQUÍ? POR QUÉ SIEMPPRE ES NULL?-->
                    <li><input type="number" name="numCatalogo" value="<%request.getAttribute("numCatalogo"); %>"/></li>
                    <li><input type="text" name="titulo" value=<% request.getAttribute("titulo"); %>/> </li>
                    <li><input type="text" name="genero" value=<%request.getAttribute("genero"); %>/> </li>
                    <li><input type="text" name="clasificacion" value=<%request.getAttribute("clasificacion"); %>/> </li>
                    <li><input type="text" name="consola" value=<%request.getAttribute("consola"); %>/> </li>
                    <li><input type="text" name="fabricante" value=<%request.getAttribute("fabricante").toString(); %>/> </li>
                    <li><input type="number" name="version" value=<%request.getAttribute("version"); %>/> </li>
                    <li><input type="submit" value ="Editar videojuego" />
                </ul>
                </form>
            
        </article>
    </body>
</html>
