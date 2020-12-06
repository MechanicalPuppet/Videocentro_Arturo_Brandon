<%-- 
    Document   : capturaCredencialClienteActualizar
    Created on : 5/12/2020, 08:30:12 PM
    Author     : R2
--%>

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
            <form action="obtenClienteActualizar">

                <ul>
                    <li><input type="number" name="numCredencial" placeholder="Num. Credencial"/></li>
                    <li><input type="submit" value ="Capturar id" />
                </ul>
            </form>

        </article>

    </body>
</html>
