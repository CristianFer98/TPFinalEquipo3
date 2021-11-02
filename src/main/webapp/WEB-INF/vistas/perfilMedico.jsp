<jsp:include page="header.jsp"></jsp:include>
<style>
</style>
<main>

	<table width="100%" border="1" bordercolor="#0000FF"
		style="background-color: beige" cellspacing="20" cellpadding="20">

		<h2>Perfil Medico</h2>


		<tr>
			<!-- Esto es una fila con los nombre de las columnas -->
			<th>Nombre</th>
			<th>${usuario.nombre}</th>
		</tr>

		<tr style="padding-top: 25px">
			<th>Especialidad</th>
			<th>${usuario.especialidad.especialidad}</th>
		</tr>

		<tr>
			<th>Pagina Personal</th>
			<th>${usuario.paginaPersonal}</th>
		</tr>

		<tr>
			<th>Contacto</th>
			<th>${usuario.telefono}</th>
		</tr>

		<tr>
			<th>Edad</th>
			<th>${usuario.edad}</th>
		</tr>

	</table>

</main>


<jsp:include page="footer.jsp"></jsp:include>