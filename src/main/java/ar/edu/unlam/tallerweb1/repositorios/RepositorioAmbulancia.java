package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Ambulancia;
import ar.edu.unlam.tallerweb1.modelo.SolicitudUsuarioAmbulancia;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioAmbulancia {
	Ambulancia buscarAmbulancia(String patente);
	Integer agregarAmbulancia(Ambulancia ambulancia);
	List <Ambulancia> obtenerListaAmbulanciaDisponibles();
	void guardarRegistro(SolicitudUsuarioAmbulancia soli);
	void actualizarEstadoAmbulancia(Ambulancia ambulancia, Boolean bol);
	List<SolicitudUsuarioAmbulancia> obtenerListaDeAmbulanciasQuePidioUsuario(Usuario user);
	SolicitudUsuarioAmbulancia obtenerSolicitudDeAmbulanciaPORID(Integer id);
	void actualizarRegistro(SolicitudUsuarioAmbulancia soli, Boolean bol);
	List<Ambulancia> obtenerTodasLasAmbulancias();
	void eliminarAmbulancia(Ambulancia amb);
	

}
