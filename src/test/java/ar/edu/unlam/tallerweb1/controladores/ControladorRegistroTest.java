package ar.edu.unlam.tallerweb1.controladores;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.DatosRegistroUsuario;
import ar.edu.unlam.tallerweb1.repositorios.emailExistenteException;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroLogin;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import java.text.ParseException;

public class ControladorRegistroTest {

	private ModelAndView mav = new ModelAndView();

	private ServicioRegistroLogin servicioUsuario; // el servicio que va a ser un MOCK
	private ControladorRegistro controladorRegistro; // el registro que me va hacer los metodos

	// datos para comprobar los ingresos para los metodos
	private String email = "Cris@gmail.com";
	private String clave = "123456789";
	private String repiteClave = "123456789";
	private String claveMal = "5555";
	private String claveLongitudMenorAOcho = "1234";

	// los objetos datosDeRegistro para un usuario comun.
	private DatosRegistroUsuario datosRegistroConContraDiferente = new DatosRegistroUsuario(email, clave,
			claveMal);
	private DatosRegistroUsuario datosRegistroConLongitudIncorrecta = new DatosRegistroUsuario(email,
			claveLongitudMenorAOcho, claveLongitudMenorAOcho);
	private DatosRegistroUsuario datosRegistroConDatosCorrectos = new DatosRegistroUsuario(email, clave,
			repiteClave);

	// datos para registrar un medico
	private String emailUsuarioMedico = "medico@gmail.com";
	private String claveUsuarioMedico = "123456789";
	private String repiteClaveUsuarioMedico = "123456789";

	private DatosRegistroUsuario datosRegistroMedico = new DatosRegistroUsuario(emailUsuarioMedico, claveUsuarioMedico,
			repiteClaveUsuarioMedico);

	@Before
	public void testQueSeHaceDespuesDeCadaTest() {// este before se hace despues de cada test

		servicioUsuario = mock(ServicioRegistroLogin.class); // me crea un mokito que es un objeto para separar y probar
																// individualmente las capas
		controladorRegistro = new ControladorRegistro(servicioUsuario);

	}

//_____________________________________________________________________________________________________________//	

	@Test
	public void testQueNoMePermiteRegistrarUnUsuarioConContraseñaDiferente() throws ParseException {

		// para usar moquito y me arroje esta exepcion tengo que poner
		doThrow(ClavesDistintasException.class).when(servicioUsuario).registrarUsuario(datosRegistroConContraDiferente);
		// aca solo controlo logica de controlador. Yo creo un mock de servicio que me
		// arroje un claves distintas. para que cuando que cuando registro en el
		// controlador reciba esa
		// excepcion.

		whenRegistroUnUsuarioConContraseñaDiferente(datosRegistroConContraDiferente);// intento registrar estos datos
		thenRegistroUnUsuarioConContraseniaDiferente("las claves deben ser iguales");

	}

	private void whenRegistroUnUsuarioConContraseñaDiferente(
			DatosRegistroUsuario datosRegistroConContraDiferente) throws ParseException {
		mav = controladorRegistro.registrarNuevoUsuario(datosRegistroConContraDiferente); // esto me devuelve un
																								// MAV

	}

	private void thenRegistroUnUsuarioConContraseniaDiferente(String mensaje) {
		assertThat(mav.getViewName()).isEqualTo("registro"); // me tiene que tirar a registro nuevamente
		assertThat(mav.getModel().get("error")).isEqualTo(mensaje);
	}

//_____________________________________________________________________________________________________________//	

	@Test
	public void testQueNoMePermitaRegistrarUnUsuarioConContraseniaPequenia() throws ParseException {

		doThrow(ClavesCortasException.class).when(servicioUsuario).registrarUsuario(datosRegistroConLongitudIncorrecta);

		whenRegistroUnUsuarioConContraseniaCorta(datosRegistroConLongitudIncorrecta);
		thenRegistroUnUsuarioConContraseniaCorta("Debe tener al menos 8 caracteres");

	}

	private void whenRegistroUnUsuarioConContraseniaCorta(DatosRegistroUsuario datosRegistro2) throws ParseException {
		mav = controladorRegistro.registrarNuevoUsuario(datosRegistro2);
	}

	private void thenRegistroUnUsuarioConContraseniaCorta(String string) {
		assertThat(mav.getViewName()).isEqualTo("registro"); // me tiene que tirar a registro nuevamente
		assertThat(mav.getModel().get("error")).isEqualTo(string);

	}

//_____________________________________________________________________________________________________________//	

	@Test
	public void testQueMePermitaRegistrarExitosamenteUnUsuarioComun() throws ParseException {
		whenRegistroUsuarioComunConContraseniaBien(datosRegistroConDatosCorrectos);
		thenRegistroUsuarioComun();

	}

	private void whenRegistroUsuarioComunConContraseniaBien(DatosRegistroUsuario datosRegistroConDatosCorrectos) throws ParseException {

		mav = controladorRegistro.registrarNuevoUsuario(datosRegistroConDatosCorrectos);
	}

	private void thenRegistroUsuarioComun() {
		assertThat(mav.getViewName()).isEqualTo("index");
	}

//_____________________________________________________________________________________________________________//	

	@Test
	public void testQueMePermitaRegistrarExitosamenteUnMedico() throws ParseException {
		whenRegistroUnMedico(datosRegistroMedico);
		thenRegistroUnMedico();

	}

	private void thenRegistroUnMedico() {
		assertThat(mav.getViewName()).isEqualTo("paginaPrincipalAdmin");

	}

	private void whenRegistroUnMedico(DatosRegistroUsuario datosRegistroMedico) throws ParseException {
		mav = controladorRegistro.registrarNuevoUsuario(datosRegistroMedico);
	}

//______________________________________________________________________________________________________________//

	@Test
	public void testQueNoMePermitaRegistrarUnUsuarioConMailExistente() throws ParseException {
		doThrow(emailExistenteException.class).when(servicioUsuario).registrarUsuario(datosRegistroConDatosCorrectos);

		whenRegistroUnUsuarioConEmailExistente(datosRegistroConDatosCorrectos);
		thenRegistroUnUsuarioConEmailExistente("Ese usuario es Existente");

	}

	private void whenRegistroUnUsuarioConEmailExistente(DatosRegistroUsuario datosRegistro2) throws ParseException {
		mav = controladorRegistro.registrarNuevoUsuario(datosRegistro2);
	}

	private void thenRegistroUnUsuarioConEmailExistente(String string) {
		assertThat(mav.getViewName()).isEqualTo("registro"); // me tiene que tirar a registro nuevamente
		assertThat(mav.getModel().get("error")).isEqualTo(string);

	}

}
