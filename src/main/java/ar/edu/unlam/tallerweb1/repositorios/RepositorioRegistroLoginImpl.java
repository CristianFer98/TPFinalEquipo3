package ar.edu.unlam.tallerweb1.repositorios;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository
public class RepositorioRegistroLoginImpl implements RepositorioRegistroLogin {

	private SessionFactory session;

	@Autowired
	public RepositorioRegistroLoginImpl(SessionFactory session) {
		this.session = session;
	}

	@Override
	public boolean registrarUsuario(Usuario usuario) {
		if (obtenerUsuarioPorEmail(usuario.getEmail()) != null) {
			return false;
		} else {
			session.getCurrentSession().save(usuario);
			return true;
		}
	}

	@Override
	public Usuario obtenerUsuarioPorEmail(String email) {
		return (Usuario) session.getCurrentSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("email", email))
				.uniqueResult();
	}

}
