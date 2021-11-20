<jsp:include page="header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<<<<<<< HEAD
<div style="display: flex; flex-wrap:wrap">
<div class="card-group" style="width: 30%; margin: 15px">

	<div class="card">
		<img src="img/basic.jpg" style="height: 250px">
		<div class="card-body">
			<h5 class="card-title">Plan Basic</h5>
			<p class="card-text">Solicita el plan Basico para obtener un 30% de descuento en tus visitas medicas.</p>
			<a href="pagarPlan?idPlan=1"><button type="button"class="btn btn-secondary">Pagar</button></a>

		</div>
	</div>

</div>

<div class="card-group" style="width: 30%; margin: 15px">

	<div class="card">
		<img src="img/silver.jpg" style="height: 250px">
		<div class="card-body">
			<h5 class="card-title">Plan Silver</h5>
			<p class="card-text">Solicita el plan Basico para obtener un 60% de descuento en tus visitas medicas</p>
			<a href="pagarPlan?idPlan=2"><button type="button"
					class="btn btn-secondary">Pagar</button></a>

		</div>
	</div>

</div>
<div class="card-group" style="width: 30%; margin: 15px">

	<div class="card">
		<img src="img/golden.jpg" style="height: 250px">
		<div class="card-body">
			<h5 class="card-title">Plan Gold</h5>
			<p class="card-text">Solicita el plan Basico para obtener un 100% de descuento en tus visitas medicas</p>
			<a href="pagar?idPlan=3"><button type="button"
					class="btn btn-secondary">Pagar</button></a>

		</div>
	</div>

</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
=======


<div style="display: flex; flex-wrap: wrap">
	<div class="card-group" style="width: 30%; margin: 15px">



		<div class="card">
			<img src="img/basic.jpg" style="height: 250px">
			<div class="card-body">
				<h5 class="card-title">Plan Basic</h5>
				<p class="card-text">Solicita el plan Basico para obtener un 30%
					de descuento en tus visitas medicas.</p>

				<c:choose>
					<c:when test="${usuario.plan.idPlanSalud == '1'}">
						<h4 style="color: green;">Asignado actualmente</h4>
					</c:when>
					<c:otherwise>
						<script
							src="https://www.mercadopago.com.ar/integrations/v1/web-payment-checkout.js"
							data-preference-id="${preferenciaBasico.id}">
							
						</script>
					</c:otherwise>
				</c:choose>



			</div>
		</div>



	</div>



	<div class="card-group" style="width: 30%; margin: 15px">



		<div class="card">
			<img src="img/silver.jpg" style="height: 250px">
			<div class="card-body">
				<h5 class="card-title">Plan Silver</h5>
				<p class="card-text">Solicita el plan Basico para obtener un 60%
					de descuento en tus visitas medicas</p>

				<c:choose>
					<c:when test="${usuario.plan.idPlanSalud == '2'}">
						<h4 style="color: green;">Asignado actualmente</h4>
					</c:when>
					<c:otherwise>
						<script
							src="https://www.mercadopago.com.ar/integrations/v1/web-payment-checkout.js"
							data-preference-id="${preferenciaSilver.id}">
							
						</script>
					</c:otherwise>
				</c:choose>



			</div>
		</div>



	</div>
	<div class="card-group" style="width: 30%; margin: 15px">



		<div class="card">
			<img src="img/golden.jpg" style="height: 250px">
			<div class="card-body">
				<h5 class="card-title">Plan Gold</h5>
				<p class="card-text">Solicita el plan Basico para obtener un
					100% de descuento en tus visitas medicas</p>


				<c:choose>
					<c:when test="${usuario.plan.idPlanSalud == '3'}">
						<h4 style="color: green;">Asignado actualmente</h4>
					</c:when>
					<c:otherwise>
						<script
							src="https://www.mercadopago.com.ar/integrations/v1/web-payment-checkout.js"
							data-preference-id="${preferenciaGold.id}">
							
						</script>
					</c:otherwise>
				</c:choose>



			</div>
		</div>



	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>

>>>>>>> ramaEsteban
