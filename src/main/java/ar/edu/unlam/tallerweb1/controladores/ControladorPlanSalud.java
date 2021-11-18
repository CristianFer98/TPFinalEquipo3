package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;
import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPConfException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.preference.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.cotizacionExistenteException;
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
