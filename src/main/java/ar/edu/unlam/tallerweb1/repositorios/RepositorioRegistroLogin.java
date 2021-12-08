package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.TurnoMedico;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioRegistroLogin {
	
	Integer registrarUsuario(Usuario usuario);
	Usuario obtenerUsuarioPorEmail(String email);
	Usuario iniciarSesion(String email, String contra);
	Usuario obtenerUsuarioPorID(Integer id);
	List<TurnoMedico> verMisTurnos(Integer id);
	List<TurnoMedico> obtenerCalificacionDeMedico(Integer id);
}
