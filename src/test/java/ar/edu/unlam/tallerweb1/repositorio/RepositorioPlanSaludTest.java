package ar.edu.unlam.tallerweb1.repositorio;

<<<<<<< HEAD
import java.time.LocalDate;

import javax.transaction.Transactional;
=======
>>>>>>> ramaEsteban

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;
=======
>>>>>>> ramaEsteban

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.persistencia.SpringTest;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPlanSalud;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegistroLogin;

public class RepositorioPlanSaludTest extends SpringTest {

	Usuario usuario = new Usuario();

	@Autowired
<<<<<<< HEAD
	private RepositorioPlanSalud repositorio;
	@Autowired
	private RepositorioRegistroLogin repositorioRegistro;

	@Test
	@Transactional
	@Rollback
	public void testQueMePermiteRecuperarLaEdadDeUnUsuario() {
=======
    private RepositorioPlanSalud repositorio;
	
	
>>>>>>> ramaEsteban

		Integer id = 1;
		usuario.setEdad(LocalDate.now());
		usuario.setIdUsuario(id);
		usuario.setEmail("Cristofer@gmail.com");
		repositorioRegistro.registrarUsuario(usuario);

		LocalDate edad = repositorio.recuperarEdad(id);

		assertThat(edad).isNotNull();

	}

}
