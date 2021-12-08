package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Ambulancia;
import ar.edu.unlam.tallerweb1.modelo.SolicitudUsuarioAmbulancia;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository
@Transactional
public class RepositorioAmbulanciaIMPL implements RepositorioAmbulancia {
	private SessionFactory sessionFactory;
	
	@Autowired
	public RepositorioAmbulanciaIMPL(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	@SuppressWarnings("deprecation")
	@Override
	public Ambulancia buscarAmbulancia(String patente) {
		return (Ambulancia) sessionFactory
			      .getCurrentSession()
				  .createCriteria(Ambulancia.class)
				  .add(Restrictions.eq("patenteAmbulancia", patente))
				  .uniqueResult();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Ambulancia> obtenerListaAmbulanciaDisponibles() {
		return sessionFactory
				      .getCurrentSession()
					  .createCriteria(Ambulancia.class)
					  .add(Restrictions.eq("disponible", true))
					  .list();		
	}


	@Override
	public Integer agregarAmbulancia(Ambulancia ambulancia) {
		sessionFactory.getCurrentSession().save(ambulancia);
		return ambulancia.getIdAmbulancia();
		
	}


	@Override
	public void guardarRegistro(SolicitudUsuarioAmbulancia soli) {
		sessionFactory.getCurrentSession().save(soli);	
	}


	@Override
	public void actualizarEstadoAmbulancia(Ambulancia ambulancia, Boolean bol) {
		Ambulancia miAmb=sessionFactory.getCurrentSession().get(Ambulancia.class, ambulancia.getIdAmbulancia());
		miAmb.setDisponible(bol);
		
		sessionFactory.getCurrentSession().update(miAmb);	 
	}


	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<SolicitudUsuarioAmbulancia> obtenerListaDeAmbulanciasQuePidioUsuario(Usuario user) {
		return sessionFactory
			      .getCurrentSession()
				  .createCriteria(SolicitudUsuarioAmbulancia.class)
				  .add(Restrictions.eq("usuarioSolicitante", user))
				  .list();	
	}


	@SuppressWarnings("deprecation")
	@Override
	public SolicitudUsuarioAmbulancia obtenerSolicitudDeAmbulanciaPORID(Integer id) {
		return (SolicitudUsuarioAmbulancia) sessionFactory
			      .getCurrentSession()
				  .createCriteria(SolicitudUsuarioAmbulancia.class)
				  .add(Restrictions.eq("idSolicitud", id))
				  .uniqueResult();
	}


	@Override
	public void actualizarRegistro(SolicitudUsuarioAmbulancia soli, Boolean bol) {
		SolicitudUsuarioAmbulancia solicitud= obtenerSolicitudDeAmbulanciaPORID(soli.getIdSolicitud());
		
		solicitud.setDireccion(null);
		solicitud.setAtendido(true);
		solicitud.setUsuarioSolicitante(null);
		
		sessionFactory.getCurrentSession().update(solicitud); 
	}


	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Ambulancia> obtenerTodasLasAmbulancias() {
		return sessionFactory
			      .getCurrentSession()
				  .createCriteria(Ambulancia.class)
				  .list();
	}


	@Override
	public void eliminarAmbulancia(Ambulancia amb) {
		sessionFactory.getCurrentSession().remove(amb);
		
	}

}
