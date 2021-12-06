package ar.edu.unlam.tallerweb1.repositorios;

import java.time.LocalDateTime;
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

		Usuario usuario = obtenerUsuarioPorId(id);

		Especialidad especialidad = buscarEspecialidadPorId(datos.getEspecialidad());
		usuario.setEspecialidad(especialidad);
		usuario.setTelefono(datos.getTelefono());
		usuario.setPaginaPersonal(datos.getPaginaPersonal());
		session.getCurrentSession().update(usuario);
		return usuario;

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

		LocalDateTime fechaActual = LocalDateTime.now();

		List<TurnoMedico> listaDeCompromisos = obtenerListaDeCompromisosMedicos(id);

		for (TurnoMedico turnoMedico : listaDeCompromisos) {
			if (fechaActual.isAfter(turnoMedico.getFecha())) {
				turnoMedico.setRealizado(true);
				session.getCurrentSession().update(turnoMedico);
			}
		}

		return listaDeCompromisos;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	private List<TurnoMedico> obtenerListaDeCompromisosMedicos(Integer id) {
		Usuario Medico = buscarMedicoPorId(id);
		return (List<TurnoMedico>) session.getCurrentSession().createCriteria(TurnoMedico.class)
				.add(Restrictions.eq("medicoAsignado", Medico)).add(Restrictions.eq("estado", false)).list();
	}

	@SuppressWarnings("deprecation")
	public Usuario buscarMedicoPorId(Integer id) {

		return (Usuario) session.getCurrentSession().createCriteria(Usuario.class).add(Restrictions.eq("idUsuario", id))
				.uniqueResult();
	}

	@Override
	public void darDeBajaTurno(Integer idTurno) {

		TurnoMedico turno = buscarTurnoPorId(idTurno);
		turno.setTurnoDadoDeAlta(true);
		turno.setPagado(true);
		session.getCurrentSession().update(turno);

	}

	@SuppressWarnings("deprecation")
	public TurnoMedico buscarTurnoPorId(Integer idTurno) {
		return (TurnoMedico) session.getCurrentSession().createCriteria(TurnoMedico.class)
				.add(Restrictions.eq("id", idTurno)).uniqueResult();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<TurnoMedico> obtenerCalificacionDeMedico(Integer id) {

		Usuario medico = buscarMedicoPorId(id);
		
		return (List<TurnoMedico>) session.getCurrentSession().createCriteria(TurnoMedico.class)
				.add(Restrictions.eq("medicoAsignado", medico)).add(Restrictions.isNotNull("calificacion")).list();

	}

}
