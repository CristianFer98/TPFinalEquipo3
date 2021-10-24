<jsp:include page="header.jsp"></jsp:include>


<table width="100%" border="1" bordercolor="#0000FF" cellspacing="10" cellpadding="10">

<h2>Perfil Medico</h2>

<tr>
    <th>Foto</th>
    <th><img style='margin:center; width:200px;height:200px;' id='base64image'                 
						 src='data:image/jpeg;base64, ${foto}' />						  
</tr>

<tr> <!-- Esto es una fila con los nombre de las columnas -->
	<th>Nombre</th>
    <th>${usuario.nombre}</th>
</tr>

<tr>
    <th>Especialidad</th>
    <th>${usuario.especialidad.especialidad}</th>
</tr>

<tr>
    <th>Pagina Personal</th>
    <th>${usuario.paginaPersonal}</th>
</tr>

<tr>
    <th>Contacto</th>
    <th>${usuario.telefono}</th>
</tr>

<tr>
    <th>Edad</th>
    <th>${usuario.edad}</th>
</tr>

</table>



<jsp:include page="footer.jsp"></jsp:include>