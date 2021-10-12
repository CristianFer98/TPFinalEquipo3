package ar.edu.unlam.tallerweb1.controladores;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.DatosDeActualizacionPerfilMedico;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioSesionMedico;

@Controller
public class ControladorMedico {

	
	private ServicioSesionMedico servicio;

	@Autowired
	public ControladorMedico(ServicioSesionMedico servicio) {
		this.servicio = servicio;
	}

	@RequestMapping(path = "EditarPerfil", method = RequestMethod.GET)
	public ModelAndView formularioEdicionPerfil() {
		return new ModelAndView("editarPerfilMedico");
	}

	@RequestMapping(path = "CargarDatosMedico", method = RequestMethod.POST)
	public ModelAndView CargarDatosMedico(
			@ModelAttribute("DatosDeActualizacionPerfilMedico") DatosDeActualizacionPerfilMedico datos,
			HttpServletRequest req) throws IOException {	
		

		Boolean cargaExitosa = false;
		ModelMap model = new ModelMap();
		Integer id = (Integer) req.getSession().getAttribute("idUsuario");
//la otra opcion es cargar un usuario completamente		
		
		byte[] fileContent = FileUtils.readFileToByteArray(new File(datos.getFoto()));
		String encodedString = Base64.getEncoder().encodeToString(fileContent);
		
		cargaExitosa = servicio.cargarDatos(datos ,id);

	
		if (cargaExitosa == true) {
			String mensajeExitoso = "carga exitosa";
			model.put("exito", encodedString);
			return new ModelAndView("editarPerfilMedico", model);
		} else {
			String mensajeError = "hubo un error";
			
			model.put("error", mensajeError);
			return new ModelAndView("editarPerfilMedico", model);
		}

	}
	@RequestMapping (path ="MyPerfil", method=RequestMethod.GET)
	public ModelAndView verPerfilMedico(HttpServletRequest req) throws IOException {
		//tengo que recorrer la informacion que me traiga del medico
		Integer id = (Integer) req.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		Usuario Medico = servicio.obtenerInformacion(id);
		
		byte[] fileContent = FileUtils.readFileToByteArray(new File(Medico.getFoto()));
		String encodedString = Base64.getEncoder().encodeToString(fileContent);	
		
		
		
		if (Medico != null) {
			model.put("foto", encodedString);
			model.put("usuario", Medico);
			return new ModelAndView("perfilMedico", model);
		
		}
		return new ModelAndView ("pefilMedico");
		
	}
	
}
