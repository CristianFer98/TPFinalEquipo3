package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Ambulancia;
import ar.edu.unlam.tallerweb1.modelo.DatosSolicitudAmbulancia;
import ar.edu.unlam.tallerweb1.modelo.SolicitudUsuarioAmbulancia;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
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

	@Override
	public Integer pedirAmbulancia(DatosSolicitudAmbulancia datos){
		Ambulancia amb= obtenerPrimerAmbulanciaDisponible();
		Boolean check= verificarSiUsuarioPidioAmbulancia(datos.getUser());
		
		if (amb == null) {
			throw new NoHayAmbulanciasDisponiblesException();
		}
		if (check == true) {
			throw new UsuarioYaPidioAmbulanciaExeception();
		}
		
		cambiarEstadoAmbulancia(amb, false);
		datos.setAmbulancia(amb);
		SolicitudUsuarioAmbulancia soli = new SolicitudUsuarioAmbulancia(datos);
		soli.setAtendido(false);
		
		repositorioAmbulancia.guardarRegistro(soli);
		
		return soli.getIdSolicitud();		
	}

	private Boolean verificarSiUsuarioPidioAmbulancia(Usuario user) {
		List <SolicitudUsuarioAmbulancia> listasDeAmbulanciasDelUsuario = repositorioAmbulancia.obtenerListaDeAmbulanciasQuePidioUsuario(user);
		
		for (SolicitudUsuarioAmbulancia i : listasDeAmbulanciasDelUsuario) {
			if (i.getAtendido() == false) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public SolicitudUsuarioAmbulancia obtenerSolicitudPORID(Integer id) {
		return repositorioAmbulancia.obtenerSolicitudDeAmbulanciaPORID(id);
	}

	@Override
	public List<SolicitudUsuarioAmbulancia> obtenerListaDeAmbulanciasQuePidioUsuario(Usuario user) {
		return repositorioAmbulancia.obtenerListaDeAmbulanciasQuePidioUsuario(user);
	}

	@Override
	public void cambiarEstadoConsulta(SolicitudUsuarioAmbulancia soli, Boolean bol) {
		repositorioAmbulancia.actualizarRegistro(soli, bol);
	}

	@Override
	public SolicitudUsuarioAmbulancia obtenerConsultaSinAtenderPorUsuario(Usuario user) {
		List <SolicitudUsuarioAmbulancia> listasDeAmbulanciasDelUsuario = repositorioAmbulancia.obtenerListaDeAmbulanciasQuePidioUsuario(user);
		
		for (SolicitudUsuarioAmbulancia i : listasDeAmbulanciasDelUsuario) {
			if (i.getAtendido() == false) {
				return i;
			}
		}
		
		return null;
	}
	
	

}
