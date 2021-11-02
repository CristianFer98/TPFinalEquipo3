package ar.edu.unlam.tallerweb1.controladores;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.DatosRegistroUsuario;
import ar.edu.unlam.tallerweb1.repositorios.emailExistenteException;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroLogin;

@Controller
public class ControladorRegistro {

	private ServicioRegistroLogin servicio;
	
	@Autowired
	public ControladorRegistro (ServicioRegistroLogin servicio) {
		this.servicio = servicio;
	}
	
	
	@RequestMapping (path = "registro", method = RequestMethod.GET) //el boton registrarse del login dispara esta vista
	public ModelAndView mostrarFormularioDeRegistro() {
		return new ModelAndView ("registro");
		
	}
	
	@RequestMapping(path = "showFormNewMedic", method = RequestMethod.GET)
	public ModelAndView mostrarFormularioDeRegistroMedico() {
		return new ModelAndView ("darDeAltaNuevoMedico");
	}
	
	
	
	@RequestMapping (path = "Registrarse", method = RequestMethod.POST)
	public ModelAndView registrarNuevoUsuario(@ModelAttribute("DatosRegistroUsuario") DatosRegistroUsuario datos) throws ParseException  { //los datos tipo usuario ya tiene su numero tipo 1
		String mensaje = null;
		ModelMap model = new ModelMap ();
		Integer idRecibida; 
		//hacer que el metodo registrar me devuelva el usuario nuevo, asi lo comparo cuando hago el login.
		try{
			idRecibida =  servicio.registrarUsuario(datos);
			
		}catch(ClavesDistintasException exception){
			 mensaje = "las claves deben ser iguales"; 
			 model.put("error", mensaje);
			 return new ModelAndView ("registro", model);
		}catch(ClavesCortasException exception1) {
			 mensaje = "Debe tener al menos 8 caracteres";
			 model.put("error", mensaje);
			 return new ModelAndView ("registro", model);
		}catch (emailExistenteException exception2) {
			mensaje = "Ese usuario es Existente";
			model.put("error", mensaje);
			return new ModelAndView ("registro", model);
	}
		model.put("id", idRecibida);

		return new ModelAndView("index", model);
		
		 
		
	}
	


	
}

