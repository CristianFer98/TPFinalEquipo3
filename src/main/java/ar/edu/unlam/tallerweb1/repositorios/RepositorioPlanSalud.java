package ar.edu.unlam.tallerweb1.repositorios;


import ar.edu.unlam.tallerweb1.modelo.PlanSalud;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioPlanSalud {


	void registrarSubscripcion(Integer idPlan, Integer idUsuario);
	PlanSalud obtenerPlanMedico(Integer idPlan);
	Usuario obtenerUsuario(Integer idUsuario);

}
