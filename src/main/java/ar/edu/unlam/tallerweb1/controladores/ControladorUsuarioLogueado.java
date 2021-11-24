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
import ar.edu.unlam.tallerweb1.modelo.Pagos;
import ar.edu.unlam.tallerweb1.modelo.TurnoMedico;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioPagos;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuarioLogueado;

@Controller
public class ControladorUsuarioLogueado {

	ServicioUsuarioLogueado servicio;
	ServicioPagos servicioPagos;

	@Autowired
	public ControladorUsuarioLogueado(ServicioUsuarioLogueado servicioUsuarioLogueado, ServicioPagos servicioPagos) {
		this.servicio = servicioUsuarioLogueado;
		this.servicioPagos = servicioPagos;
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
<<<<<<< HEAD
									  @RequestParam("idUsuario") Integer idUsuario, 
									  @RequestParam("status") String status       ,HttpServletRequest req) {
		
=======
			@RequestParam("idUsuario") Integer idUsuario, @RequestParam("status") String status,
			@RequestParam("payment_id") Integer paymentId) {

>>>>>>> main
		ModelMap model = new ModelMap();
		TurnoMedico turnoNuevo = servicio.reservarTurno(idTurno, idUsuario);

		// verificar si existe el pago de este usuario sobre este turno
		Pagos pago = servicioPagos.getPagoByIDTurnoandIdUser(idTurno, idUsuario);

		if (pago == null) {
			pago = crearNuevoComprobanteDePago(paymentId, turnoNuevo, status);
			servicioPagos.guardarDatosDePagos(pago);
		} else {
			actualizarComprobanteDePago(pago, status);
		}

		// Manejo del model
		if (status.equals("approved")) {
			model.put("estadoPago", "Pago realizado con exito");
			servicio.setPagadoTurno(turnoNuevo, true);
		} else {
			model.put("estadoPago", "Debes pagar la consulta en el hospital");
		}

		model.put("turno", turnoNuevo);
		return new ModelAndView("reservaExitosa", model);
	}

	private void actualizarComprobanteDePago(Pagos pago, String status) {
		if (status.equals("approved")) {
			servicioPagos.actualizarEstadoPago(pago, "aprobado");
		} else {
			servicioPagos.actualizarEstadoPago(pago, "pendiente");
		}
	}

	private Pagos crearNuevoComprobanteDePago(Integer paymentId, TurnoMedico turnoNuevo, String status) {
		Pagos pago = new Pagos(paymentId, turnoNuevo.getClienteAsignado(), turnoNuevo,
				turnoNuevo.getValorFinal().floatValue());

		if (status.equals("approved")) {
			pago.setEstado("aprobado");
		} else {
			pago.setEstado("pendiente");
		}

		return pago;
	}

	@RequestMapping(path = "verMisTurnos", method = RequestMethod.GET)
	public ModelAndView verMisTurnos(HttpServletRequest req) {

		Integer id = (Integer) req.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();

		List<TurnoMedico> turnos = servicio.verMisTurnos(id);

		model.put("lista", turnos);
		return new ModelAndView("misTurnos", model);
	}

	@RequestMapping(path = "paginaPrincipal", method = RequestMethod.GET)
	public ModelAndView getPaginaPrincipal() {

		return new ModelAndView("paginaPrincipal");
	}

	@RequestMapping(path = "paginaPrincipalMedicos", method = RequestMethod.GET)
	public ModelAndView getPaginaPrincipalMedicos() {

		return new ModelAndView("paginaPrincipalMedicos");
	}

	@RequestMapping(path = "paginaPrincipalAdmin", method = RequestMethod.GET)
	public ModelAndView getPaginaPrincipalAdmin() {

		return new ModelAndView("paginaPrincipalAdmin");
	}

	@RequestMapping(path = "pagofallido", method = RequestMethod.GET)
	public ModelAndView reservarTurno(@RequestParam("status") String status, @RequestParam("idTurno") Integer idTurno,
			@RequestParam("idUsuario") Integer idUsuario) {
		Integer problema = 0;
		ModelMap model = new ModelMap();

		switch (status) {
		case "rejected":
			problema = 1;
			guardarDatos(model, problema, "Pago Rechazado");
			break;
		case "in_process":
			problema = 2;
			guardarDatos(model, problema, "Pago Pendiente");
			break;
		default:
			model.put("msj", "Error inesperado");
			break;
		}
		TurnoMedico turnoNuevo = servicio.getTurnoByID(idTurno, idUsuario);
		model.put("turno", turnoNuevo);

		return new ModelAndView("reservaFallida", model);
	}

	private void guardarDatos(ModelMap model, Integer problema, String string) {
		model.put("problema", problema);
		model.put("msj", string);
	}

	@RequestMapping(path = "cancelarTurno", method = RequestMethod.GET)
	public ModelAndView cancelarTurno(@RequestParam("idTurno") Integer idTurno, HttpServletRequest req) {
		ModelMap model = new ModelMap();
		TurnoMedico turno = servicio.getTurnoByOnlyID(idTurno);

		Integer idUser = turno.getClienteAsignado().getIdUsuario();

		Pagos pago = servicioPagos.getPagoByIDTurnoandIdUser(turno.getId(), idUser);

		if (turno.getPagado() == null) {
			servicio.cancelarTurno(idTurno);
			servicioPagos.actualizarEstadoPago(pago, "cancelado");
			return verMisTurnos(req);
		} else {
			model.put("turno", turno);
			return new ModelAndView("devolucionDinero", model);
		}
	}

}
