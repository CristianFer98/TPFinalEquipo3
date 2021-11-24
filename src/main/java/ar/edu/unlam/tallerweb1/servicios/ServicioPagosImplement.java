package ar.edu.unlam.tallerweb1.servicios;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Pagos;
import ar.edu.unlam.tallerweb1.modelo.TurnoMedico;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPagos;

@Service
@Transactional
public class ServicioPagosImplement implements ServicioPagos{
	private RepositorioPagos repositorio;

	@Autowired
	public ServicioPagosImplement(RepositorioPagos repositorio) {
		this.repositorio = repositorio;
	}


	@Override
	public void guardarDatosDePagos(Pagos pago) {
		repositorio.registrarPago(pago);
		
	}


	@Override
	public Pagos getPagoByIDTurnoandIdUser(Integer idTurno, Integer idUser) {
		return repositorio.getPagoByIDTurnoandIdUser(idTurno,idUser);
	}


	@Override
	public void actualizarEstadoPago(Pagos pago, String string) {
		repositorio.actualizarEstadoPago(pago, string);
		
	}


	@Override
	public Pagos getPagoByID(Integer id) {
		return repositorio.getPagoByIdPago(id);
	}
	

}
