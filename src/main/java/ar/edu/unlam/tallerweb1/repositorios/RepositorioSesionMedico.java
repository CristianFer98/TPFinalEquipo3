package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.DatosDeActualizacionPerfilMedico;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioSesionMedico {

		Usuario cargarDatos(DatosDeActualizacionPerfilMedico datos, Integer id);
		Usuario obtenerUsuarioPorId(Integer idUsuario);
}
