<jsp:include page="header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<main>

	<h2 style="text-align: center">${sessionScope.get("nombre")}:
		Estos son los proximos turnos a los que tiene que asistir</h2>


	<c:if test="${not empty lista}">

		<ul>
			<c:forEach var="lista" items="${lista}">

				<c:if test="${lista.turnoDadoDeAlta != true}">

					<div style="display: flex; width: 100%; justify-content: center">
						<div class="card card-margin"
							style="width: 60%; height: 200px; margin: 20px">

							<div class="card-body pt-0">
								<div class="widget-49">
									<div class="widget-49-title-wrapper">
										<div class="widget-49-date-primary">
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
										<li class="widget-49-meeting-item"><span>Telefono
												de Paciente: ${lista.medicoAsignado.telefono}</span></li>
										<li class="widget-49-meeting-item"><span>Fecha de
												Nacimiento del paciente:
												${lista.medicoAsignado.fechaNacimiento}</span></li>

									</ol>
									<c:if test="${lista.realizado == true}">
										<span style="display: flex"> <a
											href="darDeBaja?idTurno=${lista.id}"> Dar de Baja </a>
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


</main>

<jsp:include page="footer.jsp"></jsp:include>