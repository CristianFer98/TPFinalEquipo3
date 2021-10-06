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

            <div class = "container">
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <form action="Registrarse" method="POST" modelAttribute="DatosRegistroUsuarioComun"><!-- Aca no son los datos del login sino de un usuario nuevo. 
        																				El cual tiene otras caracteristicas
        																				es un metodo POST porque hace cambios  -->
            <h3 class="form-signin-heading">Registro</h3>
            <hr class="colorgraph"><br>

            Ingrese su email: <input path="email" name="numero1" type="email" class="form-control" /><!-- Los atributos de la clase datosRegistro -->
           
            Ingrese una clave: <input path="contrasenia1" name="numero2" type="password" class="form-control"/>
            
            Repita su clave: <input path="contrasenia2" name="numero2" type="password" class="form-control"/>
            

            <button id="btn-registrarme" class="btn btn-lg btn-primary btn-block" Type="Submit"/>Sumar</button><!-- 
            un submit toma lo que tiene el accion. Si quiero linkear el boton submit con el accion del formulario le tengo que decir
            al control de registro, cuando diga registrarme (url del controlador) va a ejecutar ese metodo.
            el boton vincula al accion y el accion a la url y la url al metodo -->
        </form>
         <c:if test="${not empty error}">
            <h4><span>${error}</span></h4>
            <br><!-- preguntar por esto -->
        </c:if>
        
</div>
</div>
        </main>

        <footer>
            

        </footer>
</body>
</html>