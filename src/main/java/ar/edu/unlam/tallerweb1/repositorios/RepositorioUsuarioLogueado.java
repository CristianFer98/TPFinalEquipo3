package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.TurnoMedico;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioUsuarioLogueado {

	
	List <Especialidad> listarEspecialidades();
	List<Usuario> listarMedicosPorEspecialidad(Integer idEspecialidad);
	List<TurnoMedico> listarTurnosDisponibles(Integer idMedico);
	boolean reservarTurno(Integer idTurno, Integer idUsuario);
	List<TurnoMedico> verMisTurnos(Integer id);
}
