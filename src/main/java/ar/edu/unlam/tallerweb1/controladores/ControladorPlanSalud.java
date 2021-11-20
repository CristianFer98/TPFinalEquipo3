package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioPlanSalud;

@Controller
public class ControladorPlanSalud {
	private ServicioPlanSalud servicio;

	@Autowired
	public ControladorPlanSalud(ServicioPlanSalud servicio) {
		this.servicio = servicio;
	}

	@RequestMapping(path = "planes", method = RequestMethod.GET)
	public ModelAndView mostrarPlanesDisponibles() {
		return new ModelAndView("planesMedicos");
	}

}