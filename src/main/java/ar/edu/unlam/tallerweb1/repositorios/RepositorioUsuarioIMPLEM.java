package ar.edu.unlam.tallerweb1.repositorios;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Ambulancia;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository()
@Transactional
public class RepositorioUsuarioIMPLEM implements RepositorioUsuario{
	private SessionFactory sessionFactory;

	@Autowired
	public RepositorioUsuarioIMPLEM(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Usuario buscarUsuario(Integer id) {
		return (Usuario) sessionFactory
			      .getCurrentSession()
				  .createCriteria(Usuario.class)
				  .add(Restrictions.eq("idUsuario", id))
				  .uniqueResult();
	}
	

	
	
	

}
