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
			Especialidad  especialidad = buscarEspecialidadPorId(datos.getEspecialidad());
			usuario.setEspecialidad(especialidad);
			usuario.setFoto(datos.getFoto());
			usuario.setTelefono(datos.getTelefono());
			usuario.setPaginaPersonal(datos.getPaginaPersonal());
			session.getCurrentSession().update(usuario);
			return obtenerUsuarioPorId(id);
		}

		return null;
	}

	public Especialidad buscarEspecialidadPorId(Integer idEspecialidad) {
		return (Especialidad) session.getCurrentSession().createCriteria(Especialidad.class)
				.add(Restrictions.eq("idEspecialidad", idEspecialidad)).uniqueResult();

	}

	@Override
	public Usuario obtenerUsuarioPorId(Integer idUsuario) {
		return (Usuario) session.getCurrentSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("idUsuario", idUsuario)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Especialidad> obtenerListaDeEspecializacion() {
		return (List<Especialidad>) session.getCurrentSession().createCriteria(Especialidad.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dias> obtenerDiasDeLaSemana() {
		return (List <Dias>) session.getCurrentSession().createCriteria(Dias.class).list();
	}

	@Override
	public boolean cargarAgenda(ArrayList<TurnoMedico> turnosNuevos, Integer id) {
		
		Usuario medico = obtenerUsuarioPorId(id);
		
		for (TurnoMedico turnoMedico : turnosNuevos) {
			turnoMedico.setMedicoAsignado(medico); 
			session.getCurrentSession().save(turnoMedico);
		}
		
		return true;
	}

}
