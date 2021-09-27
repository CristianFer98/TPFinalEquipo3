package ar.edu.unlam.tallerweb1.repositorio;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Doctor;


@Repository("RepositorioDoctor")
public class RepositorioDoctorIMPLEM implements RepositorioDoctor {
	private SessionFactory session;

	@Autowired
	public RepositorioDoctorIMPLEM(SessionFactory session) {
		this.session = session;
	}

	
	
	@Override
	public Long guardar(Doctor doctor) {
		session.getCurrentSession().save(doctor);
        return doctor.getIdDoctor();
	}

	@Override
	public Doctor buscarPorId(Long id) {
		Doctor doctor = session.getCurrentSession().get(Doctor.class, id);
        return doctor;
	}



	@Override
	public Doctor buscar() {
		// TODO Auto-generated method stub
		return null;
	}

}
