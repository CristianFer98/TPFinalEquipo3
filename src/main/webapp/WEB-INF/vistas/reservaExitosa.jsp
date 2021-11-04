<jsp:include page="header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<main>

	<div style="display: flex; justify-content: center">
		<div class="card card-margin"
			style="width: 50%; height: 300px; margin: 20px">
			<div class="card-header no-border">
				<h5 class="card-title">Reserva Exitosa - He aqui los datos de
					su turno</h5>
			</div>
			<div class="card-body pt-0">
				<div class="widget-49">
					<div class="widget-49-title-wrapper">
						<div class="widget-49-date-primary">
							<span class="widget-49-date-day">${turno.fecha.dayOfMonth}/${turno.fecha.monthValue}</span>
						</div>
						<div class="widget-49-meeting-info">
							<span class="widget-49-pro-title">Nombre Paciente: ${turno.clienteAsignado.nombre}</span>
						</div>
					</div>
					<ol class="widget-49-meeting-points">
						<li class="widget-49-meeting-item"><span>Duracion de
								consulta ${turno.tiempoDeLaConsulta} HS.</span></li>
						<li class="widget-49-meeting-item"><span>Valor de la
								consulta : $${turno.valorConDescuento}</span></li>
						<li class="widget-49-meeting-item"><span>Medico
								Asignado: ${turno.medicoAsignado.nombre}</span></li>
						<li class="widget-49-meeting-item"><span>Contacto con
								el Medico : ${turno.medicoAsignado.telefono}</span></li>
						<li class="widget-49-meeting-item"><span>Especialidad : ${turno.medicoAsignado.especialidad.especialidad}</span></li>
					</ol>

				</div>
			</div>
		</div>
	</div>

</main>

<jsp:include page="footer.jsp"></jsp:include>