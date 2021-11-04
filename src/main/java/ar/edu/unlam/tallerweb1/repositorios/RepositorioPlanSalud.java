package ar.edu.unlam.tallerweb1.repositorios;

import java.time.LocalDate;

public interface RepositorioPlanSalud {

	LocalDate recuperarEdad(Integer id);
	Boolean corroborarExistenciaDePlan(Integer id);
	void suscribirseAPlanMedico(Integer id, Double descuento);

}
