package ar.edu.unlam.tallerweb1.servicios;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.tallerweb1.controladores.ClavesCortasException;
import ar.edu.unlam.tallerweb1.controladores.ClavesDistintasException;
import ar.edu.unlam.tallerweb1.modelo.DatosRegistroUsuarioComun;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.DatosDeInicioDeSesion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegistroLogin;
import static org.mockito.Mockito.*;

public class ServicioRegistroTest {
	private String email = "Cristian@gmail.com";
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
	private DatosDeInicioDeSesion datosLogin = new DatosDeInicioDeSesion(email,clave);

	@Before
	public void test() {
		repositorioRegistroLogin = mock(RepositorioRegistroLogin.class);
		servicioRegistroLogin = new ServicioRegistroLoginImpl(repositorioRegistroLogin);
		inscribio = false;
	}
	
//________________________________________________________________________________________________________________//	

	@Test(expected = ClavesDistintasException.class)
	public void testQueNoMePermitaRegistrarConContraseniaDiferente() {

		whenRegistroConContraseniaDiferente(datosRegistroConContraDiferente);
		//no pongo el then porque espero que al registrar me tire la exception y nada mas
	}


	private void whenRegistroConContraseniaDiferente(DatosRegistroUsuarioComun datosRegistroConContraDiferente) {
		servicioRegistroLogin.registrarUsuario(datosRegistroConContraDiferente); //esto arroja la exception
	}

//________________________________________________________________________________________________________________//	

	 @Test(expected = ClavesCortasException.class)
	 public void testQueNoMePermitaRegistrarmeConUnaContraseniaCorta() {
		 
		 whenRegistroConContraCorta(datosRegistroConLongitudIncorrecta); //lo mismo que lo anterior.
	 }

	private void whenRegistroConContraCorta(DatosRegistroUsuarioComun datosRegistroConLongitudIncorrecta) {
		servicioRegistroLogin.registrarUsuario(datosRegistroConLongitudIncorrecta);//me tira la exception esperada
	}
	
//________________________________________________________________________________________________________________//	

	
	@Test
	public void testQueMeRegistraExitosamenteUnUsuarioComun() {
		Integer idRecibida=  whenRegistroConDatosCorrectos(datosRegistroConDatosCorrectos);
		thenRegistroConDatosCorrectos(idRecibida);
		
	}

	private Integer whenRegistroConDatosCorrectos(DatosRegistroUsuarioComun datosRegistroConDatosCorrectos2) {
		return servicioRegistroLogin.registrarUsuario(datosRegistroConDatosCorrectos2);
			
		}
		
	private void thenRegistroConDatosCorrectos(Integer idRecibida) {
		Integer ve=1;
		assertEquals(idRecibida,ve);
		
		//pienso que este metodo no anda porque se esta usando mock y no se esta guardando nada en la bd
	}

	

	
	
}
