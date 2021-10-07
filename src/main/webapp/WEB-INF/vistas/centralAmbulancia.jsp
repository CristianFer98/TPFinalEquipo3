<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../../css/estilosSolicitud.css">
<title>Central Ambulancia</title>
</head>

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
     	
     	<form action="solicitudPagina">   	
     	   <button Type="Submit"/> ${key} </button>
        </form>
	
     </div>
     
     
     
     
     
     
     

</body>
</html>