<jsp:include page="headerMedico.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

		<form action="cargarAgenda" method="POST" style="display:flex"
			style="color: black; display: flex; flex-direction: column; justify-content: space-around;"
			modelAttribute="DatosAgendaMesMedico">

			<h2>Complete los datos a continuacion para el proximo mes</h2>



			<div style="display: flex; font-size: 25px" >
				<c:if test="${not empty lista}">
					<c:forEach var="lista" items="${lista}">
						<div class="form-check">
							<input class="form-check-input" path="diasDeLaSemanaElegidos" name="diasDeLaSemanaElegidos" type="checkbox" value="${lista.id}" id="flexCheckDefault">
							 <label	class="form-check-label" for="flexCheckDefault"> ${lista.dias}
							 </label>
						</div>
					</c:forEach>

				</c:if>

			</div>
____________________________________________________________________________
			<label for="horarioComienza" style="font-size:25px">Comienzo de Jornada laboral:</label> 
			<input type="time" style="width: 40%; margin:10px" id="appt" path="horarioComienzoJornada" name="horarioComienzoJornada"> 
			
			<label for="horarioFinal" style="font-size:25px">Fin de Jornada laboral:</label>
			<input type="time" style="width: 40%;" id="appt" path="horarioFinJornada" name="horarioFinJornada">
			
			<label for="precioPorConsulta" style="font-size:25px">Indique el valor de la consulta en pesos</label>
			<input type="number" style="width: 40%;" id="appt" path="valorPorConsultaNormal" name="valorPorConsultaNormal">
			
			<label for="duracionTurno" style="font-size:25px">Indique duracion de cada turno</label>
			<input type="time" style="width: 40%;" id="appt" path="duracionTurno" name="duracionTurno">
			
			
			<input type="submit"
				style="background-color: rgb(16, 11, 37); color: aliceblue;"
				class="boton_unputs" value="Cargar agenda"> 
				${mensajeDeExito}

		</form>



	</div>
</main>

<jsp:include page="footer.jsp"></jsp:include>