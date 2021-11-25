package ar.edu.unlam.tallerweb1.servicios;

import java.sql.Time;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.DatosAgendaMesMedico;
import ar.edu.unlam.tallerweb1.modelo.DatosDeActualizacionPerfilMedico;
import ar.edu.unlam.tallerweb1.modelo.Dias;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.TurnoMedico;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioSesionMedico {

	Boolean cargarDatos(DatosDeActualizacionPerfilMedico datos, Integer id);
	Usuario obtenerInformacion(Integer id);
	List <Especialidad> obtenerListaDeEspecializaciones();
	List<Dias> obtenerDiasDeLaSemana();
	boolean cargarAgenda(DatosAgendaMesMedico datos, Integer id, Time horarioComienzoJornada, Time horarioFinJornada, Time duracionDeTurno);
	List<TurnoMedico> verCompromisos(Integer id);
	
}
