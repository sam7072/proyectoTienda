<%@include file="../header.jsp" %>      
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body> 
        <div class="container">         
            <div class="main">   
                <div class="col m12">
                    <div class = "orange white-text left-align z-depth-3">
                        <h5>Gestión de Productos</h5>
                    </div>
                </div>
                <div class="row">
                    <div class="right-align">
                        <a href="control?action=nuevo" class = "btn btn-primary"><i class="fa fa-plus"></i>&nbsp;Agregar Producto</a>
                    </div>
                </div>
                <div class="col m12">
                    <table class="responsive-table">
                        <tr class='grey z-depth-4 white-text center-align'>
                            <th class="center-align">Código</th>
                            <th class="center-align">Descripción</th>
                            <th class="center-align">Precio</th>
                            <th class="center-align">Stock</th>
                            <th class="center-align">Acción</th>
                        </tr>
                        <c:forEach items="${base}" var = "p">
                            <tr>
                                <td class="left-align">${p.codigo}</td>
                                <td class="left-align">${p.descripcion}</td>
                                <td class="left-align">${p.precio}</td>
                                <td class="right-align">${p.stock}</td>
                                <td>
                                    <!--Llamar al método actualizar y crear el botón.-->
                                    <a href="control?action=actualizar&id=${p.id_producto}" class="waves-effect waves-light btn-small purple white-text z-depth-3"><i class="fa fa-pencil"></i></a>
                                    <!--Llamar al método eliminar y crear el botón.-->
                                    <a href="control?action=eliminar&id=${p.id_producto}" class="waves-effect waves-light btn-small red white-text z-depth-3"><i class="fa fa-trash-o fa-lg"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <br/>
                </div>
            </div>
        </div>
    </body>
</html>