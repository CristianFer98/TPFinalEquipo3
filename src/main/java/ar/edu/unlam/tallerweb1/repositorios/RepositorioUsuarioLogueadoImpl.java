package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.TurnoMedico;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository
@Transactional
public class RepositorioUsuarioLogueadoImpl implements RepositorioUsuarioLogueado {

	SessionFactory session;

	@Autowired
	public RepositorioUsuarioLogueadoImpl(SessionFactory session) {
		this.session = session;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Especialidad> listarEspecialidades() {
		return (List<Especialidad>) session.getCurrentSession().createCriteria(Especialidad.class).list();

	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Usuario> listarMedicosPorEspecialidad(Integer idEspecialidad) {
		Especialidad especialidad = buscarEspecialidadPorId(idEspecialidad);
		return (List<Usuario>) session.getCurrentSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("especialidad", especialidad)).list();
	}

	@SuppressWarnings("deprecation")
	private Especialidad buscarEspecialidadPorId(Integer idEspecialidad) {

		return (Especialidad) session.getCurrentSession().createCriteria(Especialidad.class)
				.add(Restrictions.eq("idEspecialidad", idEspecialidad)).uniqueResult();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<TurnoMedico> listarTurnosDisponibles(Integer idMedico) {
		Usuario medico = buscarMedicoPorId(idMedico);

		return (List<TurnoMedico>) session.getCurrentSession().createCriteria(TurnoMedico.class)
				.add(Restrictions.eq("medicoAsignado", medico)).add(Restrictions.eq("estado", true)).list();
	}

	@SuppressWarnings("deprecation")
	private Usuario buscarMedicoPorId(Integer idMedico) {
		return (Usuario) session.getCurrentSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("idUsuario", idMedico)).uniqueResult();

	}

	@Override
	public TurnoMedico reservarTurno(TurnoMedico turno, Integer idUsuario) {
		Usuario usuario = obtenerUsuarioPorId(idUsuario);
		
		
		turno.setEstado(false);
		turno.setClienteAsignado(usuario);
		

		session.getCurrentSession().update(turno);
		return turno;

	}

	@SuppressWarnings("deprecation")
	private Usuario obtenerUsuarioPorId(Integer idUsuario) {
		return (Usuario) session.getCurrentSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("idUsuario", idUsuario)).uniqueResult();

	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<TurnoMedico> verMisTurnos(Integer id) {
		Usuario usuario = obtenerUsuarioPorId(id);

		return (List<TurnoMedico>) session.getCurrentSession().createCriteria(TurnoMedico.class)
				.add(Restrictions.eq("clienteAsignado", usuario)).list();
	}

	@Override
	public Usuario obtenerMedico(Integer idMedico) {
		return obtenerUsuarioPorId(idMedico);
	}

	@SuppressWarnings("deprecation")
	@Override
	public TurnoMedico obtenerTurno(Integer idTurno) {
		return (TurnoMedico) session.getCurrentSession().createCriteria(TurnoMedico.class).add(Restrictions.eq("id", idTurno)).uniqueResult();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Usuario obtenerUsuario(Integer idUsuario) {
		return (Usuario) session.getCurrentSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("idUsuario", idUsuario)).uniqueResult();
	}

	@Override
	public void cancelarTurno(Integer idTurno) {
		TurnoMedico turno = obtenerTurno(idTurno);
		
		turno.setEstado(true);
		turno.setClienteAsignado(null);
		turno.setValorFinal(turno.getValorDeLaConsulta());
		session.getCurrentSession().update(turno);
		
	}

	@Override
	public void setPagadoTurno(TurnoMedico turno,Boolean estado) {
		TurnoMedico t=session.getCurrentSession().get(TurnoMedico.class, turno.getId());
		t.setPagado(estado);
		session.getCurrentSession().save(t);	 
	}

}
