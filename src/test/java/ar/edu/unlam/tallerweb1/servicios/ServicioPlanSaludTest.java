package ar.edu.unlam.tallerweb1.servicios;

import org.junit.Test;

public class ServicioPlanSaludTest {
	
	@Test
	public void testQuePermitaCotizarUnPlanBasico(){
		givenNoExisteUnPlanBasico();
		whenCotizoUnPlanBasico();
		thenCotizacionExitosa();
	}

	private void givenNoExisteUnPlanBasico() {
		
	}
	
	private void whenCotizoUnPlanBasico() {
		
	}
	
	private void thenCotizacionExitosa() {
		// TODO Auto-generated method stub
		
	}

}
