package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;


import ar.edu.unlam.tallerweb1.modelo.Ambulancia;
import ar.edu.unlam.tallerweb1.modelo.DatosSolicitudAmbulancia;
import ar.edu.unlam.tallerweb1.modelo.SolicitudUsuarioAmbulancia;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioAmbulancia {
	void agregarAmbulancia(Ambulancia ambulancia);
	List<Ambulancia> obtenerAmbulanciasDisponibles();
	Ambulancia obtenerPrimerAmbulanciaDisponible();
	Ambulancia obtenerAmbulanciaPorPatente(String patenteAmbulancia);
	void guardarRegistroSolicitudAmbulancia(SolicitudUsuarioAmbulancia soli);
	void cambiarEstadoAmbulancia(Ambulancia amb, Boolean bol);
	String reIngresoAmbulancia(Ambulancia amb, String patenteAmbulancia);
	Integer pedirAmbulancia(DatosSolicitudAmbulancia datos);
	SolicitudUsuarioAmbulancia obtenerSolicitudPORID(Integer id);
	List<SolicitudUsuarioAmbulancia> obtenerListaDeAmbulanciasQuePidioUsuario(Usuario user);
//	void atenderConsulta(SolicitudUsuarioAmbulancia soli, Boolean bol);
	SolicitudUsuarioAmbulancia obtenerConsultaSinAtenderPorUsuario(Usuario user);
	void cambiarEstadoConsulta(SolicitudUsuarioAmbulancia soli, Boolean bol);
	List<Ambulancia> obtenerTodasLasAmbulancias();
	void eliminarAmbulancia(Ambulancia amb);
	

}
