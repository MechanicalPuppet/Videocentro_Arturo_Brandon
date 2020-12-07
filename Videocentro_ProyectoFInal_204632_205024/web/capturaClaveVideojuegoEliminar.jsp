<%-- 
    Document   : editarVideojuego
    Created on : 4/12/2020, 07:37:50 PM
    Author     : Jbran
--%>

<%@page import="objetosNegocio.Videojuego"%>
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
            <%
            IPersistencia crud = new PersistenciaBD();
            List lista = crud.consultarVideojuegos();

            Videojuego v;
            
            for (int i = 0; i < lista.size(); i++) {

                v = (Videojuego) lista.get(i);

                out.println("<table border=1>");
                out.println("<tr>"
                        + "<td>" + v.getNumCatalogo() + "</td>"
                        + "<td>" + v.getTitulo() + "</td>"
                        + "<td>" + v.getGenero() + "</td>"
                        + "<td>" + v.getConsola() + "</td>"
                        + "<td>" + v.getFabricante() + "</td>"
                        + "<td>" + v.getVersion() + "</td>" + "</tr>");

            }
            
            %>
            <h1> ¡Ingresa la clave de tu videojuego a eliminar!</h1>
            <form action="obtenVideojuegoEliminar">
                <ul>
                    <li><input type="number" name="numCatalogo" placeholder="Num. Catálogo" required min="1" style="width: 200px" max="<%=crud.consultarVideojuegos().size()%>"/></li>
                    <li><input type="submit" value ="Capturar id" />
                </ul>
                </form>
         
    
            
            
            <script>
             
                </script>
            
        </article>
    </body>
</html>
