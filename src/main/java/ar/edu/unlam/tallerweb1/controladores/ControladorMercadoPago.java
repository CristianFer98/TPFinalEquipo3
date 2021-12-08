package ar.edu.unlam.tallerweb1.controladores;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Pagos;
import ar.edu.unlam.tallerweb1.modelo.TurnoMedico;
import ar.edu.unlam.tallerweb1.servicios.ServicioPagos;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuarioLogueado;

import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.preference.BackUrls;
import com.mercadopago.resources.datastructures.preference.Item;

@Controller
public class ControladorMercadoPago {
	ServicioUsuarioLogueado servicioUsuario;
	ServicioRegistroLogin servicioRegistroLogin;
	ServicioPagos servicioPagos;

	@Autowired
	public ControladorMercadoPago(ServicioUsuarioLogueado servicioUsuarioLogueado, ServicioRegistroLogin servicioRegistroLogin, ServicioPagos servicioPagos) {
		this.servicioUsuario = servicioUsuarioLogueado;
		this.servicioRegistroLogin = servicioRegistroLogin;
		this.servicioPagos= servicioPagos;
	}
	
	@RequestMapping(path = "reservarTurno", method = RequestMethod.GET)
	public ModelAndView reservarTurnooo(@RequestParam("idTurno") Integer idTurno,
			@RequestParam("idUsuario") Integer idUsuario, HttpServletRequest req) throws MPException {
		ModelMap model= new ModelMap();
		
		//devuelvo el turno con el descuento aplicado
		TurnoMedico turnoNuevo= servicioUsuario.getTurnoByID(idTurno, idUsuario);
		turnoNuevo.setClienteAsignado(servicioRegistroLogin.obtenerUsuarioPorId(idUsuario));
		model.put("turno", turnoNuevo);
		
		
		MercadoPago.SDK.setAccessToken("TEST-4705968898385123-111613-94630486744c2b803eca9c9073c3cb15-160323409");

		Preference preference = new Preference();
		
		
		preference.setBackUrls(
				new BackUrls().setFailure("http://localhost:8080/proyecto-limpio-spring2/pagofallido?idTurno="+turnoNuevo.getId()+"&idUsuario=" + turnoNuevo.getClienteAsignado().getIdUsuario())
							  .setPending("http://localhost:8080/proyecto-limpio-spring2/pagofallido?idTurno="+turnoNuevo.getId()+"&idUsuario=" + turnoNuevo.getClienteAsignado().getIdUsuario())
							  .setSuccess("http://localhost:8080/proyecto-limpio-spring2/pagoExitoso?idTurno="+turnoNuevo.getId()+"&idUsuario=" + turnoNuevo.getClienteAsignado().getIdUsuario())
				);
		
		// Crea un ítem en la preferencia
		Item item = new Item();
		item.setTitle("Turno medico #" + turnoNuevo.getId())
		    .setQuantity(1)
		    .setUnitPrice(turnoNuevo.getValorDeLaConsulta().floatValue());
		
		preference.appendItem(item);
		preference.save();
		
		model.put("preference", preference);
		model.put("problema", 4);
		return new ModelAndView("checkoutReserva" ,model);
	}
	
	
	@RequestMapping(path = "devolucionDinero", method= RequestMethod.GET)
	public ModelAndView devolucionDinero(@RequestParam ("idTurno") Integer id) throws MPException {
		ModelMap model = new ModelMap();
		
		TurnoMedico turno = servicioUsuario.getTurnoByOnlyID(id);
		Pagos pagoADevolver = servicioPagos.getPagoByIDTurnoandIdUser(turno.getId(), turno.getClienteAsignado().getIdUsuario());
		
		String paymentId= pagoADevolver.getPaymentId().toString();
		
		MercadoPago.SDK.setAccessToken("APP_USR-4705968898385123-111613-fad5d969f8511decebb5000b6a0fc1d9-160323409");
		
		MercadoPago.SDK.setClientId("4705968898385123");
		MercadoPago.SDK.setClientSecret("pD6o84iny2ZU4lT5i1JxhRiMbIjNETe4");
		
		Payment payment= Payment.findById(paymentId);
		
		//ArrayList<Refund> devoluciones = payment.getRefunds();
		
		
		model.put("p", payment);
		model.put("turno", turno);
		return new ModelAndView("devolucionDinero", model);
	}
	
	
	
	

}