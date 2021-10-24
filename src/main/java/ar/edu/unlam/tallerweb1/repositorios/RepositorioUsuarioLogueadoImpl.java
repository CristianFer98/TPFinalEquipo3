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

	@SuppressWarnings("unchecked")
	@Override
	public List<Especialidad> listarEspecialidades() {
		return (List<Especialidad>) session.getCurrentSession().createCriteria(Especialidad.class).list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listarMedicosPorEspecialidad(Integer idEspecialidad) {
		Especialidad especialidad = buscarEspecialidadPorId(idEspecialidad);
		return (List<Usuario>) session.getCurrentSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("especialidad", especialidad)).list();
	}

	private Especialidad buscarEspecialidadPorId(Integer idEspecialidad) {

		return (Especialidad) session.getCurrentSession().createCriteria(Especialidad.class)
				.add(Restrictions.eq("idEspecialidad", idEspecialidad)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TurnoMedico> listarTurnosDisponibles(Integer idMedico) {
		Usuario medico = buscarMedicoPorId(idMedico);

		return (List<TurnoMedico>) session.getCurrentSession().createCriteria(TurnoMedico.class)
				.add(Restrictions.eq("medicoAsignado", medico)).add(Restrictions.eq("estado", true)).list();
	}

	private Usuario buscarMedicoPorId(Integer idMedico) {
		return (Usuario) session.getCurrentSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("idUsuario", idMedico)).uniqueResult();

	}

	@Override
	public boolean reservarTurno(Integer idTurno, Integer idUsuario) {
		// obtengo el usuario, para asignarlo al turno
		Usuario usuario = obtenerUsuarioPorId(idUsuario);
		// obtengo el turno medico
		TurnoMedico turno = (TurnoMedico) session.getCurrentSession().createCriteria(TurnoMedico.class)
				.add(Restrictions.eq("id", idTurno)).uniqueResult();
		// seteo el turno para asignarle un usuario. La condicion de si un turno esta
		// reservado o no, es porque el id del paciente es null
		turno.setEstado(false);
		turno.setClienteAsignado(usuario);

		session.getCurrentSession().update(turno);
		return true;

	}

	private Usuario obtenerUsuarioPorId(Integer idUsuario) {
		return (Usuario) session.getCurrentSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("idUsuario", idUsuario)).uniqueResult();

	}

}
