<jsp:include page="header.jsp"></jsp:include>
<style>

</style>
<main>


	<div style="display: flex; justify-content: center">
		<div class="card card-margin" style="width:50%; height:300px; margin:20px">
			<div class="card-header no-border">
				<h5 class="card-title">Perfil</h5>
			</div>
			<div class="card-body pt-0">
				<div class="widget-49">
					<div class="widget-49-title-wrapper">
						<div class="widget-49-date-primary">
							<span class="widget-49-date-day">${usuario.edad.dayOfMonth}</span>
							<span class="widget-49-date-month">${usuario.edad.month}</span>
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
					</ol>
					<div class="widget-49-meeting-action">
						<a href="EditarPerfil" class="btn btn-sm btn-flash-border-primary">Editar Pefil</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</main>


<jsp:include page="footer.jsp"></jsp:include>