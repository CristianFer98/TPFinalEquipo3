package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Doctor;
import ar.edu.unlam.tallerweb1.repositorio.RepositorioDoctor;

@Service
@Transactional
public class ServicioDoctorINTERFACE implements ServicioDoctor {
	@Inject
	RepositorioDoctor repositorio;
	

	@Override
	public void registrarDoctor(Doctor doctor) {
		repositorio.guardar(doctor);		
	}

}
