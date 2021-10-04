package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.datosDeInicioDeSesion;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroLogin;

@Controller
public class ControladorLogin {

	private ServicioRegistroLogin servicio;

	@Autowired
	public ControladorLogin(ServicioRegistroLogin servicio) {
		this.servicio = servicio;
	}

	// como es el controlador del login, es el primer metodo que se carga, me
	// muestra el index donde esta el formulario
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView mostrarHome() {
		return new ModelAndView("index"); // simplemente muestro el index

	}

//lo unico que me va a impedir registrarme es si el usuario no existe. 
//sin embargo el login es para doctores, admin y usuario comun. Tengo que validar estas posibilidades.
	@RequestMapping(path = "loguearse", method = RequestMethod.POST)
	public ModelAndView iniciarSesion(@ModelAttribute("datosDeInicioSesion") datosDeInicioDeSesion datos) {
		String mensaje;
		ModelMap model = new ModelMap();
		Usuario usuario;
		

		try {
			usuario = servicio.iniciarSesion(datos);// cuando inicio sesion traigo un usuario
		} catch (UsuarioInexistenteException e) { // valido que exista
			mensaje = "Usuario Inexistente";
			model.put("error", mensaje);
			return new ModelAndView("index", model);
		}

		return comprobarTipoUsuario(usuario);// devuelvo el modelAndView dependiendo el tipo de Usuario.

	}

	private ModelAndView comprobarTipoUsuario(Usuario usuario) {
		ModelMap model = new ModelMap();
		if (usuario != null) {
			if (usuario.getNumeroDeDeTipoDeUsuario() == 1) {
				model.put("usuario", usuario);
				return new ModelAndView("paginaPrincipal", model);
			} else if (usuario.getNumeroDeDeTipoDeUsuario() == 2) {
				model.put("usuario", usuario);

				return new ModelAndView("paginaPrincipalMedicos", model);
			} else if (usuario.getNumeroDeDeTipoDeUsuario() == 3) {
				model.put("usuario", usuario);

				return new ModelAndView("paginaPrincipalAdmin", model);
			}
		}
		return new ModelAndView("index");
	}

}
