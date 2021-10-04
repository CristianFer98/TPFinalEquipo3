package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.DatosRegistroUsuarioComun;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.datosDeInicioDeSesion;

public interface ServicioRegistroLogin {
	
	boolean registrarUsuario(DatosRegistroUsuarioComun datosRegistro);
	Usuario iniciarSesion (datosDeInicioDeSesion datosLogin);

}
