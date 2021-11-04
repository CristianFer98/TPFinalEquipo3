package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.cotizacionExistenteException;
import ar.edu.unlam.tallerweb1.modelo.DatosDeInicioDeSesion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPlanSalud;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroLogin;

@Controller
public class ControladorPlanSalud {
	
	private ServicioPlanSalud servicio;
	
	
	@Autowired
	public  ControladorPlanSalud(ServicioPlanSalud servicio) {
		this.servicio = servicio;
	}
	
	
	@RequestMapping(path = "formPlanSalud", method=RequestMethod.GET)
	public ModelAndView mostrarFormPlanMedico() {
		return new ModelAndView("formPlanMedico"); 

	} 
	

	@RequestMapping(path="cotizarPlanMedico",method=RequestMethod.GET)
	public ModelAndView cotizarPlanBasico(HttpServletRequest req) {
		//segun la edad del usuario el descuento al subscribirse al plan será diferente//
		
		Integer id = (Integer) req.getSession().getAttribute("idUsuario");
		String nombreUsuario = (String) req.getSession().getAttribute("nombre");
		ModelMap model = new ModelMap();
		Double descuento;
		
		try {
			descuento = servicio.cotizarPlanMedico(id);//en porcentaje por cada visita medica

		}catch(cotizacionExistenteException e) {
			String mensaje = "Usted ya cuenta con una suscripcion a su nombre";
			model.put("nombre", nombreUsuario);
			model.put("mensaje", mensaje);
			return new ModelAndView("errorPlanMedico",model);		
		}
		
		model.put("nombre", nombreUsuario);
		model.put("valor", descuento);
		return new ModelAndView("cotizacionDePlanMedico",model);		
	}
	
	@RequestMapping(path = "suscribirseAPlan", method= RequestMethod.GET)
	public ModelAndView suscribirseAPlanMedico (@RequestParam("descuento") Double descuento,HttpServletRequest req) {
		Integer id = (Integer) req.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		
		servicio.suscribirseAPlanMedico(id, descuento);
		
		model.put("descuento", descuento);
		return new ModelAndView("suscripcionAPlan", model);
	}

	
	
	
}
