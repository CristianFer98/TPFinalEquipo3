<jsp:include page="header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<main>

	<h2 style="text-align:center">${sessionScope.get("nombre")}: Seleccione la especialidad deseada</h2>



	<c:if test="${not empty lista}">

		<ul>
			<c:forEach var="lista" items="${lista}">
				<form action="listarMedicosPorEspecialidad" method="get">
				
				<div style="display:flex; justify-content:center">
				<div class="card bg-light text-dark" style="width:80%; heigth:50px">
					<button type="submit" class="btn btn-secondary btn-lg btn-block" style="heigth:100px"value="${lista.idEspecialidad}" 
					name="valor">${lista.especialidad}</button>
				</div>
				</div>
				</form>
			</c:forEach>
		</ul>

	</c:if>




</main>

<jsp:include page="footer.jsp"></jsp:include>
