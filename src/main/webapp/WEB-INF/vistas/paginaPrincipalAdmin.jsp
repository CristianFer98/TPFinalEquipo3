<jsp:include page="header.jsp"></jsp:include>



<style>
main {
	height: auto;
	
	justify-content: center;
	align-items: center
}

.card {
	background-color: beige;
	margin:10px;
}
</style>

<main>


	<div class="container">

		<h3 style="text-align: center;">${sessionScope.get("nombre")}: Bienvenido a la Pagina Administradora</h3>
		<div class="card">
			<div class="card-body">
				<h6>Para cargar un nuevo medico</h6>
				<a href="showFormNewMedic" class="btn btn-primary">Click Aqui</a>
			</div>
		</div>
		
		<div class="card">
			<div class="card-body">
				<h6>Para gestionar las ambulancias</h6>
				<a href="formGestionAmbulancia" class="btn btn-primary">Click Aqui</a>
			</div>
		</div>

	</div>
</main>

<jsp:include page="footer.jsp"></jsp:include>
