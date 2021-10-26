package ar.edu.unlam.tallerweb1;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.controladores.ControladorMedico;
import ar.edu.unlam.tallerweb1.modelo.DatosDeActualizacionPerfilMedico;
import ar.edu.unlam.tallerweb1.modelo.DatosDeInicioDeSesion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.persistencia.SpringTest;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioSesionMedico;
import ar.edu.unlam.tallerweb1.servicios.ServicioSesionMedico;

public class TestSinMock extends SpringTest {

	DatosDeInicioDeSesion datos = new DatosDeInicioDeSesion();
	
	@Autowired
	private RepositorioSesionMedico repositorio;
	
	
	private ControladorLogin controlador;
	
	@Autowired
	private ServicioSesionMedico servicio;
	
	@Test
	public void testQueMePermiteCargarDatos() {
		
//		Integer id = 2;
//		datos.setId(id);
//		//datos.setEspecialidad(1);
//		datos.setPaginaPersonal("hola.com");
//		datos.setTelefono("46515676");
//		
//		Usuario cargo =repositorio.cargarDatos(datos, id);
//		
//		assertThat(cargo.getPaginaPersonal()).isEqualTo(datos.getPaginaPersonal());
//		
//		
		
	}
	
	@Test 
	public void test() throws IOException {
		
		//datos.setEspecialidad(1);
		datos.setContrasenia("123456789");
		datos.setEmail("admin@gmail.com");
		
		
		HttpServletRequest req = null;
		controlador.iniciarSesion(datos, req);
	}

}