<%-- 
    Document   : listar
    Created on : 29/06/2022, 18:45:41
    Author     : Oscar Castro
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Producto</title>
        <link href="resources/css/materialize.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    </head>
    <body>
        <%@include file="../header.jsp" %>
        <div class="container">
            <div class="main">
                 <form method="post" action="control">
                <div class="row">
                    <div class="orange white-text center-align z-depth-4">
                        <h5>Nuevo Producto</h5>
                    </div>
                </div>
                <div class="row">
                    <div class="col m3"></div>
                    <div class="col m3">Código</div>
                    <div class="col m4">
                        <input type="text" name="txtCode" required="" value="${base.codigo}" />
                    </div>
                </div>
                <div class="row">
                    <div class="col m3"></div>
                    <div class="col m3">Descripción</div>
                    <div class="col m4">
                        <input type="text" name="txtName" required="" value="${base.descripcion}" />
                    </div>
                </div>
                <div class="row">
                    <div class="col m3"></div>
                    <div class="col m3">Precio</div>
                    <div class="col m4">
                        <input type="text" name="txtLine" required="" value="${base.precio}" />
                    </div>
                </div>
                <div class="row">
                    <div class="col m3"></div>
                    <div class="col m3">Stock</div>
                    <div class="col m4">
                        <input type="number" name="numQ" required="" value="${base.stock}" />
                    </div>
                </div>
                <div class="row">
                    <div class="col m6"></div>
                    <div class="col m6">
                        <input type="submit" name="btnSave" value="Guardar" class="btn green white-text z-depth-3" />
                    </div>
                </div>
                </form>
            </div>
        </div>
        <script src="resources/js/jquery.js" type="text/javascript"></script>
        <script src="resources/js/materialize.js" type="text/javascript"></script>
        <script>
            $(document).ready(function () {
                $('select').formSelect();
            });
        </script>
    </body>
</html>