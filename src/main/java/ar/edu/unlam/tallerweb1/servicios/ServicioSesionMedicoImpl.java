package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.DatosDeActualizacionPerfilMedico;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioSesionMedico;

@Service
@Transactional
public class ServicioSesionMedicoImpl implements ServicioSesionMedico {

	private RepositorioSesionMedico repositorio;

	@Autowired
	public ServicioSesionMedicoImpl(RepositorioSesionMedico repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Boolean cargarDatos(DatosDeActualizacionPerfilMedico datos, Integer id) {
		if (repositorio.cargarDatos(datos, id) != null) {
			repositorio.cargarDatos(datos, id);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Usuario obtenerInformacion(Integer id) {//utilizo el metodo que me devuelve por id
		if (repositorio.obtenerUsuarioPorId(id) != null) {
			return repositorio.obtenerUsuarioPorId(id);
		}
		return null;
	}

}
