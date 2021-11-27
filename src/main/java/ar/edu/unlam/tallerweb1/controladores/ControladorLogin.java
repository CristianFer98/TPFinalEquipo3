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
	
	@RequestMapping(path = "/index", method = RequestMethod.GET)
	public ModelAndView mostrarHome2() {
		return new ModelAndView("index"); // simplemente muestro el index

	}
	
	@RequestMapping(path = "signInOut")
	public ModelAndView mostrarSignInSignOut() {
		return new ModelAndView("loginRegistro");
	}

//lo unico que me va a impedir registrarme es si el usuario no existe. 
//sin embargo el login es para doctores, admin y usuario comun. Tengo que validar estas posibilidades.
	@RequestMapping(path = "loguearse", method = RequestMethod.POST)
	public ModelAndView iniciarSesion(@ModelAttribute("datosDeInicioSesion") DatosDeInicioDeSesion datos, HttpServletRequest req) {
		String mensaje;
		ModelMap model = new ModelMap();
		Usuario usuario = new Usuario();
		

		try {
			 usuario = servicio.iniciarSesion(datos);// cuando inicio sesion traigo un usuario
		} catch (UsuarioInexistenteException e) { // valido que exista
			mensaje = "Usuario Inexistente";
			model.put("errorLogin", mensaje);
			return new ModelAndView("loginRegistro", model);
		}

		return  comprobarTipoUsuario(usuario, req);// devuelvo el modelAndView dependiendo el tipo de Usuario.

	}
	
	
	
	private ModelAndView comprobarTipoUsuario(Usuario usuario, HttpServletRequest req) {
		ModelMap model = new ModelMap();
		
			req.getSession().setAttribute("idUsuario", usuario.getIdUsuario());
			req.getSession().setAttribute("nombre", usuario.getNombre());

			if (usuario.getNumeroDeTipoDeUsuario() == 1) {
				model.put("usuario", usuario);
				return new ModelAndView("paginaPrincipal", model);
			} else if (usuario.getNumeroDeTipoDeUsuario() == 2) {
				model.put("usuario", usuario);
				
				return new ModelAndView("paginaPrincipalMedicos", model);
			} else if (usuario.getNumeroDeTipoDeUsuario() == 3) {
				model.put("usuario", usuario);

				return new ModelAndView("paginaPrincipalAdmin", model);
			}
		
		return new ModelAndView("loginRegistro");
	}
	
	
	

}
