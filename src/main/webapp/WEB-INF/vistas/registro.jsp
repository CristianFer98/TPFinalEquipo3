<jsp:include page="header.jsp"></jsp:include>

        <main>

    
            <div class="registro">
                
                    <form action="Registrarse" method="POST" class="formulario" modelAttribute="DatosRegistroUsuarioComun">
                    	<h2>Ingrese sus datos para registrarse</h2>
                        <input type="text" path="email" name="email" id="contrasenia2" placeholder="Ingrese su email" class="inicioSesion_inputs" required>
                        <input type="text" path="nombre" name="nombre" id="nombre" placeholder="Ingrese su Nombre" class="inicioSesion_inputs" required>
                        <input type="text" path="edad" name="edad" id="edad" placeholder="Ingrese su edad" class="inicioSesion_inputs" required>                       
                        <input type="password" path="contrasenia1" name="contrasenia1" id="contrasenia2" placeholder="Ingrese Clave" class="inicioSesion_inputs" required>
                        <input type="password" path="contrasenia2" name="contrasenia2" id="contrasenia2" placeholder="Repita su Clave" class="inicioSesion_inputs" required>                      
                        <input type="submit" style="background-color: rgb(16, 11, 37); color: aliceblue;" class="boton_unputs" value="Registrarse" >
                        <a href="index" style="color: black; text-decoration: none;">Ya estas registrado? click aqui</a>
                        ${error}
                       
                    </form>
                    


            </div>
        </main>

  <jsp:include page="footer.jsp"></jsp:include>
  