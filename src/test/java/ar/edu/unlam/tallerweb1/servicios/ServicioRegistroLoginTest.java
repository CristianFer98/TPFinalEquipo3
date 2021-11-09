package ar.edu.unlam.tallerweb1.servicios;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.tallerweb1.controladores.ClavesCortasException;
import ar.edu.unlam.tallerweb1.controladores.ClavesDistintasException;
import ar.edu.unlam.tallerweb1.controladores.UsuarioInexistenteException;
import ar.edu.unlam.tallerweb1.modelo.DatosDeInicioDeSesion;
import ar.edu.unlam.tallerweb1.modelo.DatosRegistroUsuario;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegistroLogin;
import static org.mockito.Mockito.*;

import java.text.ParseException;

import static org.assertj.core.api.Assertions.assertThat;

public class ServicioRegistroLoginTest {
	private String email = "Cristian@gmail.com";
	private String clave = "123456789";
	private String claveMal = "5555";
	private String claveLongitudMenorAOcho = "1234";

	private DatosRegistroUsuario datosRegistroConContraDiferente = new DatosRegistroUsuario(email, clave, claveMal);
	private DatosRegistroUsuario datosRegistroConLongitudIncorrecta = new DatosRegistroUsuario(email,
			claveLongitudMenorAOcho, claveLongitudMenorAOcho);
	private ServicioRegistroLoginImpl servicioRegistroLogin;
	private RepositorioRegistroLogin repositorioRegistroLogin;

	@Before
	public void test() {
		repositorioRegistroLogin = mock(RepositorioRegistroLogin.class);
		servicioRegistroLogin = new ServicioRegistroLoginImpl(repositorioRegistroLogin);
	}
//________________________________________________________________________________________________________________//	

	@Test(expected = ClavesDistintasException.class)
	public void testQueNoMePermitaRegistrarConContraseniaDiferente() throws ParseException {

		whenRegistroConContraseniaDiferente(datosRegistroConContraDiferente);
		// no pongo el then porque espero que al registrar me tire la exception y nada
		// mas
	}

	private void whenRegistroConContraseniaDiferente(DatosRegistroUsuario datosRegistroConContraDiferente)
			throws ParseException {
		servicioRegistroLogin.registrarUsuario(datosRegistroConContraDiferente); // esto arroja la exception
	}

//________________________________________________________________________________________________________________//	

	@Test(expected = ClavesCortasException.class)
	public void testQueNoMePermitaRegistrarmeConUnaContraseniaCorta() throws ParseException {

		whenRegistroConContraCorta(datosRegistroConLongitudIncorrecta); // lo mismo que lo anterior.
	}

	private void whenRegistroConContraCorta(DatosRegistroUsuario datosRegistroConLongitudIncorrecta)
			throws ParseException {
		servicioRegistroLogin.registrarUsuario(datosRegistroConLongitudIncorrecta);// me tira la exception esperada
	}

//________________________________________________________________________________________________________________//	

	@Test
	public void testQueMeRegistraExitosamenteUnUsuarioComun() throws ParseException {

		DatosRegistroUsuario datos = new DatosRegistroUsuario();
		datos.setContrasenia1("123456789");
		datos.setContrasenia2("123456789");
		datos.setEdad("2000-08-08");
		datos.setEmail("Cris@gmail.com");
		datos.setNombre("Cristian");
		datos.setNumeroDeTipoDeUsuario(1);

		when(repositorioRegistroLogin.registrarUsuario(new Usuario())).thenReturn(1);

		Integer idUsuario = servicioRegistroLogin.registrarUsuario(datos);

		assertThat(idUsuario == 1);

	}

//_________________________________________________________________________________________//

	@Test
	public void testQueMePermiteIniciarSesion() {
		DatosDeInicioDeSesion datos = new DatosDeInicioDeSesion();
		datos.setContrasenia("123456789");
		datos.setEmail("Cristian@gmail.com");

		when(repositorioRegistroLogin.iniciarSesion(datos.getEmail(), datos.getContrasenia()))
				.thenReturn(new Usuario());

		Usuario usuario = servicioRegistroLogin.iniciarSesion(datos);
		assertThat(usuario).isNotNull();
	}
	
	@Test (expected = UsuarioInexistenteException.class)
	public void testQueNoMePermiteIniciarSesionConUnMailInexistente() {
		DatosDeInicioDeSesion datos = new DatosDeInicioDeSesion();
		datos.setContrasenia("123456789");
		datos.setEmail("Cristian@gmail.com");
		
		when(repositorioRegistroLogin.iniciarSesion(datos.getEmail(), datos.getContrasenia())).thenReturn(null);
		
		servicioRegistroLogin.iniciarSesion(datos);
		
	}

}
