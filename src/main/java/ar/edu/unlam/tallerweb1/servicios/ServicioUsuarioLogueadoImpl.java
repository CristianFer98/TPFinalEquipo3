package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.TurnoMedico;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuarioLogueado;

@Service
public class ServicioUsuarioLogueadoImpl implements ServicioUsuarioLogueado {

	RepositorioUsuarioLogueado repositorio;
	
	@Autowired
	public ServicioUsuarioLogueadoImpl(RepositorioUsuarioLogueado repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<Especialidad> listarEspecialidades() {
		return repositorio.listarEspecialidades(); 
	}

	

	
	@Override
	public List<Usuario> listarMedicosPorEspecialidad(Integer idEspecialidad) {
		return repositorio.listarMedicosPorEspecialidad(idEspecialidad);
	}

	@Override
	public List<TurnoMedico> listarTurnos(Integer idMedico) {
		
		return repositorio.listarTurnosDisponibles(idMedico);
	}

	@Override
	public boolean reservarTurno(Integer idTurno, Integer idUsuario) {

		return repositorio.reservarTurno(idTurno , idUsuario);
	}
	
	
	
}