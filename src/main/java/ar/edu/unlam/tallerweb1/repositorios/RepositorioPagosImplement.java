package ar.edu.unlam.tallerweb1.repositorios;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import ar.edu.unlam.tallerweb1.modelo.Pagos;


@Repository
public class RepositorioPagosImplement implements RepositorioPagos {
	private SessionFactory session;
	
	@Autowired
	public RepositorioPagosImplement(SessionFactory session) {
		this.session = session;
	}

	@Override
	public void registrarPago(Pagos pago) {
		session.getCurrentSession().save(pago);

	}

	@SuppressWarnings("deprecation")
	@Override
	public Pagos getPagoByIDTurnoandIdUser(Integer idTurno, Integer idUser) {
		return (Pagos) session.getCurrentSession()
				.createCriteria(Pagos.class)
				.add(Restrictions.eq("turno.id", idTurno))
				.add(Restrictions.eq("cliente.idUsuario", idUser))
				.uniqueResult();
				
	}

	@Override
	public Pagos getPagoByIdPago(Integer idPago) {
		return (Pagos)session.getCurrentSession().get(Pagos.class, idPago);
	}

	@Override
	public void actualizarEstadoPago(Pagos pago, String string) {
		Pagos pagoUpdate= session.getCurrentSession().get(Pagos.class, pago.getIdPago());
		pagoUpdate.setEstado(string);
		session.getCurrentSession().save(pagoUpdate);		
	}

}
