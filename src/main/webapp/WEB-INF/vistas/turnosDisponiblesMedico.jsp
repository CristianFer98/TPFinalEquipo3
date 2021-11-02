<jsp:include page="header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<main>

	<h2 style="text-align:center">${sessionScope.get("nombre")}: Acontinuacion eliga los turnos disponibles para ESTE DOCTOR</h2>

	<c:if test="${not empty lista}">

		<ul>
			<c:forEach var="lista" items="${lista}">
				<form action="reservarTurno" method="post">

					<div class="card bg-light text-dark">
						<input type="hidden" name="idTurno" value="${lista.id}">
							
						<button type="submit" class="btn btn-secondary btn-lg btn-block"
							value="${sessionScope.get('idUsuario')}" name="idUsuario">${lista.fecha}</button>
					</div>

				</form>
			</c:forEach>
		</ul>

	</c:if>

</main>

<jsp:include page="footer.jsp"></jsp:include>
