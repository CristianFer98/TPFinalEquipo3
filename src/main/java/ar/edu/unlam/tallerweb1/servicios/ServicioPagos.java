package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Pagos;


public interface ServicioPagos {
	void guardarDatosDePagos(Pagos pago);

	Pagos getPagoByIDTurnoandIdUser(Integer integer, Integer idUser);

	void actualizarEstadoPago(Pagos pago, String string);

	Pagos getPagoByID(Integer id);
	

}
