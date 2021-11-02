<jsp:include page="header.jsp"></jsp:include>





	<h1 style="text-align:center">${sessionScope.get("nombre")}: Bienvenido a la Pagina Principal de Pacientes.</h1>
	
	
	 <a href="listarEspecialidad">
		<div class="card border-primary mb-3" style="witdh:100%">
			<div class="card-header">Solicitá tu turno</div>
			<div class="card-body text-primary">
				<h5 class="card-title">Turnos</h5>
				<p class="card-text">Tenes los mejores especialistas en salud.</p>
			</div>
		</div>
		
		
	</a> <a href="verMisTurnos">
		<div class="card border-primary mb-3" style="width:100%;">
			<div class="card-header">Turnos Asignados</div>
			<div class="card-body text-primary">
				<h5 class="card-title">Consulta</h5>
				<p class="card-text">No recordas la fecha de un turno? Entra.</p>
			</div>
		</div>
	</a> 
	
	<a href="centralAmbulancia" >
<button type="button" style="" class="btn btn-danger btn-lg btn-block">Solicitar Ambulancia Urgente</button>
	</a>

</div>

<jsp:include page="footer.jsp"></jsp:include>
