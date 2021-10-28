package ar.edu.unlam.tallerweb1.controladores;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.DatosDeInicioDeSesion;
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
		controladorLogin = new ControladorLogin(servicioUsuario);
		// individualmente las capas

	}

//________________________________________________________________________________________________________//

	@Test
	public void testQueMePermiteLoguearUnUsuarioComun() {
		datos.setEmail("Cris@gmail.com");
		datos.setContrasenia("123456789");

		Usuario usuario = mock(Usuario.class);

		when(servicioUsuario.iniciarSesion(datos)).thenReturn(usuario);// este usuario es el que mockee

		HttpSession http = mock(HttpSession.class);
		HttpServletRequest mockedRequest = mock(HttpServletRequest.class);// necesito hacer estos mock
		when(mockedRequest.getSession()).thenReturn(http);// cuando hago HttpServlet que me devuelva una Session (HTTP)
		when(usuario.getNumeroDeDeTipoDeUsuario()).thenReturn(1);// cuando haga getNumero que siempre devuelva 1 (esto
																	// faltaba)

		mav = controladorLogin.iniciarSesion(datos, mockedRequest);

		thenLogueoElUsuarioComun(mav);

	}

	private void thenLogueoElUsuarioComun(ModelAndView mav) {
		assertThat(mav.getViewName()).isEqualTo("paginaPrincipal");
	}

//_______________________________________________________________________________________________________________//

	@Test
	public void testQueMePermiteLoguearUnMedico() {
		datos.setEmail("Cris@gmail.com");
		datos.setContrasenia("123456789");

		Usuario usuario = mock(Usuario.class);

		when(servicioUsuario.iniciarSesion(datos)).thenReturn(usuario);// este usuario es el que mockee

		HttpSession http = mock(HttpSession.class);
		HttpServletRequest mockedRequest = mock(HttpServletRequest.class);// necesito hacer estos mock
		when(mockedRequest.getSession()).thenReturn(http);// cuando hago HttpServlet que me devuelva una Session (HTTP)
		when(usuario.getNumeroDeDeTipoDeUsuario()).thenReturn(2);// cuando haga getNumero que siempre devuelva 1 (esto
																	// faltaba)

		mav = controladorLogin.iniciarSesion(datos, mockedRequest);

		thenLogueoElUsuarioMedico(mav);

	}

	private void thenLogueoElUsuarioMedico(ModelAndView mav) {
		assertThat(mav.getViewName()).isEqualTo("paginaPrincipalMedicos");
	}

//___________________________________________________________________________________________________________________//

	@Test
	public void testQueMePermiteLoguearUnAdmin() {
		datos.setEmail("Cris@gmail.com");
		datos.setContrasenia("123456789");

		Usuario usuario = mock(Usuario.class);

		when(servicioUsuario.iniciarSesion(datos)).thenReturn(usuario);// este usuario es el que mockee

		HttpSession http = mock(HttpSession.class);
		HttpServletRequest mockedRequest = mock(HttpServletRequest.class);// necesito hacer estos mock
		when(mockedRequest.getSession()).thenReturn(http);// cuando hago HttpServlet que me devuelva una Session (HTTP)
		when(usuario.getNumeroDeDeTipoDeUsuario()).thenReturn(3);// cuando haga getNumero que siempre devuelva 1 (esto
																	// faltaba)

		mav = controladorLogin.iniciarSesion(datos, mockedRequest);

		thenLogueoElUsuarioAdmin(mav);

	}

	private void thenLogueoElUsuarioAdmin(ModelAndView mav) {
		assertThat(mav.getViewName()).isEqualTo("paginaPrincipalAdmin");
	}

//__________________________________________________________________________________________________________________//

	@Test
	public void testQueNoMePermitaLoguearUnUsuarioInexistente() {
		datos.setEmail("Cris@gmail.com");
		datos.setContrasenia("123456789");

		doThrow(UsuarioInexistenteException.class).when(servicioUsuario).iniciarSesion(datos);

		HttpSession http = mock(HttpSession.class);
		HttpServletRequest mockedRequest = mock(HttpServletRequest.class);
		when(mockedRequest.getSession()).thenReturn(http);

		mav = controladorLogin.iniciarSesion(datos, mockedRequest);

		thenInicioSesionConUsuarioInexistente(mav);
	}

	private void thenInicioSesionConUsuarioInexistente(ModelAndView mav2) {
		assertThat(mav2.getViewName()).isEqualTo("index");

	}
}