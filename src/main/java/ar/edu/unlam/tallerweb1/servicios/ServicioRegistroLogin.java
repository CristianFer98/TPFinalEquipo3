package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.text.ParseException;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.DatosDeInicioDeSesion;
import ar.edu.unlam.tallerweb1.modelo.DatosRegistroUsuario;
import ar.edu.unlam.tallerweb1.modelo.TurnoMedico;

public interface ServicioRegistroLogin {
	
	Integer registrarUsuario(DatosRegistroUsuario datosRegistro) throws ParseException;
	Usuario iniciarSesion (DatosDeInicioDeSesion datosLogin);
	Usuario obtenerUsuarioPorMail(String mail);
	Usuario obtenerUsuarioPorId(Integer id);
	List<TurnoMedico> verMisTurnos(Integer id);
	Double obtenerCalificacion(Integer id);
}
