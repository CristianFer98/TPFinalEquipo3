
<jsp:include page="header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<main>

	<div style="display:flex; justify-content:center">
	<div class="card card-margin" style="width: 50%; height: auto; margin: 20px">
		<div class="card-header no-border" style="background-color: #EBE9E8;">
			<h5 class="card-title">${soli.getUsuarioSolicitante().getNombre()}
				tu ambulancia llegará lo antes posible</h5>
		</div>
		<div class="card-body pt-0" style="background-color: #FCFAF9;">
			<div class="widget-49">
				<div class="widget-49-title-wrapper">

					<div class="widget-49-meeting-info"></div>
				</div>
				<ol class="widget-49-meeting-points">
					<li class="widget-49-meeting-item"><span>Direccion:
							${soli.getDireccion()}</span></li>
					<li class="widget-49-meeting-item"><span>Patente de
							Ambulancia ${soli.getAmbulanciaEnCamino().getPatenteAmbulancia()}</span></li>
							
				</ol>
				<h4 style ="text-align:center; font-weight:bold">Asegurese de que sea la ambulancia correcta para evitar inconvenientes</h4>
				
				<div class="widget-49-meeting-action">
					<div style="display: flex; justify-content: center">
						<form action="canceloAmbulancia">
							<input type="text" name="ambulanciaCancelada"
								value="${soli.getAmbulanciaEnCamino().getPatenteAmbulancia()}"
								style="display: none">
							<button class="btn btn-primary" type="submit">CANCELAR</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</main>

<jsp:include page="footer.jsp"></jsp:include>
