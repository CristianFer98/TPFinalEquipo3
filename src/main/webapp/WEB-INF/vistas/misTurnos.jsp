<jsp:include page="header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
	*{
		padding: 0;
	}
</style>

<main>

	<h2 style="text-align: center">${sessionScope.get("nombre")}:
		Estas son las visitas medicas que tiene programadas</h2>
		
	<c:if test="${turnoCancel != null}">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

		<script>
			$(function() {
	 		 var messageText = 'Turno ${turnoCancel.getId()} cancelado con exito';
	  		 var alertBox = '<div class="alert alert-warning alert-dismissible fade show" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>' + messageText + '</div>';
	  
	 		 $('.msj').append(alertBox);
	    });
        </script>


		
    			<div class="msj">
    
    			</div>
  		
	</c:if>	

	<c:if test="${not empty lista}">

		<ul>
			<c:forEach var="lista" items="${lista}">

				<div style="display: flex; width: 100%; justify-content: center">
					<div class="card card-margin"
						style="width: 60%; height: auto; margin: 20px">

						<div class="card-body">
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
											$${lista.valorFinal}</span></li>
									<li class="widget-49-meeting-item">
									
									<c:if test="${lista.pagado == null}">
	        							 <div style="background-color: yellow;"> Pendiente De Pago</div> 
	        						</c:if>
	        						<c:if test="${lista.pagado != null}">
	        							 <div style="background-color: green; color: white" > PAGADO</div> 
	        						</c:if>
									
									</li>			
								</ol>
								<div class="widget-49-meeting-action">
									<a href="cancelarTurno?idTurno=${lista.id}" class="btn btn-danger">Cancelar
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

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<jsp:include page="footer.jsp"></jsp:include>