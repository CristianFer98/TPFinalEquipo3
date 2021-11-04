<jsp:include page="header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<main>

	<h2 style="text-align: center">${sessionScope.get("nombre")}:
		Estas son las visitas medicas que tiene programadas</h2>

	<c:if test="${not empty lista}">

		<ul>
			<c:forEach var="lista" items="${lista}">

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
										<span class="widget-49-pro-title">Nombre:
											${lista.clienteAsignado.nombre}</span> <span
											class="widget-49-meeting-time">Horario:
											${lista.fecha.hour}:${lista.fecha.minute}</span>
									</div>
								</div>
								<ol class="widget-49-meeting-points">
									<li class="widget-49-meeting-item"><span>Especialidad:
											${lista.medicoAsignado.especialidad.especialidad}</span></li>
									<li class="widget-49-meeting-item"><span>Medico:
											${lista.medicoAsignado.nombre}</span></li>
									<li class="widget-49-meeting-item"><span>Contacto:
											${lista.medicoAsignado.email}</span></li>
									<li class="widget-49-meeting-item"><span>Duracion:
											${lista.tiempoDeLaConsulta}</span></li>
									<li class="widget-49-meeting-item"><span>Precio:
											$${lista.valorConDescuento}</span></li>
								</ol>
								<div class="widget-49-meeting-action">
									<a href="cancelarTurno?idTurno=${lista.id}" class="btn btn-sm btn-flash-border-primary">Cancelar
										Turno</a>
								</div>
							</div>
						</div>
					</div>
				</div>

			</c:forEach>
		</ul>

	</c:if>

</main>

<jsp:include page="footer.jsp"></jsp:include>