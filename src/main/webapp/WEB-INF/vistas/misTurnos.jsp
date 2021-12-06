<jsp:include page="header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
	*{
		padding: 0;
		
	}
	
	#form {
  width: 250px;
  margin: 0 auto;
  height: 50px;
}

#form p {
  text-align: center;
}

#form label {
  font-size: 20px;
}

input[type="radio"] {
  display: none;
}

label {
  color: grey;
}

.clasificacion{
      direction: rtl;/* right to left */
      unicode-bidi: bidi-override;/* bidi de bidireccional */
  }

label:hover,
label:hover ~ label {
  color: orange;
}

input[type="radio"]:checked ~ label {
  color: orange;
  
}
</style>

<main>

	<h2 style="text-align: center">${sessionScope.get("nombre")}:
		Estas son las visitas medicas que tiene programadas</h2>
		
	<c:if test="${turnoCancel != null}">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

		
    			<div class="msj">
    
    			</div>
  		
	</c:if>	

	<c:if test="${not empty lista}">

		<ul>
			<c:forEach var="lista" items="${lista}">
			 
			<c:if test="${lista.calificacion == null}">
	

				<div style="display: flex; width: 100%; justify-content: center">
					<div class="card card-margin"
						style="width: 60%; height: auto; margin: 20px">

						<div class="card-body">
							<div class="widget-49">
								<div class="widget-49-title-wrapper">
									<div class="widget-49-date-primary">
										<span class="widget-49-date-month">${lista.fecha.monthValue}/${lista.fecha.dayOfMonth}</span>
									</div>
									<div class="widget-49-meeting-info">
										<span class="widget-49-pro-title">Nombre:
											${lista.clienteAsignado.nombre}</span> <span
											class="widget-49-meeting-time">Horario:
											${lista.fecha.hour}:${lista.fecha.minute}</span>
									</div>
								</div>
								<ol class="widget-49-meeting-points">
									<li class="widget-49-meeting-item"><span>Especialidad:
											${lista.medicoAsignado.especialidad.especialidad}</span></li>
									<li class="widget-49-meeting-item"><span>Medico:
											${lista.medicoAsignado.nombre}</span></li>
									<li class="widget-49-meeting-item"><span>Contacto:
											${lista.medicoAsignado.email}</span></li>
									<li class="widget-49-meeting-item"><span>Duracion:
											${lista.tiempoDeLaConsulta}</span></li>
									<li class="widget-49-meeting-item"><span>Precio:
											$${lista.valorFinal}</span></li>
									<li class="widget-49-meeting-item">
									
									<c:if test="${lista.pagado == null}">
	        							 <span  style="display: flex"> Estado:  <div style="background-color: yellow;"> Pendiente De Pago</div> </span>
	        						</c:if>
	        						<c:if test="${lista.pagado != null}">
	        							 <span style="display: flex"> Estado:  <div style="background-color: green; color: white" > PAGADO</div> </span>
	        						 </c:if>
									
									</li>			
								</ol>
								
								<c:if test="${lista.pagado != true}">
								<div class="widget-49-meeting-action">
									<a href="cancelarTurno?idTurno=${lista.id}" class="btn btn-danger">Cancelar
										Turno</a>
								</div>
								</c:if>
								
								
								
								<c:if test="${lista.turnoDadoDeAlta == true}">
									
                    					<form action="calificar" method="POST" modelAttribute="Calificacion">
									  <p class="clasificacion">
									    <input id="radio1" path="calificacion" type="radio" name="calificacion" value="5"><!--
									    --><label for="radio1">
									    <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-star" viewBox="0 0 16 16">
										  <path d="M2.866 14.85c-.078.444.36.791.746.593l4.39-2.256 4.389 2.256c.386.198.824-.149.746-.592l-.83-4.73 3.522-3.356c.33-.314.16-.888-.282-.95l-4.898-.696L8.465.792a.513.513 0 0 0-.927 0L5.354 5.12l-4.898.696c-.441.062-.612.636-.283.95l3.523 3.356-.83 4.73zm4.905-2.767-3.686 1.894.694-3.957a.565.565 0 0 0-.163-.505L1.71 6.745l4.052-.576a.525.525 0 0 0 .393-.288L8 2.223l1.847 3.658a.525.525 0 0 0 .393.288l4.052.575-2.906 2.77a.565.565 0 0 0-.163.506l.694 3.957-3.686-1.894a.503.503 0 0 0-.461 0z"/>
										</svg>
										
									    </label><!--
									    --><input id="radio2" path="calificacion" type="radio" name="calificacion" value="4"><!--
									    --><label for="radio2">
									     <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-star" viewBox="0 0 16 16">
										  <path d="M2.866 14.85c-.078.444.36.791.746.593l4.39-2.256 4.389 2.256c.386.198.824-.149.746-.592l-.83-4.73 3.522-3.356c.33-.314.16-.888-.282-.95l-4.898-.696L8.465.792a.513.513 0 0 0-.927 0L5.354 5.12l-4.898.696c-.441.062-.612.636-.283.95l3.523 3.356-.83 4.73zm4.905-2.767-3.686 1.894.694-3.957a.565.565 0 0 0-.163-.505L1.71 6.745l4.052-.576a.525.525 0 0 0 .393-.288L8 2.223l1.847 3.658a.525.525 0 0 0 .393.288l4.052.575-2.906 2.77a.565.565 0 0 0-.163.506l.694 3.957-3.686-1.894a.503.503 0 0 0-.461 0z"/>
										</svg>
									    </label><!--
									    --><input id="radio3" path="calificacion" type="radio" name="calificacion" value="3"><!--
									    --><label for="radio3">
									     <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-star" viewBox="0 0 16 16">
										  <path d="M2.866 14.85c-.078.444.36.791.746.593l4.39-2.256 4.389 2.256c.386.198.824-.149.746-.592l-.83-4.73 3.522-3.356c.33-.314.16-.888-.282-.95l-4.898-.696L8.465.792a.513.513 0 0 0-.927 0L5.354 5.12l-4.898.696c-.441.062-.612.636-.283.95l3.523 3.356-.83 4.73zm4.905-2.767-3.686 1.894.694-3.957a.565.565 0 0 0-.163-.505L1.71 6.745l4.052-.576a.525.525 0 0 0 .393-.288L8 2.223l1.847 3.658a.525.525 0 0 0 .393.288l4.052.575-2.906 2.77a.565.565 0 0 0-.163.506l.694 3.957-3.686-1.894a.503.503 0 0 0-.461 0z"/>
										</svg>
									    </label><!--
									    --><input id="radio4" path="calificacion" type="radio" name="calificacion" value="2"><!--
									    --><label for="radio4">
									     <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-star" viewBox="0 0 16 16">
										  <path d="M2.866 14.85c-.078.444.36.791.746.593l4.39-2.256 4.389 2.256c.386.198.824-.149.746-.592l-.83-4.73 3.522-3.356c.33-.314.16-.888-.282-.95l-4.898-.696L8.465.792a.513.513 0 0 0-.927 0L5.354 5.12l-4.898.696c-.441.062-.612.636-.283.95l3.523 3.356-.83 4.73zm4.905-2.767-3.686 1.894.694-3.957a.565.565 0 0 0-.163-.505L1.71 6.745l4.052-.576a.525.525 0 0 0 .393-.288L8 2.223l1.847 3.658a.525.525 0 0 0 .393.288l4.052.575-2.906 2.77a.565.565 0 0 0-.163.506l.694 3.957-3.686-1.894a.503.503 0 0 0-.461 0z"/>
										</svg>
									    </label><!--
									    --><input id="radio5" path="calificacion" type="radio" name="calificacion" value="1"><!--
									    --><label for="radio5">
									     <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-star" viewBox="0 0 16 16">
										  <path d="M2.866 14.85c-.078.444.36.791.746.593l4.39-2.256 4.389 2.256c.386.198.824-.149.746-.592l-.83-4.73 3.522-3.356c.33-.314.16-.888-.282-.95l-4.898-.696L8.465.792a.513.513 0 0 0-.927 0L5.354 5.12l-4.898.696c-.441.062-.612.636-.283.95l3.523 3.356-.83 4.73zm4.905-2.767-3.686 1.894.694-3.957a.565.565 0 0 0-.163-.505L1.71 6.745l4.052-.576a.525.525 0 0 0 .393-.288L8 2.223l1.847 3.658a.525.525 0 0 0 .393.288l4.052.575-2.906 2.77a.565.565 0 0 0-.163.506l.694 3.957-3.686-1.894a.503.503 0 0 0-.461 0z"/>
										</svg>
									    </label>
									  </p>
									<input id="idTurno" path="idTurno" name="idTurno" type="hidden" value="${lista.id}">
									<button type="submit" class="btn btn-primary">Calificar</button>
									
									</form>
									</c:if>
												
								</div>
								
								
							</div>
							
						</div>
					</div>
			
									</c:if>

			</c:forEach>
		</ul>

	</c:if>

</main>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<jsp:include page="footer.jsp"></jsp:include>