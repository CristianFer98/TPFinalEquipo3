package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RepoReserva implements RepoReservaINTERFAZ {

	private SessionFactory sessionFactory;
	
	@Autowired
	public RepoReserva (SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void reservarTurno(Integer idMedico, Integer idUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelarTurno(Integer idMedico, Integer idUsuario) {
		// TODO Auto-generated method stub
		
	}

	

}
