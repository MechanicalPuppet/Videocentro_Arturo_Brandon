<%-- 
    Document   : capturaEditarCliente
    Created on : 5/12/2020, 08:45:04 PM
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
            <h1> ¡Edita al cliente!</h1>
            <form action="editarCliente">
                <ul>
                    
                    <li><input type="number" name="numCredencial" readonly="readonly" value="<%=session.getAttribute("numCredencial")%>"/></li>
                    <li><input type="text" name="nombre" value="<%= session.getAttribute("nombre") %>"/> </li>
                    <li><input type="text" name="direccion" value="<%=session.getAttribute("direccion") %>"/> </li>
                    <li><input type="text" name="telefono" value="<%=session.getAttribute("telefono") %>"/> </li>
                    
                    <li><input type="submit" value ="Editar cliente" />
                </ul>
                </form>
            
        </article>
    </body>
</html>
