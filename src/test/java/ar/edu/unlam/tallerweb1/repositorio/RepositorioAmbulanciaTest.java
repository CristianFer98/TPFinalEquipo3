package ar.edu.unlam.tallerweb1.repositorio;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Ambulancia;
import ar.edu.unlam.tallerweb1.modelo.DatosSolicitudAmbulancia;
import ar.edu.unlam.tallerweb1.modelo.SolicitudUsuarioAmbulancia;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.persistencia.SpringTest;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAmbulancia;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegistroLogin;

public class RepositorioAmbulanciaTest extends SpringTest{
	
	@Inject
	private RepositorioAmbulancia repositorio;
	
	@Inject
	private RepositorioRegistroLogin repositorioRegistroLogin;
	
	
	
	//1. que registre ambulancia correctamente
	//2. que me actualize el estado de la ambulancia en la BBDD
	//3. obtener lista de solicitudes solo con USUARIOS DETERMINADOS

	
	//1
	@Test
	@Transactional
	@Rollback
	public void testQueRegistreLaAmbulancia() {
		Ambulancia amb= givenAmbulanciaExistente();
		Integer idAmbRegistrada = whereRegistroAmbulancia(amb);
		
		//VERIFICACION
		Integer idAmbObtenida=amb.getIdAmbulancia();
		
		assertEquals(idAmbRegistrada, idAmbObtenida);		
	}
	
	//2.
	@Test
	@Transactional
	@Rollback
	public void queCambieElEstadoDeLaAmbEnLaBBDD() {
		Ambulancia amb= givenAmbulanciaExistente(); //devuelve ambulancia con disponible TRUE
		whereRegistroAmbulancia(amb);
		
		Boolean estadoActual= amb.getDisponible();
		
		//error
		repositorio.actualizarEstadoAmbulancia(amb, false);
		
		Boolean estadoObtenido= repositorio.buscarAmbulancia(amb.getPatenteAmbulancia()).getDisponible();
		Boolean estadoEsperado= false;
		
		assertNotEquals(estadoActual, estadoObtenido);
		assertEquals(estadoEsperado, estadoObtenido);
		
	}

	private Integer whereRegistroAmbulancia(Ambulancia amb) {
		repositorio.agregarAmbulancia(amb);
		return amb.getIdAmbulancia();
	}

	private Ambulancia givenAmbulanciaExistente() {
		Ambulancia amb= new Ambulancia("AAA222", true);
		return amb;
	}
	
	// 3
	@Test
	@Transactional
	@Rollback
	public void obtenerListaDeSolicitudesDEUNUsuario() {
		agregarAmbulancias();
		
		Usuario user =  new Usuario("123456789", "test@gmail.com", 1);
		Usuario user2 =  new Usuario("123456789", "test2@gmail.com", 1);
		
		repositorioRegistroLogin.registrarUsuario(user);
		repositorioRegistroLogin.registrarUsuario(user2);
		
		
		generarSolicitud(user);
		generarSolicitud(user2);
		generarSolicitud(user);
		
		List<SolicitudUsuarioAmbulancia> solicitudesObtenidas= repositorio.obtenerListaDeAmbulanciasQuePidioUsuario(user);
		
		Integer valorEsperado=2;
		Integer valorActual= solicitudesObtenidas.size();
				
		assertEquals(valorEsperado, valorActual);
		
	}

	private void agregarAmbulancias() {
		Ambulancia amb= new Ambulancia("aaa111", true);
		Ambulancia amb2= new Ambulancia("bbb222", true);
		Ambulancia amb3= new Ambulancia("ccc333", true);
		
		repositorio.agregarAmbulancia(amb);
		repositorio.agregarAmbulancia(amb2);
		repositorio.agregarAmbulancia(amb3);
	}

	private void generarSolicitud(Usuario user) {
		DatosSolicitudAmbulancia solicitud = new DatosSolicitudAmbulancia("Edison 3580");
		solicitud.setUser(user);
		SolicitudUsuarioAmbulancia soli1 = new SolicitudUsuarioAmbulancia(solicitud );	
		repositorio.guardarRegistro(soli1);
	}
	

}
