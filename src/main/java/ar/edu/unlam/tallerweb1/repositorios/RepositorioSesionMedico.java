package ar.edu.unlam.tallerweb1.repositorios;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.DatosDeActualizacionPerfilMedico;
import ar.edu.unlam.tallerweb1.modelo.Dias;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.TurnoMedico;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioSesionMedico {

		Usuario cargarDatos(DatosDeActualizacionPerfilMedico datos, Integer id);
		Usuario obtenerUsuarioPorId(Integer idUsuario);
		List<Especialidad> obtenerListaDeEspecializacion();
		List<Dias> obtenerDiasDeLaSemana();
		boolean cargarAgenda(ArrayList<TurnoMedico> turnosNuevos, Integer id);
		List<TurnoMedico> verCompromisos(Integer id);
		void darDeBajaTurno(Integer idTurno);
		List<TurnoMedico> obtenerCalificacionDeMedico(Integer id);
}
