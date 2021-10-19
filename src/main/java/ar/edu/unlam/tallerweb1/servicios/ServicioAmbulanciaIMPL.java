package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Ambulancia;
import ar.edu.unlam.tallerweb1.modelo.SolicitudUsuarioAmbulancia;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAmbulancia;

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

	@Override
	public Ambulancia obtenerAmbulanciaPorPatente(String patenteAmbulancia) {
		return repositorioAmbulancia.buscarAmbulancia(patenteAmbulancia);	
	}

	@Override
	public void guardarRegistroSolicitudAmbulancia(SolicitudUsuarioAmbulancia soli) {
		repositorioAmbulancia.guardarRegistro(soli);
		
	}

	@Override
	public void cambiarEstadoAmbulancia(Ambulancia amb, Boolean bol) {
		repositorioAmbulancia.actualizarEstadoAmbulancia(amb, bol);
		
	}

	@Override
	public String reIngresoAmbulancia(Ambulancia amb, String patente) {
		String msj;
		
		if (amb == null) {
			Ambulancia amb2= new Ambulancia(patente, true);
			agregarAmbulancia(amb2);
			msj= "Ambulancia " + amb2.getPatenteAmbulancia() + " Creada";
		}else {
			cambiarEstadoAmbulancia(amb, true);
			msj= "Ambulancia " + amb.getPatenteAmbulancia() + " Disponible Nuevamente";
		}
		
		return msj;
	}
	
	

}
