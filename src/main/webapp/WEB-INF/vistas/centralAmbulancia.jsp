

<style>
	*{
		margin:0;
		padding:0;
	}
	
	.conteiner{
		min-height: 90vh;
		display: flex;
		justify-content: center;
		align-items: center;
	}

	
	.info-amb{    
		background: lightgrey;
    	padding: 25px;
    	display: flex;
    	flex-direction: column;
    	justify-content: center;
    	align-items: center;
    }
    
    
	.info-amb form {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    margin-top: 10px;
	}
	
	.info-amb form div{
		margin-bottom: 10px;
	}
    
    .info-content{
    	display:flex;
    }

</style>



<body>
     <jsp:include page="header.jsp"></jsp:include>
     
     
     
     <div class="conteiner">
       <div class="info-amb">
     	<span class="info-content">LA CANTIDAD DE AMBULANCIAS EN EL HOSPITAL ES DE:  <span>${cantidad}</span> </span> 
     	
     	<form action="solicitudPagina" modelAttribute="datosSolicitudAmbulancia">
     	
     		<div>
     		Su direccion:<input type="text" path="direccion" name="direccion" required>	
     		</div>
     	   	
     	   <button Type="Submit" class="btn btn-danger"/> ${key} </button>
        </form>
	
     </div>
     
     </div>
   
</body>


