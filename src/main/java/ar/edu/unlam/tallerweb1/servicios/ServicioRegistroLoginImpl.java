package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.controladores.ClavesCortasException;
import ar.edu.unlam.tallerweb1.controladores.ClavesDistintasException;
import ar.edu.unlam.tallerweb1.modelo.DatosRegistroUsuarioComun;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.DatosDeInicioDeSesion;
import ar.edu.unlam.tallerweb1.modelo.DatosRegistroMedico;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegistroLogin;

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
		//el siguiente metodo puede arrojar una exception
		Usuario usuario = repositorioRegistroLogin.iniciarSesion(datosLogin.getEmail(),datosLogin.getContrasenia());
		return usuario;
	}

	@Override
	public boolean registrarUsuario(DatosRegistroUsuarioComun datos) {
		String clave = datos.getContrasenia1();
		String repiteClave = datos.getContrasenia2();
		
		if (lasClavesSonDistintas(clave, repiteClave)) {
			throw new ClavesDistintasException();
		}

		if (lasClavesSonDeMenorLongitud(clave)) {
			throw new ClavesCortasException();
		}
		
		Usuario usuario = new Usuario();
		usuario.setEmail(datos.getEmail());
		usuario.setContrasenia(datos.getContrasenia1());
		
		return repositorioRegistroLogin.registrarUsuario(usuario);

	}
	
	@Override
	public boolean registrarUsuario(DatosRegistroMedico datos) {
		String clave = datos.getContrasenia1();
		String repiteClave = datos.getContrasenia2();
		
		if (lasClavesSonDistintas(clave, repiteClave)) {
			throw new ClavesDistintasException();
		}

		if (lasClavesSonDeMenorLongitud(clave)) {
			throw new ClavesCortasException();
		}
		
		Usuario usuario = new Usuario();
		usuario.setEmail(datos.getEmail());
		usuario.setContrasenia(datos.getContrasenia1());
		
		return repositorioRegistroLogin.registrarUsuario(usuario);
		
	}

	private boolean lasClavesSonDistintas(String clave, String repiteclave) {
		return clave.equals(repiteclave);

	}
	
	private boolean lasClavesSonDeMenorLongitud(String contrasenia) {
		return contrasenia.length() < 8;
	}



}
