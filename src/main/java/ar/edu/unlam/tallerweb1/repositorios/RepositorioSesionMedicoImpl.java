package ar.edu.unlam.tallerweb1.repositorios;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.DatosDeActualizacionPerfilMedico;
import ar.edu.unlam.tallerweb1.modelo.Dias;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.TurnoMedico;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository
@Transactional
public class RepositorioSesionMedicoImpl implements RepositorioSesionMedico {

	private SessionFactory session;

	@Autowired
	public RepositorioSesionMedicoImpl(SessionFactory session) {
		this.session = session;
	}

	@Override
	public Usuario cargarDatos(DatosDeActualizacionPerfilMedico datos, Integer id) {
		if (obtenerUsuarioPorId(id) != null) {

			Usuario usuario = obtenerUsuarioPorId(id);

			// usuario.setEspecialidad(datos.getEspecialidad());
			Especialidad especialidad = buscarEspecialidadPorId(datos.getEspecialidad());
			usuario.setEspecialidad(especialidad);
			usuario.setTelefono(datos.getTelefono());
			usuario.setPaginaPersonal(datos.getPaginaPersonal());
			session.getCurrentSession().update(usuario);
			return obtenerUsuarioPorId(id);
		}

		return null;
	}

	@SuppressWarnings("deprecation")
	public Especialidad buscarEspecialidadPorId(Integer idEspecialidad) {
		return (Especialidad) session.getCurrentSession().createCriteria(Especialidad.class)
				.add(Restrictions.eq("idEspecialidad", idEspecialidad)).uniqueResult();

	}

	@SuppressWarnings("deprecation")
	@Override
	public Usuario obtenerUsuarioPorId(Integer idUsuario) {
		return (Usuario) session.getCurrentSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("idUsuario", idUsuario)).uniqueResult();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Especialidad> obtenerListaDeEspecializacion() {
		return (List<Especialidad>) session.getCurrentSession().createCriteria(Especialidad.class).list();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Dias> obtenerDiasDeLaSemana() {
		return (List<Dias>) session.getCurrentSession().createCriteria(Dias.class).list();
	}

	@Override
	public boolean cargarAgenda(ArrayList<TurnoMedico> turnosNuevos, Integer id) {

		Usuario medico = obtenerUsuarioPorId(id);

		if (medico != null) {
			for (TurnoMedico turnoMedico : turnosNuevos) {
				turnoMedico.setMedicoAsignado(medico);
				session.getCurrentSession().save(turnoMedico);
			}
			return true;
		} else {
			return false;
		}

	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<TurnoMedico> verCompromisos(Integer id) {

		Usuario Medico = buscarMedicoPorId(id);

		return (List<TurnoMedico>) session.getCurrentSession().createCriteria(TurnoMedico.class)
				.add(Restrictions.eq("medicoAsignado", Medico)).add(Restrictions.eq("estado", false)).list();
	}

	@SuppressWarnings("deprecation")
	private Usuario buscarMedicoPorId(Integer id) {

		return (Usuario) session.getCurrentSession().createCriteria(Usuario.class).add(Restrictions.eq("idUsuario", id))
				.uniqueResult();
	}

}
