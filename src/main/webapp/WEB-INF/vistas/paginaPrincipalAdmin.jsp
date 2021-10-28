<jsp:include page="header.jsp"></jsp:include>

		<style>
			main{
				min-height: 90vh;
				display:flex;
				align-items: center;
				flex-direction: column;
			}
			
			.titulo-admin{
				margin:15px 0px;
			}
			
			.titulo-admin span{
				text-transform: capitalize;
			}
			
			.registro{
			    display: flex;
   			 	flex-direction: column;
    			justify-content: center;
   				align-items: center;
			
			}
			
			.registro form{
			
			
			}
			
			.registro form input{
			}
		
			.ambulancias-control{
				margin-top: 30px;
			}
			
			.ambulancias-control form{
				margin-top: 10px;
			}
		
		
		</style>



        <main>

		<div class="titulo-admin">
			<span>${sessionScope.get("nombre")}</span> : Bienvenido a la Pagina Administradora
		</div>
        
 		
 		<div class="registro">
                	<h3>Ingrese los datos para registrar a un Medico</h3>
                    <form action="RegistrarMedico" method="POST" class="formulario" modelAttribute="DatosRegistroMedico">
                    	
                    	<div>
                    	<input type="text" path="email" name="email" id="contrasenia2" placeholder="Ingrese el Email" class="inicioSesion_inputs" required>					
                        <input type="text" path="nombre" name="nombre" id="nombre" placeholder="Ingrese su Nombre" class="inicioSesion_inputs" required>
                        <input type="text" path="edad" name="edad" id="edad" placeholder="Ingrese su Edad" class="inicioSesion_inputs" required>	
                        <input type="password" path="contrasenia1" name="contrasenia1" id="contrasenia2" placeholder="Ingrese Clave" class="inicioSesion_inputs" required>
                        <input type="password" path="contrasenia2" name="contrasenia2" id="contrasenia2" placeholder="Repita su Clave" class="inicioSesion_inputs" required>                      
                        <input type="submit" style="background-color: rgb(16, 11, 37); color: aliceblue;" class="boton_unputs" value="Registrarse" >                   	
                    	</div>
                                               
                        <div>
                        <h4 style="color:red">${error}</h4>
                        <h4 style="color:green">${mensaje}</h4>                       
                        </div>

                       
                    </form>
            </div>
            
            <div class="ambulancias-control">
            		<h3> AMBULANCIAS CONTROL PANEL</h3>
            		<form action="registrarAmbulancia">
            		 Patente: <input type="text" name="patente">
            		 <input type="submit" value="DAR DE ALTA AMBULANCIA">
            		</form>  
            		<form action="activarUsuario">
            		 Email: <input type="text" name="email">
            		 <input type="submit" value="ATENDER CONSULTA DE ESTE USER">
            		</form>               
                   ${msj}   
            </div>
 
 		
        </main>

<jsp:include page="footer.jsp"></jsp:include>
      