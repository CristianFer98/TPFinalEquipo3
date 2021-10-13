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
    
    <style>
    	.btn-ambulancia a{
    	border: none;
   		background: tomato;
    	padding: 15PX;
    	margin: 5px;
    	border-radius: 35px;
    	margin-top: 40px;
    	
    	}
    </style>

    <title>Document</title>
</head>
<body>
        <header>
            <div class="header_titulo">
            <img src="css/hospital.png" alt="logoHospital" id="logo"> Hospital Florencia Martin
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
                
                    <form action="loguearse" method="POST" class="formulario"  modelAttribute="datosDeInicioSesion">
                        <input type="text" path="email" name="email" id="email" placeholder="Ingrese Usuario" class="inicioSesion_inputs" required>
                        <input type="password" path ="contrasenia" name="contrasenia" id="contrasenia" placeholder="Ingrese Clave" class="inicioSesion_inputs" required>

                        <input type="submit" style="background-color: rgb(16, 11, 37); color: aliceblue;" class="boton_unputs" value="Iniciar Sesion" >
                        <a href="registro" style="color: black; text-decoration: none;">Registrarse</a>
                        ${error}
                    </form>
            </div>
        </main>
        
        <div class="btn-ambulancia">
        	<a href="centralAmbulancia">SOLICITAR AMBULANCIA</a>
        </div>
        
        

        <footer>
            

        </footer>
</body>
</html>