package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Pagos;


public interface RepositorioPagos {
	void registrarPago(Pagos pago);
	Pagos getPagoByIDTurnoandIdUser(Integer idTurno, Integer idUser);
	Pagos getPagoByIdPago(Integer idPago);
	void actualizarEstadoPago(Pagos pago, String string);

}
