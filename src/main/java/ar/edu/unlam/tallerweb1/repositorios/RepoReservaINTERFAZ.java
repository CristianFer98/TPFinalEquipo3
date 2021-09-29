package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;


public interface RepoReservaINTERFAZ {

	
	void reservarTurno(Integer idMedico, Integer idUsuario); 
	void cancelarTurno(Integer idMedico, Integer idUsuario);
}
