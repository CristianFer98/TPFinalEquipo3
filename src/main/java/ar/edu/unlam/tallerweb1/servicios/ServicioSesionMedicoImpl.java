package ar.edu.unlam.tallerweb1.servicios;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.DatosAgendaMesMedico;
import ar.edu.unlam.tallerweb1.modelo.DatosDeActualizacionPerfilMedico;
import ar.edu.unlam.tallerweb1.modelo.Dias;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.TurnoMedico;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioSesionMedico;

@Service
@Transactional
public class ServicioSesionMedicoImpl implements ServicioSesionMedico {

	private RepositorioSesionMedico repositorio;

	@Autowired
	public ServicioSesionMedicoImpl(RepositorioSesionMedico repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Boolean cargarDatos(DatosDeActualizacionPerfilMedico datos, Integer id) {
		repositorio.cargarDatos(datos, id);
		return true;

	}

	@Override
	public Usuario obtenerInformacion(Integer id) {// utilizo el metodo que me devuelve por id
		if (repositorio.obtenerUsuarioPorId(id) != null) {
			return repositorio.obtenerUsuarioPorId(id);
		}
		return null;
	}

	@Override
	public List<Especialidad> obtenerListaDeEspecializaciones() {
		return repositorio.obtenerListaDeEspecializacion();

	}

	@Override
	public List<Dias> obtenerDiasDeLaSemana() {
		return repositorio.obtenerDiasDeLaSemana();
	}

	@Override
	public boolean cargarAgenda(DatosAgendaMesMedico datos, Integer id, Time horarioComienzoJornada,
			Time horarioFinJornada, Time duracionDeTurno) {

		Boolean cargo;

		LocalDateTime inicioDeActividadMensual = obtenerInicioDeActividadMensual(horarioComienzoJornada,horarioFinJornada);
		LocalDateTime finDeActividadMensual = obtenerFinDeActividadMensual(horarioComienzoJornada, horarioFinJornada);
		LocalTime duracionConsulta = obtenerDuracionConsulta(duracionDeTurno);

		ArrayList<TurnoMedico> turnosNuevos = recorrerFechas(inicioDeActividadMensual, finDeActividadMensual, datos.getDiasDeLaSemanaElegidos(), duracionConsulta, datos.getValorPorConsultaNormal());

		cargo = repositorio.cargarAgenda(turnosNuevos, id);
		return cargo;
	}

	public ArrayList<TurnoMedico> recorrerFechas(LocalDateTime inicioDeActividadMensual, LocalDateTime finDeActividadMensual, ArrayList<Integer> diasDeLaSemana, LocalTime duracionDeTurno, Double precioPorConsulta) {

		
		LocalDateTime horarioRespaldo = inicioDeActividadMensual;

		ArrayList<TurnoMedico> nuevosTurnos = new ArrayList<TurnoMedico>();

		for (int i = 0; i < diasDeLaSemana.size(); i++) {
			while (inicioDeActividadMensual.isBefore(finDeActividadMensual)) {
				if (diasDeLaSemana.get(i) == inicioDeActividadMensual.getDayOfWeek().getValue()) {

					if (inicioDeActividadMensual.getHour() >= horarioRespaldo.getHour()
							&& inicioDeActividadMensual.getHour() <= finDeActividadMensual.getHour()) {
						TurnoMedico nuevoTurno = new TurnoMedico();
						nuevoTurno.setFecha(inicioDeActividadMensual);
						nuevoTurno.setValorDeLaConsulta(precioPorConsulta);
						nuevoTurno.setValorFinal(precioPorConsulta);
						nuevoTurno.setTiempoDeLaConsulta(duracionDeTurno);
						nuevosTurnos.add(nuevoTurno);
					} 
				}
				inicioDeActividadMensual = inicioDeActividadMensual.plusHours(duracionDeTurno.getHour())
						.plusMinutes(duracionDeTurno.getMinute());
			}
			//nuevosTurnos.remove(nuevosTurnos.size()-1);

			inicioDeActividadMensual = horarioRespaldo;
		}
		return nuevosTurnos;
	}

	@Override
	public List<TurnoMedico> verCompromisos(Integer id) {

		return repositorio.verCompromisos(id);
	}
	
	

	@SuppressWarnings("deprecation")
	private LocalTime obtenerDuracionConsulta(Time duracionDeTurno) {
		return LocalTime.of(duracionDeTurno.getHours(), duracionDeTurno.getMinutes());

	}

	@SuppressWarnings("deprecation")
	private LocalDateTime obtenerFinDeActividadMensual(Time horarioComienzoJornada, Time horarioFinJornada) {
		LocalDateTime tiempoActual = LocalDateTime.now();
		return LocalDateTime.of(tiempoActual.getYear()+1, tiempoActual.getMonth().plus(1), tiempoActual.getDayOfMonth(),
				horarioFinJornada.getHours(), horarioFinJornada.getHours());

	}

	@SuppressWarnings("deprecation")
	private LocalDateTime obtenerInicioDeActividadMensual(Time horarioComienzoJornada, Time horarioFinJornada) {
		LocalDateTime tiempoActual = LocalDateTime.now();
		return LocalDateTime.of(tiempoActual.getYear(), tiempoActual.getMonth(), tiempoActual.getDayOfMonth(),
				horarioComienzoJornada.getHours(), horarioComienzoJornada.getMinutes());
	}

	@Override
	public void darDeBaja(Integer idTurno) {
		repositorio.darDeBajaTurno(idTurno);
	}

	@Override
	public Double obtenerCalificacion(Integer id) {
		List<TurnoMedico> turnosCalificados= repositorio.obtenerCalificacionDeMedico(id);
		Double sumaDeCalificaciones=0.0;
		for (TurnoMedico turnoMedico : turnosCalificados) {
			sumaDeCalificaciones+=turnoMedico.getCalificacion();
		}
		
		Double calificacionFinal = sumaDeCalificaciones/turnosCalificados.size();
		return calificacionFinal;
	}

}
