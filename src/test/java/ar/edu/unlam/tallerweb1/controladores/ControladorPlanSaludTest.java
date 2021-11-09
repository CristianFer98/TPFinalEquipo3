package ar.edu.unlam.tallerweb1.controladores;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.cotizacionExistenteException;
import ar.edu.unlam.tallerweb1.servicios.ServicioPlanSalud;

public class ControladorPlanSaludTest {

	private ModelAndView mav;
	private ControladorPlanSalud controlador;
	private ServicioPlanSalud servicio;
	HttpServletRequest req;

	@Before
	public void testQueSeHaceDespuesDeCadaTest() {

		servicio = mock(ServicioPlanSalud.class);
		controlador = new ControladorPlanSalud(servicio);

	}

	// ____________________________________________________________________________//

	@Test
	public void testMostrarFormPlanMedico() {
		mav = controlador.mostrarFormPlanMedico();
		assertThat(mav.getViewName()).isEqualTo("formPlanMedico");
	}

	// ______________________________________________________________________________//

	@Test
	public void testQueMePermitaCotizarPlanMedico() {
		Integer id = 1;
		Double descuento = 35.0;
		HttpSession http = mock(HttpSession.class);
		HttpServletRequest mockedRequest = mock(HttpServletRequest.class);
		when(mockedRequest.getSession()).thenReturn(http);
		when(mockedRequest.getSession().getAttribute("idUsuario")).thenReturn(id);

		when(servicio.cotizarPlanMedico(id)).thenReturn(descuento);
		mav = controlador.cotizarPlanBasico(mockedRequest);

		assertThat(mav.getViewName()).isEqualTo("cotizacionDePlanMedico");
		assertThat(mav.getModel().get("valor")).isEqualTo(35.0);
	}

//______________________________________________________________________________//

	@Test
	public void testQueNoMePermitaCotizarPlanPorYaEstarRegistradoAUno() {
		HttpSession http = mock(HttpSession.class);
		HttpServletRequest mockedRequest = mock(HttpServletRequest.class);
		when(mockedRequest.getSession()).thenReturn(http);
		when(mockedRequest.getSession().getAttribute("idUsuario")).thenReturn(1);

		doThrow(cotizacionExistenteException.class).when(servicio).cotizarPlanMedico(1);
		mav = controlador.cotizarPlanBasico(mockedRequest);

		assertThat(mav.getViewName()).isEqualTo("errorPlanMedico");
		assertThat(mav.getModel().get("mensaje")).isEqualTo("Usted ya cuenta con una suscripcion a su nombre");

	}

//____________________________________________________________________________//

	@Test
	public void testQueMePermiteSubscribirALaCotizacion() {
		HttpSession http = mock(HttpSession.class);
		HttpServletRequest mockedRequest = mock(HttpServletRequest.class);
		when(mockedRequest.getSession()).thenReturn(http);
		when(mockedRequest.getSession().getAttribute("idUsuario")).thenReturn(1);

		Double descuento = 35.0;

		mav = controlador.suscribirseAPlanMedico(descuento, mockedRequest);

		assertThat(mav.getViewName()).isEqualTo("suscripcionAPlan");
		assertThat(mav.getModel().get("descuento")).isEqualTo(35.0);

	}

}