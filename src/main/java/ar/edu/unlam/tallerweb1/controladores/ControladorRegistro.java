package ar.edu.unlam.tallerweb1.controladores;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

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
	public ControladorRegistro(ServicioRegistroLogin servicio) {
		this.servicio = servicio;
	}

	@RequestMapping(path = "registro", method = RequestMethod.GET) // el boton registrarse del login dispara esta vista
	public ModelAndView mostrarFormularioDeRegistro() {
		return new ModelAndView("registro");

	}

	@RequestMapping(path = "showFormNewMedic", method = RequestMethod.GET)
	public ModelAndView mostrarFormularioDeRegistroMedico(HttpServletRequest req) {
		if (req.getSession().getAttribute("idUsuario") != null) {
			return new ModelAndView("darDeAltaNuevoMedico");

		}else {
			return new ModelAndView("index");
		}
		
	}

	@RequestMapping(path = "Registrarse", method = RequestMethod.POST)
	public ModelAndView registrarNuevoUsuario(@ModelAttribute("DatosRegistroUsuario") DatosRegistroUsuario datos,
			HttpServletRequest req) throws ParseException { // los datos tipo usuario ya tiene su numero tipo 1

		if (datos.getNumeroDeTipoDeUsuario() == 2 && req.getSession().getAttribute("idUsuario") != null || datos.getNumeroDeTipoDeUsuario() == 1) {

			String mensaje = null;
			ModelMap model = new ModelMap();
			Integer idRecibida;
			// hacer que el metodo registrar me devuelva el usuario nuevo, asi lo comparo
			// cuando hago el login.
			try {
				idRecibida = servicio.registrarUsuario(datos);

			} catch (ClavesDistintasException exception) {
				mensaje = "las claves deben ser iguales";
				model.put("error", mensaje);

				if (datos.getNumeroDeTipoDeUsuario() == 2) {
					return new ModelAndView("darDeAltaNuevoMedico", model);
				}
				return new ModelAndView("registro", model);

			} catch (ClavesCortasException exception1) {
				mensaje = "Debe tener al menos 8 caracteres";
				model.put("error", mensaje);

				if (datos.getNumeroDeTipoDeUsuario() == 2) {
					return new ModelAndView("darDeAltaNuevoMedico", model);
				}

				return new ModelAndView("registro", model);
			} catch (emailExistenteException exception2) {
				mensaje = "Ese usuario es Existente";
				model.put("error", mensaje);

				if (datos.getNumeroDeTipoDeUsuario() == 2) {
					return new ModelAndView("darDeAltaNuevoMedico", model);
				}

				return new ModelAndView("registro", model);
			}

			if (datos.getNumeroDeTipoDeUsuario() == 2) {
				mensaje = "Medico registrado Con exito";
				model.put("mensaje", mensaje);
				return new ModelAndView("darDeAltaNuevoMedico", model);

			}

			model.put("id", idRecibida);
			return new ModelAndView("registro", model);

		} else {
			return new ModelAndView("index");
		}

	}

}
