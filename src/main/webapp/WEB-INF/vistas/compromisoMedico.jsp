<jsp:include page="headerMedico.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<main>


<div style="display:flex; width:100%; justify-content:space-around">


	<div style="width:50%">
	<h5 style="text-align: center; font-weight:bold">${sessionScope.get("nombre")}:
		Estos son los proximos turnos a los que tiene que asistir</h5>


	<c:if test="${not empty lista}">

		<ul>
			<c:forEach var="lista" items="${lista}">

				<c:if test="${lista.turnoDadoDeAlta != true}">

					<div style="display: flex; width: 100%; justify-content: center">
						<div class="card card-margin" style="width: 100%; height: 200px; margin: 20px; box-shadow: 0px 8px 20px -7px rgba(0,0,0,0.75);">

							<div class="card-body pt-0">
								<div class="widget-49">
									<div class="widget-49-title-wrapper">
										<div class="widget-49-date-primary" style="margin-top:5px">
											<span class="widget-49-date-month">${lista.fecha.monthValue}/${lista.fecha.dayOfMonth}</span>
										</div>
										<div class="widget-49-meeting-info">
											<span class="widget-49-pro-title">Nombre del paciente:
												${lista.clienteAsignado.nombre}</span> <span
												class="widget-49-meeting-time">Horario:
												${lista.fecha.hour}:${lista.fecha.minute} HS.</span>
										</div>
									</div>
									<ol class="widget-49-meeting-points">
										<li class="widget-49-meeting-item"><span>Dia de la consulta
												: ${lista.fecha.monthValue}/${lista.fecha.dayOfMonth}/${lista.fecha.year}</span></li>
										<li class="widget-49-meeting-item"><span>Fecha de
												Nacimiento del paciente:
												${lista.clienteAsignado.fechaNacimiento}</span></li>
										<li class="widget-49-meeting-item"><span>Valor de la consulta: 
												$${lista.valorFinal}</span></li>
										<li class="widget-49-meeting-item"><span>Duracion de la consulta: 
												${lista.tiempoDeLaConsulta}</span></li>			
												

									</ol>
									<c:if test="${lista.realizado == true}">
										<span style="display: flex"> 
										<a href="darDeBaja?idTurno=${lista.id}" style="font-weight:bold; color:green"> Dar de Baja </a>
										</span>
									</c:if>

								</div>
							</div>
						</div>
					</div>
				</c:if>

			</c:forEach>
		</ul>

	</c:if>
	</div>
	
	
	<div class="content-right" style="width:40%; background-color:#FCFAF9; box-shadow: 2px 2px 5px #999; height:400px; margin-top:60px ">
				<div class="calendario" style="background-color:#FCFAF9;">
					<div id="calendar" style="background-color:#FCFAF9;"></div>
				</div>
	</div>
	
	
	
	
	</div>

</main>

<script src="js/js/mobiscroll.javascript.min.js"></script>
		<script>
			mobiscroll.datepicker('#calendar', {
				controls : [ 'calendar' ],
				display : 'inline',
				themeVariant : 'light',
			});
		</script>

<jsp:include page="footer.jsp"></jsp:include>