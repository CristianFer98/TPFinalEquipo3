<<<<<<< HEAD
//package ar.edu.unlam.tallerweb1.servicios;
//
=======
package ar.edu.unlam.tallerweb1.servicios;

>>>>>>> ramaEsteban
//import static org.junit.Assert.*;
//
//import org.aspectj.lang.annotation.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.transaction.annotation.Transactional;
//
<<<<<<< HEAD
=======
//import ar.edu.unlam.tallerweb1.modelo.Ambulancia;
>>>>>>> ramaEsteban
//import ar.edu.unlam.tallerweb1.modelo.DatosSolicitudAmbulancia;
//import ar.edu.unlam.tallerweb1.modelo.SolicitudUsuarioAmbulancia;
//import ar.edu.unlam.tallerweb1.persistencia.SpringTest;
//import ar.edu.unlam.tallerweb1.repositorios.RepositorioAmbulancia;
//import static org.mockito.Mockito.*;
//
<<<<<<< HEAD
=======
//
>>>>>>> ramaEsteban
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
<<<<<<< HEAD
//		
//	}
//	
//	
//
//	
//	
=======
//	}
//	
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
////		Boolean actual= amb2.getDisponible();
////		Boolean expected= false;
////		
////		assertEquals(expected, actual);
////	}
//
//	
//	// MOQUEAR AMBULANCIA
>>>>>>> ramaEsteban
//	
//
//}
