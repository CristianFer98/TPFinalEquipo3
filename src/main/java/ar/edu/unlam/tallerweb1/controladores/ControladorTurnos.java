package ar.edu.unlam.tallerweb1.controladores;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioTurnos;

@Controller
public class ControladorTurnos {
	private ServicioTurnos servicioTurnos;

	@Autowired
	public ControladorTurnos(ServicioTurnos servicioTurnos) {
		this.servicioTurnos = servicioTurnos;
	}
	
	
	@RequestMapping(path = "/menuTurnos")
	public ModelAndView mostrarMenuDeTurnos() {
//		Date fecha=new Date();
//		fecha.setYear(2021);
		ModelMap modelo= new ModelMap();
		
		String fecha="HOLAAAAAAAAS";
		modelo.put("saludo", fecha);
		
		return new ModelAndView("registrarse");
	}
	
	
	

}
