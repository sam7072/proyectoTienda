<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        <div class="container">         
            <div class="main">   
                <div class="col m12">
                    <div class = "blue white-text left-align z-depth-3">
                        <h5>Lista de Productos</h5>
                    </div>
                    <div class="right-align">
                        <a href="PDF" target="_blank" class = "btn btn-primary red"><i class="fa fa-file-pdf-o"></i>&nbsp;Exportar a PDF</a>
                    </div>
                <br/>
                <div class="col m12">
                    <table class="responsive-table">
                        <tr class='grey z-depth-4 white-text center-align'>
                            <th class="center-align">Código</th>
                            <th class="center-align">Descripción</th>
                            <th class="center-align">Precio</th>
                            <th class="center-align">Stock</th>
                        </tr>
                        <c:forEach items="${base}" var = "p">
                            <tr>
                                <td class="left-align">${p.codigo}</td>
                                <td class="left-align">${p.descripcion}</td>
                                <td class="left-align">${p.precio}</td>
                                <td class="right-align">${p.stock}</td>
                            </tr>
                        </c:forEach>
                    </table>
                    <br/>                                                               
                </div>
            </div>
    </body>
</html>

