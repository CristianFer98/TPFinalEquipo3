package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Ambulancia;
import ar.edu.unlam.tallerweb1.modelo.SolicitudUsuarioAmbulancia;

public interface ServicioAmbulancia {
	void agregarAmbulancia(Ambulancia ambulancia);
	List<Ambulancia> obtenerAmbulanciasDisponibles();
	Ambulancia obtenerPrimerAmbulanciaDisponible();
	Ambulancia obtenerAmbulanciaPorPatente(String patenteAmbulancia);
	void guardarRegistroSolicitudAmbulancia(SolicitudUsuarioAmbulancia soli);
	void cambiarEstadoAmbulancia(Ambulancia amb, Boolean bol);
	

}
