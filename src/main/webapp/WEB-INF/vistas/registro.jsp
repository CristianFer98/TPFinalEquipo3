<jsp:include page="header.jsp"></jsp:include>

		<style>
			main{
				min-height: 90vh;
				display: flex;
				justify-content: center;
    			align-items: center
			}
			
			.registro{
			display: flex;
    		flex-direction: column;
   			justify-content: center;
    		align-items: center;
			width: 100%;
			}
			
			.registro h2{
			
			}
			
			.registro form{
			display: flex;
    		flex-direction: column;
    		justify-content: flex-end;
    		align-items: center;
    		margin-top: 15px;  		
			padding: 15px 25px;
			background-color: lightgrey;
			}
			
			.registro form input[type=submit]{			
 		    margin-top: 15px;
    		border-radius: 25px;
    		padding: 5px 15px;
    		border-style: none;
   			text-decoration: none;
    		background-color: #6C63FF;
   			color: white;
			}
			
			.inicioSesion_inputs{
			margin-bottom: 10px;
    		border-style: none;
   		 	padding: 5px 10px;
   			background: lightgray;
    		border-bottom: solid grey;
			}
			
			.inicioSesion_inputs:focus{
			border-bottom: solid #6C63FF;
			}
			
			#foto-svg{
				 width: 45%;
   				 padding: 15px;
			}
		</style>


        <main>

    
            <div class="registro">
                	<h2>Ingrese sus datos para registrarse</h2>
                    <form action="Registrarse" method="POST" class="formulario" modelAttribute="DatosRegistroUsuarioComun">
                        <input type="text" path="email" name="email" id="contrasenia2" placeholder="Ingrese su email" class="inicioSesion_inputs" required>
                        <input type="text" path="nombre" name="nombre" id="nombre" placeholder="Ingrese su Nombre" class="inicioSesion_inputs" required>
                        <input type="date" path="edad" name="edad" id="edad" placeholder="Ingrese su edad" class="inicioSesion_inputs" required>                       
                        <input type="password" path="contrasenia1" name="contrasenia1" id="contrasenia2" placeholder="Ingrese Clave" class="inicioSesion_inputs" required>
                        <input type="password" path="contrasenia2" name="contrasenia2" id="contrasenia2" placeholder="Repita su Clave" class="inicioSesion_inputs" required>                      
                       
                        <input type="submit" class="boton_unputs" value="Registrarse" >
                        <a href="index" style="color: black; text-decoration: none;">Ya estas registrado? click aqui</a>
                        ${error}
                       
                    </form>
            </div>
            
            <img alt="" src="css/medicina3.svg" id="foto-svg">           
        </main>

  <jsp:include page="footer.jsp"></jsp:include>
  