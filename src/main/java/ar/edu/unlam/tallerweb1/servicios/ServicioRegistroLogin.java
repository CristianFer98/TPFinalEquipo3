package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.DatosRegistroUsuarioComun;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.emailExistenteException;

import java.text.ParseException;

import ar.edu.unlam.tallerweb1.modelo.DatosDeInicioDeSesion;
import ar.edu.unlam.tallerweb1.modelo.DatosRegistroMedico;

public interface ServicioRegistroLogin {
	
	Integer registrarUsuario(DatosRegistroUsuarioComun datosRegistro) throws ParseException;
	Integer registrarUsuario(DatosRegistroMedico datos) throws emailExistenteException, ParseException;
	Usuario iniciarSesion (DatosDeInicioDeSesion datosLogin);
	Usuario obtenerUsuarioPorMail(String mail);
	Usuario obtenerUsuarioPorId(Integer id);

}
