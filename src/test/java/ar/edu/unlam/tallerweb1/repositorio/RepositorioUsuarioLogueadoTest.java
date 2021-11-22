package ar.edu.unlam.tallerweb1.repositorio;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.TurnoMedico;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.persistencia.SpringTest;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegistroLogin;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuarioLogueado;

public class RepositorioUsuarioLogueadoTest extends SpringTest{
	@Inject
	RepositorioUsuarioLogueado repositorio;
	@Inject
	RepositorioRegistroLogin repositorioRegistroLogin;

	

//	@Test
//	@Transactional
//	@Rollback
//	public void queGuardeTurno() {
//		TurnoMedico turno= new TurnoMedico();
//		
//		Usuario user = new Usuario("123456789","test@gmail.com",1);
//		repositorioRegistroLogin.registrarUsuario(user);
//		
//		repositorio.reservarTurno(turno, user.getIdUsuario());
//		
//		TurnoMedico turno2  = repositorio.obtenerTurno(1);
//		
//		assertEquals(turno.getId(), turno2.getId());
//	}

}
