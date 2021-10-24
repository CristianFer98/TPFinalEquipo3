<jsp:include page="header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<main>

	${sessionScope.get("nombre")}: Seleccione la especialidad deseada



	<c:if test="${not empty lista}">

		<ul>
			<c:forEach var="lista" items="${lista}">
				<form action="listarMedicosPorEspecialidad" method="get">
				
				<div class="card bg-light text-dark">
					<button type="submit" class="btn btn-secondary btn-lg btn-block" value="${lista.idEspecialidad}" 
					name="valor">${lista.especialidad}</button>
				</div>
				</form>
			</c:forEach>
		</ul>

	</c:if>




</main>

<jsp:include page="footer.jsp"></jsp:include>
