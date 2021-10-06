package ar.edu.unlam.tallerweb1.controladores;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.DatosDeInicioDeSesion;
import ar.edu.unlam.tallerweb1.modelo.DatosRegistroMedico;
import ar.edu.unlam.tallerweb1.modelo.DatosRegistroUsuarioComun;

import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroLogin;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

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
	private DatosRegistroUsuarioComun datosRegistroConContraDiferente = new DatosRegistroUsuarioComun(email, clave,
			claveMal);
	private DatosRegistroUsuarioComun datosRegistroConLongitudIncorrecta = new DatosRegistroUsuarioComun(email,
			claveLongitudMenorAOcho, claveLongitudMenorAOcho);
	private DatosRegistroUsuarioComun datosRegistroConDatosCorrectos = new DatosRegistroUsuarioComun(email, clave,
			repiteClave);

	// datos para registrar un medico
	private String emailUsuarioMedico = "medico@gmail.com";
	private String claveUsuarioMedico = "123456789";
	private String repiteClaveUsuarioMedico = "123456789";

	private DatosRegistroMedico datosRegistroMedico = new DatosRegistroMedico(emailUsuarioMedico, claveUsuarioMedico,
			repiteClaveUsuarioMedico);

	@Before
	public void testQueSeHaceDespuesDeCadaTest() {// este before se hace despues de cada test

		servicioUsuario = mock(ServicioRegistroLogin.class); // me crea un mokito que es un objeto para separar y probar
																// individualmente las capas
		controladorRegistro = new ControladorRegistro(servicioUsuario);

	}

//_____________________________________________________________________________________________________________//	

	@Test
	public void testQueNoMePermiteRegistrarUnUsuarioConContraseñaDiferente() {

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
			DatosRegistroUsuarioComun datosRegistroConContraDiferente) {
		mav = controladorRegistro.registrarNuevoUsuarioComun(datosRegistroConContraDiferente); // esto me devuelve un
																								// MAV

	}

	private void thenRegistroUnUsuarioConContraseniaDiferente(String mensaje) {
		assertThat(mav.getViewName()).isEqualTo("registro"); // me tiene que tirar a registro nuevamente
		assertThat(mav.getModel().get("error")).isEqualTo(mensaje);
	}

//_____________________________________________________________________________________________________________//	

	@Test
	public void testQueNoMePermitaRegistrarUnUsuarioConContraseniaPequenia() {

		doThrow(ClavesCortasException.class).when(servicioUsuario).registrarUsuario(datosRegistroConLongitudIncorrecta);

		whenRegistroUnUsuarioConContraseniaCorta(datosRegistroConLongitudIncorrecta);
		thenRegistroUnUsuarioConContraseniaCorta("Debe tener al menos 8 caracteres");

	}

	private void whenRegistroUnUsuarioConContraseniaCorta(DatosRegistroUsuarioComun datosRegistro2) {
		mav = controladorRegistro.registrarNuevoUsuarioComun(datosRegistro2);
	}

	private void thenRegistroUnUsuarioConContraseniaCorta(String string) {
		assertThat(mav.getViewName()).isEqualTo("registro"); // me tiene que tirar a registro nuevamente
		assertThat(mav.getModel().get("error")).isEqualTo(string);

	}

//_____________________________________________________________________________________________________________//	

	@Test
	public void testQueMePermitaRegistrarExitosamenteUnUsuarioComun() {
		whenRegistroUsuarioComunConContraseniaBien(datosRegistroConDatosCorrectos);
		thenRegistroUsuarioComun();

	}

	private void whenRegistroUsuarioComunConContraseniaBien(DatosRegistroUsuarioComun datosRegistroConDatosCorrectos) {

		mav = controladorRegistro.registrarNuevoUsuarioComun(datosRegistroConDatosCorrectos);
	}

	private void thenRegistroUsuarioComun() {
		assertThat(mav.getViewName()).isEqualTo("index");
	}

//_____________________________________________________________________________________________________________//	

	@Test
	public void testQueMePermitaRegistrarExitosamenteUnMedico() {
		whenRegistroUnMedico(datosRegistroMedico);
		thenRegistroUnMedico();

	}

	private void thenRegistroUnMedico() {
		assertThat(mav.getViewName()).isEqualTo("paginaPrincipalAdmin");

	}

	private void whenRegistroUnMedico(DatosRegistroMedico datosRegistroMedico) {
		mav = controladorRegistro.registrarMedico(datosRegistroMedico);
	}

}
