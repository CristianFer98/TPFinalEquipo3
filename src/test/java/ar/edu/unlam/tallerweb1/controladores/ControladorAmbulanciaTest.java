<<<<<<< HEAD
//package ar.edu.unlam.tallerweb1.controladores;
//
//import static org.junit.Assert.*;
//
//import java.text.ParseException;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.transaction.annotation.Transactional;
//
//import ar.edu.unlam.tallerweb1.modelo.Ambulancia;
//import ar.edu.unlam.tallerweb1.modelo.DatosRegistroUsuario;
//import ar.edu.unlam.tallerweb1.modelo.DatosSolicitudAmbulancia;
//import ar.edu.unlam.tallerweb1.modelo.SolicitudUsuarioAmbulancia;
//import ar.edu.unlam.tallerweb1.modelo.Usuario;
//import ar.edu.unlam.tallerweb1.persistencia.SpringTest;
//import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegistroLogin;
//import ar.edu.unlam.tallerweb1.servicios.NoHayAmbulanciasDisponiblesException;
//import ar.edu.unlam.tallerweb1.servicios.ServicioAmbulancia;
//import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroLogin;
//import ar.edu.unlam.tallerweb1.servicios.UsuarioYaPidioAmbulanciaExeception;
//
//public class ControladorAmbulanciaTest extends SpringTest {
//	@Autowired
//	private ServicioAmbulancia servicioAmbulancia;
//	@Autowired
//	private ServicioRegistroLogin servicioRegistroLogin;
//	@Autowired
//	private RepositorioRegistroLogin repositorioRegistroLogin;
//
//	//1. El usuario puede pedir ambulancia
//	//2. el usuario no puede pedir ambulancia si no hay ambulancia
//	//3. El usuario no puede pedir ambulancia si ya pidio antes   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
// 
//
//	@Test
//	@Transactional
//	@Rollback
//	public void testUsuarioPuedePedirAmbulancias() throws ParseException {
//		Ambulancia amb= new Ambulancia("aaa111", true);
//		servicioAmbulancia.agregarAmbulancia(amb);
//		
//		DatosRegistroUsuario datosRegistro= new DatosRegistroUsuario("test@gmail.com", "123456789", "123456789");
//		servicioRegistroLogin.registrarUsuario(datosRegistro);
//		Usuario user= servicioRegistroLogin.obtenerUsuarioPorMail("test@gmail.com");
//		
//		DatosSolicitudAmbulancia datos= new DatosSolicitudAmbulancia("EDISON 3580");
//		datos.setUser(user);
//		
//		Integer idObtenido= servicioAmbulancia.pedirAmbulancia(datos);
//		
//		Integer idEsperado =  1;
//		
//		assertEquals(idEsperado, idObtenido);	
//	}
//	
//	@Test(expected = NoHayAmbulanciasDisponiblesException.class)
//	@Transactional
//	@Rollback
//	public void testNoSePuedePedirAmbulanciaSiNoExisteAmbulancia() throws ParseException {
//		DatosRegistroUsuario datosRegistro= new DatosRegistroUsuario("test@gmail.com", "123456789", "123456789");
//		servicioRegistroLogin.registrarUsuario(datosRegistro);
//		Usuario user= servicioRegistroLogin.obtenerUsuarioPorMail("test@gmail.com");
//		
//		DatosSolicitudAmbulancia datos= new DatosSolicitudAmbulancia("EDISON 3580");
//		datos.setUser(user);
//		
//		servicioAmbulancia.pedirAmbulancia(datos);	
//	}
//	
//	@Test(expected = UsuarioYaPidioAmbulanciaExeception.class)
//	@Transactional
//	@Rollback
//	public void UsuarioNoPuedePedirAmbulanciaSiYaPidioAntes() throws ParseException{		
//		Ambulancia amb= new Ambulancia("aaa111", true);
//		servicioAmbulancia.agregarAmbulancia(amb);
//		
//		Ambulancia amb2= new Ambulancia("bbb222", true);
//		servicioAmbulancia.agregarAmbulancia(amb2);
//		
//	
//		DatosRegistroUsuario datosRegistro= new DatosRegistroUsuario("test@gmail.com", "123456789", "123456789");
//		servicioRegistroLogin.registrarUsuario(datosRegistro);
//		Usuario user= servicioRegistroLogin.obtenerUsuarioPorMail("test@gmail.com");
//		
//		
//		DatosSolicitudAmbulancia datos= new DatosSolicitudAmbulancia("EDISON 3580");	
//		datos.setUser(user);
//		servicioAmbulancia.pedirAmbulancia(datos);
//		
//		
//		DatosSolicitudAmbulancia datos2= new DatosSolicitudAmbulancia("EDISON 3580");
//		datos2.setUser(user);		
//		servicioAmbulancia.pedirAmbulancia(datos2);
//		
//	}
//	
//	@Test
//	@Transactional
//	@Rollback
//	public void adminPuedeMarcarSolicitudComoAtendida() throws ParseException {
//		Usuario user =  registrarUser();
//		
//		Ambulancia amb= new Ambulancia("aaa111", true);
//		servicioAmbulancia.agregarAmbulancia(amb);
//		
//		DatosSolicitudAmbulancia datos= new DatosSolicitudAmbulancia("EDISON 3580");	
//		datos.setUser(user);
//		servicioAmbulancia.pedirAmbulancia(datos);
//			
//		List <SolicitudUsuarioAmbulancia> solicitudes= servicioAmbulancia.obtenerListaDeAmbulanciasQuePidioUsuario(user);
//		assertEquals(1, solicitudes.size());
//		
//		SolicitudUsuarioAmbulancia solicitudAAtender= servicioAmbulancia.obtenerConsultaSinAtenderPorUsuario(user);	
//		servicioAmbulancia.atenderConsulta(solicitudAAtender);
//		
//		Boolean obtenido= solicitudAAtender.getAtendido();
//		Boolean esperado= true;
//		
//		assertEquals(esperado, obtenido);
//		
//		
//		
//	}
//
//	private Usuario registrarAdmin() {
//		Usuario admin = new Usuario("123456789", "admin@gmail.com", 3);
//		repositorioRegistroLogin.registrarUsuario(admin);
//		return admin;
//	}
//
//	private Usuario registrarUser() throws ParseException {
//		DatosRegistroUsuario datosRegistro= new DatosRegistroUsuario("test@gmail.com", "123456789", "123456789");
//		servicioRegistroLogin.registrarUsuario(datosRegistro);
//		Usuario user= servicioRegistroLogin.obtenerUsuarioPorMail("test@gmail.com");
//		return user;
//	}
//	
//
//
//
//
//
//
//}
=======
package ar.edu.unlam.tallerweb1.controladores;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.doThrow;
import org.junit.Before;
import org.junit.Test;

import org.springframework.web.servlet.ModelAndView;


import ar.edu.unlam.tallerweb1.modelo.DatosSolicitudAmbulancia;
import ar.edu.unlam.tallerweb1.modelo.SolicitudUsuarioAmbulancia;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import ar.edu.unlam.tallerweb1.servicios.NoHayAmbulanciasDisponiblesException;
import ar.edu.unlam.tallerweb1.servicios.ServicioAmbulancia;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroLogin;
import ar.edu.unlam.tallerweb1.servicios.UsuarioYaPidioAmbulanciaExeception;

public class ControladorAmbulanciaTest{

	private ModelAndView mav = new ModelAndView();
	private ServicioAmbulancia servicioAmbulancia; // el servicio que va a ser un MOCK
	private ServicioRegistroLogin servicioRegistroLogin;
	private ControladorAmbulancias controladorAmbulancia; // el registro que me va hacer los metodos
	
	

	@Before
	public void testQueSeHaceDespuesDeCadaTest() {// este before se hace despues de cada test

		servicioAmbulancia = mock(ServicioAmbulancia.class); // me crea un mokito que es un objeto para separar y probar
		servicioRegistroLogin= mock(ServicioRegistroLogin.class);
		controladorAmbulancia = new ControladorAmbulancias(servicioAmbulancia, servicioRegistroLogin);
		// individualmente las capas

	}
	
	

	//1. El usuario puede pedir ambulancia
	//2. el usuario no puede pedir ambulancia si no hay ambulancia
	//3. El usuario no puede pedir ambulancia si ya pidio antes   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 

	@Test
	public void testUsuarioPuedePedirAmbulancias() throws ParseException {
		DatosSolicitudAmbulancia solicitud = new DatosSolicitudAmbulancia();
		Usuario user=new Usuario("123456789", "test@gmail.com", 1);
		SolicitudUsuarioAmbulancia soli=new SolicitudUsuarioAmbulancia();
		

		HttpSession http = mock(HttpSession.class);
		HttpServletRequest mockedRequest = mock(HttpServletRequest.class);// necesito hacer estos mock
		when(mockedRequest.getSession()).thenReturn(http);// cuando hago HttpServlet que me devuelva una Session (HTTP)
		when(mockedRequest.getSession().getAttribute("idUsuario")).thenReturn(1);
		when(servicioRegistroLogin.obtenerUsuarioPorId(1)).thenReturn(user);
		when(servicioAmbulancia.pedirAmbulancia(solicitud)).thenReturn(1);
		when(servicioAmbulancia.obtenerSolicitudPORID(1)).thenReturn(soli);
		
		
		 mav= controladorAmbulancia.mostrarSolucitudDeAmbulanciaEnCurso(solicitud, mockedRequest);
		
		assertThat(mav.getViewName()).isEqualTo("solicitudDeAmbulancia");
		
	}
	

	@Test
	public void UsuarioNoPuedePedirAmbulanciaSiYaPidioAntes() throws ParseException {
		DatosSolicitudAmbulancia solicitud = new DatosSolicitudAmbulancia();
		Usuario user=new Usuario("123456789", "test@gmail.com", 1);
		

		HttpSession http = mock(HttpSession.class);
		HttpServletRequest mockedRequest = mock(HttpServletRequest.class);// necesito hacer estos mock
		when(mockedRequest.getSession()).thenReturn(http);// cuando hago HttpServlet que me devuelva una Session (HTTP)
		when(mockedRequest.getSession().getAttribute("idUsuario")).thenReturn(1);
		when(servicioRegistroLogin.obtenerUsuarioPorId(1)).thenReturn(user);
		doThrow(UsuarioYaPidioAmbulanciaExeception.class).when(servicioAmbulancia).pedirAmbulancia(solicitud);

		
	     mav= controladorAmbulancia.mostrarSolucitudDeAmbulanciaEnCurso(solicitud, mockedRequest);
		
		assertThat(mav.getViewName()).isEqualTo("centralAmbulancia");
		assertThat(mav.getModel().get("msj")).isEqualTo("Usted ya tiene una ambulancia pedida en curso");
	}
	
	@Test
	public void usuarioNoPuedePedirAmbulanciaExistente() throws ParseException{		
		DatosSolicitudAmbulancia solicitud = new DatosSolicitudAmbulancia();
		Usuario user=new Usuario("123456789", "test@gmail.com", 1);
		

		HttpSession http = mock(HttpSession.class);
		HttpServletRequest mockedRequest = mock(HttpServletRequest.class);// necesito hacer estos mock
		when(mockedRequest.getSession()).thenReturn(http);// cuando hago HttpServlet que me devuelva una Session (HTTP)
		when(mockedRequest.getSession().getAttribute("idUsuario")).thenReturn(1);
		when(servicioRegistroLogin.obtenerUsuarioPorId(1)).thenReturn(user);
		doThrow(NoHayAmbulanciasDisponiblesException.class).when(servicioAmbulancia).pedirAmbulancia(solicitud);

		
	    ModelAndView mav= controladorAmbulancia.mostrarSolucitudDeAmbulanciaEnCurso(solicitud, mockedRequest);
		
		assertThat(mav.getViewName()).isEqualTo("centralAmbulancia");
		assertThat(mav.getModel().get("msj")).isEqualTo("Disculpe, por el momento no hay ambulancias");
		
	}
	
	@Test
	public void adminPuedeMarcarSolicitudComoAtendida() throws ParseException {
		Usuario user=new Usuario("123456789", "test@gmail.com", 1);
		SolicitudUsuarioAmbulancia soli=new SolicitudUsuarioAmbulancia();
		soli.setAtendido(false);
		
		
		HttpSession http = mock(HttpSession.class);
		HttpServletRequest mockedRequest = mock(HttpServletRequest.class);// necesito hacer estos mock
		when(mockedRequest.getSession()).thenReturn(http);// cuando hago HttpServlet que me devuelva una Session (HTTP)		
		when(servicioRegistroLogin.obtenerUsuarioPorMail("test@gmail.com")).thenReturn(user);
		when(servicioAmbulancia.obtenerConsultaSinAtenderPorUsuario(user)).thenReturn(soli);
//		when(servicioAmbulancia.cambiarEstadoConsulta(soli, true))
		servicioAmbulancia.cambiarEstadoConsulta(soli, true);
		
		
		
		ModelAndView mav= controladorAmbulancia.adminPuedeAtenderConsulta("test@gmail.com");
		
		assertThat(mav.getModel().get("msj")).isEqualTo("Estado consulta cambiado con exito!");
		assertThat(mav.getViewName()).isEqualTo("paginaPrincipalAdmin");	
		
	}







}
>>>>>>> ramaEsteban
