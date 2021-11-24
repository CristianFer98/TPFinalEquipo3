package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;


import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.TurnoMedico;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioUsuarioLogueado {

	List <Especialidad> listarEspecialidades();
	List <Usuario> listarMedicosPorEspecialidad(Integer idEspecialidad);
	List<TurnoMedico> listarTurnos(Integer idMedico);
	TurnoMedico reservarTurno(Integer idTurno, Integer idUsuario);
	List<TurnoMedico> verMisTurnos(Integer id);
	Usuario obtenerMedico(Integer idMedico);
	void cancelarTurno(Integer idTurno);
<<<<<<< HEAD
	TurnoMedico getTurnoByID(Integer idTurno, Integer idUsuario);
=======

	TurnoMedico getTurnoByID(Integer idTurno, Integer idUsuario);

>>>>>>> main
	void setPagadoTurno(TurnoMedico turno,Boolean estado);
	TurnoMedico getTurnoByOnlyID(Integer idTurno);
	
	
}
