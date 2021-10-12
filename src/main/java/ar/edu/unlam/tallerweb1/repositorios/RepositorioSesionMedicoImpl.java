package ar.edu.unlam.tallerweb1.repositorios;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.DatosDeActualizacionPerfilMedico;
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
			usuario.setEspecialidad(datos.getEspecialidad());
			usuario.setFoto(datos.getFoto());
			usuario.setTelefono(datos.getTelefono());
			usuario.setPaginaPersonal(datos.getPaginaPersonal());
			session.getCurrentSession().update(usuario);
			return obtenerUsuarioPorId(id);
		}

		return null;
	}

	@Override
	public Usuario obtenerUsuarioPorId(Integer idUsuario) {
		return (Usuario) session.getCurrentSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("idUsuario", idUsuario)).uniqueResult();
	}

	

}
