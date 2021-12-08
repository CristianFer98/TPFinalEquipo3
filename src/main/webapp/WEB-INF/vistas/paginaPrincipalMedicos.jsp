<jsp:include page="headerMedico.jsp"></jsp:include>




<div class="contenido" style="display:flex; justify-content:space-around; width:100%">

	<div class="section-content" style="width:50%">
				<h2>Hola, ${sessionScope.get("nombre")}.</h2>

				<div class="content-buttons">
					<h5>Servicios</h5>


					<div class="btns shadow-shorter">
						<a href="FormAgenda">Cargar Agenda</a>
						<p>Defina su horario de trabajo para el proximo mes</p>
					</div>

					<div class="btns shadow-shorter">
						<a href="EditarPerfil">Editar perfil</a>
						<p>Algo no esta bien con su informacion? </p>
					</div>

					<div class="btns shadow-shorter">
						<a href="verTurnos">Compromisos</a>
						<p>Turnos asignados</p>
					</div>


				</div>
			</div>
			
        
        <div style="padding-top:135px">
		<div class="card card-margin" style="width:100%; height:auto; box-shadow: 0px 8px 20px -7px rgba(0,0,0,0.75);">
			<div class="card-header no-border">
				<h5 class="card-title" >Perfil - Calificacion promedio: <img style="heigth:70px; width:200px" src="img/${calificacionSP}.png">  ${calificacion}</h5>
			</div>
			<div class="card-body pt-0">
				<div class="widget-49">
					<div class="widget-49-title-wrapper">
						<div class="widget-49-date-primary">
							<span class="widget-49-date-day"><img style="heigth:50px; width:50px" src="img/${usuario.avatar}.png"></span>
							<span class="widget-49-date-month"></span>
						</div>
						<div class="widget-49-meeting-info">
							<span class="widget-49-pro-title">Nombre:
								${usuario.nombre}</span> <span class="widget-49-meeting-time">Especialidad:
								${usuario.especialidad.especialidad}</span>
						</div>
					</div>
					<ol class="widget-49-meeting-points">
						<li class="widget-49-meeting-item"><span>Email:
								${usuario.email}</span></li>
						<li class="widget-49-meeting-item"><span>Pagina Web
								Personal: ${usuario.paginaPersonal}</span></li>
						<li class="widget-49-meeting-item"><span>Contacto:
								${usuario.telefono}</span></li>
						<li class="widget-49-meeting-item"><span>Fecha de cumpleaños:
								${usuario.edad.dayOfMonth}/${usuario.edad.month.value} </span></li>
					</ol>
					<div class="widget-49-meeting-action">
						<a href="EditarPerfil" class="btn btn-sm btn-flash-border-primary"><button type="button" class="btn btn-outline-primary">Editar</button></a>
					
					</div>
				
				</div>
				
			</div>
		</div>
		
		
	</div>
        
        
       </div>


<jsp:include page="footer.jsp"></jsp:include>
