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



public class AmbulanciaServicioTest extends SpringTest{
	@Autowired
	private ServicioAmbulanciaIMPL servicio;
	
	
	
	
	@Test
	@Transactional
	@Rollback
	public void obtenerListasDeRegistrosEspecifica() {
		DatosSolicitudAmbulancia datos= new DatosSolicitudAmbulancia("Edison 3580");
		SolicitudUsuarioAmbulancia soli= new SolicitudUsuarioAmbulancia(datos);			
		servicio.guardarRegistroSolicitudAmbulancia(soli);
		
		SolicitudUsuarioAmbulancia soliObtenida = servicio.obtenerSolicitudPORID(1);
		
		
		assertNotNull(soliObtenida);
	}
	
//	@Test
//	@Transactional
//	@Rollback
//	public void cambiarEstadoAmbulancia(){
//		Ambulancia amb = new Ambulancia("aaa111", true);
//		servicio.agregarAmbulancia(amb);
//		servicio.cambiarEstadoAmbulancia(amb, false);
//		
//		Ambulancia amb2= servicio.obtenerAmbulanciaPorPatente("aaa111");
//		
//		Boolean actual= amb2.getDisponible();
//		Boolean expected= false;
//		
//		assertEquals(expected, actual);
//	}

	
	
	

}