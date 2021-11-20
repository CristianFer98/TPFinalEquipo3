package ar.edu.unlam.tallerweb1.controladores;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
		Usuario medico = servicio.obtenerMedico(idMedico);
		model.put("medico", medico);
		model.put("lista", listaDeTurnosDisponibles);
		
		return new ModelAndView("turnosDisponiblesMedico", model);
	}

	@RequestMapping(path = "pagoExitoso", method = RequestMethod.GET)
	public ModelAndView reservarTurno(@RequestParam("idTurno") Integer idTurno,
									  @RequestParam("idUsuario") Integer idUsuario, 
									  @RequestParam("status") String status       ,HttpServletRequest req) {
		
		ModelMap model = new ModelMap();
		TurnoMedico turnoNuevo = servicio.reservarTurno(idTurno, idUsuario);
		
		if (status.equals("approved")) {
			model.put("estadoPago", "Pago realizado con exito");
			servicio.setPagadoTurno(turnoNuevo, true);
		}else {
			model.put("estadoPago", "Debes pagar la consulta en el hospital");
		}
		
		model.put("turno", turnoNuevo);
		
		return new ModelAndView("reservaExitosa", model);
	}
	
	@RequestMapping (path = "verMisTurnos", method = RequestMethod.GET)
	public ModelAndView verMisTurnos (HttpServletRequest req) {
		
		Integer id = (Integer) req.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		
		List <TurnoMedico> turnos = servicio.verMisTurnos(id);
		
		
		model.put("lista", turnos);
		return new ModelAndView("misTurnos", model);
	}
	
	@RequestMapping(path = "cancelarTurno", method= RequestMethod.GET)
	public ModelAndView cancelarTurno (@RequestParam ("idTurno") Integer idTurno, HttpServletRequest req) {

		servicio.cancelarTurno(idTurno);
		
		return verMisTurnos(req);
	}
	
	@RequestMapping(path = "paginaPrincipal", method= RequestMethod.GET)
	public ModelAndView getPaginaPrincipal() {
		
		return new ModelAndView("paginaPrincipal");
	}

	@RequestMapping(path = "paginaPrincipalMedicos", method= RequestMethod.GET)
	public ModelAndView getPaginaPrincipalMedicos() {
		
		return new ModelAndView("paginaPrincipalMedicos");
	}
	@RequestMapping(path = "paginaPrincipalAdmin", method= RequestMethod.GET)
	public ModelAndView getPaginaPrincipalAdmin() {
		
		return new ModelAndView("paginaPrincipalAdmin");
	}

}
