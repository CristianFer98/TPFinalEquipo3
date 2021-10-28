package ar.edu.unlam.tallerweb1.controladores;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Ambulancia;
import ar.edu.unlam.tallerweb1.modelo.DatosRegistroUsuarioComun;
import ar.edu.unlam.tallerweb1.modelo.DatosSolicitudAmbulancia;
import ar.edu.unlam.tallerweb1.modelo.SolicitudUsuarioAmbulancia;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegistroLogin;
import ar.edu.unlam.tallerweb1.servicios.NoHayAmbulanciasDisponiblesException;
import ar.edu.unlam.tallerweb1.servicios.ServicioAmbulancia;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroLogin;
import ar.edu.unlam.tallerweb1.servicios.UsuarioYaPidioAmbulanciaExeception;

public class ControladorAmbulanciaTest extends SpringTest {
	@Autowired
	private ServicioAmbulancia servicioAmbulancia;
	@Autowired
	private ServicioRegistroLogin servicioRegistroLogin;
	@Autowired
	private RepositorioRegistroLogin repositorioRegistroLogin;

	//1. El usuario puede pedir ambulancia
	//2. el usuario no puede pedir ambulancia si no hay ambulancia
	//3. El usuario no puede pedir ambulancia si ya pidio antes   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 

	@Test
	@Transactional
	@Rollback
	public void testUsuarioPuedePedirAmbulancias() throws ParseException {
		Ambulancia amb= new Ambulancia("aaa111", true);
		servicioAmbulancia.agregarAmbulancia(amb);
		
		DatosRegistroUsuarioComun datosRegistro= new DatosRegistroUsuarioComun("test@gmail.com", "123456789", "123456789");
		servicioRegistroLogin.registrarUsuario(datosRegistro);
		Usuario user= servicioRegistroLogin.obtenerUsuarioPorMail("test@gmail.com");
		
		DatosSolicitudAmbulancia datos= new DatosSolicitudAmbulancia("EDISON 3580");
		datos.setUser(user);
		
		Integer idObtenido= servicioAmbulancia.pedirAmbulancia(datos);
		
		Integer idEsperado =  1;
		
		assertEquals(idEsperado, idObtenido);	
	}
	
	@Test(expected = NoHayAmbulanciasDisponiblesException.class)
	@Transactional
	@Rollback
	public void testNoSePuedePedirAmbulanciaSiNoExisteAmbulancia() throws ParseException {
		DatosRegistroUsuarioComun datosRegistro= new DatosRegistroUsuarioComun("test@gmail.com", "123456789", "123456789");
		servicioRegistroLogin.registrarUsuario(datosRegistro);
		Usuario user= servicioRegistroLogin.obtenerUsuarioPorMail("test@gmail.com");
		
		DatosSolicitudAmbulancia datos= new DatosSolicitudAmbulancia("EDISON 3580");
		datos.setUser(user);
		
		servicioAmbulancia.pedirAmbulancia(datos);	
	}
	
	@Test(expected = UsuarioYaPidioAmbulanciaExeception.class)
	@Transactional
	@Rollback
	public void UsuarioNoPuedePedirAmbulanciaSiYaPidioAntes() throws ParseException{		
		Ambulancia amb= new Ambulancia("aaa111", true);
		servicioAmbulancia.agregarAmbulancia(amb);
		
		Ambulancia amb2= new Ambulancia("bbb222", true);
		servicioAmbulancia.agregarAmbulancia(amb2);
		
	
		DatosRegistroUsuarioComun datosRegistro= new DatosRegistroUsuarioComun("test@gmail.com", "123456789", "123456789");
		servicioRegistroLogin.registrarUsuario(datosRegistro);
		Usuario user= servicioRegistroLogin.obtenerUsuarioPorMail("test@gmail.com");
		
		
		DatosSolicitudAmbulancia datos= new DatosSolicitudAmbulancia("EDISON 3580");	
		datos.setUser(user);
		servicioAmbulancia.pedirAmbulancia(datos);
		
		
		DatosSolicitudAmbulancia datos2= new DatosSolicitudAmbulancia("EDISON 3580");
		datos2.setUser(user);		
		servicioAmbulancia.pedirAmbulancia(datos2);
		
	}
	
	@Test
	@Transactional
	@Rollback
	public void adminPuedeMarcarSolicitudComoAtendida() throws ParseException {
		Usuario user =  registrarUser();
		
		Ambulancia amb= new Ambulancia("aaa111", true);
		servicioAmbulancia.agregarAmbulancia(amb);
		
		DatosSolicitudAmbulancia datos= new DatosSolicitudAmbulancia("EDISON 3580");	
		datos.setUser(user);
		servicioAmbulancia.pedirAmbulancia(datos);
			
		List <SolicitudUsuarioAmbulancia> solicitudes= servicioAmbulancia.obtenerListaDeAmbulanciasQuePidioUsuario(user);
		assertEquals(1, solicitudes.size());
		
		SolicitudUsuarioAmbulancia solicitudAAtender= servicioAmbulancia.obtenerConsultaSinAtenderPorUsuario(user);	
		servicioAmbulancia.atenderConsulta(solicitudAAtender);
		
		Boolean obtenido= solicitudAAtender.getAtendido();
		Boolean esperado= true;
		
		assertEquals(esperado, obtenido);
		
		
		
	}

	private Usuario registrarAdmin() {
		Usuario admin = new Usuario("123456789", "admin@gmail.com", 3);
		repositorioRegistroLogin.registrarUsuario(admin);
		return admin;
	}

	private Usuario registrarUser() throws ParseException {
		DatosRegistroUsuarioComun datosRegistro= new DatosRegistroUsuarioComun("test@gmail.com", "123456789", "123456789");
		servicioRegistroLogin.registrarUsuario(datosRegistro);
		Usuario user= servicioRegistroLogin.obtenerUsuarioPorMail("test@gmail.com");
		return user;
	}
	






}
