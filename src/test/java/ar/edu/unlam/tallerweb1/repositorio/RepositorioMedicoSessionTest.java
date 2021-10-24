package ar.edu.unlam.tallerweb1.repositorio;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unlam.tallerweb1.modelo.DatosDeActualizacionPerfilMedico;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.persistencia.SpringTest;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegistroLogin;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioSesionMedico;

public class RepositorioMedicoSessionTest extends SpringTest {

	DatosDeActualizacionPerfilMedico datos = new DatosDeActualizacionPerfilMedico();
	
	@Autowired
	private RepositorioSesionMedico repositorio;
	
	
	@Test
	public void testQueMePermiteCargarDatos() {
		
		Integer id = 2;
		datos.setId(id);
		//datos.setEspecialidad(1);
		datos.setPaginaPersonal("hola.com");
		datos.setTelefono("46515676");
		
		Usuario cargo =repositorio.cargarDatos(datos, id);
		
		assertThat(cargo.getPaginaPersonal()).isEqualTo(datos.getPaginaPersonal());
		
		
		
	}

}
