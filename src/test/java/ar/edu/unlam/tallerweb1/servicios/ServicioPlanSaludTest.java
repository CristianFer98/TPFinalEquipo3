package ar.edu.unlam.tallerweb1.servicios;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unlam.tallerweb1.modelo.PlanSalud;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPlanSalud;

public class ServicioPlanSaludTest {

	private ModelAndView mav;
	private ServicioPlanSaludImpl servicio;
	private RepositorioPlanSalud repositorio;
	
	HttpServletRequest req;

	@Before
	public void testQueSeHaceDespuesDeCadaTest() {

		repositorio = mock(RepositorioPlanSalud.class);
		servicio = new ServicioPlanSaludImpl(repositorio);

	}
	
	
	@Test
	public void testQueMePermiteObtenerUnPlan() {
		Integer idPlan = 1;
		when(repositorio.obtenerPlanMedico(idPlan)).thenReturn(new PlanSalud());
		
		assertThat(servicio.obtenerPlan(1)).isNotNull();
		
		
	}
	
	@Test
	public void testQueMePermiteObtenerUnUsuario() {
		Integer idUsuario = 1;
		when(repositorio.obtenerUsuario(idUsuario)).thenReturn(new Usuario());
		
		assertThat(servicio.obtenerUsuario(1)).isNotNull();
		
		
	}
	
}
