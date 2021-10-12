<jsp:include page="header.jsp"></jsp:include>


        <div class="registro">
                
                    <form action="CargarDatosMedico" method="POST" class="formulario" modelAttribute="DatosDeActualizacionPerfilMedico"  >
                    	<h2>Ingrese sus datos para registrarse</h2>
                    	
                    	  <select path="especialidad" name="especialidad" id="especialidad">
						  <option value="Cardiologo" name="especialidad">Cardiologo</option>
						  <option value="Pediatra" name="especialidad" selected>Pediatra</option>
						  <option value="Tramuatologo" name="especialidad">Tramuatologo</option>
						  <option value="Gastroenterologo" name="especialidad">Gastroenterologo</option>
						  <option value="Quinesiologo" name="especialidad">Quinesiologo</option>
						</select>
						<input type="text" path="telefono" name="telefono" placeholder="Telefono de Contacto" class="inicioSesion_inputs">
						<input type="text" path="paginaPersonal" name="paginaPersonal" id="PaginaPersonal" placeholder="Ingrese su sitio web" class="inicioSesion_inputs">
						<input type="file" path="foto" name="foto" id="foto" class="inicioSesion_inputs">         
						<input type="submit" style="background-color: rgb(16, 11, 37); color: aliceblue;" class="boton_unputs" value="Cargar datos" >
						<img style='display:block; width:100px;height:100px;' id='base64image'                 
						 src='data:image/jpeg;base64, ${exito}' />						  
						<a href="MyPerfil">Ir a mi perfil</a>                 	
                    	
                    </form>
                        
                    


            </div>

     <jsp:include page="footer.jsp"></jsp:include>
     