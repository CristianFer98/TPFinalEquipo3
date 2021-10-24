package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.controladores.ClavesCortasException;
import ar.edu.unlam.tallerweb1.controladores.ClavesDistintasException;
import ar.edu.unlam.tallerweb1.controladores.UsuarioInexistenteException;
import ar.edu.unlam.tallerweb1.modelo.DatosRegistroUsuarioComun;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.DatosDeInicioDeSesion;
import ar.edu.unlam.tallerweb1.modelo.DatosRegistroMedico;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegistroLogin;
import ar.edu.unlam.tallerweb1.repositorios.emailExistenteException;

@Service
@Transactional
public class ServicioRegistroLoginImpl implements ServicioRegistroLogin {

	RepositorioRegistroLogin repositorioRegistroLogin;

	@Autowired
	public ServicioRegistroLoginImpl(RepositorioRegistroLogin repositorioRegistroLogin) {
		this.repositorioRegistroLogin = repositorioRegistroLogin;
	}

	@Override
	public Usuario iniciarSesion(DatosDeInicioDeSesion datosLogin) {
		Usuario usuario;

		if (repositorioRegistroLogin.iniciarSesion(datosLogin.getEmail(), datosLogin.getContrasenia()) == null) {// no encuentra ninguna
			throw new UsuarioInexistenteException();
		} else {
			usuario = repositorioRegistroLogin.iniciarSesion(datosLogin.getEmail(), datosLogin.getContrasenia());
		}

		return usuario;
	}

	
	//refactorizar los metodos
	@Override
	public Integer registrarUsuario(DatosRegistroUsuarioComun datos) throws emailExistenteException {
		String clave = datos.getContrasenia1();
		String repiteClave = datos.getContrasenia2();
		Integer idRecibida;

		if (lasClavesSonDistintas(clave, repiteClave) == true) {
			throw new ClavesDistintasException();
		}

		if (lasClavesSonDeMenorLongitud(clave) == true) {
			throw new ClavesCortasException();
		}

		Usuario usuario = new Usuario();
		usuario.setEmail(datos.getEmail());
		usuario.setContrasenia(datos.getContrasenia1());
		usuario.setNumeroDeDeTipoDeUsuario(datos.getNumeroDeDeTipoDeUsuario());
		usuario.setNombre(datos.getNombre());
		usuario.setEdad(datos.getEdad());

		idRecibida = repositorioRegistroLogin.registrarUsuario(usuario);
		return idRecibida;

	}

	@Override
	public Integer registrarUsuario(DatosRegistroMedico datos)throws emailExistenteException {
		String clave = datos.getContrasenia1();
		String repiteClave = datos.getContrasenia2();
		Integer idRecibida;

		if (lasClavesSonDistintas(clave, repiteClave) == true) {
			throw new ClavesDistintasException();
		}

		if (lasClavesSonDeMenorLongitud(clave) == true) {
			throw new ClavesCortasException();
		}

		Usuario usuario = new Usuario();
		usuario.setEmail(datos.getEmail());
		usuario.setContrasenia(datos.getContrasenia1());
		usuario.setNumeroDeDeTipoDeUsuario(datos.getNumeroDeDeTipoDeUsuario());
		usuario.setEdad(datos.getEdad());
		usuario.setNombre(datos.getNombre());
		
		idRecibida = repositorioRegistroLogin.registrarUsuario(usuario);
		return idRecibida;

	}

	private boolean lasClavesSonDistintas(String clave, String repiteclave) {
		if (!clave.equals(repiteclave)) {
			return true;
		}
		return false;

	}

	private boolean lasClavesSonDeMenorLongitud(String contrasenia) {
		if (contrasenia.length() < 8) {
			return true;
		}
		return false;
	}

}
