<%-- 
    Document   : Login_JSP
    Created on : 30/11/2020, 10:59:37 PM
    Author     : R2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>

            
        
        <form action="Login_Servlet">
            Ingresa usuario: <input type="text" name="usuario"><br/>
            Ingresa contraseña: <input type="password" name="contra"><br/>
            <input type="submit"/>
        </form>
    </body>
</html>
