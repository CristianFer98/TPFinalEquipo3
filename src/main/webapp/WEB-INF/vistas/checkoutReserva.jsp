<jsp:include page="header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<main>

	<div style="display: flex; justify-content: center">
		<div class="card card-margin"
			style="width: 50%; height: auto; margin: 20px; ">
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
	         
             


			<script
  				src="https://www.mercadopago.com.ar/integrations/v1/web-payment-checkout.js"
  				data-preference-id="${preference.id}">
			</script>
			 

			 <div class="btn btn-secondary" >
			 	<a href="pagoExitoso?idTurno=${turno.id}&idUsuario=${turno.clienteAsignado.idUsuario}&status=no&payment_id=0" style="color:white">Pagar en la clinica</a>
			 </div>
			
			</div>
			
		</div>

	
	

	
	
	<script src="https://sdk.mercadopago.com/js/v2"></script>
	<script>
		// Agrega credenciales de SDK
		const mp = new MercadoPago('TEST-734025de-7dce-4565-ae60-d940bcca5b07', {
			locale : 'es-AR'
		});

		// Inicializa el checkout
		mp.checkout({
			preference : {
				id : '${preferenceId}'
			},
			render : {
				container : '.cho-container', // Indica el nombre de la clase donde se mostrará el botón de pago
				label : 'Pagar', // Cambia el texto del botón de pago (opcional)
			}
		});
	</script>

</main>

<jsp:include page="footer.jsp"></jsp:include>