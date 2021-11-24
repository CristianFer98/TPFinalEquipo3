
<jsp:include page="header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<main>
	<div
		style="display: flex; justify-content: center; height: 400px; align-items: center">
		<div
			style="height: auto; width: 80%; display: flex; flex-direction: column; justify-content: center; background-color: beige; border-radius: 15px">
			<h2 style="text-align: center">${sessionScope.get("nombre")} 
				Cancelaste correctamente la ambulancia de patente: ${patente}</h2>


			<div style="display: flex; justify-content: center">
				<a href="paginaPrincipal"><button type="button"
						class="btn btn-primary" style="width: 100%; align-self: center">Volver
						a la pagina principal</button></a>
			</div>
			
			
		</div>
	</div>
</main>

<jsp:include page="footer.jsp"></jsp:include>
