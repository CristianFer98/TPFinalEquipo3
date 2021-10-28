
 <jsp:include page="header.jsp"></jsp:include>
 
 
<style>
main{
	min-height: 90vh;
	display: flex;
	align-items: center;
    justify-content: center;
}

.svg{
	width: 60%;
	display: flex;
	align-items: center;
    justify-content: center;
}

.svg img{
	width: 80%;
}


.inicioSesion{
	width: 40%;
    height: 400px;
    display: flex;
    justify-content: center;
    align-items: center;
	

}

.registro{
  

}

.formulario{
    display: flex;
    flex-direction: column;
    align-items: center;
    align-content: center;
	background: lightgrey;
	    padding: 20px;
    border-radius: 2px;
}


.inicioSesion_inputs{
    margin-bottom: 10px;
    border-style: none;
    padding: 5px 10px;
    background: lightgray;
    border-bottom: solid grey;
}

.inicioSesion_inputs:focus{
	border-bottom: solid #6C63FF;
}


.boton_unputs{
    background: #6C63FF;
    color: white;
    padding: 5px 20px;
    margin-top: 25px;
    border-radius: 25px;
    border-style: none;
}


.seccionEspecialidades{

}
	
</style>

<body>


        <main>
        	<div class="svg">
        		<img alt="" src="css/medicina.svg">
        	</div>
        
            <div class="inicioSesion">             
                    <form action="loguearse" method="POST" class="formulario"  modelAttribute="datosDeInicioSesion">
                        <input type="text" path="email" name="email" id="email" placeholder="Ingrese Usuario" class="inicioSesion_inputs" required>
                        <input type="password" path ="contrasenia" name="contrasenia" id="contrasenia" placeholder="Ingrese Clave" class="inicioSesion_inputs" required>

                        <input type="submit"  class="boton_unputs" value="Iniciar Sesion" >
                        <a href="registro" style="color: black; text-decoration: none;">Registrarse</a>
                        ${error}
                    </form>
            </div>
        </main>
        
        
        

 <jsp:include page="footer.jsp"></jsp:include>