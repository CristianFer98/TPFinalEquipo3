package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPConfException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.preference.BackUrls;
import com.mercadopago.resources.datastructures.preference.Item;

import ar.edu.unlam.tallerweb1.modelo.PlanSalud;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioPlanSalud;

@Controller
public class ControladorPlanSalud {
	private ServicioPlanSalud servicio;

	@Autowired
	public ControladorPlanSalud(ServicioPlanSalud servicio) {
		this.servicio = servicio;
	}

	@RequestMapping(path = "planes", method = RequestMethod.GET)
	public ModelAndView showPlanesMedicos(HttpServletRequest req) {
		// segun la edad del usuario el descuento al subscribirse al plan será
		// diferente//

		if (req.getSession().getAttribute("idUsuario") != null) {

			ModelMap model = new ModelMap();
			Integer idUsuario = (Integer) req.getSession().getAttribute("idUsuario");

			Usuario usuario = servicio.obtenerUsuario(idUsuario);

			Integer idPlanBasico = 1;
			Integer idPlanSilver = 2;
			Integer idPlanGold = 3;

			PlanSalud planBasico = servicio.obtenerPlan(idPlanBasico);
			PlanSalud planSilver = servicio.obtenerPlan(idPlanSilver);
			PlanSalud planGold = servicio.obtenerPlan(idPlanGold);

			Preference PreferenciaBasico = generarPreferenciaBasico(planBasico);
			Preference PreferenciaSilver = generarPreferenciaSilver(planSilver);
			Preference PreferenciaGold = generarPreferenciaGold(planGold);

			model.put("preferenciaBasico", PreferenciaBasico);
			model.put("preferenciaSilver", PreferenciaSilver);
			model.put("preferenciaGold", PreferenciaGold);
			model.put("usuario", usuario);

			return new ModelAndView("planesMedicos", model);
		} else {
			return new ModelAndView("index");

		}

	}

	@RequestMapping(path = "registrarPlan", method = RequestMethod.GET)
	public ModelAndView registrarSubscripcionSalud(@RequestParam("idPlanSalud") Integer idPlan,
			HttpServletRequest req) {

		if (req.getSession().getAttribute("idUsuario") != null) {

			Integer idUsuario = (Integer) req.getSession().getAttribute("idUsuario");

			servicio.registrarSubscripcion(idPlan, idUsuario);

			return new ModelAndView("subscripcionExitosa");
		} else {
			return new ModelAndView("index");

		}
	}

	public Preference generarPreferenciaBasico(PlanSalud planBasico) {
		// integrar mercadoPago
		try {
			MercadoPago.SDK.setAccessToken("TEST-262736215767777-111621-1ac4ab10864719f8f5f2c61e9e77bd5e-183335380");
		} catch (MPConfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Crea un objeto de preferencia
		Preference preference = new Preference();

		// Crea un ítem en la preferencia
		Item item = new Item();
		item.setTitle(planBasico.getNombre()).setQuantity(1).setId("1") // porque es el plan con id uno.
				.setUnitPrice(planBasico.getPrecioDelPlan());
		preference.appendItem(item);

		preference.setBackUrls(
				new BackUrls().setSuccess("http://localhost:8080/proyecto-limpio-spring/registrarPlan?idPlanSalud="
						+ planBasico.getIdPlanSalud()));
		try {
			preference.save();
		} catch (MPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return preference;
	}

	public Preference generarPreferenciaSilver(PlanSalud planSilver) {
		// integrar mercadoPago
		try {
			MercadoPago.SDK.setAccessToken("TEST-262736215767777-111621-1ac4ab10864719f8f5f2c61e9e77bd5e-183335380");
		} catch (MPConfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Crea un objeto de preferencia
		Preference preference = new Preference();

		// Crea un ítem en la preferencia
		Item item = new Item();
		item.setTitle(planSilver.getNombre()).setQuantity(1).setId("2") // porque es el plan con id uno.
				.setUnitPrice(planSilver.getPrecioDelPlan());
		preference.appendItem(item);

		preference.setBackUrls(
				new BackUrls().setSuccess("http://localhost:8080/proyecto-limpio-spring/registrarPlan?idPlanSalud="
						+ planSilver.getIdPlanSalud()));
		try {
			preference.save();
		} catch (MPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return preference;
	}

	public Preference generarPreferenciaGold(PlanSalud planGold) {
		// integrar mercadoPago
		try {
			MercadoPago.SDK.setAccessToken("TEST-262736215767777-111621-1ac4ab10864719f8f5f2c61e9e77bd5e-183335380");
		} catch (MPConfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Crea un objeto de preferencia
		Preference preference = new Preference();

		// Crea un ítem en la preferencia
		Item item = new Item();
		item.setTitle(planGold.getNombre()).setQuantity(1).setId("3") // porque es el plan con id uno.
				.setUnitPrice(planGold.getPrecioDelPlan());
		preference.appendItem(item);
		preference.setBackUrls(new BackUrls().setSuccess(
				"http://localhost:8080/proyecto-limpio-spring/registrarPlan?idPlanSalud=" + planGold.getIdPlanSalud()));

		try {
			preference.save();
		} catch (MPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return preference;

	}
}