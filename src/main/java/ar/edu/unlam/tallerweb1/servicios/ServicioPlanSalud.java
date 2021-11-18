package ar.edu.unlam.tallerweb1.servicios;

public interface ServicioPlanSalud {


	void suscribirseAPlanMedico(Integer id, Double descuento);

	Boolean comprobarExistenciaDePlan(Integer id);


}
