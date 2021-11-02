<jsp:include page="header.jsp"></jsp:include>

<style>
			main{
				height:500px;
				justify-content: center;
    			align-items: center
			}
			
			.card{
				background-color:beige;
			}
			
</style>



        <div class="container">

        <h3 style="
         text-align: center;
        ">${sessionScope.get("nombre")}: Bienvenido a la Pagina De Medicos</h3> 
 		
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
 			<h6>Para cargar su agenda Mensual  </h6>
 		    <a href="FormAgenda" class="btn btn-primary" >Click Aqui</a>
 		</div>	
 		</div>

 		<div class="card">
 		<div class="card-body">
 			<h6>Ver sus compromisos </h6>
 		    <a href="verTurnos" class="btn btn-primary" >Click Aqui</a>
 		</div>	
 		</div>
 		
 
 		
        </div>

        
       


<jsp:include page="footer.jsp"></jsp:include>
