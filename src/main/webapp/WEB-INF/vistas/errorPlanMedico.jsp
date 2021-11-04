<jsp:include page="header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<main>
<div style="height:200px; wodth:100%; display:flex; justify-content:center; background-color:beige">
<h1 style="text-align:center">${sessionScope.get("nombre")}: Usted ya cuenta con un descuento asignado actualmente</h1>
</div> 
</main>

<jsp:include page="footer.jsp"></jsp:include>