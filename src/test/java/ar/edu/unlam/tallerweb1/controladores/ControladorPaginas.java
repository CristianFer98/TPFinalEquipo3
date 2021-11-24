package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorPaginas {
	
	@RequestMapping (path = "index")
	public ModelAndView irAIndex() {
		return new ModelAndView("index.jsp");	
	}

}
