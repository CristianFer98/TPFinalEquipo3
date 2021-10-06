<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/estilo.css">
    <script src="https://kit.fontawesome.com/f44bbf66b4.js" crossorigin="anonymous"></script>

    <title>Document</title>
</head>
<body>
        <header>
            <div class="header_titulo">
            <img src="css/hospital.png" alt="logoHospital" id="logo"> Hospital Andres Borgeat
            </div>
                    
            <div class="buscador">
                <input type="search" name="buscador" class="buscadorHeader" placeholder="Buscar servicios" id="">
                <input type="submit" value="Buscar" style="height: 30px;">
            </div>

        </header>

        <nav>
            <a href="" class="linkNav">Principal</a>
            <a href="" class="linkNav">Acerca del Hospital</a>
            <a href="" class="linkNav">Areas</a>
            <a href="" class="linkNav">Contacto</a>

        </nav>

        <main>

            <div class="inicioSesion">
                
                    <form action="loguearse" method="POST" class="formulario">
                        <input type="text" name="usuario" id="usuario" placeholder="Ingrese Usuario" class="inicioSesion_inputs">
                        <input type="password" name="clave" id="clave" placeholder="Ingrese Clave" class="inicioSesion_inputs">
                        <input type="submit" style="background-color: rgb(16, 11, 37); color: aliceblue;" class="boton_unputs" value="Iniciar Sesion" >
                        <a href="FormularioDeRegistro" style="color: black; text-decoration: none;">Registrarse</a>
                    </form>


            </div>
        </main>

        <footer>
            

        </footer>
</body>
</html>