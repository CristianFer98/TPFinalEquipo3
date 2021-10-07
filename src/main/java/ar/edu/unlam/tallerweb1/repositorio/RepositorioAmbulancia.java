package ar.edu.unlam.tallerweb1.repositorio;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Ambulancia;

public interface RepositorioAmbulancia {
	void buscarAmbulancia();
	void agregarAmbulancia(Ambulancia ambulancia);
	List <Ambulancia> obtenerListaAmbulanciaDisponibles();
	

}
