package ar.edu.unlam.tallerweb1.repositorios;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository
@Transactional
public class RepositorioPlanSaludImpl implements RepositorioPlanSalud {

	private SessionFactory session;

	@Autowired
	public RepositorioPlanSaludImpl(SessionFactory session) {
		this.session = session;
	}

	@Override
	public LocalDate recuperarEdad(Integer id) {

		Usuario usuario = recuperarUsuarioPorId(id);

		return usuario.getEdad();
	}

	@SuppressWarnings("deprecation")
	private Usuario recuperarUsuarioPorId(Integer id) {
		return (Usuario) session.getCurrentSession().createCriteria(Usuario.class).add(Restrictions.eq("idUsuario", id))
				.uniqueResult();
	}

	@Override
	public Boolean corroborarExistenciaDePlan(Integer id) {

		Usuario usuario = recuperarUsuarioPorId(id);
		if (usuario.getDescuentoPorPlanMedico() == null) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public void suscribirseAPlanMedico(Integer id, Double descuento) {
		Usuario usuario = recuperarUsuarioPorId(id);
		usuario.setDescuentoPorPlanMedico(descuento);
		session.getCurrentSession().update(usuario);
	}

}
