package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.TurnoMedico;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuarioLogueado;

import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPConfException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.preference.BackUrls;
import com.mercadopago.resources.datastructures.preference.Item;

@Controller
public class controladorMercadoPago {
	ServicioUsuarioLogueado servicioUsuario;
	ServicioRegistroLogin servicioRegistroLogin;

	@Autowired
	public controladorMercadoPago(ServicioUsuarioLogueado servicioUsuarioLogueado, ServicioRegistroLogin servicioRegistroLogin) {
		this.servicioUsuario = servicioUsuarioLogueado;
		this.servicioRegistroLogin = servicioRegistroLogin;
	}
	
	@RequestMapping(path = "reservarTurno", method = RequestMethod.GET)
	public ModelAndView reservarTurno(@RequestParam("idTurno") Integer idTurno,
			@RequestParam("idUsuario") Integer idUsuario, HttpServletRequest req) throws MPException {
		ModelMap model= new ModelMap();
		
		
		TurnoMedico turnoNuevo= servicioUsuario.getTurnoByID(idTurno);
		turnoNuevo.setClienteAsignado(servicioRegistroLogin.obtenerUsuarioPorId(idUsuario));
		model.put("turno", turnoNuevo);
		
		
		MercadoPago.SDK.setAccessToken("TEST-4705968898385123-111613-94630486744c2b803eca9c9073c3cb15-160323409");

		Preference preference = new Preference();
		
		preference.setBackUrls(
				new BackUrls().setFailure("http://localhost:8080/proyecto-limpio-spring/pagofallido")
							  .setPending("http://localhost:8080/proyecto-limpio-spring/pagoPendiente")
							  .setSuccess("http://localhost:8080/proyecto-limpio-spring/pagoExitoso?idTurno="+turnoNuevo.getId()+"&idUsuario=" + turnoNuevo.getClienteAsignado().getIdUsuario())
				);
		
		// Crea un ítem en la preferencia
		Item item = new Item();
		item.setTitle("Turno medico #" + turnoNuevo.getId())
		    .setQuantity(1)
		    .setUnitPrice(turnoNuevo.getValorConDescuento().floatValue());
		
		preference.appendItem(item);
		preference.save();
		
		model.put("preference", preference);
		return new ModelAndView("checkoutReserva" ,model);
	}
	
	
	
	@RequestMapping(path = "pagofallido", method = RequestMethod.GET)
	public ModelAndView pagoFallido() {
		ModelMap model = new ModelMap();
		
		
		return new ModelAndView("reservaFallida", model);
	}
	
	@RequestMapping(path = "pagoPendiente", method = RequestMethod.GET)
	public ModelAndView pagoPendiente() {
		ModelMap model = new ModelMap();
		
		
		return new ModelAndView("reservaPendiente", model);
	}
	
	
	

}
