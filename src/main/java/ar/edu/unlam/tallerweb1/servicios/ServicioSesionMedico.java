package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.DatosDeActualizacionPerfilMedico;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioSesionMedico {

	Boolean cargarDatos(DatosDeActualizacionPerfilMedico datos, Integer id);
	Usuario obtenerInformacion(Integer id);
}
