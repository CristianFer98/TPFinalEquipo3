package ar.edu.unlam.tallerweb1.servicios;

public interface ServicioPlanSalud {

	Double cotizarPlanMedico(Integer id);

	void suscribirseAPlanMedico(Integer id, Double descuento);


}
