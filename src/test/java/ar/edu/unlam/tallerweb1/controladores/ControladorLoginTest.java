package ar.edu.unlam.tallerweb1.controladores;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.DatosDeInicioDeSesion;
import ar.edu.unlam.tallerweb1.modelo.DatosRegistroMedico;
import ar.edu.unlam.tallerweb1.modelo.DatosRegistroUsuarioComun;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroLogin;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ControladorLoginTest {
	
	private ModelAndView mav = new ModelAndView();
	private ServicioRegistroLogin servicioUsuario; // el servicio que va a ser un MOCK
	private ControladorLogin controladorLogin; // el registro que me va hacer los metodos
	DatosDeInicioDeSesion datos = new DatosDeInicioDeSesion();

	@Before
	public void testQueSeHaceDespuesDeCadaTest() {// este before se hace despues de cada test

		servicioUsuario = mock(ServicioRegistroLogin.class); // me crea un mokito que es un objeto para separar y probar
		// individualmente las capas

	}

//________________________________________________________________________________________________________//

	@Test
	public void testQueMePermiteLoguearUnUsuarioComun() {
		datos.setEmail("Cris@gmail.com");
		datos.setContrasenia("123456789");
		
		when(servicioUsuario.iniciarSesion(datos)).thenReturn(new Usuario());
		HttpSession http = mock(HttpSession.class);
		
		HttpServletRequest  mockedRequest = mock(HttpServletRequest.class);
		when(mockedRequest.getSession()).thenReturn(http);
		
		mav = controladorLogin.iniciarSesion(datos, mockedRequest);
		
	}

	

	private void thenLogueoElUsuario(ModelAndView mav) {
	}

}