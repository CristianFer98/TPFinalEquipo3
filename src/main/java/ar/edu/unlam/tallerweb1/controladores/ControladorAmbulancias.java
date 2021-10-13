package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Ambulancia;
import ar.edu.unlam.tallerweb1.servicios.ServicioAmbulancia;

@Controller
public class ControladorAmbulancias {
	private ServicioAmbulancia servicioAmbulacia;
	
	@Autowired
	public ControladorAmbulancias(ServicioAmbulancia servicioAmb) {
		this.servicioAmbulacia = servicioAmb;
	}	
	

	
	@RequestMapping(path = "/centralAmbulancia")
	public ModelAndView mostrarListaAmbulancias() {
		ModelMap modelo = new ModelMap();
		Ambulancia am1= new Ambulancia("bbb222",false);
		Ambulancia am2= new Ambulancia("CCC222",true);
		
		
//		servicioAmbulacia.agregarAmbulancia(am1);
//		servicioAmbulacia.agregarAmbulancia(am2);
		
		List <Ambulancia> listaAmbulancias= servicioAmbulacia.obtenerAmbulanciasDisponibles();
		int cantidad= listaAmbulancias.size();
		
		if (cantidad == 0) {
			modelo.put("cantidad", " 0 .Puede anotarse en la lista de espera");
			modelo.put("key", "INGRESAR LISTA DE ESPERA");
		}else {
			modelo.put("cantidad", cantidad);
			modelo.put("key", "SOLICITAR");
		}
		
		
		
		return new ModelAndView("centralAmbulancia", modelo);
	}

	
	@RequestMapping(path = "solicitudPagina")
	public ModelAndView mostrarSolucitudDeAmbulanciaEnCurso() {
		ModelMap modelo = new ModelMap();
		
		Ambulancia amb= servicioAmbulacia.obtenerPrimerAmbulanciaDisponible();
		servicioAmbulacia.obtenerPrimerAmbulanciaDisponible().setDisponible(false);;
		modelo.put("amb", amb);
		
		
		return new ModelAndView("solicitudDeAmbulancia", modelo);
	}


}
