package ar.edu.unlam.tallerweb1.controladores;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.internal.util.MockUtil;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.DatosRegistroUsuarioComun;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.DatosDeInicioDeSesion;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroLogin;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

public class ControladorRegistroLoginTest {

	private ModelAndView mav= new ModelAndView();
;
	private ServicioRegistroLogin servicioUsuario;
	private ControladorRegistro controladorRegistro;
	private ControladorLogin controladorLogin;

	private String email = "Cris@gmail.com";
	private String clave = "123456789";
	private String repiteClave = "123456789";
	private String claveMal = "5555";
	private String claveLongitudMenorAOcho = "1234";

	private DatosRegistroUsuarioComun datosRegistroConContraDiferente = new DatosRegistroUsuarioComun(email, clave,
			claveMal);
	private DatosRegistroUsuarioComun datosRegistroConLongitudIncorrecta = new DatosRegistroUsuarioComun(email,
			claveLongitudMenorAOcho, claveLongitudMenorAOcho);
	private DatosRegistroUsuarioComun datosRegistroConDatosCorrectos = new DatosRegistroUsuarioComun(email, clave,
			repiteClave);
	private DatosDeInicioDeSesion datosLogin = new DatosDeInicioDeSesion(email, clave);

	private Usuario admin = new Usuario("Cristian@Hotmail.com", "123456789", 3);// simulo el usuario que me trae el
																				// repo.

	@Before
	public void testQueSeHaceDespuesDeCadaTest() {// este before se hace despues de cada test

		servicioUsuario = mock(ServicioRegistroLogin.class); // me crea un mokito que es un objeto para separar y probar
																// individualmente las capas
		controladorRegistro = new ControladorRegistro(servicioUsuario);
		controladorLogin = new ControladorLogin(servicioUsuario);

	}

	@Test
	public void testQueNoMePermiteRegistrarUnUsuarioConContraseñaDiferente() {

		// para usar moquito y me arroje esta exepcion tengo que poner
		doThrow(ClavesDistintasException.class).when(servicioUsuario).registrarUsuario(datosRegistroConContraDiferente);
		// aca solo controlo logica de controlador. Yo creo un mock de servicio que me
		// arroje un claves
		// distintas. para que cuando que cuando registro en el controlador reciba esa
		// escepcion.

		whenRegistroUnUsuarioConContraseñaDiferente(datosRegistroConContraDiferente);// intento registrar estos datos
		thenElregistroFalla("las claves deben ser iguales");

	}

	@Test
	public void testQueNoMePermitaRegistrarUnUsuarioConContraseniaPequenia() {

		doThrow(ClavesCortasException.class).when(servicioUsuario).registrarUsuario(datosRegistroConLongitudIncorrecta);

		whenRegistroUnUsuarioConContraseniaCorta(datosRegistroConLongitudIncorrecta);
		thenElregistroFalla("Debe tener al menos 8 caracteres");

	}

	@Test
	public void testQueMePermitaRegistrarExitosamenteUnUsuario() {
		whenRegistroConContraseniaBien(datosRegistroConDatosCorrectos);
		thenRegistroExitoso();

	}

	// los usuarios comunes pueden registrarse en un formulario comun. Sin embargo
	// para el tipo de usuario medico
	// solo se puede crear desde un admin. La manera de validarlos por ahora es si
	// tienen un boolean de su tipo
	// voy a hacer un controlador especial para las cosas que hace un admin con su
	// test correspondiente.

	@Test
	public void testQueNoMePermiteIniciarSesionSiElUsuarioNoExiste() {

		doThrow(UsuarioInexistenteException.class).when(servicioUsuario).iniciarSesion(datosLogin);
		whenInicioSesionConUnUsuarioInexistente(datosLogin);
		thenInicioSesionConUnUsuarioInexistente();
	}

	@Test
	public void testQueMePermiteIniciarSesionConUsuarioComun() {//cuando este terminado va a funcionar. 
		whenInicioSesionConUsuarioExistente(datosLogin);
		thenInicioSesionConUsuarioExistenteComun();
	}

	@Test // los admin tienen tipoDeUsuario3 //cuando este terminado va a funcionar. 
	public void testQuePermiteIniciarSesionAUnAdmin() {

		whenInicioSesionConUsuarioExistente(datosLogin);
		thenInicioSesionConUsuarioExistenteAdmin();

	}

	@Test // los admin tienen tipoDeUsuario3 //cuando este terminado va a funcionar. 
	public void testQuePermiteIniciarSesionAUnMedico() {

		whenInicioSesionConUsuarioExistente(datosLogin);
		thenInicioSesionConUsuarioExistenteMedico();

	}
	private void thenInicioSesionConUsuarioExistenteAdmin() {
		assertThat (mav.getViewName()).isEqualTo("paginaPrincipalAdmin");
		
	}
	
	private void thenInicioSesionConUsuarioExistenteMedico() {

		assertThat(mav.getViewName()).isEqualTo("paginaPrincipalMedicos");
	}
	
	private void thenInicioSesionConUsuarioExistenteComun() {
		assertThat(mav.getViewName()).isEqualTo(("paginaPrincipal"));
	}


	private void thenInicioSesionConUnUsuarioInexistente() {
		assertThat(mav.getViewName()).isEqualTo(("index"));
		assertThat(mav.getModel().get("error")).isEqualTo(("Usuario Inexistente"));

	}

	private void whenInicioSesionConUnUsuarioInexistente(DatosDeInicioDeSesion datosLogin) {
		mav = controladorLogin.iniciarSesion(datosLogin);

	}



	private void whenInicioSesionConUsuarioExistente(DatosDeInicioDeSesion datosLogin2) {
		mav = controladorLogin.iniciarSesion(datosLogin2);// el mav tiene la vista, con el mensaje de error si es
															// necesario y el usuario

	}

	private void thenRegistroExitoso() {
        assertThat(mav.getViewName()).isEqualTo("paginaPrincipal");
	}

	private void whenRegistroConContraseniaBien(DatosRegistroUsuarioComun datosRegistroConDatosCorrectos) {

		mav = controladorRegistro.registrarNuevoUsuario(datosRegistroConDatosCorrectos);
	}

	private void whenRegistroUnUsuarioConContraseniaCorta(DatosRegistroUsuarioComun datosRegistro2) {
		mav = controladorRegistro.registrarNuevoUsuario(datosRegistro2);
	}

	private void whenRegistroUnUsuarioConContraseñaDiferente(
			DatosRegistroUsuarioComun datosRegistroConContraDiferente) {
		mav = controladorRegistro.registrarNuevoUsuario(datosRegistroConContraDiferente); // esto me devuelve un MAV

	}

	private void thenElregistroFalla(String mensaje) {
		assertThat(mav.getViewName()).isEqualTo("paginaDeRegistro"); // me tiene que tirar a registro nuevamente
		assertThat(mav.getModel().get("error")).isEqualTo(mensaje);
	}

}
