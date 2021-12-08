<jsp:include page="headerMedico.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	

<main>


	<div style="display:flex; width:100%; justify-content:space-around">
	
	
	<div style="background-color:#FCFAF9; box-shadow: 0px 8px 20px -7px rgba(0,0,0,0.75); width:52%; height:auto; padding:5px">


		<form action="cargarAgenda" method="POST" style="color:black; display: flex; flex-direction: column; justify-content: space-around; width:90%" modelAttribute="DatosAgendaMesMedico">
			
			<div style="display: flex; flex-direction: column;  height:auto">
				<h4 style="text-align:center; font-weight:bold">Complete los datos a continuacion para el proximo mes</h4>
				
				<div style="display: flex; font-size: 20px; flex-wrap:wrap" >
				<c:if test="${not empty lista}">
					<c:forEach var="lista" items="${lista}">
						<div class="form-check" style="margin:5px">
							<input class="form-check-input" path="diasDeLaSemanaElegidos" name="diasDeLaSemanaElegidos" type="checkbox" value="${lista.id}" id="flexCheckDefault">
							 <label	class="form-check-label" for="flexCheckDefault"> ${lista.dias}
							 </label>
						</div>
					</c:forEach>

				</c:if>

				</div>
				<label for="horarioComienza" style="margin-left:20px; margin-right:20px; margin-top:10px;">Comienzo de Jornada laboral:</label> 
				<input type="time" id="horarioComienza" path="horarioComienzoJornada" name="horarioComienzoJornada" required
				style="border: 1px solid rgba(0,0,0,0.2); height:35px; border-radius: 10px; margin-left:20px; margin-right:20px; margin-bottom:10px;"  >
				
				<label for="horarioFinJornada" style="margin-left:20px; margin-right:20px; margin-top:10px;">Fin de Jornada laboral:</label> 	
				<input type="time" id="horarioFinJornada"  path="horarioFinJornada" name="horarioFinJornada" required
				style="border: 1px solid rgba(0,0,0,0.2); height:35px; border-radius: 10px; margin-left:20px; margin-right:20px; margin-bottom:10px;"> 
				
				<label for="valorPorConsultaNormal" style="margin-left:20px; margin-right:20px; margin-top:10px;">Valor de la Consulta:</label> 	
				<input type="number" id="valorPorConsultaNormal" path="valorPorConsultaNormal" name="valorPorConsultaNormal" required
				style="border: 1px solid rgba(0,0,0,0.2); height:35px; border-radius: 10px; margin-left:20px; margin-right:20px; margin-bottom:10px;"> 
				
				<label for="duracionTurno" style="margin-left:20px; margin-right:20px; margin-top:10px;">Indique duracion de Turno:</label> 	
				<input type="time" id="duracionTurno"  path="duracionTurno" name="duracionTurno" required
				style="border: 1px solid rgba(0,0,0,0.2); height:35px; border-radius: 10px; margin-left:20px; margin-right:20px; margin-bottom:10px;"> 
				
			
				
				<button type=submit class="btn btn-primary" style="width:200px; align-self:center">Cargar</button>
				
			</div>

		</form>
		
		
	</div>
	
	<div class="content-right" style="width:35%; background-color:#FCFAF9; box-shadow: 2px 2px 5px #999; ">
				<div class="calendario" style="background-color:#FCFAF9;">
					<div id="calendar" style="background-color:#FCFAF9;"></div>
				</div>
	</div>
</div>
	
	<script src="js/js/mobiscroll.javascript.min.js"></script>
		<script>
			mobiscroll.datepicker('#calendar', {
				controls : [ 'calendar' ],
				display : 'inline',
				themeVariant : 'light',
			});
		</script>
</main>

<jsp:include page="footer.jsp"></jsp:include>