<jsp:include page="header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<div style="display: flex; flex-wrap: wrap">
	<div class="card-group" style="width: 30%; margin: 15px">



		<div class="card" style="box-shadow: 0px 8px 20px -7px rgba(0,0,0,0.75);">
			<img src="img/basic.jpg" style="height: 250px" >
			<div class="card-body" >
				<h5 class="card-title">Plan Basic</h5>
				<h6 class="card-subtitle mb-2 text-muted">$1000</h6>
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



		<div class="card" style="box-shadow: 0px 8px 20px -7px rgba(0,0,0,0.75);">
			<img src="img/silver.jpg" style="height: 250px">
			<div class="card-body">
				<h5 class="card-title">Plan Silver</h5>
				<h6 class="card-subtitle mb-2 text-muted">$1700</h6>
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



		<div class="card" style="box-shadow: 0px 8px 20px -7px rgba(0,0,0,0.75);">
			<img src="img/golden.jpg" style="height: 250px">
			<div class="card-body">
				<h5 class="card-title">Plan Gold</h5>
				<h6 class="card-subtitle mb-2 text-muted">$2500</h6>
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

