<jsp:include page="header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<main>

	<h2 style="text-align: center">${sessionScope.get("nombre")}:
		Seleccione la especialidad deseada</h2>



	<c:if test="${not empty lista}">


		<div style="display: flex; flex-wrap:wrap">

			<c:forEach var="lista" items="${lista}">
				
				<div class="card-group" style="width:30%; margin:15px">
				
					<div class="card">
						<img src="img/${lista.fotoEspecialidad}.jpg" style="height:250px" alt="${lista.fotoEspecialidad}">
						<div class="card-body">
							<h5 class="card-title">${lista.especialidad}</h5>
							<p class="card-text">Tenemos los mejores especialistas en el area de ${lista.especialidad}</p>
							<a href="listarMedicosPorEspecialidad?valor=${lista.idEspecialidad}" ><button type="button" class="btn btn-secondary">Entrar</button></a>

						</div>
					</div>
				
				</div>
				
			</c:forEach>
		</div>



	</c:if>




</main>

<jsp:include page="footer.jsp"></jsp:include>
