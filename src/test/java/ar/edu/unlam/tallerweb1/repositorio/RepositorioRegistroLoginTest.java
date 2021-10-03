package ar.edu.unlam.tallerweb1.repositorio;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.persistencia.SpringTest;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegistroLogin;

public class RepositorioRegistroLoginTest extends SpringTest { // levanto el entorno de Spring

	private String email = "Cris@gmail.com";
	private String clave = "123456789";
	Usuario usuario = new Usuario();

	// a estas alturas solo podria recibir un usuario correcto

	@Autowired
	private RepositorioRegistroLogin repositorioRegistroLogin;

	@Test
	@Transactional
	@Rollback
	public void testQueMePermitaRegistrarUnUsuarioNuevo() {

		Usuario usuario = givenTengoUnUsuario(email, clave);// creo un usuario
		boolean resultado = whereRegistroUnUsuario(usuario);// registro un usuario. me devuelve un boolean
		thenMePermiteRegistrar(resultado);
		// ver como chequear esto
	}

	private void thenMePermiteRegistrar(boolean resultado) {

		assertTrue(resultado);
	}

	private boolean whereRegistroUnUsuario(Usuario usuario) {
		return repositorioRegistroLogin.registrarUsuario(usuario);
	}

	private Usuario givenTengoUnUsuario(String email, String clave) {
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setContrasenia(clave);
		return usuario;

	}

	@Test
	@Transactional
	@Rollback
	public void testQueNoMePermitaRegistrarUnUsuarioConMailExistente() {

		Usuario usuario = givenTengoUnUsuario(email, clave);
		Usuario usuari2 = givenTengoUnUsuario(email, clave);

		boolean resultadoSi = whereRegistroUnUsuario(usuario);
		boolean resultadoNo = whereRegistroUnUsuario(usuari2);

		thenUsuarioEsRegistradoConMailExistente(resultadoSi, resultadoNo);
	}

	private void thenUsuarioEsRegistradoConMailExistente(boolean resultadoSi, boolean resultadoNo) {
		assertTrue(resultadoSi);
		assertFalse(resultadoNo);// no me deja porque este ya existe
	}

}
