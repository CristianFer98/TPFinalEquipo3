

<style>
	*{
		margin:0;
		padding:0;
	}
	
	.conteiner{

		border-radius:10px;
		min-height: 80vh;
		display: flex;
		justify-content: center;
		align-items: center;
	}

	
	.info-amb{    
		heigth:400px;
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
	<div><jsp:include page="header.jsp"></jsp:include></div> 
     
     
     <div class="conteiner">
       <div class="info-amb" style="border-radius:15px">
     	
     	
     	<form action="solicitudPagina" modelAttribute="datosSolicitudAmbulancia">
     	
     		<div>
     		Su direccion:<input type="text" path="direccion" name="direccion" required>	
     		</div>
     	   	
     	   <button Type="Submit" class="btn btn-danger"/> SOLICITAR </button>
        </form>
		${msj}
     </div>
     
     </div>

   
        <jsp:include page="footer.jsp"></jsp:include>
   
</body>


