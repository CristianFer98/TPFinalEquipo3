<jsp:include page="header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<main>

	<h2 style="text-align: center">${sessionScope.get("nombre")}:
		Seleccione su medico preferido</h2>


	<c:if test="${not empty lista}">

		<c:forEach var="lista" items="${lista}">
			
			<div style="display:flex; justify-content:center; margin:15px">
			<div class="card w-75" >
				<div class="card-body">
					<h5 class="card-title">${lista.nombre}</h5>
					<p class="card-text">Telefono: ${lista.telefono} - Pagina web: ${lista.paginaPersonal}</p>
					<a href="mostrarTurnos?idUsuario=${lista.idUsuario}" class="btn btn-primary">Ver turnos disponibles</a>
				</div>
			</div>
			</div>
		</c:forEach>


	</c:if>

</main>

<jsp:include page="footer.jsp"></jsp:include>
