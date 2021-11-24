package ar.edu.unlam.tallerweb1.controladores;


import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.TurnoMedico;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuarioLogueado;

public class ControladorUsuarioLogueadoTest {

	private ModelAndView mav = new ModelAndView();
	private ServicioUsuarioLogueado servicioUsuario;
	private ControladorUsuarioLogueado controladorUsuarioLogueado;

	@Before
	public void testQueSeHaceDespuesDeCadaTest() {

		servicioUsuario = mock(ServicioUsuarioLogueado.class);
		controladorUsuarioLogueado = new ControladorUsuarioLogueado(servicioUsuario, null);

	}

//____________________________________________________________________________________________________//

	@Test
	public void testQueMeMuestreLasEspecialidades() {

		HttpSession http = mock(HttpSession.class);
		HttpServletRequest mockedRequest = mock(HttpServletRequest.class);
		when(mockedRequest.getSession()).thenReturn(http);

		mav = controladorUsuarioLogueado.listarEspecialidades(mockedRequest);

		thenMuestroLasEspecialidades(mav);
	}

	private void thenMuestroLasEspecialidades(ModelAndView mav2) {
		assertThat(mav2.getViewName()).isEqualTo("especialidades");

	}

//_____________________________________________________________________________//

	@Test
	public void testQueMeListeMedicosPorEspecialidad() {
		Integer idEspecialidad = 1;
		List<Usuario> medicos = null;

		HttpSession http = mock(HttpSession.class);
		HttpServletRequest mockedRequest = mock(HttpServletRequest.class);
		when(mockedRequest.getSession()).thenReturn(http);
		when(servicioUsuario.listarMedicosPorEspecialidad(idEspecialidad)).thenReturn(medicos);

		mav = controladorUsuarioLogueado.listarMedicosPorEspecialidad(idEspecialidad, mockedRequest);
		assertThat(mav.getViewName()).isEqualTo("listaDeMedicos");
	}

//__________________________________________________________________________________________________________//

	@Test
	public void testQueMeListeTurnosDeUnMedico() {

		List<TurnoMedico> turnos = null;
		Integer id = 1;
		when(servicioUsuario.listarTurnos(id)).thenReturn(turnos);
		HttpSession http = mock(HttpSession.class);
		HttpServletRequest mockedRequest = mock(HttpServletRequest.class);
		when(mockedRequest.getSession()).thenReturn(http);

		mav = controladorUsuarioLogueado.listarTurnosDisponiblesDeUnMedico(1, mockedRequest);

		assertThat(mav.getViewName()).isEqualTo("turnosDisponiblesMedico");
	}

//__________________________________________________________________________________________________________//


//	@Test
//	public void testQueMePermitaReservarUnTurno() {
//		HttpSession http = mock(HttpSession.class);
//		HttpServletRequest mockedRequest = mock(HttpServletRequest.class);
//		when(mockedRequest.getSession()).thenReturn(http);
//
//		mav = controladorUsuarioLogueado.reservarTurno(1, 1, null, mockedRequest);
//
//		assertThat(mav.getViewName()).isEqualTo("reservaExitosa");
//	}

//_________________________________________________________________________________________//
	@Test
	public void testQueMePermitaVerMisTurnos() {
		HttpSession http = mock(HttpSession.class);
		HttpServletRequest mockedRequest = mock(HttpServletRequest.class);
		when(mockedRequest.getSession()).thenReturn(http);
		Integer idUsuario = 1;
		ArrayList<TurnoMedico> turnos = new ArrayList<TurnoMedico>();
		when(servicioUsuario.verMisTurnos(idUsuario)).thenReturn(turnos);
//
//		mav = controladorUsuarioLogueado.verMisTurnos(mockedRequest);

		assertThat(mav.getViewName()).isEqualTo("misTurnos");
	}

//________________________________________________________________________________________//

	@Test
	public void testQueMePermitaCancelarUnTurno() {
		HttpSession http = mock(HttpSession.class);
		HttpServletRequest mockedRequest = mock(HttpServletRequest.class);
		when(mockedRequest.getSession()).thenReturn(http);
		when(mockedRequest.getSession().getAttribute("idUsuario")).thenReturn(1);

		mav = controladorUsuarioLogueado.cancelarTurno(1, mockedRequest);

		assertThat(mav.getViewName()).isEqualTo("misTurnos");

	}
}
