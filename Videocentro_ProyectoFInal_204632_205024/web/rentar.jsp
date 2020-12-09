<%-- 
    Document   : rentar
    Created on : 6/12/2020, 10:05:19 PM
    Author     : Jbran
--%>

<%@page import="objetosNegocio.Articulo"%>
<%@page import="objetosNegocio.ArticuloED"%>
<%@page import="java.util.List"%>
<%@page import="persistencia.PersistenciaBD"%>
<%@page import="interfaces.IPersistencia"%>
<%@page import="interfaces.IPersistencia"%>
<%@page import="objetosNegocio.Cliente"%>
<%@page import="objetosNegocio.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Rentar un videojuego</title>
        <meta charset="UTF-8">
        <link href="estilos/estilosIndex.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>

    <header>
        <h1>¡Estás en la parte de rentas!</h1>

    </header>


    <nav>
         <a href="rentas.html"><button type="button"></button></a>
        <ul>
            <li><a href="control?tarea=rentar">¡Rentar un videojuego!</a></li>
            <li><a href="control?tarea=devolver">¡Devolver un videojuego!</a></li>
        </ul>

    </nav>

    <article>
        <%

            IPersistencia crud = new PersistenciaBD();

            List listaClientes = crud.consultarClientes();

            List<ArticuloED> listaArticulos = crud.consultarVideojuegosDisponibles();

            Articulo v;

            Cliente c;
            out.println("<table border=1>");
            out.println("<tr>");
            out.println("<th> Numero credencial </th>");
            out.println("<th> Nombre </th>");
            out.println("<th> Direccion </th>");
            out.println("<th> Telefono </th>");
            out.println("</tr>");
            for (int i = 0; i < listaClientes.size(); i++) {

                c = (Cliente) listaClientes.get(i);

                out.println("<tr>"
                        + "<td>" + c.getNumCredencial() + "</td>"
                        + "<td>" + c.getNombre() + "</td>"
                        + "<td>" + c.getDireccion() + "</td>"
                        + "<td>" + c.getTelefono() + "</td>" + "</tr>");

            }
            out.println("</table>");
            out.println("<br>");

            out.println("<table border=1>");
            out.println("<tr>");
            out.println("<th> Numero catalogo </th>");
            out.println("<th> Titulo </th>");
            out.println("<th> Genero </th>");

            out.println("</tr>");
            for (int i = 0; i < listaArticulos.size(); i++) {

                v = listaArticulos.get(i).getArticulo();

                out.println("<tr>"
                        + "<td>" + v.getNumCatalogo() + "</td>"
                        + "<td>" + v.getTitulo() + "</td>"
                        + "<td>" + v.getGenero() + "</td>" + "</tr>");

            }
            out.println("</table>");
        %>


        <form action="rentar">
            <ul>
                <li><input type="number" name="numCredencial" placeholder="Num. Credencial cliente" style="width: 250px" required min="1" max="<%=crud.consultarClientes().size()%>"/></li>
                <li><input type="number" name="numCatalogo" placeholder="Num. Catálogo artículo" style="width: 250px" required min="1" max="<%=crud.consultarVideojuegosDisponibles().size()%>"/></li>
                <li><input type="number" name="tiempoRenta" placeholder="Número de días de la renta" style="width: 250px" required min="1" max="30"/></li>
                <li><input type="submit" value="Realizar renta"> </li>
            </ul> 

        </form>
    </article>

                <footer>
            
            <h5>Todos los derechos reservados.</h5>
            <h6>Podría interesarte: <a href="https://ideasnuevas.net/wp-content/uploads/2016/08/Wallpapersxl-Perritos-Bonitos-Seguro-Que-Estabas-Esperando-Otro-Fondo-De-Perros-Pues-Ya-No-Tienes-276709-1440x1080.jpg">Contenido vital que todos deben ver.</a></h6>
            
            
        </footer>
</html>
