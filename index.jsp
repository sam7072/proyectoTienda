<!doctype html>
<html lang="es">

    <head>
        <meta charset="utf-8">
        <title> Formulario de Acceso </title>    
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Videojuegos & Desarrollo">
        <meta name="description" content="Muestra de un formulario de acceso en HTML y CSS">
        <meta name="keywords" content="Formulario Acceso, Formulario de LogIn">
        <link href="https://fonts.googleapis.com/css?family=Nunito&display=swap" rel="stylesheet"> 
        <link href="https://fonts.googleapis.com/css?family=Overpass&display=swap" rel="stylesheet">

        <!-- Link hacia el archivo de estilos css -->
        <link rel="stylesheet" href="resources/css/login.css">
        <style type="text/css">
        </style>
        <script type="text/javascript"></script>
    </head>
    <body>
        <main>

            <div style="width: 400px">
                <img src="" alt="logo"/>
            </div>
            <div style="width: 400px">
                <div>
                    <form method="post" action="controlUser?action=validar">
                        <h3 class=text-center>Iniciar sesiÃ³n</h3>
                        <label>Nombre del cliente</label>
                        <input type="text" class="form-control" name="txtUser" placeholder="Usuario" required=""/>
                        ${msjUser}
                        <br/>
                        <label>ContraseÃ±a</label>
                        <input type="password" class="form-control" name="txtPass" required=""/>
                        ${msjPass}
                        <br />
                        <div>
                            ${msjTodo}
                            <input type="submit" value="Ingresar"/>

            <div id="contenedor">
                <div id="central">
                    <div id="login">
                        <div class="titulo">
                            Bienvenido

                        </div>
                        <form id="loginform" method="post" action="controlUser?action=validar">
                            <label>Nombre de usuario</label>
                            <input type="text" class="form-control" name="txtUser" placeholder="Usuario" required=""/>
                            ${msjUser}
                            <br/>
                            <label>Contraseña</label>
                            <input type="password" class="form-control" name="txtPass" required=""/>
                            ${msjPass}
                            <br />
                            <div>
                                ${msjTodo}
                                <input type="submit" value="Ingresar"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </main>
    </body>
</html>