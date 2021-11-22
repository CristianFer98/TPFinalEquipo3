package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.PlanSalud;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioPlanSalud {



	Boolean comprobarExistenciaDePlan(Integer id);
	void registrarSubscripcion(Integer idPlan, Integer idUsuario);
	PlanSalud obtenerPlan(Integer idPlan);
	Usuario obtenerUsuario(Integer idUsuario);

	


}
