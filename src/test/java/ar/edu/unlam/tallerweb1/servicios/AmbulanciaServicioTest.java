package ar.edu.unlam.tallerweb1.servicios;

import static org.junit.Assert.*;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAmbulancia;
import static org.mockito.Mockito.*;

public class AmbulanciaServicioTest extends SpringTest{
	private ServicioAmbulanciaIMPL servicio;
	private RepositorioAmbulancia repositorio;
	
	@Before(value = "")
	public void test() {
		repositorio= mock(RepositorioAmbulancia.class);
		servicio= new ServicioAmbulanciaIMPL(repositorio);
		
	}
	
	@Test
	@Transactional
	@Rollback
	public void obtenerAmbulanciasDisponibles() {
		
	}
	
	

	
	
	

}
