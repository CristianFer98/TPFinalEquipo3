package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Doctor;
@Repository
public class RepoListadoDeEspecialidad implements ListadoEspecialidadINTERFAZ {

	private SessionFactory session;
	
	@Autowired
	public RepoListadoDeEspecialidad (SessionFactory session) {
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Doctor> listarCardiologos() {
		return (List<Doctor>) session.getCurrentSession()
                .createCriteria(Doctor.class)
                .add(Restrictions.eq("especialidad", "cardiologo"))
                .list();
		 
	}

}
