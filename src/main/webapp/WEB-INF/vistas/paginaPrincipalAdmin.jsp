
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

        ${usuario.nombre}: Bienvenido a la Pagina Administradora
 		
 		<div class="registro">
                
                    <form action="RegistrarMedico" method="POST" class="formulario" modelAttribute="DatosRegistroMedico">
                    	<h3>Ingrese los datos para registrar a un Medico</h3>
                        <input type="text" path="email" name="email" id="contrasenia2" placeholder="Ingrese el Email" class="inicioSesion_inputs" required>					
                        <input type="text" path="nombre" name="nombre" id="nombre" placeholder="Ingrese su Nombre" class="inicioSesion_inputs" required>
                        <input type="text" path="edad" name="edad" id="edad" placeholder="Ingrese su Edad" class="inicioSesion_inputs" required>	
                        <input type="password" path="contrasenia1" name="contrasenia1" id="contrasenia2" placeholder="Ingrese Clave" class="inicioSesion_inputs" required>
                        <input type="password" path="contrasenia2" name="contrasenia2" id="contrasenia2" placeholder="Repita su Clave" class="inicioSesion_inputs" required>                      
                        <input type="submit" style="background-color: rgb(16, 11, 37); color: aliceblue;" class="boton_unputs" value="Registrarse" >
                        <h4 style="color:red">${error}</h4>
                        <h4 style="color:green">${mensaje}</h4> 
                       
                    </form>
                  

            </div>
 
 		
        </main>

        <footer>
            

        </footer>
</body>
</html>