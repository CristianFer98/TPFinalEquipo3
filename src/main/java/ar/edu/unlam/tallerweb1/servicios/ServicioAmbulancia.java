package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Ambulancia;

public interface ServicioAmbulancia {
	void agregarAmbulancia(Ambulancia ambulancia);
	List<Ambulancia> obtenerAmbulanciasDisponibles();
	Ambulancia obtenerPrimerAmbulanciaDisponible();
	

}
