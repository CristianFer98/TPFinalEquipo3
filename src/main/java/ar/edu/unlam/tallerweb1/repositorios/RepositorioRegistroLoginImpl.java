package ar.edu.unlam.tallerweb1.repositorios;

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
	public Integer registrarUsuario(Usuario usuario) throws emailExistenteException {//se registra el usuario, cualquiera sea.
		if (obtenerUsuarioPorEmail(usuario.getEmail()) != null) {
			throw new emailExistenteException();
		} else {
			 session.getCurrentSession().save(usuario);
			  Usuario usuario1 = obtenerUsuarioPorEmail(usuario.getEmail());
			  return usuario1.getIdUsuario();
		}
	} 

	@SuppressWarnings("deprecation")
	@Override
	public Usuario obtenerUsuarioPorEmail(String email) {
		return (Usuario) session.getCurrentSession().createCriteria(Usuario.class).add(Restrictions.eq("email", email))
				.uniqueResult();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Usuario iniciarSesion(String email, String contra) {
		return  (Usuario) session.getCurrentSession().createCriteria(Usuario.class).add(Restrictions.eq("email", email))
				.add(Restrictions.eq("contrasenia", contra)).uniqueResult();

	}

	@SuppressWarnings("deprecation")
	@Override
	public Usuario obtenerUsuarioPorID(Integer id) {
		return (Usuario) session.getCurrentSession().createCriteria(Usuario.class).add(Restrictions.eq("idUsuario", id))
				.uniqueResult();
	}

}
