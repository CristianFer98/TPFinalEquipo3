package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
		return new ModelAndView ("paginaDeRegistro");
		
	}
	@RequestMapping (path = "Registrarse", method = RequestMethod.POST)
	public ModelAndView registrarNuevoUsuario(DatosRegistroUsuarioComun datos) {
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
