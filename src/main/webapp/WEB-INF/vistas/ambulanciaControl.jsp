<jsp:include page="headerAdmin.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
main {
	min-height: 90vh;
	display: flex;
	align-items: center;
	flex-direction: column;
}

.titulo-admin {
	margin: 15px 0px;
}

.titulo-admin span {
	text-transform: capitalize;
}

.registro {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	width: 100%;
}



.ambulancias-control {
	margin-top: 30px;
}

.ambulancias-control form {
	margin-top: 10px;
}

.registro form input[type=submit] {
	margin-top: 15px;
	border-radius: 25px;
	padding: 5px 15px;
	border-style: none;
	text-decoration: none;
	background-color: #6C63FF;
	color: white;
}

.inicioSesion_inputs {
	margin-bottom: 10px;
	border-style: none;
	padding: 5px 10px;
	background: lightgray;
	border-bottom: solid grey;
}

.inicioSesion_inputs:focus {
	border-bottom: solid #6C63FF;
}

#foto-svg {
	width: 45%;
	padding: 15px;
}
</style>

<main>






	<div class="registro" style="box-shadow: 0px 8px 20px -7px rgba(0,0,0,0.75); width:650px" >
		<div>
			<h3 style="text-align:center; font-weight:bold">AMBULANCIAS CONTROL PANEL</h3>

			<div class="tabla-ambulancias">
				<div>${msj}</div>

				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th scope="col">id</th>
							<th scope="col">Patente Ambulancia</th>
							<th scope="col">Estado</th>
							<th scope="col">Handle</th>
							<th scope="col">Eliminar</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="ambulancia" items="${listaAmbulancia}">
							<tr>
								<th scope="row">${ambulancia.idAmbulancia}</th>
								<td>${ambulancia.patenteAmbulancia}</td>
								<td><c:if test="${ambulancia.disponible == true}">
        		DISPONIBLE
          </c:if> <c:if test="${ambulancia.disponible == false}">
        		NO DISPONIBLE
          </c:if></td>
								<td><c:if test="${ambulancia.disponible == true}">
										<a href="ocuparAmbulancia?patente=${ambulancia.patenteAmbulancia}" ><button type="button" class="btn btn-outline-danger">Ocupar</button></a>
									</c:if> <c:if test="${ambulancia.disponible == false}">
										<a href="registrarAmbulancia?patente=${ambulancia.patenteAmbulancia}"><button type="button" class="btn btn-success">Liberar</button></a>
									</c:if></td>
								<td>
								<a href="eliminarAmbulancia?patente=${ambulancia.patenteAmbulancia}"><button type="button" class="btn btn-danger">Eliminar</button></a>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<div>
					<form action="registrarAmbulancia">
						Patente de Ambulancia a AGREGAR: <input type="text" name="patente">
						<input type="submit" value="AGREGAR">
					</form>
				</div>

			</div>
			<form action="activarUsuario">
				Email: <input type="text" name="email"> <input type="submit"
					value="ATENDER CONSULTA DE ESTE USER">
			</form>
		</div>
	</div>


</main>

<jsp:include page="footer.jsp"></jsp:include>