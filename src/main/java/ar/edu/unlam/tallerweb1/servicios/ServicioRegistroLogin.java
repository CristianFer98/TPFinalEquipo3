package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.DatosRegistroUsuarioComun;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.DatosDeInicioDeSesion;
import ar.edu.unlam.tallerweb1.modelo.DatosRegistroMedico;

public interface ServicioRegistroLogin {
	
	Integer registrarUsuario(DatosRegistroUsuarioComun datosRegistro);
	Integer registrarUsuario(DatosRegistroMedico datos);
	Usuario iniciarSesion (DatosDeInicioDeSesion datosLogin);

}
