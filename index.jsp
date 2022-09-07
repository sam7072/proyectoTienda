<!DOCTYPE html>
<html lang="utf-8">
    <head>
        <title>Login</title>
        <meta charset="utf-8">

    </head>
    <body>
        <main>
            <div style="width: 400px">
                <img src="" alt="logo"/>
            </div>
            <div style="width: 400px">
                <div>
                    <form method="post" action="controlUser?action=validar">
                        <h3 class=text-center>Iniciar sesión</h3>
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
        </main>
    </body>
</html>