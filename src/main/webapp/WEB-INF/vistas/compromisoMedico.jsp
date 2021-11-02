<jsp:include page="header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<main>

	<h2 style="text-align:center">${sessionScope.get("nombre")}: Estos son los proximos turnos a los que tiene que asistir</h2>


	<c:if test="${not empty lista}">

		<ul>
			<c:forEach var="lista" items="${lista}">
				
				<div class="card bg-light text-dark">
					<button type="button" class="btn btn-secondary btn-lg btn-block" 
					name="idUsuario">${lista.fecha}</button>
				</div>
				
			</c:forEach>
		</ul>

	</c:if>

</main>

<jsp:include page="footer.jsp"></jsp:include>