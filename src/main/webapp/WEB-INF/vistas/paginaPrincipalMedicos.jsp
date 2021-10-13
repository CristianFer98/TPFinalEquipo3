<jsp:include page="header.jsp"></jsp:include>


        <main>

        ${sessionScope.get("nombre")}: Bienvenido a la Pagina De Medicos con ID: ${sessionScope.get("idUsuario")}
 		
 		Para editar su perfil  <a href="EditarPerfil">Click Aqui</a>
 
 		
        </main>

<jsp:include page="footer.jsp"></jsp:include>
