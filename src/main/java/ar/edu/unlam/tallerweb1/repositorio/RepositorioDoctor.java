package ar.edu.unlam.tallerweb1.repositorio;

import ar.edu.unlam.tallerweb1.modelo.Doctor;

public interface RepositorioDoctor {

	Long guardar(Doctor doctor);
	Doctor buscar();
	Doctor buscarPorId(Long id);
	

}
