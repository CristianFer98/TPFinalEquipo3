package ar.edu.unlam.tallerweb1.repositorio;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.persistencia.SpringTest;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPlanSalud;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegistroLogin;

public class RepositorioPlanSaludTest extends SpringTest {

	Usuario usuario = new Usuario();

	@Autowired
	private RepositorioPlanSalud repositorio;
	@Autowired
	private RepositorioRegistroLogin repositorioRegistro;

	@Test
	@Transactional
	@Rollback
	public void testQueMePermiteRecuperarLaEdadDeUnUsuario() {

		Integer id = 1;
		usuario.setEdad(LocalDate.now());
		usuario.setIdUsuario(id);
		usuario.setEmail("Cristofer@gmail.com");
		repositorioRegistro.registrarUsuario(usuario);

		LocalDate edad = repositorio.recuperarEdad(id);

		assertThat(edad).isNotNull();

	}

}
