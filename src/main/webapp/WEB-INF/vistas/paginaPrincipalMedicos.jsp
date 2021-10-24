<jsp:include page="header.jsp"></jsp:include>


        <main>

        ${sessionScope.get("nombre")}: Bienvenido a la Pagina De Medicos con ID: ${sessionScope.get("idUsuario")}
 		
 		Para ver su perfil <a href="MyPerfil">Ira mi perfil</a> <br>
 		Para editar su perfil  <a href="EditarPerfil">Click Aqui</a> <br>
 		Para cargar su agenda semanal <a href="FormAgenda">Click Aqui</a>
 		
 
 		
        </main>

<jsp:include page="footer.jsp"></jsp:include>
