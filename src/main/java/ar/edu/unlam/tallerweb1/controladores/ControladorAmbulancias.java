package ar.edu.unlam.tallerweb1.controladores;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Ambulancia;
import ar.edu.unlam.tallerweb1.modelo.DatosSolicitudAmbulancia;
import ar.edu.unlam.tallerweb1.modelo.SolicitudUsuarioAmbulancia;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.NoHayAmbulanciasDisponiblesException;
import ar.edu.unlam.tallerweb1.servicios.ServicioAmbulancia;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroLogin;
import ar.edu.unlam.tallerweb1.servicios.UsuarioYaPidioAmbulanciaExeception;

@Controller
public class ControladorAmbulancias {
	private ServicioAmbulancia servicioAmbulacia;
	private ServicioRegistroLogin servicioRegistroLogin;
	
	

	@Autowired
	public ControladorAmbulancias(ServicioAmbulancia servicioAmb, ServicioRegistroLogin servicioRegistroLogin) {
		this.servicioAmbulacia = servicioAmb;
		this.servicioRegistroLogin = servicioRegistroLogin;
	}	
	
	@RequestMapping (path = "formGestionAmbulancia", method = RequestMethod.GET)
	public ModelAndView mostrarFormularioGestionAmbulancia() {
		ModelMap model = new ModelMap();
		List<Ambulancia> ambulancias= servicioAmbulacia.obtenerTodasLasAmbulancias();
		
		
		model.put("listaAmbulancia", ambulancias);
		model.put("x", ambulancias.size());
		return new ModelAndView("ambulanciaControl",model);
		
	}
	
	@RequestMapping(path = "centralAmbulancia")
	public ModelAndView mostrarListaAmbulancias(HttpServletRequest req) {
		ModelMap modelo = new ModelMap();
		
		
		Integer id = (Integer) req.getSession().getAttribute("idUsuario");
		
		modelo.put("key", id);
		return new ModelAndView("centralAmbulancia", modelo);
	}

	
	@RequestMapping(path = "solicitudPagina")
	public ModelAndView mostrarSolucitudDeAmbulanciaEnCurso(@ModelAttribute("datosSolicitudAmbulancia") DatosSolicitudAmbulancia solicitud
															,HttpServletRequest req) {
		ModelMap modelo = new ModelMap();
				
		Integer id = (Integer) req.getSession().getAttribute("idUsuario");
		solicitud.setUser(servicioRegistroLogin.obtenerUsuarioPorId(id));	
		
		modelo.put("key", id);

		Integer idSolicitud = null;
		SolicitudUsuarioAmbulancia soli = null;
		
		try {
			idSolicitud= servicioAmbulacia.pedirAmbulancia(solicitud);
			soli = servicioAmbulacia.obtenerSolicitudPORID(idSolicitud);			
		} catch (UsuarioYaPidioAmbulanciaExeception e) {
			String msj ="Usted ya tiene una ambulancia pedida en curso"; 
			return mostrarMensajeError(modelo,msj);
		}catch (NoHayAmbulanciasDisponiblesException e) {
			String msj= "Disculpe, por el momento no hay ambulancias";
			return mostrarMensajeError(modelo, msj);
		}
		
		modelo.put("soli", soli);
		return new ModelAndView("solicitudDeAmbulancia", modelo);
		
	}
	
	
	private ModelAndView mostrarMensajeError(ModelMap modelo,String msj) {
		modelo.put("msj", msj);
    	return new ModelAndView("centralAmbulancia", modelo);		
	}

	@RequestMapping(path = "registrarAmbulancia")
	public ModelAndView adminPuedeREIngresarAmbulancia(@RequestParam("patente") String patenteAmbulancia) {
		ModelMap modelo= new ModelMap();
		Ambulancia amb= servicioAmbulacia.obtenerAmbulanciaPorPatente(patenteAmbulancia);		
		String msj= servicioAmbulacia.reIngresoAmbulancia(amb, patenteAmbulancia);
		

		List<Ambulancia> ambulancias= servicioAmbulacia.obtenerTodasLasAmbulancias();
		
		
		modelo.put("listaAmbulancia", ambulancias);		
		modelo.put("msj", msj);
		
		return new ModelAndView("ambulanciaControl", modelo);
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
		
		servicioAmbulacia.cambiarEstadoConsulta(soli, true);
		msj= "Estado consulta cambiado con exito!";
		modelo.put("msj", msj);
		return new ModelAndView("ambulanciaControl", modelo);
	}
	
	
	
	
	

	@RequestMapping(path = "canceloAmbulancia")
	public ModelAndView cancelarAmbulancia(@RequestParam("ambulanciaCancelada") String patenteAmbulancia, HttpServletRequest req) {
		ModelMap modelo= new ModelMap();
		
		modelo.put("patente", patenteAmbulancia);
		
		Ambulancia amb= servicioAmbulacia.obtenerAmbulanciaPorPatente(patenteAmbulancia);
		servicioAmbulacia.cambiarEstadoAmbulancia(amb, true);
		
		Integer id = (Integer) req.getSession().getAttribute("idUsuario");
		Usuario user= servicioRegistroLogin.obtenerUsuarioPorId(id);
		
		SolicitudUsuarioAmbulancia soli = servicioAmbulacia.obtenerConsultaSinAtenderPorUsuario(user);
		servicioAmbulacia.cambiarEstadoConsulta(soli, true);
		
		
		
		return new ModelAndView("cancelacionAmbulancia", modelo);
	}
	
	@RequestMapping(path = "ocuparAmbulancia")
	public ModelAndView ocuparAmbulancia(@RequestParam("patente") String patenteAmbulancia) {
		Ambulancia amb= servicioAmbulacia.obtenerAmbulanciaPorPatente(patenteAmbulancia);		
		
		servicioAmbulacia.cambiarEstadoAmbulancia(amb, false);	
		
		return new ModelAndView("redirect: formGestionAmbulancia");
	}
	
	@RequestMapping(path = "eliminarAmbulancia")
	public ModelAndView eliminarAmbulancia(@RequestParam("patente") String patenteAmbulancia) {
		Ambulancia amb= servicioAmbulacia.obtenerAmbulanciaPorPatente(patenteAmbulancia);		
		
		servicioAmbulacia.eliminarAmbulancia(amb);	
		
		return new ModelAndView("redirect: formGestionAmbulancia");
	}

}
