package ar.edu.unlam.tallerweb1.controladores;

import java.util.HashMap;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioOperacionesMatematica;

@Controller
public class ControladorMuestraHome {
	
	@Inject
	ServicioOperacionesMatematica servicio;
	
//	@Autowired
//	public ControladorMuestraHome(ServicioOperacionesMatematica servicio){
//		servicio=this.servicio;
//	}
	
	

	@RequestMapping(path="/", method = RequestMethod.GET)
	public ModelAndView mostrarHome () {
		
	return new ModelAndView("index");		
	}
	
	@RequestMapping(path="/registrarse", method = RequestMethod.GET)
	public ModelAndView mostrarRegistrarse () {
	ModelMap modelo = new ModelMap(); 	
		
	String hola= "Hola";
	modelo.put("saludo", hola);

	return new ModelAndView("registrarse",modelo);
	}
	
	

	@RequestMapping(path="/sumarNumeros", method = RequestMethod.GET)
	public ModelAndView sumarNumeros(@RequestParam("num1")int n1,
									 @RequestParam("num2")int n2) {
		ModelMap modelo = new ModelMap(); 	
		
		
		
		Integer suma= n1+n2;
		modelo.put("sum", suma);
		
		return new ModelAndView("sumarNumeros",modelo);
	}
	

}
