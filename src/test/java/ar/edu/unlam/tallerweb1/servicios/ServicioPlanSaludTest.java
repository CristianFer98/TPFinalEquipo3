//package ar.edu.unlam.tallerweb1.servicios;
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.time.LocalDate;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import ar.edu.unlam.tallerweb1.modelo.cotizacionExistenteException;
//import ar.edu.unlam.tallerweb1.repositorios.RepositorioPlanSalud;
//
//public class ServicioPlanSaludTest {
//	
//
//	private RepositorioPlanSalud repositorio;//esta es la interfaz que inyecto 
//	private ServicioPlanSaludImpl servicio; //esta es la implementacion
//
//	@Before
//	public void testQueSeHaceDespuesDeCadaTest() {
//
//		repositorio = mock(RepositorioPlanSalud.class); //mockeo el repositorio por que?
//		servicio = new ServicioPlanSaludImpl(repositorio); //inyecto el repo
//
//	}
//	
////_________________________________________________________________________________________//
//	
//	@Test 
//	public void testQueMeCotizaExitosamenteElPlanMedico() {
//		Integer idUsuario = 1;
//		LocalDate edad = LocalDate.of(2000, 11, 11);
//		
//		when(repositorio.corroborarExistenciaDePlan(idUsuario)).thenReturn(false);
//		when(repositorio.recuperarEdad(idUsuario)).thenReturn(edad);
//		
//		Double descuento = servicio.cotizarPlanMedico(idUsuario);
//		
//		assertThat(descuento.equals(35.0));
//	}
//	
////_________________________________________________________________________________________//
//	
//	@Test
//	(expected = cotizacionExistenteException.class)
//	public void testQueNoMePermitaCotizarPorYaTenerUnaSubscripcion() {
//		Integer idUsuario = 1;
//		when(repositorio.corroborarExistenciaDePlan(idUsuario)).thenReturn(true);
//		servicio.cotizarPlanMedico(idUsuario);
//	}
//	
//}
