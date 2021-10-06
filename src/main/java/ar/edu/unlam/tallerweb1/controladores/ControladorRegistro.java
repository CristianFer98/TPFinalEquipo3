package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.DatosRegistroMedico;
import ar.edu.unlam.tallerweb1.modelo.DatosRegistroUsuarioComun;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroLogin;

@Controller
public class ControladorRegistro {

	private ServicioRegistroLogin servicio;
	
	@Autowired
	public ControladorRegistro (ServicioRegistroLogin servicio) {
		this.servicio = servicio;
	}
	

	
	
	@RequestMapping (path = "FormularioDeRegistro", method = RequestMethod.GET) //el boton registrarse del login dispara esta vista
	public ModelAndView mostrarFormularioDeRegistro() {
		return new ModelAndView ("registro1");
		
	}
	@RequestMapping (path = "Registrarse", method = RequestMethod.POST)
	public ModelAndView registrarNuevoUsuario(@ModelAttribute("DatosRegistroUsuarioComun") DatosRegistroUsuarioComun datos) { //los datos tipo usuario ya tiene su numero tipo 1
		String mensaje = null;
		ModelMap model = new ModelMap ();
		

		try{
			servicio.registrarUsuario(datos);
		}catch(ClavesDistintasException exception){
			 mensaje = "las claves deben ser iguales";
			 model.put("error", mensaje);
			 return new ModelAndView ("paginaDeRegistro", model);
		}catch(ClavesCortasException exception1) {
			 mensaje = "Debe tener al menos 8 caracteres";
			 model.put("error", mensaje);
			 return new ModelAndView ("paginaDeRegistro", model);
		}
		
		return new ModelAndView("index");
		
		
		
	}
	
	//este metodo va a estar en la vista que pertenece al admin.
	@RequestMapping (path = "RegistrarMedico", method= RequestMethod.POST)
	public ModelAndView registrarMedico (@ModelAttribute("datosDeInicioSesion") DatosRegistroMedico datos) {//el datos tipo medico ya tiene un atributo con su numero 2
		String mensaje = null;
		ModelMap model = new ModelMap ();
		

		try{
			servicio.registrarUsuario(datos);
		}catch(ClavesDistintasException exception){
			 mensaje = "las claves deben ser iguales";
			 model.put("error", mensaje);
			 return new ModelAndView ("paginaDeRegistro", model);
		}catch(ClavesCortasException exception1) {
			 mensaje = "Debe tener al menos 8 caracteres";
			 model.put("error", mensaje);
			 return new ModelAndView ("paginaDeRegistro", model);
		}
		
		return new ModelAndView("paginaPrincipal");
		
		
	}
}
