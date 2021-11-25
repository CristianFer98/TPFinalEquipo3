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

import ar.edu.unlam.tallerweb1.modelo.Pagos;
import ar.edu.unlam.tallerweb1.modelo.TurnoMedico;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioPagos;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuarioLogueado;

public class ControladorUsuarioLogueadoTest {

	private ModelAndView mav = new ModelAndView();
	private ServicioUsuarioLogueado servicioUsuario;
	private ServicioPagos servicioPago;
	private ControladorUsuarioLogueado controladorUsuarioLogueado;

	@Before
	public void testQueSeHaceDespuesDeCadaTest() {

		servicioUsuario = mock(ServicioUsuarioLogueado.class);
		servicioPago = mock(ServicioPagos.class);

		controladorUsuarioLogueado = new ControladorUsuarioLogueado(servicioUsuario, servicioPago);

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

	@Test
	public void testQueMePermitaReservarUnTurno() {
		HttpSession http = mock(HttpSession.class);
		HttpServletRequest mockedRequest = mock(HttpServletRequest.class);
		when(mockedRequest.getSession()).thenReturn(http);

		Integer idTurno = 1;
		Integer idUsuario = 1;
		String status = "approved";
		Integer paymentId = 123456;
		TurnoMedico turno = new TurnoMedico();
		Pagos pago = new Pagos();

		when(servicioUsuario.reservarTurno(idTurno, idUsuario)).thenReturn(turno);
		when(servicioPago.getPagoByIDTurnoandIdUser(idTurno, idUsuario)).thenReturn(pago);

		mav = controladorUsuarioLogueado.reservarTurno(idTurno, idUsuario, status, paymentId);

		assertThat(mav.getViewName()).isEqualTo("reservaExitosa");
	}

//_________________________________________________________________________________________//
	@Test
	public void testQueMePermitaVerMisTurnos() {

		HttpSession http = mock(HttpSession.class);
		HttpServletRequest mockedRequest = mock(HttpServletRequest.class);
		when(mockedRequest.getSession()).thenReturn(http);
		Integer idUsuario = 1;
		ArrayList<TurnoMedico> turnos = new ArrayList<TurnoMedico>();
		when(servicioUsuario.verMisTurnos(idUsuario)).thenReturn(turnos);

		mav = controladorUsuarioLogueado.verMisTurnos(mockedRequest);

		assertThat(mav.getViewName()).isEqualTo("misTurnos");
	}

//________________________________________________________________________________________//

	@Test
	public void testQueMePermitaCancelarUnTurno() {

		Integer idTurno = 1;

		Usuario usuario = new Usuario();
		usuario.setIdUsuario(1);

		Pagos pago = new Pagos();

		TurnoMedico turno = new TurnoMedico();
		turno.setId(1);
		turno.setClienteAsignado(usuario);

		HttpSession http = mock(HttpSession.class);
		HttpServletRequest mockedRequest = mock(HttpServletRequest.class);
		when(mockedRequest.getSession()).thenReturn(http);
		when(mockedRequest.getSession().getAttribute("idUsuario")).thenReturn(1);

		when(servicioUsuario.getTurnoByOnlyID(idTurno)).thenReturn(turno);
		mav = controladorUsuarioLogueado.cancelarTurno(1, mockedRequest);

		assertThat(mav.getViewName()).isEqualTo("misTurnos");

	}
}
