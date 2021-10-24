package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;


import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.TurnoMedico;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioUsuarioLogueado {

	List <Especialidad> listarEspecialidades();
	List <Usuario> listarMedicosPorEspecialidad(Integer idEspecialidad);
	List<TurnoMedico> listarTurnos(Integer idMedico);
	boolean reservarTurno(Integer idTurno, Integer idUsuario);
	
}