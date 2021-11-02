<jsp:include page="header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<main>
<style>
			main{
				height:500px;
				justify-content: center;
    			align-items: center
			}
			
			.registro{			
			display: flex;
    		flex-direction: column;
   			justify-content: center;
    		align-items: center;
			width: 100%;
			border-radius: 10px;
			}
			
			.registro h2{
			
			}
			
			.registro form{
				border-radius: 10px;
			
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

	<div class="registro">

	<form action="CargarDatosMedico" method="POST" class="formulario" modelAttribute="DatosDeActualizacionPerfilMedico">
		<h4 style="font-weight:bold; color:black">Cargue sus datos de Medico</h4>

		
		<select path="especialidad" name="especialidad" id="especialidad">

			<c:if test="${not empty lista}">
				<c:forEach var="lista" items="${lista}">
					<option value="${lista.idEspecialidad}">${lista.especialidad}</option>
				</c:forEach>

			</c:if>

		</select> 
	 
		  <input type="text" path="telefono" name="telefono" placeholder="Telefono de Contacto" class="inicioSesion_inputs">
	     <input type="file" path="foto" name="foto" id="foto" class="inicioSesion_inputs">
	     <input type="text" path="paginaPersonal" name="paginaPersonal" id="PaginaPersonal" placeholder="Ingrese su sitio web" class="inicioSesion_inputs"> 
	     
	     <input type="submit" style="background-color: rgb(16, 11, 37); color: aliceblue;" class="boton_unputs" value="Cargar datos"> 
	     <a href="MyPerfil">Ira mi perfil</a>
	${mensaje}
	</form>




</div>

</main>

<jsp:include page="footer.jsp"></jsp:include>
