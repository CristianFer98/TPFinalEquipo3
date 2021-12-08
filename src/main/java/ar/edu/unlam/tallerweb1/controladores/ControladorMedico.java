package ar.edu.unlam.tallerweb1.controladores;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.DatosAgendaMesMedico;
import ar.edu.unlam.tallerweb1.modelo.DatosDeActualizacionPerfilMedico;
import ar.edu.unlam.tallerweb1.modelo.Dias;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.TurnoMedico;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioSesionMedico;

@Controller

public class ControladorMedico {

	private ServicioSesionMedico servicio;

	@Autowired
	public ControladorMedico(ServicioSesionMedico servicio) {
		this.servicio = servicio;
	}

	@RequestMapping(path = "EditarPerfil", method = RequestMethod.GET)

	public ModelAndView formularioEdicionPerfil(HttpServletRequest req) {

		if (req.getSession().getAttribute("idUsuario") != null) {

			ModelMap model = new ModelMap();
			List<Especialidad> especializaciones;
			Integer id = (Integer) req.getSession().getAttribute("idUsuario");
			Usuario medico = servicio.obtenerInformacion(id);

			especializaciones = servicio.obtenerListaDeEspecializaciones();
			model.put("medico", medico);
			model.put("lista", especializaciones);
			return new ModelAndView("editarPerfilMedico", model);
		} else {
			return new ModelAndView("index");
		}
	}

	@RequestMapping(path = "CargarDatosMedico", method = RequestMethod.POST)
	public ModelAndView CargarDatosMedico(
			@ModelAttribute("DatosDeActualizacionPerfilMedico") DatosDeActualizacionPerfilMedico datos,
			HttpServletRequest req) throws IOException {

		if (req.getSession().getAttribute("idUsuario") != null) {
			Boolean cargaExitosa;
			ModelMap model = new ModelMap();
			Integer id = (Integer) req.getSession().getAttribute("idUsuario");

			cargaExitosa = servicio.cargarDatos(datos, id);

			if (cargaExitosa == true) {
				Usuario usuario =servicio.obtenerInformacion(id);
				
				Double calificacion = servicio.obtenerCalificacion(id);
				Double calificacionDos = calificacion;
				Long calificacionSinPuntos = Math.round(calificacionDos);

				model.put("calificacionSP", calificacionSinPuntos);
				model.put("calificacion", calificacion);
				model.put("usuario", usuario);

				return new ModelAndView("paginaPrincipalMedicos", model);
				
			} else {
				String mensajeError = "hubo un error";

				model.put("mensaje", mensajeError);
				ModelAndView MAV = formularioEdicionPerfil(req);
				return MAV.addAllObjects(model);
			}
		} else {
			return new ModelAndView("index");

		}

	}

	

	@RequestMapping(path = "FormAgenda", method = RequestMethod.GET)
	public ModelAndView mostrarFormularioAgendaMedica(HttpServletRequest req) {

		if (req.getSession().getAttribute("idUsuario") != null) {

			ModelMap model = new ModelMap();
			List<Dias> dias = servicio.obtenerDiasDeLaSemana();

			model.put("lista", dias);
			return new ModelAndView("formularioCargaAgenda", model);
		} else {
			return new ModelAndView("index");
		}
	}

	@RequestMapping(path = "cargarAgenda")
	public ModelAndView cargarAgendaMedico(@ModelAttribute("DatosAgendaMesMedico") DatosAgendaMesMedico datos,
			HttpServletRequest req) throws ParseException {
		if (req.getSession().getAttribute("idUsuario") != null) {

			// recupero la id del medico
			Integer id = (Integer) req.getSession().getAttribute("idUsuario");
			// validar que id no sea nulo. ver Handler
			ModelMap model = new ModelMap();

			// Como el form me tira un string lo parseo a fecha tanto la de inicio como la
			// de fin
			DateFormat formatter = new SimpleDateFormat("hh:mm");

			java.sql.Time duracionDeTurno = new java.sql.Time(formatter.parse(datos.getDuracionTurno()).getTime());
			java.sql.Time horarioComienzoJornada = new java.sql.Time(
					formatter.parse(datos.getHorarioComienzoJornada()).getTime());
			java.sql.Time horarioFinJornada = new java.sql.Time(
					formatter.parse(datos.getHorarioFinJornada()).getTime());

			servicio.cargarAgenda(datos, id, horarioComienzoJornada, horarioFinJornada, duracionDeTurno);

			return new ModelAndView("exito", model);
		} else {
			return new ModelAndView("index");

		}
	}

	@RequestMapping(path = "verTurnos")
	public ModelAndView verCompromiso(HttpServletRequest req) {

		if (req.getSession().getAttribute("idUsuario") != null) {

			Integer id = (Integer) req.getSession().getAttribute("idUsuario");

			ModelMap model = new ModelMap();

			List<TurnoMedico> turnosCompromiso = servicio.verCompromisos(id);

			model.put("lista", turnosCompromiso);
			return new ModelAndView("compromisoMedico", model);
		} else {
			return new ModelAndView("index");

		}

	}

	@RequestMapping(path = "darDeBaja")
	public ModelAndView darDeBajaTurno(@RequestParam("idTurno") Integer idTurno, HttpServletRequest req) {

		if (req.getSession().getAttribute("idUsuario") != null) {

			servicio.darDeBaja(idTurno);

			return verCompromiso(req);
		} else {
			return new ModelAndView("index");

		}
	}
	
	@RequestMapping(path = "paginaPrincipalMedicos", method = RequestMethod.GET)
	public ModelAndView getPaginaPrincipalMedicos(HttpServletRequest req) {

		if (req.getSession().getAttribute("idUsuario") != null) {
			
			ModelMap model = new ModelMap();
			Integer id = (Integer) req.getSession().getAttribute("idUsuario");
			Usuario usuario =servicio.obtenerInformacion(id);
			
			Double calificacion = servicio.obtenerCalificacion(id);
			Double calificacionDos = calificacion;
			Long calificacionSinPuntos = Math.round(calificacionDos);

			model.put("calificacionSP", calificacionSinPuntos);
			model.put("calificacion", calificacion);
			model.put("usuario", usuario);
			
			
			
			return new ModelAndView("paginaPrincipalMedicos", model);
		} else {
			return new ModelAndView("index");

		}
	}

}
