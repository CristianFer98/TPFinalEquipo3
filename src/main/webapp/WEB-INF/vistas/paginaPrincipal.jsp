<jsp:include page="header.jsp"></jsp:include>





	<h1 style="text-align:center">${sessionScope.get("nombre")}: Bienvenido a la Pagina Principal de Pacientes.</h1>
	
	


<div style="display: flex; flex-wrap:wrap">

				
				<div class="card-group" style="width:30%; margin:15px">
				
					<div class="card">
						<img src="img/turnoMedico.jpg" style="height:250px">
						<div class="card-body">
							<h5 class="card-title">Solicita tu turno</h5>
							<p class="card-text">Tenes los mejores especialistas en salud.</p>
							<a href="listarEspecialidad" ><button type="button" class="btn btn-secondary">Entrar</button></a>

						</div>
					</div>
				
				</div>
				
				<div class="card-group" style="width:30%; margin:15px">
				
				
				
				<div class="card">
						<img src="img/emergencia.jpg" style="height:250px" >
						<div class="card-body">
							<h5 class="card-title">Boton de panico</h5>
							<p class="card-text">Solicita una ambulancia</p>
							<a href="centralAmbulancia" ><button type="button" class="btn btn-secondary">Urgente</button></a>

						</div>
					</div>
				</div>
				
				<div class="card-group" style="width:30%; margin:15px">
				
					<div class="card">
						<img src="img/planMedico.jpg" style="height:250px">
						<div class="card-body">
							<h5 class="card-title">Accede a nuestro plan medico</h5>
							<p class="card-text">Los mejores descuentos para tus tratamientos</p>
							<a href="cotizarPlanMedico" ><button type="button" class="btn btn-secondary">Entrar</button></a>

						</div>
					</div>
				
				</div>
				
				<div class="card-group" style="width:30%; margin:15px">
				
						<div class="card">
						<img src="img/recordar.jpg" style="height:250px">
						<div class="card-body">
							<h5 class="card-title">Turnos asignados</h5>
							<p class="card-text">¿No recordas la fecha de un turno?</p>
							<a href="verMisTurnos" ><button type="button" class="btn btn-secondary">Entrar</button></a>

						</div>
					</div>
				
				</div>
				
		</div>

<jsp:include page="footer.jsp"></jsp:include>
