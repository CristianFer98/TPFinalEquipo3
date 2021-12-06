//package ar.edu.unlam.tallerweb1.repositorio;
//
//import static org.assertj.core.api.Assertions.*;
//
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import ar.edu.unlam.tallerweb1.modelo.DatosDeActualizacionPerfilMedico;
//import ar.edu.unlam.tallerweb1.modelo.Usuario;
//import ar.edu.unlam.tallerweb1.persistencia.SpringTest;
//import ar.edu.unlam.tallerweb1.repositorios.RepositorioSesionMedico;
//
//public class RepositorioMedicoSessionTest extends SpringTest {
//
//	DatosDeActualizacionPerfilMedico datos = new DatosDeActualizacionPerfilMedico();
//	
//	@Autowired
//	private RepositorioSesionMedico repositorio;
//	
//	
//	@Test
//	public void testQueMePermiteCargarDatos() {
//		
//		Integer id = 1;
//		datos.setId(id);
//		datos.setPaginaPersonal("hola.com");
//		datos.setTelefono("46515676");
//		
//		Usuario nuevaCarga =repositorio.cargarDatos(datos, id);//devuelve un usuario de la bd, lo comparo
//		
//		assertThat(nuevaCarga.getPaginaPersonal()).isEqualTo(datos.getPaginaPersonal());
//		
//		
//	}
//	
//	
//
//	
//
//}