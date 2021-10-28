<jsp:include page="header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<main>${sessionScope.get("nombre")}: Agenda del proximo mes
	cargada con exito</main>

<jsp:include page="footer.jsp"></jsp:include>