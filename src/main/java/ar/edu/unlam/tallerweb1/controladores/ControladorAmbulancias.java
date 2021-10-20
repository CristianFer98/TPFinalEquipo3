package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Ambulancia;
import ar.edu.unlam.tallerweb1.modelo.DatosSolicitudAmbulancia;
import ar.edu.unlam.tallerweb1.modelo.SolicitudUsuarioAmbulancia;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioAmbulancia;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroLogin;

@Controller
public class ControladorAmbulancias {
	private ServicioAmbulancia servicioAmbulacia;
	private ServicioRegistroLogin servicioRegistroLogin;
	
	

	@Autowired
	public ControladorAmbulancias(ServicioAmbulancia servicioAmb, ServicioRegistroLogin servicioRegistroLogin ) {
		this.servicioAmbulacia = servicioAmb;
		this.servicioRegistroLogin = servicioRegistroLogin;
	}	
	

	
	@RequestMapping(path = "centralAmbulancia")
	public ModelAndView mostrarListaAmbulancias() {
		ModelMap modelo = new ModelMap();
		
		
		modelo.put("key", "SOLICITAR");
		return new ModelAndView("centralAmbulancia", modelo);
	}

	
	@RequestMapping(path = "solicitudPagina")
	public ModelAndView mostrarSolucitudDeAmbulanciaEnCurso(@ModelAttribute("datosSolicitudAmbulancia") DatosSolicitudAmbulancia solicitud
															,HttpServletRequest req) {
		ModelMap modelo = new ModelMap();
				
		Integer id = (Integer) req.getSession().getAttribute("idUsuario");
		Usuario usuario= servicioRegistroLogin.obtenerUsuarioPorId(id);
		solicitud.setUser(usuario);		
		
		Integer idSolicitud= servicioAmbulacia.pedirAmbulancia(solicitud);
		SolicitudUsuarioAmbulancia soli = servicioAmbulacia.obtenerSolicitudPORID(idSolicitud);
		
		modelo.put("soli", soli);
	
		return new ModelAndView("solicitudDeAmbulancia", modelo);
	}
	
	
	@RequestMapping(path = "registrarAmbulancia")
	public ModelAndView adminPuedeREIngresarAmbulancia(@RequestParam("patente") String patenteAmbulancia) {
		ModelMap modelo= new ModelMap();
		Ambulancia amb= servicioAmbulacia.obtenerAmbulanciaPorPatente(patenteAmbulancia);
		
		String msj= servicioAmbulacia.reIngresoAmbulancia(amb, patenteAmbulancia);
		
		modelo.put("msj", msj);
		
		return new ModelAndView("paginaPrincipalAdmin", modelo);
	}
	
	@RequestMapping(path = "activarUsuario")
	public ModelAndView adminPuedeAtenderConsulta(@RequestParam("email") String emailUsuario) {
		ModelMap modelo= new ModelMap();
		
		String msj;
		
		Usuario user= servicioRegistroLogin.obtenerUsuarioPorMail(emailUsuario);		
		if (user == null) {
			msj="Usuario Inexistente";
			modelo.put("msj", msj);
			return new ModelAndView("paginaPrincipalAdmin", modelo);
		}
		
		SolicitudUsuarioAmbulancia soli = servicioAmbulacia.obtenerConsultaSinAtenderPorUsuario(user);
		if (soli == null) {
			msj="Usuario sin solicitud sin atender";
			modelo.put("msj", msj);
			return new ModelAndView("paginaPrincipalAdmin", modelo);
		}
		
		servicioAmbulacia.atenderConsulta(soli);
		msj= "Estado consulta cambiado con exito!";
		modelo.put("msj", msj);
		return new ModelAndView("paginaPrincipalAdmin", modelo);
	}
	
	
	
	
	

	@RequestMapping(path = "canceloAmbulancia")
	public ModelAndView cancelarAmbulancia(@RequestParam("ambulanciaCancelada") String patenteAmbulancia) {
		ModelMap modelo= new ModelMap();
		
		modelo.put("patente", patenteAmbulancia);
		Ambulancia amb= servicioAmbulacia.obtenerAmbulanciaPorPatente(patenteAmbulancia);
		
		servicioAmbulacia.cambiarEstadoAmbulancia(amb, true);
		
		return new ModelAndView("cancelacionAmbulancia", modelo);
	}

}
