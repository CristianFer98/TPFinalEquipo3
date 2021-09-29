package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class ControladorHome {
	
	
	@RequestMapping(path="/", method = RequestMethod.GET)
	public ModelAndView mostrarHome () {
		
	return new ModelAndView("index"); // simplemente muestro el index
		
	}
	
	
	
	@RequestMapping (path ="/registrarse", method = RequestMethod.POST)
	public ModelAndView registrarse (@ModelAttribute ("datosRegistro") DatosRegistro datos) {
		
		return new ModelAndView("paginaPrincipal");
	}
	
	// metodo para registrar
	
	
	// metodo para Iniciar sesion.
	
	
	

}
