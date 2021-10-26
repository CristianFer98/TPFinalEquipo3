package ar.edu.unlam.tallerweb1.controladores;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.PlanAvanzado;
import ar.edu.unlam.tallerweb1.modelo.PlanBasico;
import ar.edu.unlam.tallerweb1.servicios.ServicioPlanSalud;

public class ControladorPlanSaludTest {
		
	private ModelAndView mav;
	private ControladorPlanSalud controlador;
	private ServicioPlanSalud servicio;
	HttpServletRequest req;
	
	@Test
	public void testQuePuedaCotizarPlanBasico() {
		givenExistePlanBasico();
		mav = whenCotizoPlanBasico();
		thenSeCotizoElPlanBasicoExitosamente();
	}

	@Test
	public void testQuePuedaCotizarAvanzado() {
		givenExistePlanAvanzado();
		mav = whenCotizoPlanAvanzado();
		thenSeCotizoElPlanAvanzadoExitosamente();
	}


	private void givenExistePlanBasico() {
		PlanBasico basico = new PlanBasico();
	}


	private ModelAndView whenCotizoPlanBasico() {
		return controlador.cotizarPlanBasico(req);
	}
	
	private void thenSeCotizoElPlanBasicoExitosamente() {
		assertThat(mav.getViewName()).isEqualTo("cotizacion");
		
	}
	
	private void givenExistePlanAvanzado() {
		PlanAvanzado avanzado = new PlanAvanzado();	
	}

	private ModelAndView whenCotizoPlanAvanzado() {
		return controlador.cotizarPlanAvanzado(req);

	}

	private void thenSeCotizoElPlanAvanzadoExitosamente() {
		assertThat(mav.getViewName()).isEqualTo("cotizacion");
		
	}
}