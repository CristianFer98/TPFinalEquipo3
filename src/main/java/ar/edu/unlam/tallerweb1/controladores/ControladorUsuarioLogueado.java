package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.TurnoMedico;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuarioLogueado;

@Controller
public class ControladorUsuarioLogueado {

	ServicioUsuarioLogueado servicio;

	@Autowired
	public ControladorUsuarioLogueado(ServicioUsuarioLogueado servicioUsuarioLogueado) {
		this.servicio = servicioUsuarioLogueado;
	}

	@RequestMapping(path = "listarEspecialidad", method = RequestMethod.GET)
	public ModelAndView listarEspecialidades(HttpServletRequest req) {
		req.getSession().getAttribute("nombre");
		ModelMap model = new ModelMap();
		List<Especialidad> especialidades = servicio.listarEspecialidades();

		model.put("lista", especialidades);
		return new ModelAndView("especialidades", model);

	}

	@RequestMapping(path = "listarMedicosPorEspecialidad", method = RequestMethod.GET)
	public ModelAndView listarMedicosPorEspecialidad(@RequestParam("valor") Integer idEspecialidad,
			HttpServletRequest req) {
		ModelMap model = new ModelMap();

		req.getSession().getAttribute("nombre");
		List<Usuario> especialistas = servicio.listarMedicosPorEspecialidad(idEspecialidad);

		model.put("lista", especialistas);
		return new ModelAndView("listaDeMedicos", model);

	}

	// me tiene que mostrar todos los turnos disponibles para ese Medico
	// seleccionado
	// asi que tengo que recuperar de ese medico su ID.
	@RequestMapping(path = "mostrarTurnos", method = RequestMethod.GET)
	public ModelAndView listarTurnosDisponiblesDeUnMedico(@RequestParam("idUsuario") Integer idMedico,
			HttpServletRequest req) {
		ModelMap model = new ModelMap();
		req.getSession().getAttribute("nombre");
		req.getSession().getAttribute("idUsuario");

		List<TurnoMedico> listaDeTurnosDisponibles = servicio.listarTurnos(idMedico);

		model.put("lista", listaDeTurnosDisponibles);

		return new ModelAndView("turnosDisponiblesMedico", model);
	}

	@RequestMapping(path = "reservarTurno", method = RequestMethod.POST)
	public ModelAndView reservarTurno(@RequestParam("idTurno") Integer idTurno,
			@RequestParam("idUsuario") Integer idUsuario, HttpServletRequest req) {
		
		
		ModelMap model = new ModelMap();
		boolean reservaExitosa;
		
		servicio.reservarTurno(idTurno, idUsuario);
		
		
		return new ModelAndView("reservaExitosa");

	}

}
