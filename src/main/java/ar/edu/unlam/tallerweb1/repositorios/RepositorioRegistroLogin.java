package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.DatosRegistroUsuarioComun;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioRegistroLogin {
	
	Integer registrarUsuario(Usuario usuario);
	Usuario obtenerUsuarioPorEmail(String email);
	Usuario iniciarSesion(String email, String contra);
	Usuario obtenerUsuarioPorID(Integer id);

}
