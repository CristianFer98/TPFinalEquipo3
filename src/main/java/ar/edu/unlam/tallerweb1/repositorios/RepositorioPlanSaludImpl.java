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

	@Override
	public Integer recuperarEdad(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	


	
}
