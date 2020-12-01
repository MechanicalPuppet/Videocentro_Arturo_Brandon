<%-- 
    Document   : Bienvenido
    Created on : 1/12/2020, 02:03:09 AM
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
        <%
            if(session.getAttribute("elUsuario")==null){
            response.sendRedirect("Login_JSP.jsp");
            }
        %>
        
        <h1>WENAS WENAS </h1>
    </body>
</html>
