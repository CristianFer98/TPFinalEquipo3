package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Doctor;
import ar.edu.unlam.tallerweb1.servicios.ServListadoEspecialidadINTERFAZ;

@Controller
public class ControladorInterno {
// una vez estoy en la pagina principal, y voy al href especialidades. las debo mostrar
	
	private ServListadoEspecialidadINTERFAZ servicioListado;
	

	@Autowired
	public ControladorInterno(ServListadoEspecialidadINTERFAZ servicioListado) {
		this.servicioListado = servicioListado;
	}
	
	
	//mapeo para ir a las especialidades
	@RequestMapping (path="/especialidades" )
	public ModelAndView mostrarEspecialidades () {
		return new ModelAndView("especialidades");
	
}
	
	// mapeo para mostrar los cardiologos
	@RequestMapping (path="/cardiologia")
	public ModelAndView listarCardiologos () {
		ModelMap model = new ModelMap();
		List<Doctor> cardiologos = servicioListado.listarCardiologos();
		Integer numero= cardiologos.size();
		model.put("cantidad", numero);
		return new ModelAndView ("cardiologia", model); //funciona.
	}
}
