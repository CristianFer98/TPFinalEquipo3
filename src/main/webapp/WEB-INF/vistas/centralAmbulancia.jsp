

<style>
	*{
		margin:0;
		padding:0;
	}
	
	body{
		min-height:100vh;
		display: flex;
    	justify-content: center;
    	align-items: center
	}
	
	.info-amb{    
		background: lightgrey;
    	padding: 25px;
    	display: flex;
    	flex-direction: column;
    	justify-content: center;
    	align-items: center;
    }
    
    .info-content{
    	display:flex;
    }
    
    button{
    	border: none;
   		 background: lightblue;
    	padding: 15PX;
    	margin: 5px;
    	border-radius: 35px;
    	margin-top: 20px;
    }


</style>



<body>
     
     <div class="info-amb">
     	<span class="info-content">LA CANTIDAD DE AMBULANCIAS EN EL HOSPITAL ES DE:  <span>${cantidad}</span> </span> 
     	
     	<form action="solicitudPagina" modelAttribute="datosSolicitudAmbulancia">
     	
     		<div>
     		Su direccion:<input type="text" path="direccion" name="direccion" required>	
     		</div>
     	   	
     	   <button Type="Submit"/> ${key} </button>
        </form>
	
     </div>
</body>


