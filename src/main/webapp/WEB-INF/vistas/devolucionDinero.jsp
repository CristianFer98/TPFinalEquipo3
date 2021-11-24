<jsp:include page="header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
	.main{
		min-height: 80vh;
		display: flex;
		align-items: center;
		justify-content: center;
	}
</style>


<div class="main">
	
   <div class="card">
     <div class="card-body">
        <h5 class="card-title">Cancelacion turno - Numero: ${turno.getId()}</h5>
    	<p class="card-text">Paciente: ${turno.getClienteAsignado().getNombre()}</p>
    	<p class="card-text">Medico: ${turno.getMedicoAsignado().getNombre()}</p>
    	<p class="card-text">Precio: ${turno.getValorFinal()}</p>
    	<a href="devolucionDinero?idTurno=${turno.getId()}" class="btn btn-danger">SOLICITAR REMBOLSO</a>
  	</div>
	</div>
	
	<div> ${p}</div>
	
</div>


<jsp:include page="footer.jsp"></jsp:include>