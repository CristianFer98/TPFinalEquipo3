
 <jsp:include page="header.jsp"></jsp:include>

<body>


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
        
        
        

 <jsp:include page="footer.jsp"></jsp:include>