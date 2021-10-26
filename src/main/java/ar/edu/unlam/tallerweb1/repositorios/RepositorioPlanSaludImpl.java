package ar.edu.unlam.tallerweb1.repositorios;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository 
public class RepositorioPlanSaludImpl implements RepositorioPlanSalud{

	//Creo la session para conectarme con la BD
	private SessionFactory sesion;
	
	//Defino mi session
	//Con el Autowired Spring instancia mi objeto
	@Autowired
	public RepositorioPlanSaludImpl(SessionFactory sesion) {
		this.sesion = sesion;
	}

	//Recupero la edad a traves del id en la session actual
	//Uso un criterio para recuperar donde identificador y id tienen que ser iguales
	@Override
	public Integer recuperarEdad(Integer id) {
	
		
		Usuario usuario = (Usuario)sesion.getCurrentSession().
				createCriteria(Usuario.class).
				add(Restrictions.eq("idUsuario", id)).
				uniqueResult();
		
		return usuario.getEdad();
	}

	


	
}
