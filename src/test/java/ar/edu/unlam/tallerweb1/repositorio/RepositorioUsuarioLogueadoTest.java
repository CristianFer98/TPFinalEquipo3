package ar.edu.unlam.tallerweb1.repositorio;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Especialidad;
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

	

	@Test
	@Transactional
	@Rollback
	public void testQueMePermitaConfirmarUnTurno() {
		TurnoMedico turno= new TurnoMedico();
		Usuario user = new Usuario("123456789","test@gmail.com",1);
		turno.setId(1);
		//registro al usuario
		repositorioRegistroLogin.registrarUsuario(user);
		
		//reservo el turno 
		repositorio.reservarTurno(turno, user.getIdUsuario());
		
		TurnoMedico turno2  = repositorio.obtenerTurno(1);
		
		assertThat(turno2).isNotNull();
	}
	
	@Test
	@Transactional
	@Rollback 
	public void testQueMePermitaCancelarUnTurno() {
		
		
	}


}
