<jsp:include page="headerAdmin.jsp"></jsp:include>






<div class="contenido" style="display: flex; justify-content: space-around; width: 100%">

	<div class="section-content" style="width: 60%">
		<h2>Hola, ${sessionScope.get("nombre")}.</h2>

		<div class="content-buttons">
			<h5>Servicios</h5>


			<div class="btns shadow-shorter">
				<a href="showFormNewMedic">Cargar Nuevo Medico</a>
				<p>Para nuevos contratados</p>
			</div>

			<div class="btns shadow-shorter">
				<a href="formGestionAmbulancia">Gestion de Ambulancias</a>
				<p>Alta y Baja de Ambulancias</p>
			</div>
	</div>
</div>
			<!-- Seccion de calendario y turnos disponibles -->

			<div class="content-right"
				style="width: 40%; background-color: #FCFAF9; box-shadow: 2px 2px 5px #999;">
				<div class="calendario" style="background-color: #FCFAF9;">
					<div id="calendar" style="background-color: #FCFAF9;"></div>
				</div>

			</div>
		

	</div>



<script src="js/js/mobiscroll.javascript.min.js"></script>
<script>
	mobiscroll.datepicker('#calendar', {
		controls : [ 'calendar' ],
		display : 'inline',
		themeVariant : 'light',
	});
</script>

<jsp:include page="footer.jsp"></jsp:include>
