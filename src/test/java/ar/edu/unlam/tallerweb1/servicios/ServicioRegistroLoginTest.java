package ar.edu.unlam.tallerweb1.servicios;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.tallerweb1.controladores.ClavesCortasException;
import ar.edu.unlam.tallerweb1.controladores.ClavesDistintasException;
import ar.edu.unlam.tallerweb1.modelo.DatosRegistroUsuarioComun;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.datosDeInicioDeSesion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegistroLogin;
import static org.mockito.Mockito.*;

public class ServicioRegistroLoginTest {
	private String email = "Cris@gmail.com";
	private String clave = "123456789";
	private String repiteClave = "123456789";
	private String claveMal = "5555";
	private String claveLongitudMenorAOcho = "1234";

	private DatosRegistroUsuarioComun datosRegistroConContraDiferente = new DatosRegistroUsuarioComun(email, clave,claveMal);
	private DatosRegistroUsuarioComun datosRegistroConLongitudIncorrecta = new DatosRegistroUsuarioComun(email,claveLongitudMenorAOcho, claveLongitudMenorAOcho);
	private DatosRegistroUsuarioComun datosRegistroConDatosCorrectos = new DatosRegistroUsuarioComun(email, clave,repiteClave);
	private Boolean inscribio;
	private ServicioRegistroLoginImpl servicioRegistroLogin;
	private RepositorioRegistroLogin repositorioRegistroLogin;
	private datosDeInicioDeSesion datosLogin = new datosDeInicioDeSesion(email,clave);

	@Before
	public void test() {
		repositorioRegistroLogin = mock(RepositorioRegistroLogin.class);
		servicioRegistroLogin = new ServicioRegistroLoginImpl(repositorioRegistroLogin);
		inscribio = false;
	}

	@Test(expected = ClavesDistintasException.class)
	public void testQueNoMePermitaRegistrarConContraseniaDiferente() {

		whenRegistroConContraseniaDiferente(datosRegistroConContraDiferente);
		//no pongo el then porque espero que al registrar me tire la exception y nada mas
	}


	private void whenRegistroConContraseniaDiferente(DatosRegistroUsuarioComun datosRegistroConContraDiferente) {
		servicioRegistroLogin.registrarUsuario(datosRegistroConContraDiferente); //esto arroja la exception
	}

	 @Test(expected = ClavesCortasException.class)
	 public void testQueNoMePermitaRegistrarmeConUnaContraseniaCorta() {
		 
		 whenRegistroConContraCorta(datosRegistroConLongitudIncorrecta); //lo mismo que lo anterior.
	 }

	private void whenRegistroConContraCorta(DatosRegistroUsuarioComun datosRegistroConLongitudIncorrecta) {
		servicioRegistroLogin.registrarUsuario(datosRegistroConLongitudIncorrecta);//me tira la exception esperada
	}
	
	@Test
	public void testQueMeRegistraExitosamenteUnUsuarioComun() {
		whenRegistroConDatosCorrectos(datosRegistroConDatosCorrectos);
		thenRegistroConDatosCorrectos();
		
	}

	private void thenRegistroConDatosCorrectos() {
		assertThat(inscribio == true);
	}

	private void whenRegistroConDatosCorrectos(DatosRegistroUsuarioComun datosRegistroConDatosCorrectos2) {
	inscribio =	servicioRegistroLogin.registrarUsuario(datosRegistroConDatosCorrectos2);
		
	}
	
	@Test
	public void testQueMePermiteIniciarSesionConUsuarioComun() {
	givenTengoUnUsuarioRegistrado(datosRegistroConDatosCorrectos);
	Usuario usuario = whenInicioSesionConUnUsuarioComun(datosLogin);
	thenInicioSesionConUnUsuarioComun(usuario);
	}

	private void thenInicioSesionConUnUsuarioComun(Usuario usuario) {
		assertThat(usuario != null);
	}

	private Usuario whenInicioSesionConUnUsuarioComun(datosDeInicioDeSesion datosLogin2) {
		Usuario usuario = servicioRegistroLogin.iniciarSesion(datosLogin2);
		return usuario;
	}

	private void givenTengoUnUsuarioRegistrado(DatosRegistroUsuarioComun datosRegistroConDatosCorrectos2) {
		servicioRegistroLogin.registrarUsuario(datosRegistroConDatosCorrectos2);
		
	}
	
}
