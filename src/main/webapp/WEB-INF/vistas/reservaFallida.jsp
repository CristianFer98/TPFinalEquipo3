<jsp:include page="header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<main>

	<div style="display: flex; justify-content: center">
		<div class="card card-margin"
			style="width: 50%; height: auto; margin: 20px">
			<div class="card-header no-border">
				<h5 class="card-title">Checkout de Su reserva</h5>
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

								consulta : $${turno.valorDeLaConsulta}</span></li>

						<li class="widget-49-meeting-item"><span>Medico
								Asignado: ${turno.medicoAsignado.nombre}</span></li>
						<li class="widget-49-meeting-item"><span>Contacto con
								el Medico : ${turno.medicoAsignado.telefono}</span></li>
						<li class="widget-49-meeting-item"><span>Especialidad : ${turno.medicoAsignado.especialidad.especialidad}</span></li>
					</ol>

				</div>
			</div>
			
			<c:set var = "problema" scope = "session" value = "0"/>
			 
	         <c:if test="${problema == 1}">
	         <div class="alert alert-danger">${msj}</div>
	         </c:if>
	         
	         <c:if test="${problema == 2}">
	         <div class="alert alert-warning">${msj}</div>
	         </c:if>
	         
   
			 

			 <div class="btn btn-secondary" >
			 	<a href="paginaPrincipal" style="color:white">VOLVER A LA PAGINA PRINCIPAL</a>
			 </div>
			
		</div>
			
	</div>

</main>

<jsp:include page="footer.jsp"></jsp:include>