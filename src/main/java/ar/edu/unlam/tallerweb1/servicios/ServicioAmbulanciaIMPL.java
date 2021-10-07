package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Ambulancia;
import ar.edu.unlam.tallerweb1.repositorio.RepositorioAmbulancia;

@Service()
public class ServicioAmbulanciaIMPL implements ServicioAmbulancia {
	private RepositorioAmbulancia repositorioAmbulancia;
	
	@Autowired
	public ServicioAmbulanciaIMPL(RepositorioAmbulancia repositorioAmbulancia) {
		this.repositorioAmbulancia = repositorioAmbulancia;
	}

	@Override
	public List<Ambulancia> obtenerAmbulanciasDisponibles() {		
		return repositorioAmbulancia.obtenerListaAmbulanciaDisponibles();
	}

	@Override
	public void agregarAmbulancia(Ambulancia ambulancia) {
		repositorioAmbulancia.agregarAmbulancia(ambulancia);		
	}

	@Override
	public Ambulancia obtenerPrimerAmbulanciaDisponible() {
		List<Ambulancia> actual = obtenerAmbulanciasDisponibles();
		
		for (Ambulancia a : actual) {
			if (a.getDisponible().equals(true)) {
				return a;
			}
		}
		return null;
	}
	
	

}
