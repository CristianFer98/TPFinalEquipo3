
<jsp:include page="header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<main>
	<div
		style="display: flex; justify-content: center; height: 400px; align-items: center">
		<div
			style="height: auto; width: 80%; display: flex; flex-direction: column; justify-content: center; background-color: beige; border-radius: 15px">
			<h2 style="text-align: center">${sessionScope.get("nombre")}:Tu
				ambulancia llegara lo mas pronto posible</h2>

			<h4>Nombre: ${soli.getUsuarioSolicitante().getNombre()}</h4>
			<h4>Direccion: ${soli.getDireccion()}</h4>

			<h4>LA PATENTE DE SU AMBULANCIA ES=
				${soli.getAmbulanciaEnCamino().getPatenteAmbulancia()}</h4>
			<h4>Asegurate que sea la ambulancia correcta para evitar
				incidentes</h4>


			<div style="display: flex; justify-content: center">
				<a href="paginaPrincipal"><button type="button"
						class="btn btn-primary" style="width: 100%; align-self: center">Volver
						a la pagina principal</button></a>
			</div>
			
			<div style="display: flex; justify-content: center">
				<form action="canceloAmbulancia">
        	 	<input type="text" name="ambulanciaCancelada" value="${soli.getAmbulanciaEnCamino().getPatenteAmbulancia()}" style="display:none">
        		<button type="submit">CANCELAR</button>
        	</form>
			</div>
		</div>
	</div>
</main>

<jsp:include page="footer.jsp"></jsp:include>
