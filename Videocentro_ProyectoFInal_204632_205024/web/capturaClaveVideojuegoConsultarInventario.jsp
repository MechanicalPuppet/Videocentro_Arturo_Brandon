<%-- 
    Document   : capturaClaveVideojuegoConsultarInventario.jsp
    Created on : 6/12/2020, 12:28:44 PM
    Author     : R2
--%>

<%@page import="objetosNegocio.Videojuego"%>
<%@page import="java.util.List"%>
<%@page import="persistencia.PersistenciaBD"%>
<%@page import="interfaces.IPersistencia"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="estilos/estilosIndex.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INVENTARIO</title>
    </head>
    <body>
        <div>CONSULTAR INVENTARIO</div>


        <nav>
            <ul>

                <li><a href="control?tarea=inventarear">Inventarear</a></li>
                <li><a href="control?tarea=desinventarear">Desinventarear</a></li>
                <li><a href="control?tarea=consultarInventario">Consultar inventario de videojuego</a></li>

            </ul>

        </nav>

        <article>
            
            <h1> ¡Ingresa la clave de tu videojuego al cual deseas consultar su inventario!</h1>
            <form action="obtenVideojuegoConsultarInventario">
                <ul>
                    <li><input type="number" name="numCatalogo" placeholder="Num. Catálogo" required min="0"/></li>
                    <li><input type="submit" value ="Capturar id" />
                </ul>
            </form>

            <%
                IPersistencia crud = new PersistenciaBD();

                List lista = crud.consultarVideojuegos();

                Videojuego v;
                out.println("<table border=1>");

                out.println("<tr>"
                            + "<td>" + "Núm.Catalago"+ "</td>"
                            + "<td>" + "Título" + "</td>"
                            + "<td>" + "Genero" + "</td>"
                            + "<td>" + "Consola" + "</td>"
                            + "<td>" + "Fabricante" + "</td>"
                            + "<td>" + "Version" + "</td>" + "</tr>");
                
                for (int i = 0; i < lista.size(); i++) {

                    v = (Videojuego) lista.get(i);

                    out.println("<tr>"
                            + "<td>" + v.getNumCatalogo() + "</td>"
                            + "<td>" + v.getTitulo() + "</td>"
                            + "<td>" + v.getGenero() + "</td>"
                            + "<td>" + v.getConsola() + "</td>"
                            + "<td>" + v.getFabricante() + "</td>"
                            + "<td>" + v.getVersion() + "</td>" + "</tr>");

                }%>
            
        </article>
    </body>
</html>
