package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.DatosRegistroUsuarioComun;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioRegistroLogin {
	
	boolean registrarUsuario(DatosRegistroUsuarioComun datos);
	boolean iniciarSesion (String email, String contra);

}
