package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;


public interface ServicioReservaDeTurnoInterfaz {

 	void reservarTurno(Integer idMedico, Integer idUsuario); 
	void cancelarTurno(Integer idMedico, Integer idUsuario); 
	
	

}
