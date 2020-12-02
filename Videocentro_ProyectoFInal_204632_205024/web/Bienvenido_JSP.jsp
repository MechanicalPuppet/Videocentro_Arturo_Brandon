<%-- 
    Document   : Bienvenido
    Created on : 1/12/2020, 02:03:09 AM
    Author     : R2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="estilos/estilosIndex.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VIDEOCENTRO ARTURO Y BRANDON</title>
    </head>
    <body>
        <%
            if(session.getAttribute("elUsuario")==null){
            response.sendRedirect("Login_JSP.jsp");
            }
        %>
        
        <nav>
            <ul>
                
                <li><a href="clientes.html">Clientes</a></li>
                <li><a href="videojuegos.html">Videojuegos</a></li>
                <li><a href="rentas.html">Rentas</a></li>
                <li><a href="inventario.html">Inventario</a></li>
                
            </ul>
            
        </nav>
    </body>
</html>
