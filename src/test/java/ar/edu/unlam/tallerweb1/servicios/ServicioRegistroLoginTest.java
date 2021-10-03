package ar.edu.unlam.tallerweb1.servicios;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.tallerweb1.controladores.ClavesCortasException;
import ar.edu.unlam.tallerweb1.controladores.ClavesDistintasException;
import ar.edu.unlam.tallerweb1.modelo.DatosRegistroUsuarioComun;
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
	ServicioRegistroLoginImpl servicioRegistroLogin;
	RepositorioRegistroLogin repositorioRegistroLogin;

	@Before
	public void test() {

		servicioRegistroLogin = new ServicioRegistroLoginImpl(repositorioRegistroLogin);
		repositorioRegistroLogin = mock(RepositorioRegistroLogin.class);
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
}
