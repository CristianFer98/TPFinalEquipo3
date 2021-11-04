<jsp:include page="header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div style="display: flex; justify-content: center">
	<div
		style="background-color: beige; width: 50%; height: 300px; margin: center; margin: 15px; border-radius: 15px">
		<h2 style="text-align: center">${nombre}</h2>
		<p style="font-size: 25px; text-align: center">Hemos seleccionado
			la mejor opcion para vos, ahora mismo podemos otorgarte un ${valor}%
			de descuento para tus consultas en el Hospital Florencia Martin</p>
		<a href="suscribirseAPlan?descuento=${valor}"> <button type="button" class="btn btn-dark btn-lg btn-block" style="">Registrar plan medico</button></a>

	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
