package ar.edu.unlam.tallerweb1.repositorio;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.controladores.ClavesDistintasException;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.persistencia.SpringTest;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegistroLogin;
import ar.edu.unlam.tallerweb1.repositorios.emailExistenteException;

public class RepositorioRegistroLoginTest extends SpringTest { // levanto el entorno de Spring

	private String email = "Cristian@gmail.com";
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
		Integer id =whereRegistroUnUsuario(usuario);// registro un usuario. me devuelve un boolean
		thenMePermiteRegistrar(usuario.getIdUsuario());
		// ver como chequear esto
	}
	
	private Usuario givenTengoUnUsuario(String email, String clave) {
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setContrasenia(clave);
		usuario.setNumeroDeDeTipoDeUsuario(1);
		return usuario;

	}
	
	private Integer whereRegistroUnUsuario(Usuario usuario) {
		Integer id = repositorioRegistroLogin.registrarUsuario(usuario);
		return id;
	}

	private void thenMePermiteRegistrar(Integer id) {
		//Integer ve = 1;//no se como hacer que se reinicie por cada test el repositorio por eso le puse 2
		
			assertThat(id).isNotNull();//si quiero que funcione tengo que poner el hibernate context en CREATE
	}


	@Transactional
	@Rollback
	@Test(expected = emailExistenteException.class)
	public void testQueNoMePermitaRegistrarUnUsuarioConMailExistente() {

		Usuario usuario = givenTengoUnUsuario(email, clave);
		Usuario usuari2 = givenTengoUnUsuario(email, clave);

		whereRegistroUnUsuario(usuario);
		whereRegistroUnUsuario(usuari2);

	}
	
	

	@Transactional
	@Rollback
	@Test
	public void testQueMePermitaIniciarSesionAUnUsuarioComun() { //seria lo mismo para los otros tipo de usuarios

		Usuario usuario = new Usuario ("123456789","Gaston@gmail.com",1);
		
		givenRegistroUnUsuario(usuario);
		Usuario usuarioRecibidoAlIniciarSesion = whereInicioSesion(usuario.getEmail(), usuario.getContrasenia());
		thenInicioSesion(usuario, usuarioRecibidoAlIniciarSesion);

	}

	private void thenInicioSesion(Usuario usuario, Usuario usuarioRecibidoAlIniciarSesion) {
		assertThat(usuario.getContrasenia()).isEqualTo(usuarioRecibidoAlIniciarSesion.getContrasenia());
		
	}

	private Usuario whereInicioSesion(String email, String contra) {
		Usuario usuario = repositorioRegistroLogin.iniciarSesion(email, contra);
		return usuario;
	}

	private void givenRegistroUnUsuario(Usuario usuario) {
		repositorioRegistroLogin.registrarUsuario(usuario);
	}
	
	

}
