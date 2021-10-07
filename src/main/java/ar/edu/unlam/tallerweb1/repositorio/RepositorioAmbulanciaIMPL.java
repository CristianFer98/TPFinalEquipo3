package ar.edu.unlam.tallerweb1.repositorio;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Ambulancia;

@Repository
@Transactional
public class RepositorioAmbulanciaIMPL implements RepositorioAmbulancia {
	private SessionFactory sessionFactory;
	
	@Autowired
	public RepositorioAmbulanciaIMPL(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	@Override
	public void buscarAmbulancia() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Ambulancia> obtenerListaAmbulanciaDisponibles() {
		return sessionFactory
				      .getCurrentSession()
					  .createCriteria(Ambulancia.class)
					  .add(Restrictions.eq("disponible", true))
					  .list();		
	}


	@Override
	public void agregarAmbulancia(Ambulancia ambulancia) {
		sessionFactory.getCurrentSession().save(ambulancia);
		
	}

}
