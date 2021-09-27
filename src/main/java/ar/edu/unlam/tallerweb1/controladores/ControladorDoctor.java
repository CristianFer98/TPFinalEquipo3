package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Doctor;
import ar.edu.unlam.tallerweb1.servicios.ServicioDoctor;

@Controller
public class ControladorDoctor {
	@Inject
	ServicioDoctor servicio;
	
	
	
	@RequestMapping(path = "/registroDoc")
	public ModelAndView mostrarRegistroDoctor() {
		
		
		return new ModelAndView("registro-Doctor");
	}
	
	@RequestMapping(path = "/cargarNuevoDoctor", method=RequestMethod.POST)
	public ModelAndView mostrarCargaDoctorExitosa(@ModelAttribute("datosDeRegistroDoctor") String nombreDoc) {
		Doctor doctor= new Doctor();
		doctor.setNombre(nombreDoc);
		servicio.registrarDoctor(doctor);
		
		return new ModelAndView("exito");
	}
	
	
	
	

}
