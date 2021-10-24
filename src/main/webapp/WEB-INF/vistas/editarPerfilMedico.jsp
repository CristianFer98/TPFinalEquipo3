<jsp:include page="header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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

<jsp:include page="footer.jsp"></jsp:include>
