package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.controladores.ClavesCortasException;
import ar.edu.unlam.tallerweb1.controladores.ClavesDistintasException;
import ar.edu.unlam.tallerweb1.modelo.DatosRegistroUsuarioComun;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
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
	public boolean iniciarSesion(String email, String contra) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registrarUsuario(DatosRegistroUsuarioComun datos) {
		if (lasClavesSonDistintas(datos) == true) {
			throw new ClavesDistintasException();
		}

		if (lasClavesSonDeMenorLongitud(datos) == true) {
			throw new ClavesCortasException();
		}
		
		Usuario usuario = new Usuario();
		usuario.setEmail(datos.getEmail());
		usuario.setContrasenia(datos.getContrasenia1());
		
		repositorioRegistroLogin.registrarUsuario(usuario);
		return true;
	}

	private boolean lasClavesSonDistintas(DatosRegistroUsuarioComun datos) {
		return !datos.getContrasenia1().equals(datos.getContrasenia2());

	}
	
	private boolean lasClavesSonDeMenorLongitud(DatosRegistroUsuarioComun datos) {
		return datos.getContrasenia1().length() < 8;
	}

}
