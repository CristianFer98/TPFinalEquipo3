<!DOCTYPE html>
<html lang="en">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/indexRegistro.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />
    <title>Login-Registro</title>
</head>

<body>
    <div class="container">
        <div class="forms-container">
            <div class="login-registro">

                <form action="loguearse" method="POST" modelAttribute="datosDeInicioSesion" class="form-login">
                    <h2 class="titulo">Login</h2>
                    <div class="input-field">
                        <i class="fas fa-envelope"></i>
                        <input type="text" path="email" name="email" id="email" placeholder="Email" required>
                    </div>
                    <div class="input-field">
                        <i class="fas fa-lock"></i>
                        <input type="password" path ="contrasenia" name="contrasenia" id="contrasenia" placeholder="Contraseña" required>                     
                    </div>
                    <div>${errorLogin}</div>
                    <input type="submit" value="Login" class="btn solid">
                    <p class="social-text">O inicia sesion con:</p>
                    <div class="social-media">
                        <a href="#" class="social-icon">
                            <i class="fab fa-facebook-f"></i>
                        </a>
                        <a href="#" class="social-icon">
                            <i class="fab fa-twitter"></i>
                        </a>
                        <a href="#" class="social-icon">
                            <i class="fab fa-google"></i>
                        </a>
                        <a href="#" class="social-icon">
                            <i class="fab fa-linkedin-in"></i>
                        </a>
                    </div>
                </form>


                <form  action="Registrarse" method="POST" modelAttribute="DatosRegistroUsuario"class="form-registro">
                    <h2 class="titulo">Registrate</h2>
                    <div class="input-field">
                        <i class="fas fa-envelope"></i>
                        <input type="text" path="email" name="email" placeholder="Email" required>
                    </div>
                    <div class="input-field">
                        <i class="fas fa-user"></i>
                        <input type="text" path="nombre" name="nombre" id="nombre" placeholder="Ingrese su Nombre" required>
                    </div>
                    <div class="input-field">
                        <i class="fas fa-calendar"></i>
                        <input type="date" path="edad" name="edad" id="edad" placeholder="Ingrese su edad" required>  
                    </div>
                    <div class="input-field">
                        <i class="fas fa-lock"></i>
                        <input type="password" path="contrasenia1" name="contrasenia1" placeholder="Contraseña" required>
                    </div>
                    <div class="input-field">
                        <i class="fas fa-lock"></i>
                        <input type="password" path="contrasenia2" name="contrasenia2" id="contrasenia2" placeholder="Repite Contraseña" required>
                        <input type="hidden" path="numeroDeTipoDeUsuario" name="numeroDeTipoDeUsuario" value="1">
                    </div>
                    <div>${error}</div>
                    <input type="submit" value="Registrate" class="btn solid">
                    <p class="social-text">O registrate con </p>
                    <div class="social-media">
                        <a href="#" class="social-icon">
                            <i class="fab fa-facebook-f"></i>
                        </a>
                        <a href="#" class="social-icon">
                            <i class="fab fa-twitter"></i>
                        </a>
                        <a href="#" class="social-icon">
                            <i class="fab fa-google"></i>
                        </a>
                        <a href="#" class="social-icon">
                            <i class="fab fa-linkedin-in"></i>
                        </a>
                    </div>
                </form>

            </div>
        </div>


        <div class="panels-container">
            <div class="panel left-panel">
                <div class="content">
                    <h3>Sos nuevo por aca?</h3>
                    <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Veniam, harum voluptatibus, repellat tempora numquam perspiciatis modi dolor </p>
                    <button class="btn transparent" id="registrate-btn">Registrate</button>
                </div>

                <img src="img/medicine.svg" class="image">
            </div>

            <div class="panel right-panel">
                <div class="content">
                    <h3>Ya estas registrado?</h3>
                    <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Veniam, harum voluptatibus, repellat tempora numquam perspiciatis modi dolor </p>
                    <button class="btn transparent" id="login-btn">Logueate</button>
                </div>

                <img src="img/medical.svg" class="image">
            </div>
        </div>


    </div>

    <script src="js/indexRegistro.js"></script>
</body>

</html>