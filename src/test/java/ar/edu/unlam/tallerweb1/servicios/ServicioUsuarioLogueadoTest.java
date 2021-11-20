package ar.edu.unlam.tallerweb1.servicios;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.tallerweb1.modelo.TurnoMedico;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuarioLogueado;

public class ServicioUsuarioLogueadoTest {

	private RepositorioUsuarioLogueado repositorio;
	private ServicioUsuarioLogueadoImpl servicio;

	@Before
	public void testQueSeHaceDespuesDeCadaTest() {

		repositorio = mock(RepositorioUsuarioLogueado.class);
		servicio = new ServicioUsuarioLogueadoImpl(repositorio);

	}

//________________________________________________________________________//

	@Test
	public void testQueMePermiteRegistrarUnNuevoTurno() {
		Integer idTurno = 1;
		Integer idUsuario = 1;
		Usuario usuario = new Usuario();
		TurnoMedico turno = new TurnoMedico();
		when(repositorio.obtenerTurno(idTurno)).thenReturn(turno);
		when(repositorio.obtenerUsuario(idUsuario)).thenReturn(usuario);
		when(repositorio.reservarTurno(turno, idUsuario)).thenReturn(new TurnoMedico());

		TurnoMedico turnoNuevo = servicio.reservarTurno(idTurno, idUsuario);

		assertThat(turnoNuevo).isNotNull();

	}
	
//________________________________________________________________________//
	
<<<<<<< HEAD
	@Test
	public void testQueMePermiteHacerDescuentoAlTurnoNuevo() {
		Integer idTurno = 1;
		Integer idUsuario = 1;
		
		//defino el usuario
		Usuario usuario = new Usuario();
		Double descuento = 50.0;
		usuario.setDescuentoPorPlanMedico(descuento);
		
		//defino el turno
		TurnoMedico turno = new TurnoMedico();
		Double valorConsulta = 500.0;
		turno.setValorConDescuento(valorConsulta);
		turno.setValorPorConsultaNormal(valorConsulta);

		when(repositorio.obtenerTurno(idTurno)).thenReturn(turno);
		when(repositorio.obtenerUsuario(idUsuario)).thenReturn(usuario);
		when(repositorio.reservarTurno(turno, idUsuario)).thenReturn(turno);
		
		TurnoMedico turnoNuevo = servicio.reservarTurno(idTurno, idUsuario);
		
		Double valorEsperado = 250.0;
		assertThat(turnoNuevo.getValorConDescuento()).isEqualTo(valorEsperado);
	}

}
=======


}
>>>>>>> ramaEsteban
