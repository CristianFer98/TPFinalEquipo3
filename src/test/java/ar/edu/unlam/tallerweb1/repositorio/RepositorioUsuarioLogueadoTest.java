//package ar.edu.unlam.tallerweb1.repositorio;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.util.ArrayList;
//
//import javax.inject.Inject;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.transaction.annotation.Transactional;
//
//import ar.edu.unlam.tallerweb1.modelo.TurnoMedico;
//import ar.edu.unlam.tallerweb1.modelo.Usuario;
//import ar.edu.unlam.tallerweb1.persistencia.SpringTest;
//import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegistroLogin;
//import ar.edu.unlam.tallerweb1.repositorios.RepositorioSesionMedico;
//import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuarioLogueado;
//
//public class RepositorioUsuarioLogueadoTest extends SpringTest{
//	@Inject
//	RepositorioUsuarioLogueado repositorio;
//	@Inject
//	RepositorioRegistroLogin repositorioRegistroLogin;
//	@Inject
//	RepositorioSesionMedico repositorioMedico;
//
//	@Before
//	public void testAntesdeCadaTest() {
//	
//	}
//
//	@Test
//	@Rollback
//	@Transactional
//	public void testQueMePermitaConfirmarUnTurno() {
//		TurnoMedico turno= new TurnoMedico();
//		turno.setId(1);
//
//		ArrayList<TurnoMedico> turnos = new ArrayList <TurnoMedico>();
//		turnos.add(turno);
//		
//		//registro al usuario
//		Usuario usuario = new Usuario("123456789","test@gmail.com",1);
//		usuario.setIdUsuario(1);
//		Usuario usuarioMedico = new Usuario("123456789", "medico@gmail.com",2);
//		usuarioMedico.setIdUsuario(2);
//		
//		repositorioRegistroLogin.registrarUsuario(usuario);
//		repositorioRegistroLogin.registrarUsuario(usuarioMedico);
//
//		
//		repositorioMedico.cargarAgenda(turnos, 2);
//		
//		//reservo el turno 
//		repositorio.reservarTurno(turno, usuario.getIdUsuario());
//		
//		TurnoMedico turno2  = repositorio.obtenerTurno(1);
//		
//		assertThat(turno2.getClienteAsignado()).isNotNull();
//	}
//	
////	@Test
////	@Rollback
////	@Transactional
////	public void testQueMePermitaCancelarUnTurno() {
////		TurnoMedico turno= new TurnoMedico();
////		turno.setId(1);
////
////		ArrayList<TurnoMedico> turnos = new ArrayList <TurnoMedico>();
////		turnos.add(turno);
////		
////		//registro al usuario
////		Usuario usuario = new Usuario("123456789","test@gmail.com",1);
////		usuario.setIdUsuario(1);
////		Usuario usuarioMedico = new Usuario("123456789", "medico@gmail.com",2);
////		usuarioMedico.setIdUsuario(2);
////		
////		repositorioRegistroLogin.registrarUsuario(usuario);
////		repositorioRegistroLogin.registrarUsuario(usuarioMedico);
////
////		
////		repositorioMedico.cargarAgenda(turnos, 2);
////		
////		//reservo el turno 
////		repositorio.reservarTurno(turno, usuario.getIdUsuario());
////		
////		//canelo el turno
////		
////		repositorio.cancelarTurno(1);
////		
////		TurnoMedico turnoCancelado = repositorio.obtenerTurno(1);
////		
////		assertThat(turnoCancelado.getEstado()).isTrue();
////		
////	}
////
////	
////	@Test
////	@Rollback
////	@Transactional
////	public void testQueMePermiteCalificarUnTurno() {
////		TurnoMedico turno= new TurnoMedico();
////		turno.setId(1);
////		turno.setEstado(false);
////		turno.setPagado(true);
////
////		ArrayList<TurnoMedico> turnos = new ArrayList <TurnoMedico>();
////		turnos.add(turno);
////		
////		//registro al usuario
////		Usuario usuario = new Usuario("123456789","test@gmail.com",1);
////		usuario.setIdUsuario(1);
////		Usuario usuarioMedico = new Usuario("123456789", "medico@gmail.com",2);
////		usuarioMedico.setIdUsuario(2);
////		
////		repositorioRegistroLogin.registrarUsuario(usuario);
////		repositorioRegistroLogin.registrarUsuario(usuarioMedico);
////
////		
////		repositorioMedico.cargarAgenda(turnos, 2);
////		
////		//reservo el turno 
////		repositorio.reservarTurno(turno, usuario.getIdUsuario());
////		
////		//CALIFICO TURNO
////		repositorio.calificarTurno(1, 4);
////		
////		TurnoMedico turnoCalificado = repositorio.obtenerTurno(1);
////		
////		assertThat(turnoCalificado.getCalificacion()).isEqualTo(4);
////	}
//	
//	
//
//}
