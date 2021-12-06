//package ar.edu.unlam.tallerweb1.servicios;
//
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//import static org.assertj.core.api.Assertions.assertThat;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import ar.edu.unlam.tallerweb1.modelo.TurnoMedico;
//import ar.edu.unlam.tallerweb1.modelo.Usuario;
//import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuarioLogueado;
//
//public class ServicioUsuarioLogueadoTest {
//
//	private RepositorioUsuarioLogueado repositorio;
//	private ServicioUsuarioLogueadoImpl servicio;
//
//	@Before
//	public void testQueSeHaceDespuesDeCadaTest() {
//
//		repositorio = mock(RepositorioUsuarioLogueado.class);
//		servicio = new ServicioUsuarioLogueadoImpl(repositorio);
//
//	}
//
////________________________________________________________________________//
//
//	@Test
//	public void testQueMePermiteRegistrarUnNuevoTurno() {
//		Integer idTurno = 1;
//		Integer idUsuario = 1;
//		Usuario usuario = new Usuario();
//		TurnoMedico turno = new TurnoMedico();
//		when(repositorio.obtenerTurno(idTurno)).thenReturn(turno);
//		when(repositorio.obtenerUsuario(idUsuario)).thenReturn(usuario);
//		when(repositorio.reservarTurno(turno, idUsuario)).thenReturn(new TurnoMedico());
//
//		TurnoMedico turnoNuevo = servicio.reservarTurno(idTurno, idUsuario);
//
//		assertThat(turnoNuevo).isNotNull();
//
//	}
//	
////________________________________________________________________________//
//	
//
//
//}
