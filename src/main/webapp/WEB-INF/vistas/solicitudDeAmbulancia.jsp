<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="ISO-8859-1">
        <link rel="stylesheet" href="../../css/estilosSolicitud.css">
        <title>SOLICITUD</title>
    </head>
    
    <style>
	*{
		margin:0;
		padding:0;
	}
	body{
		min-height:100vh;
    	display: flex;
    	flex-direction: column;
    	justify-content: center;
    align-items: center;
	}
	
	.solicitud-container{
		    padding: 10px;
    	background-color: lightgray;
    	display: flex;
    	align-items: center;
    	justify-content: center;
    	flex-direction: column;
	}
	 
	.soli-info{
		padding: 10px 50px;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    font-size: 18px;
	}
	.btn-canelar{
		border: none;
   		background: tomato;
    	padding: 15PX;
    	margin: 5px;
    	border-radius: 35px;
    	margin-top: 20px;
	}
	
	span{
		margin-top: 20px;
	}
	
	span:nth-child(2){
	}
	
	#patente{
	    background-color: #808080a1;
    padding: 10px;
    text-transform: uppercase;
    font-weight: 900;
	}
	
	
	</style>
    
    

    <body>

        <div class="solicitud-container">
        	<div class="soli-info">
        		<span>Tu ambulancia llegara lo mas pronto posible</span>
            	<span>LA PATENTE DE SU AMBULANCIA ES= <span id="patente"> ${amb.getPatenteAmbulancia()} </span></span>
            	<span>Asegurate que sea la ambulancia correcta para evitar incidentes</span>
        	</div>
        	<div class="soli-btns">
        		<button class="btn-canelar">CANCELAR</button>
        	</div>
            
        </div>

    </body>

    </html>