<%-- 
    Document   : capturaCredencialClienteActualizar
    Created on : 5/12/2020, 08:30:12 PM
    Author     : R2
--%>

<%@page import="objetosNegocio.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="persistencia.PersistenciaBD"%>
<%@page import="interfaces.IPersistencia"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CLIENTES</title>
    </head>
    <body>

        <div>EDITAR CLIENTES</div>

        <nav>
            <ul>

                <li><a href="control?tarea=agregarCliente">Agregar clientes</a></li>
                <li><a href="control?tarea=editarCliente">Editar clientes</a></li>
                <li><a href="control?tarea=eliminarCliente">Eliminar clientes</a></li>
                <li><a href="control?tarea=consultarCliente">Consultar clientes</a></li>

            </ul>

        </nav>

        <article>
            <h1> ¡Ingresa la clave del cliente a editar!</h1>
            
            <%
                IPersistencia crud = new PersistenciaBD();

                List listaClientes = crud.consultarClientes();
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
            %>
            
            <form action="obtenClienteActualizar">

                <ul>
                    <li><input type="number" name="numCredencial" placeholder="Num. Credencial" min="1" max="9999999999" required/></li>
                    <li><input type="submit" value ="Capturar id" />
                </ul>
            </form>

        </article>

    </body>
</html>
