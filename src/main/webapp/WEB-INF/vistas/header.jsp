<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="css/estilo.css">
	<link rel="stylesheet" href="css/cardsPerfil.css">	
    
    <script src="https://kit.fontawesome.com/f44bbf66b4.js" crossorigin="anonymous"></script>

    <title>Document</title>
</head>

<style>
@import url('https://fonts.googleapis.com/css2?family=Poppins&display=swap');

*{
	padding:0;
	margin:0;
	font-family: 'Poppins', sans-serif;
}


body{
background-color:#C2E4EB;
height:auto;
}

.header_nombre h2{
	font-weight: 600;
	margin: 0;
}

#barra-resposive{
	display: none;
}

@media (max-width:670px){
    .header_titulo{
        font-size: 15px;
    }
	
	.header_nombre h2{
		display:none;
	}
	
	#barra-resposive{
		display:block;
		    font-size: 35px
	}
	
	nav{
		display: none;
	}
	
</style>


<body>
        <header>
            <div class="header_titulo">
            <img src="css/hospital.png" alt="logoHospital" id="logo"> 
            </div>  
            
            <div class="header_nombre">
            	<h2>Hospital Florencia Martin </h2>
            	<i class="fas fa-bars" id="barra-resposive"></i>
            </div>                 
        </header>

        <nav>
            <a href="" class="linkNav">Principal</a>
            <a href="" class="linkNav">Acerca del Hospital</a>
            <a href="" class="linkNav">Areas</a>
            <a href="" class="linkNav">Contacto</a>
        </nav>
