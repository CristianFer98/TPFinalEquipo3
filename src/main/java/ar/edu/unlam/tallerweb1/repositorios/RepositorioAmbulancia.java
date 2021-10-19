package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Ambulancia;
import ar.edu.unlam.tallerweb1.modelo.SolicitudUsuarioAmbulancia;

public interface RepositorioAmbulancia {
	Ambulancia buscarAmbulancia(String patente);
	Integer agregarAmbulancia(Ambulancia ambulancia);
	List <Ambulancia> obtenerListaAmbulanciaDisponibles();
	void guardarRegistro(SolicitudUsuarioAmbulancia soli);
	void actualizarEstadoAmbulancia(Ambulancia ambulancia, Boolean bol);
	

}
