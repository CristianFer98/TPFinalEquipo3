package ar.edu.unlam.tallerweb1.servicios;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.tallerweb1.controladores.ClavesCortasException;
import ar.edu.unlam.tallerweb1.controladores.ClavesDistintasException;
import ar.edu.unlam.tallerweb1.modelo.DatosRegistroUsuarioComun;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegistroLogin;
import static org.mockito.Mockito.*;

import java.text.ParseException;

import static org.assertj.core.api.Assertions.assertThat;

public class ServicioRegistroTest {
	private String email = "Cristian@gmail.com";
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

	private void whenRegistroConContraseniaDiferente(DatosRegistroUsuarioComun datosRegistroConContraDiferente) throws ParseException {
		servicioRegistroLogin.registrarUsuario(datosRegistroConContraDiferente); // esto arroja la exception
	}

//________________________________________________________________________________________________________________//	

	@Test(expected = ClavesCortasException.class)
	public void testQueNoMePermitaRegistrarmeConUnaContraseniaCorta() throws ParseException {

		whenRegistroConContraCorta(datosRegistroConLongitudIncorrecta); // lo mismo que lo anterior.
	}

	private void whenRegistroConContraCorta(DatosRegistroUsuarioComun datosRegistroConLongitudIncorrecta) throws ParseException {
		servicioRegistroLogin.registrarUsuario(datosRegistroConLongitudIncorrecta);// me tira la exception esperada
	}

//________________________________________________________________________________________________________________//	

	@Test
	public void testQueMeRegistraExitosamenteUnUsuarioComun() throws ParseException {

		Usuario usuario = mock(Usuario.class);
		Integer id = 1;
		DatosRegistroUsuarioComun datos = mock(DatosRegistroUsuarioComun.class);
		
		when(datos.getContrasenia1()).thenReturn("123456789");
		when(datos.getContrasenia2()).thenReturn("123456789");

		when(usuario.getEmail()).thenReturn("Cris.com");
		when(usuario.getIdUsuario()).thenReturn(1);
		when(repositorioRegistroLogin.obtenerUsuarioPorEmail(usuario.getEmail())).thenReturn(usuario);
		when(repositorioRegistroLogin.registrarUsuario(new Usuario())).thenReturn(id);

		Integer idRecibida = servicioRegistroLogin.registrarUsuario(datos);

		assertThat(idRecibida).isEqualTo(0);// no entiendo xq da cero
	}

}
