package ar.edu.unlam.tallerweb1.repositorio;


import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
//
//
import ar.edu.unlam.tallerweb1.modelo.DatosDeActualizacionPerfilMedico;
import ar.edu.unlam.tallerweb1.persistencia.SpringTest;
//import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegistroLogin;
//import ar.edu.unlam.tallerweb1.repositorios.RepositorioSesionMedico;

public class RepositorioMedicoSessionTest extends SpringTest {

	DatosDeActualizacionPerfilMedico datos = new DatosDeActualizacionPerfilMedico();
	
//	@Autowired
//	private RepositorioSesionMedico repositorio;
//	
//	@Autowired
//	private RepositorioRegistroLogin repositorioReg;
	
	
	@Test
	@Transactional
	@Rollback
	public void testQueMePermiteCargarDatos() {
		
		
//		Integer id = 1;
//		datos.setId(id);
//		datos.setPaginaPersonal("hola.com");
//		datos.setTelefono("46515676");
//		
//		Usuario usuario = new Usuario();
//		usuario.setIdUsuario(id);
//		usuario.setEmail("jjj@gmail.com");
//		usuario.setContrasenia("123456789");
//		repositorioReg.registrarUsuario(usuario);
//		
//		Usuario nuevaCarga =repositorio.cargarDatos(datos, id);
//		
//		assertThat(nuevaCarga.getPaginaPersonal()).isEqualTo(datos.getPaginaPersonal());
		
		
	}
	
	

	

}