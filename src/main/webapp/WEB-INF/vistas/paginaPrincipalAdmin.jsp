<jsp:include page="header.jsp"></jsp:include>


        <main>

        ${sessionScope.get("nombre")}: Bienvenido a la Pagina Administradora
 		
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

<jsp:include page="footer.jsp"></jsp:include>
      