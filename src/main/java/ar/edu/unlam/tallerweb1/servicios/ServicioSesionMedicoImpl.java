package ar.edu.unlam.tallerweb1.servicios;

import java.sql.Time;
import java.time.LocalDateTime;
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
		if (repositorio.cargarDatos(datos, id) != null) {
			repositorio.cargarDatos(datos, id);
			return true;
		} else {
			return false;
		}
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
			Time horarioFinJornada) {
		LocalDateTime tiempoActual = LocalDateTime.now();
		
		Boolean cargo;
		@SuppressWarnings("deprecation")
		LocalDateTime inicioDeActividadMensual = LocalDateTime.of(tiempoActual.getYear(), tiempoActual.getMonth(),
				tiempoActual.getDayOfMonth(), horarioComienzoJornada.getHours(), horarioComienzoJornada.getMinutes()) ;

		@SuppressWarnings("deprecation")
		LocalDateTime finDeActividadMensual = LocalDateTime.of(tiempoActual.getYear(), tiempoActual.getMonth().plus(1),
				tiempoActual.getDayOfMonth(), horarioFinJornada.getHours()  , horarioFinJornada.getHours());

		ArrayList<TurnoMedico> turnosNuevos = recorrerFechas(inicioDeActividadMensual, finDeActividadMensual,
				datos.getDiasDeLaSemanaElegidos());

		cargo = repositorio.cargarAgenda(turnosNuevos, id);
		return cargo;
	}

	public ArrayList<TurnoMedico> recorrerFechas(LocalDateTime inicioDeActividadMensual,
			LocalDateTime finDeActividadMensual, ArrayList<Integer> diasDeLaSemana) {

		// Recorro primero los dias del mes y luego recorro el horario. finalmente
		// asigno a un nuevo turno ese objeto
		ArrayList<TurnoMedico> nuevosTurnos = new ArrayList<TurnoMedico>();
		LocalDateTime horarioRespaldo = inicioDeActividadMensual;

		for (int i = 0; i < diasDeLaSemana.size(); i++) {
			while (inicioDeActividadMensual.isBefore(finDeActividadMensual)) {
				if (diasDeLaSemana.get(i) == inicioDeActividadMensual.getDayOfWeek().getValue()) {

					if (inicioDeActividadMensual.getHour() >= horarioRespaldo.getHour()
							&& inicioDeActividadMensual.getHour() <= finDeActividadMensual.getHour()) {
						TurnoMedico nuevoTurno = new TurnoMedico();
						nuevoTurno.setFecha(inicioDeActividadMensual);
						nuevosTurnos.add(nuevoTurno);
					}
				}
				inicioDeActividadMensual = inicioDeActividadMensual.plusHours(1);
			}

			inicioDeActividadMensual = horarioRespaldo;
		}
		return nuevosTurnos;
	}

	@Override
	public List<TurnoMedico> verCompromisos(Integer id) {
		
		return repositorio.verCompromisos(id);
	}

}
