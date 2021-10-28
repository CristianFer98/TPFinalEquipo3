package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.DatosDeInicioDeSesion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPlanSalud;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroLogin;

@Controller
public class ControladorPlanSalud {
	
	private ServicioPlanSalud servicio;
	
	//Defino mi servicio
	//Con el Autowired Spring instancia mi objeto
	@Autowired
	public  ControladorPlanSalud(ServicioPlanSalud servicio) {
		this.servicio = servicio;
	}
	
	// te lleva a la vista de los planes
	@RequestMapping(path = "planes", method=RequestMethod.GET)
	public ModelAndView mostrarPlan() {
		return new ModelAndView("planes"); 

	} 
	
	//Con el Http... lo que hago es obtener la id de la BD
	//Entonces uso el id para encontrar la edad y cotizar
	//la vista cotizacion me tiene que mostrar la cotizacion segun la edad del paciente
	@RequestMapping(path="plan-basico",method=RequestMethod.GET)
	public ModelAndView cotizarPlanBasico(HttpServletRequest req) {
		Integer id = (Integer) req.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		Double montoB= servicio.cotizarbasico(id);
		model.put("valor", montoB);
		return new ModelAndView("cotizacion",model);		
	}
	
	@RequestMapping(path="plan-avanzado",method=RequestMethod.GET)
	public ModelAndView cotizarPlanAvanzado(HttpServletRequest req) {
		Integer id = (Integer) req.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		Double montoA= servicio.cotizaravanzado(id);
		model.put("valor", montoA);
		return new ModelAndView("cotizacion",model); 	
	}
	
	
	
}
