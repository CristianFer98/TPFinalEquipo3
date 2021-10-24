<jsp:include page="header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<main>


	<div class="registro">

		<form action="cargarAgenda" method="POST" class="formulario"
			style="color: black; display: flex; flex-direction: column; justify-content: space-around;"
			modelAttribute="DatosAgendaMesMedico">

			<h3>Complete los datos a continuacion para el proximo mes</h3>



			<div style="display: flex">
				<c:if test="${not empty lista}">
					<c:forEach var="lista" items="${lista}">
						<div class="form-check">
							<input class="form-check-input" path="diasDeLaSemanaElegidos" name="diasDeLaSemanaElegidos" type="checkbox" value="${lista.id}" id="flexCheckDefault">
							 <label	class="form-check-label" for="flexCheckDefault"> ${lista.dias} 			${lista.id}
							 </label>
						</div>
					</c:forEach>

				</c:if>

			</div>

			<label for="horarioComienza">Indique Comienzo de Jornadalaboral:</label> 
			<input type="time" style="width: 40%" id="appt" path="horarioComienzoJornada" name="horarioComienzoJornada"> 
			
			<label for="horarioFinal">Indique Fin de Jornada laboral:</label>
			<input type="time" style="width: 40%;" id="appt" path="horarioFinJornada" name="horarioFinJornada">
			
			<input type="submit"
				style="background-color: rgb(16, 11, 37); color: aliceblue;"
				class="boton_unputs" value="Registrarse"> 
				${mensajeDeExito}

		</form>



	</div>
</main>

<jsp:include page="footer.jsp"></jsp:include>