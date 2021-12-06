//package ar.edu.unlam.tallerweb1.controladores;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.web.servlet.ModelAndView;
//
//
//import ar.edu.unlam.tallerweb1.modelo.PlanSalud;
//import ar.edu.unlam.tallerweb1.modelo.Usuario;
//import ar.edu.unlam.tallerweb1.servicios.ServicioPlanSalud;
//
//public class ControladorPlanSaludTest {
//
//	private ModelAndView mav;
//	private ControladorPlanSalud controlador;
//	private ServicioPlanSalud servicio;
//	HttpServletRequest req;
//
//	@Before
//	public void testQueSeHaceDespuesDeCadaTest() {
//
//		servicio = mock(ServicioPlanSalud.class);
//		controlador = new ControladorPlanSalud(servicio);
//
//	}
//
//
////______________________________________________________________________________//
//
//@Test 
//public void testQueMeMuestraElFormularioAlPlanMedico() {
//	HttpSession http = mock(HttpSession.class);
//	HttpServletRequest mockedRequest = mock(HttpServletRequest.class);
//	when(mockedRequest.getSession()).thenReturn(http);
//	when(mockedRequest.getSession().getAttribute("idUsuario")).thenReturn(1);
//	PlanSalud plan = new PlanSalud();
//	plan.setIdPlanSalud(1);
//	plan.setNombre("Gold");
//	Float precio = (float) 200.0;
//	plan.setPrecioDelPlan(precio);
//
//	
//	when(servicio.obtenerUsuario(1)).thenReturn(new Usuario());
//	when(servicio.obtenerPlan(1)).thenReturn(plan);
//	when(servicio.obtenerPlan(2)).thenReturn(plan);
//	when(servicio.obtenerPlan(3)).thenReturn(plan);
//
//	mav = controlador.showPlanesMedicos(mockedRequest);
//	
//	assertThat(mav.getViewName()).isEqualTo("planesMedicos");
//}
//
////____________________________________________________________________________//
//
//	@Test
//	public void testQueMePermiteSubscribirAlPlan() {
//		HttpSession http = mock(HttpSession.class);
//		HttpServletRequest mockedRequest = mock(HttpServletRequest.class);
//		when(mockedRequest.getSession()).thenReturn(http);
//		when(mockedRequest.getSession().getAttribute("idUsuario")).thenReturn(1);
//		
//	
//		Integer idDelPlan = 1;
//		
//		mav = controlador.registrarSubscripcionSalud(idDelPlan, mockedRequest);
//
//		assertThat(mav.getViewName()).isEqualTo("subscripcionExitosa");
//
//	}
//
//}