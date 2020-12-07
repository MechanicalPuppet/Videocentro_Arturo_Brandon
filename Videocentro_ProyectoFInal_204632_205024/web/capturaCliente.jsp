<%-- 
    Document   : capturaCliente
    Created on : 7/12/2020, 12:05:24 AM
    Author     : Jbran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>CLIENTES</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
        <div>CLIENTES</div>
        
         <nav>
            <ul>
                
                <li><a href="control?tarea=agregarCliente">Agregar cliente</a></li>
                <li><a href="control?tarea=editarCliente">Editar cliente</a></li>
                <li><a href="control?tarea=eliminarCliente">Eliminar cliente</a></li>
                <li><a href="control?tarea=consultarCliente">Consultar cliente</a></li>
                
            </ul>
            
        </nav>
        
        <article>
            <h1> ¡AGREGAR CLIENTE!</h1>
            <form action="agregaCliente">
                <ul>
                    <li><input type="number" name="numCredencial" placeholder="Número de credencial"  min="1" max="9999999999" required/> </li>
                    <li><input type="text" name="nombre" placeholder="Nombre" pattern="[a-zA-Z ]{3,35}" maxlength="35" required/>Solamente se permiten letras </li>
                    <li><input type="text" name="direccion" placeholder="Dirección"  maxlength="35" required/> </li>
                    <li><input type="text" name="telefono" placeholder="Teléfono" maxlength="15" pattern="^[0-9]+"/> </li>
                    <li><input type="submit" value="Agregar cliente"/> </li>
                </ul>
                </form>
            
        </article>
    </body>
</html>
