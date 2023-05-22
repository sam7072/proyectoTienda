<%-- 
    Document   : header
    Created on : 04/07/2022, 20:46:09
    Author     : Oscar Castro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="resources/css/materialize.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/own.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <title>Tienda</title>
    </head>
    <body>
        <div class="container">
            <ul class="">
                <li><a href="control?action=productos">Gestión de productos</a></li>
                <li class="right-align"><a href="controlUser?action=cerrar">Salir</a></li>
            </ul>
        </div>
        <script>
            // Get the element with id="defaultOpen" and click on it
            document.getElementById("defaultOpen").click();
        </script>
    </body>
</html>