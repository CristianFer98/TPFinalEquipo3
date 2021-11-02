<jsp:include page="header.jsp"></jsp:include>

		<style>
<<<<<<< HEAD
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
=======
			
			
			.registro{
			display: flex;
    		flex-direction: row;
   			justify-content: center;
    		align-items: center;
			width: 100%;
			}
			
			.registro h2{
>>>>>>> cristian
			
			}
			
			.registro form{
<<<<<<< HEAD
			
			
			}
			
			.registro form input{
			}
		
			.ambulancias-control{
				margin-top: 30px;
			}
			
			.ambulancias-control form{
				margin-top: 10px;
			}
		
		
=======
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
>>>>>>> cristian
		</style>



        <main>


		<div class="" style="text-align:center">
			<h1>${sessionScope.get("nombre")} : Bienvenido a la Pagina Administradora</h1>
		</div>
        
 		
 		<div class="registro">
                   	
                    	<div>

                    <form action="RegistrarMedico" method="POST" style="display:flex; flex-direction:column;" modelAttribute="DatosRegistroMedico">
                    	
                    	<div style="display:flex; flex-direction:column">
                    	<h4>Ingrese los datos para registrar a un Medico</h4>

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
            

            <div class="registro">
            <div>
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
            </div>
 
 		
        </main>

<jsp:include page="footer.jsp"></jsp:include>
      