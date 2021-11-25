package ar.edu.unlam.tallerweb1.repositorios;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.PlanSalud;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository
@Transactional
public class RepositorioPlanSaludImpl implements RepositorioPlanSalud {

	private SessionFactory session;

	@Autowired
	public RepositorioPlanSaludImpl(SessionFactory session) {
		this.session = session;
	}

	
	@SuppressWarnings("deprecation")
	private Usuario recuperarUsuarioPorId(Integer id) {
		return (Usuario) session.getCurrentSession().createCriteria(Usuario.class).add(Restrictions.eq("idUsuario", id))
				.uniqueResult();
	}


	@SuppressWarnings("deprecation")
	@Override
	public PlanSalud obtenerPlanMedico(Integer idPlan) {

		return (PlanSalud) session.getCurrentSession().createCriteria(PlanSalud.class)
				.add(Restrictions.eq("idPlanSalud", idPlan)).uniqueResult();

	}

	@Override
	public void registrarSubscripcion(Integer idPlan, Integer idUsuario) {
		Usuario usuario = recuperarUsuarioPorId(idUsuario);
		PlanSalud planAsignado = obtenerPlanMedico(idPlan);

		usuario.setPlan(planAsignado);

		session.getCurrentSession().update(usuario);

	}

	@SuppressWarnings("deprecation")
	@Override
	public Usuario obtenerUsuario(Integer idUsuario) {
		return (Usuario) session.getCurrentSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("idUsuario", idUsuario)).uniqueResult();
	}

}
