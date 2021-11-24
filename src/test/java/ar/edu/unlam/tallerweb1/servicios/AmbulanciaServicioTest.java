package ar.edu.unlam.tallerweb1.servicios;

<<<<<<< HEAD
//import static org.junit.Assert.*;
//
//import org.aspectj.lang.annotation.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.transaction.annotation.Transactional;
//
//import ar.edu.unlam.tallerweb1.modelo.Ambulancia;
//import ar.edu.unlam.tallerweb1.modelo.DatosSolicitudAmbulancia;
//import ar.edu.unlam.tallerweb1.modelo.SolicitudUsuarioAmbulancia;
//import ar.edu.unlam.tallerweb1.persistencia.SpringTest;
//import ar.edu.unlam.tallerweb1.repositorios.RepositorioAmbulancia;
//import static org.mockito.Mockito.*;
//
//
//public class AmbulanciaServicioTest extends SpringTest{
//	@Autowired
//	private ServicioAmbulanciaIMPL servicio;
//	@Autowired
//	private ServicioRegistroLogin servicioRegistroLogin;
//	@Autowired
//	private RepositorioAmbulancia repositorio;
//	
//	@Before(value = "")
//	public void test() {
//		repositorio= mock(RepositorioAmbulancia.class);
//		servicio= new ServicioAmbulanciaIMPL(repositorio);	
//	}
//	
//	@Test
//	@Transactional
//	@Rollback
//	public void obtenerListasDeRegistrosEspecifica() {
//		DatosSolicitudAmbulancia datos= new DatosSolicitudAmbulancia("Edison 3580");
//		SolicitudUsuarioAmbulancia soli= new SolicitudUsuarioAmbulancia(datos);			
//		servicio.guardarRegistroSolicitudAmbulancia(soli);
//		
//		SolicitudUsuarioAmbulancia soliObtenida = servicio.obtenerSolicitudPORID(1);
//		
//		
//		assertEquals(soli.getIdSolicitud(), soliObtenida.getIdSolicitud());
//		assertNotNull(soliObtenida);
//	}
//	
=======

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
	
>>>>>>> main
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
<<<<<<< HEAD
////		Boolean actual= amb2.getDisponible();
////		Boolean expected= false;
////		
////		assertEquals(expected, actual);
////	}
//
//	
//	// MOQUEAR AMBULANCIA
//	
//
//}
=======
//		Boolean actual= amb2.getDisponible();
//		Boolean expected= false;
//		
//		assertEquals(expected, actual);
//	}

	
	
	

}
>>>>>>> main
