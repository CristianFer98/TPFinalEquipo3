<jsp:include page="header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<div class="contenido" style="display:flex; justify-content:space-around; width:100%">

	<div class="section-content" style="width:60%">
				<h2>Hola, ${sessionScope.get("nombre")}.</h2>

				<div class="content-buttons">
					<h5>Servicios</h5>


					<div class="btns shadow-shorter">
						<a href="listarEspecialidad">Reservar Turno</a>
						<p>Reserva tu turno con el medico que vos desees</p>
					</div>

					<div class="btns shadow-shorter">
						<a href="centralAmbulancia">Solicitar Ambulancia</a>
						<p>Urgencia? Reserva tu ambulancia lo mas pronto posible</p>
					</div>

					<div class="btns shadow-shorter">
						<a href="planes">Planes Medicos</a>
						<p>Asociate a nuestros planes medicos y obtene los mejores
							beneficios</p>
					</div>


				</div>
			</div>
			
			
<!-- Seccion de calendario y turnos disponibles -->

				<div class="content-right" style="width:40%; background-color:#FCFAF9; box-shadow: 2px 2px 5px #999; ">
				<div class="calendario" style="background-color:#FCFAF9;">
					<div id="calendar" style="background-color:#FCFAF9;"></div>
				</div>

<!-- Seccion de turnos proximos -->
				<div class="lista-turnos">
					<h3>Proximos Turnos</h3>

					<c:forEach var="lista" items="${lista}">
					
					<c:if test="${lista.calificacion == null}">
					
						<div class="turno-card" style="display:flex; justify-content:space-between; width: 100%;">
							
							<!-- INFORMACION -->
	
							<div>
								<div>Dr. ${lista.medicoAsignado.nombre} -
									${lista.medicoAsignado.especialidad.especialidad}</div>
								<div>Hora: ${lista.fecha.hour}:${lista.fecha.minute} Hs. - Precio: $${lista.valorFinal}</div>
								<div>Fecha: ${lista.fecha.monthValue}/${lista.fecha.dayOfMonth}/${lista.fecha.year}</div>
								
								<c:if test="${lista.pagado == null}">
									<div style="background-color: #FFA745; color: black; border-radius:10px" >
										Pendiente De Pago</div>
								</c:if>
								<c:if test="${lista.pagado != null && lista.turnoDadoDeAlta == null}">
									<div style="background-color: #FFED56; color: black; border-radius:10px">
										Pagado</div>
								</c:if>
								
								<c:if test="${lista.turnoDadoDeAlta != null }">
									<div style="background-color: #8FFFAC; color: black; border-radius:10px">
										Finalizado</div>
								</c:if>
							</div>	
							
							<!-- Si NO esta pagado lo puede cancelar -->
							<div>
								<c:if test="${lista.pagado != true}">
								<div class="widget-49-meeting-action">
									<a href="cancelarTurno?idTurno=${lista.id}" class="btn btn-danger">Cancelar
										Turno</a>
								</div>
								</c:if>
							</div>		
							<!-- Si Esta dado de alta lo puede valorar -->
								<div>
								<c:if test="${lista.turnoDadoDeAlta == true}">
									
                    					
									<div class="ec-stars-wrapper">
										<a href="calificar?calificar=1&idTurno=${lista.id}" data-value="1" title="Votar con 1 estrellas">&#9733;</a>
										<a href="calificar?calificar=2&idTurno=${lista.id}" data-value="2" title="Votar con 2 estrellas">&#9733;</a>
										<a href="calificar?calificar=3&idTurno=${lista.id}" data-value="3" title="Votar con 3 estrellas">&#9733;</a>
										<a href="calificar?calificar=4&idTurno=${lista.id}" data-value="4" title="Votar con 4 estrellas">&#9733;</a>
										<a href="calificar?calificar=5&idTurno=${lista.id}" data-value="5" title="Votar con 5 estrellas">&#9733;</a>
									</div>
									
								
								</c:if>
									</div>
								
							</div>
						
						
						</c:if>
					</c:forEach>

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

<jsp:include page="footer.jsp"></jsp:include>
