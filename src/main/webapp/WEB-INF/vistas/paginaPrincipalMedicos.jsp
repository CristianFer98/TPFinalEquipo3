<jsp:include page="header.jsp"></jsp:include>


        <div class="container">

        <h3 style="
         text-align: center;
        ">${sessionScope.get("nombre")}: Bienvenido a la Pagina De Medicos con ID: ${sessionScope.get("idUsuario")}</h3> 
 		
 		<div class="card">
 		<div class="card-body">
 			<h6>Para ver su perfil </h6>
 		    <a href="MyPerfil" class="btn btn-primary">Ir a mi perfil</a> 
 		</div>	
 		</div>
 		
 		
 		<div class="card">
 		<div class="card-body">
 			<h6>Para editar su perfil </h6>
 		    <a href="EditarPerfil" class="btn btn-primary" >Click Aqui</a>
 		</div>	
 		</div>


		<div class="card">
 		<div class="card-body">
 			<h6>Para cargar su agenda semanal  </h6>
 		    <a href="FormAgenda" class="btn btn-primary" >Click Aqui</a>
 		</div>	
 		</div>

 		
 		
 
 		
        </div>

<jsp:include page="footer.jsp"></jsp:include>
