<jsp:include page="header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<main>

	<h2 style="text-align: center">${sessionScope.get("nombre")}:
		Acontinuacion elija los turnos disponibles para el medico
		${medico.nombre}</h2>


<div style="display:flex">

		<c:if test="${not empty lista}">
	
		

			<div style="width: 50%; overflow: auto; height: 400px; margin: 20px">
				<div class="card-header" style="background-color: grey">Turnos
					Disponibles</div>
				<c:forEach var="lista" items="${lista}">
				
				<c:if test="${lista.realizado != true}">
	        						
					<a href="reservarTurno?idTurno=${lista.id}&idUsuario=${sessionScope.get('idUsuario')}">
						
						<div class="list-group-item">
						
							<p style="color: #252440; font-size: 20px">
								${lista.fecha.year}/${lista.fecha.monthValue}/${lista.fecha.dayOfMonth}
								- ${lista.fecha.hour}:${lista.fecha.minute} HS. Precio $${lista.valorDeLaConsulta}
							<p>
						</div>
					</a>
					</c:if>
				</c:forEach>

			</div>
		</c:if>


		
		<div class="card card-margin" style="width:50%; height:auto; margin:20px">
			<div class="card-header no-border" style="background-color:#EBE9E8;">
				<h5 class="card-title" >Perfil</h5>
			</div>
			<div class="card-body pt-0" style="background-color:#FCFAF9;">
				<div class="widget-49">
					<div class="widget-49-title-wrapper">
						<div class="widget-49-date-primary">
							<span class="widget-49-date-day"><img style="heigth:50px; width:50px" src="img/${medico.avatar}.png"></span>
							<span class="widget-49-date-month"></span>
						</div>
						<div class="widget-49-meeting-info">
							<span class="widget-49-pro-title">Nombre:
								${medico.nombre}</span> <span class="widget-49-meeting-time">Especialidad:
								${medico.especialidad.especialidad}</span>
						</div>
					</div>
					<ol class="widget-49-meeting-points">
						<li class="widget-49-meeting-item"><span>Email:
								${medico.email}</span></li>
						<li class="widget-49-meeting-item"><span>Pagina Web
								Personal: ${medico.paginaPersonal}</span></li>
						<li class="widget-49-meeting-item"><span>Contacto:
								${medico.telefono}</span></li>
					</ol>
					<div class="widget-49-meeting-action">
						
					</div>
				</div>
			</div>
		</div>
	</div>
	

</main>

<jsp:include page="footer.jsp"></jsp:include>
