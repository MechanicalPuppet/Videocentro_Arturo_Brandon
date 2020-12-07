<%-- 
    Document   : devolver
    Created on : 6/12/2020, 10:34:12 PM
    Author     : Jbran
--%>

<%@page import="objetosNegocio.Renta"%>
<%@page import="java.util.List"%>
<%@page import="persistencia.PersistenciaBD"%>
<%@page import="interfaces.IPersistencia"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Devolver</title>
    </head>
    <body>
        <nav>
        <ul>
        <li><a href="control?tarea=rentar">¡Rentar un videojuego!</a></li>
        <li><a href="control?tarea=devolver">¡Devolver un videojuego!</a></li>
        </ul>
    
    </nav>
        <header>
            <h1>¡Estás a punto de devolver algo!</h1>
        </header>
        
        <%
             IPersistencia crud = new PersistenciaBD();
  
                 List<Renta> lista = crud.consultarRentasVideojuegos();
                 out.println("<table border=1>");
                 out.println("<tr>");
                 out.println("<th> Renta </th>");
                 out.println("<th> Credencial </th>");
                 out.println("<th> Articulo </th>");
                 out.println("<th> Fecha </th>");
                 out.println("<th> Tiempo </th>");
                 out.println("</tr>");
                 for (int i = 0; i < lista.size(); i++) {
                     out.println("<td>" + (i + 1) + "</td>"
                             + "<td>" + lista.get(i).getCliente().getNumCredencial() + "</td>"
                             + "<td>" + lista.get(i).getArticulo().getNumCatalogo() + "</td>"
                             + "<td>" + lista.get(i).getFechaRenta() + "</td>"
                             + "<td>" + lista.get(i).getTiempoRenta() + "</td> </tr>");
                 }
                 out.println("</table>");
               
        
        %>
        
        <form action="devolver">
                <ul>
                    <li><input type="number" name="numRenta" placeholder="Num. Renta" style="width :200px" required min="1" max="<%=crud.consultarRentasVideojuegos().size() %>"/></li>
                    <li><input type="submit" value="Realizar renta"> </li>
                </ul> 
                
            </form>
        
        
        
        
    </body>
</html>
