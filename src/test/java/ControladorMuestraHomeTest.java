import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.tallerweb1.controladores.ControladorMuestraHome;
import ar.edu.unlam.tallerweb1.servicios.ServicioOperacionesMatematica;
import ar.edu.unlam.tallerweb1.servicios.ServicioOperacionesMatmeticaIMPL;

public class ControladorMuestraHomeTest {

	@Test
	public void testQueSumeCorrectamente() {
		
		ServicioOperacionesMatmeticaIMPL servicio = new ServicioOperacionesMatmeticaIMPL();
		
		int obtenido=servicio.sumarNumeros(10, 10);
		
		assertEquals(20, obtenido);
		
	}

}
