package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Doctor;
import ar.edu.unlam.tallerweb1.repositorios.ListadoEspecialidadINTERFAZ;

@Service
@Transactional
public class ServListadoEspecialidad implements ServListadoEspecialidadINTERFAZ {

	private ListadoEspecialidadINTERFAZ repo;
	
	@Autowired
	public ServListadoEspecialidad (ListadoEspecialidadINTERFAZ repositorio) {
		this.repo = repositorio;
	}
	
	@Override
	public List<Doctor> listarCardiologos() {
		return repo.listarCardiologos();
	}

}
