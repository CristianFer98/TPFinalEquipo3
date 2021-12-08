<jsp:include page="headerAdmin.jsp"></jsp:include>

<style>
main {
	min-height: 90vh;
	display: flex;
	align-items: center;
	flex-direction: column;
}

</style>



<main>




	<div style="background-color:#FCFAF9; box-shadow: 0px 8px 20px -7px rgba(0,0,0,0.75); width:700px; height:400px; padding:5px">


		<form action="Registrarse" method="POST" style="display: flex; flex-direction: column; " modelAttribute="DatosRegistroUsuario">

			<div style="display: flex; flex-direction: column; width:700px; height:400px">
				<h4 style="text-align:center; font-weight:bold">Ingrese los datos para registrar a un Medico</h4>

				<input type="text" path="email" name="email" id="contrasenia2" placeholder="Ingrese el Email" required
				style="border: 1px solid rgba(0,0,0,0.2); height:35px; border-radius: 10px; margin-left:20px; margin-right:20px; margin-top:10px;"  >
				<input type="text" path="nombre" name="nombre" id="nombre" placeholder="Ingrese su Nombre" required
				style="border: 1px solid rgba(0,0,0,0.2); height:35px; border-radius: 10px; margin-left:20px; margin-right:20px; margin-top:10px;"> 
				<input type="date" path="edad" name="edad" id="edad" placeholder="Ingrese su Edad" required
				style="border: 1px solid rgba(0,0,0,0.2); height:35px; border-radius: 10px; margin-left:20px; margin-right:20px; margin-top:10px;"> 
				<input type="password" path="contrasenia1" name="contrasenia1" id="contrasenia2" placeholder="Ingrese Clave" required
				style="border: 1px solid rgba(0,0,0,0.2); height:35px; border-radius: 10px; margin-left:20px; margin-right:20px; margin-top:10px;"> 
				<input type="password" path="contrasenia2" name="contrasenia2" id="contrasenia2" placeholder="Repita su Clave" required
				style="border: 1px solid rgba(0,0,0,0.2); height:35px; border-radius: 10px; margin-left:20px; margin-right:20px; margin-top:10px;"> 
				
				<select path="sexo" name="sexo" style="border: 1px solid rgba(0,0,0,0.2); height:35px; border-radius: 10px; margin-left:20px;margin-right:20px; margin-top:10px;">
					<option value="M">MASCULINO</option>
					<option value="F" selected>FEMENINO</option>
				</select> 
				
				<button type="submit" class="btn btn-primary" style="width:200px; align-self:center; margin-top:5px"  >Registrar</button>
				<input type="hidden" path="numeroDeTipoDeUsuario" name="numeroDeTipoDeUsuario" value="2">
			</div>

			<div>
				<h4 style="color: red">${error}</h4>
				<h4 style="color: green">${mensaje}</h4>
			</div>


		</form>
	</div>
</main>

<jsp:include page="footer.jsp"></jsp:include>