  package ar.edu.unlam.tallerweb1.controladores;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.DatosAgendaMesMedico;
import ar.edu.unlam.tallerweb1.modelo.DatosDeActualizacionPerfilMedico;
import ar.edu.unlam.tallerweb1.modelo.Dias;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
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
		ModelMap model = new ModelMap();
		List<Especialidad> especializaciones;
		especializaciones = servicio.obtenerListaDeEspecializaciones();

		model.put("lista", especializaciones);
		return new ModelAndView("editarPerfilMedico", model);
	}

	
	
	
	@RequestMapping(path = "CargarDatosMedico", method = RequestMethod.POST)
	public ModelAndView CargarDatosMedico(
			@ModelAttribute("DatosDeActualizacionPerfilMedico") DatosDeActualizacionPerfilMedico datos,
			HttpServletRequest req) throws IOException {

		Boolean cargaExitosa = false;
		ModelMap model = new ModelMap();
		Integer id = (Integer) req.getSession().getAttribute("idUsuario");

		cargaExitosa = servicio.cargarDatos(datos, id);

		if (cargaExitosa == true) {
			String mensajeExitoso = "carga exitosa";
			model.put("mensaje", mensajeExitoso);
			ModelAndView MAV =  formularioEdicionPerfil();
			return MAV.addAllObjects(model);
		} else {
			String mensajeError = "hubo un error";

			model.put("mensaje", mensajeError);
			ModelAndView MAV =  formularioEdicionPerfil();
			return MAV.addAllObjects(model);
		}

	}

	@RequestMapping(path = "MyPerfil", method = RequestMethod.GET)
	public ModelAndView verPerfilMedico(HttpServletRequest req) throws IOException {
		// tengo que recorrer la informacion que me traiga del medico
		Integer id = (Integer) req.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		Usuario Medico = servicio.obtenerInformacion(id);

		byte[] fileContent = FileUtils.readFileToByteArray(new File(Medico.getFoto()));
		String encodedString = Base64.getEncoder().encodeToString(fileContent);

		model.put("foto", encodedString);
		model.put("usuario", Medico);
		return new ModelAndView("perfilMedico", model);

	}
	
	@RequestMapping (path = "FormAgenda" , method =RequestMethod.GET)
	public ModelAndView mostrarFormularioAgendaMedica () {
		ModelMap model = new ModelMap ();
		List <Dias> dias = servicio.obtenerDiasDeLaSemana();
		
		model.put("lista", dias);
		return new ModelAndView("formularioCargaAgenda", model);
	}
	
	@RequestMapping (path = "cargarAgenda")
	public ModelAndView cargarAgendaMedico (@ModelAttribute ("DatosAgendaMesMedico") DatosAgendaMesMedico datos, HttpServletRequest req) throws ParseException {
			//recupero la id del medico
			Integer id = (Integer) req.getSession().getAttribute("idUsuario");
			ModelMap model = new ModelMap();
			
			//Como el form me tira un string lo parseo a fecha tanto la de inicio como la de fin
			DateFormat formatter = new SimpleDateFormat("hh:mm");
			
			java.sql.Time horarioComienzoJornada = new java.sql.Time(formatter.parse(datos.getHorarioComienzoJornada()).getTime());
			java.sql.Time horarioFinJornada = new java.sql.Time(formatter.parse(datos.getHorarioFinJornada()).getTime());
			
			
			
			boolean cargo = servicio.cargarAgenda(datos, id, horarioComienzoJornada, horarioFinJornada);

			return new ModelAndView("exito", model);
	}
	
	

}
