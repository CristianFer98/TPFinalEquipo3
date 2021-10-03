package ar.edu.unlam.tallerweb1.controladores;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.internal.util.MockUtil;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.DatosRegistroUsuarioComun;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroLogin;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

public class ControladorRegistroLoginTest {

	private ModelAndView mav;
	private ServicioRegistroLogin servicioUsuario;
	private ControladorRegistro controlador;

	private String email = "Cris@gmail.com";
	private String clave = "123456789";
	private String repiteClave = "123456789";
	private String claveMal = "5555";
	private String claveLongitudMenorAOcho = "1234";

	private DatosRegistroUsuarioComun datosRegistroConContraDiferente = new DatosRegistroUsuarioComun(email, clave,claveMal);
	private DatosRegistroUsuarioComun datosRegistroConLongitudIncorrecta = new DatosRegistroUsuarioComun(email,claveLongitudMenorAOcho, claveLongitudMenorAOcho);
	private DatosRegistroUsuarioComun datosRegistroConDatosCorrectos = new DatosRegistroUsuarioComun(email,clave, repiteClave);

	@Before
	public void test() {// este before se hace despues de cada test

		servicioUsuario = mock(ServicioRegistroLogin.class); // me crea un mokito que es un objeto para separar y probar
																// individualmente las capas
		controlador = new ControladorRegistro(servicioUsuario);

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

	private void thenRegistroExitoso() {
		assertThat(mav.getViewName().equals("paginaInicio"));
	}

	private void whenRegistroConContraseniaBien(DatosRegistroUsuarioComun datosRegistroConDatosCorrectos) {
		
		mav = controlador.registrarNuevoUsuario(datosRegistroConDatosCorrectos);
	}

	private void whenRegistroUnUsuarioConContraseniaCorta(DatosRegistroUsuarioComun datosRegistro2) {
		mav = controlador.registrarNuevoUsuario(datosRegistro2);
	}

	private void whenRegistroUnUsuarioConContraseñaDiferente(DatosRegistroUsuarioComun datosRegistroConContraDiferente) {
		mav = controlador.registrarNuevoUsuario(datosRegistroConContraDiferente); // esto me devuelve un MAV

	}

	private void thenElregistroFalla(String mensaje) {
		assertThat(mav.getViewName()).isEqualTo("paginaDeRegistro"); // me tiene que tirar a registro nuevamente
		assertThat(mav.getModel().get("error")).isEqualTo(mensaje);
	}

}
