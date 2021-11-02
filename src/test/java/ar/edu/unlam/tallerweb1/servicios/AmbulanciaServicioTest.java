package ar.edu.unlam.tallerweb1.servicios;

import static org.junit.Assert.*;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.DatosSolicitudAmbulancia;
import ar.edu.unlam.tallerweb1.modelo.SolicitudUsuarioAmbulancia;
import ar.edu.unlam.tallerweb1.persistencia.SpringTest;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAmbulancia;
import static org.mockito.Mockito.*;

public class AmbulanciaServicioTest extends SpringTest{
	@Autowired
	private ServicioAmbulanciaIMPL servicio;
	@Autowired
	private ServicioRegistroLogin servicioRegistroLogin;
	@Autowired
	private RepositorioAmbulancia repositorio;
	
	@Before(value = "")
	public void test() {
		repositorio= mock(RepositorioAmbulancia.class);
		servicio= new ServicioAmbulanciaIMPL(repositorio);	
	}
	
	@Test
	@Transactional
	@Rollback
	public void obtenerListasDeRegistrosEspecifica() {
		DatosSolicitudAmbulancia datos= new DatosSolicitudAmbulancia("Edison 3580");
		SolicitudUsuarioAmbulancia soli= new SolicitudUsuarioAmbulancia(datos);			
		servicio.guardarRegistroSolicitudAmbulancia(soli);
		
		SolicitudUsuarioAmbulancia soliObtenida = servicio.obtenerSolicitudPORID(1);
		
		
		assertEquals(soli.getIdSolicitud(), soliObtenida.getIdSolicitud());
		assertNotNull(soliObtenida);
		
	}
	
	

	
	
	

}
