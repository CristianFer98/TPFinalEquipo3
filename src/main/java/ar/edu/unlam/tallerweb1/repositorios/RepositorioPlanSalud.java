package ar.edu.unlam.tallerweb1.repositorios;

import java.time.LocalDate;

import ar.edu.unlam.tallerweb1.modelo.PlanSalud;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioPlanSalud {

	LocalDate recuperarEdad(Integer id);
	Boolean corroborarExistenciaDePlan(Integer id);
	void registrarSubscripcion(Integer idPlan, Integer idUsuario);
	PlanSalud obtenerPlanMedico(Integer idPlan);
	Usuario obtenerUsuario(Integer idUsuario);

}
