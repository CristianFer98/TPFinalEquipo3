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
	public TurnoMedico reservarTurno(Integer idTurno, Integer idUsuario) {	
		TurnoMedico turno = repositorio.obtenerTurno(idTurno);
		Usuario usuario = repositorio.obtenerUsuario(idUsuario);
		
		if (usuario.getPlan() != null) {
			Double descuento = calcularDescuento(turno, usuario);
			turno.setValorFinal(descuento);
		}
		
		
		return repositorio.reservarTurno(turno , idUsuario);
	}

	private Double calcularDescuento(TurnoMedico turno, Usuario usuario) {
		Double valorComun = turno.getValorDeLaConsulta();
		Double descuento = usuario.getPlan().getDescuento();
		Double valorFinal = valorComun - ((valorComun * descuento)/100);
		return valorFinal;
	}

	@Override
	public List<TurnoMedico> verMisTurnos(Integer id) {
		return repositorio.verMisTurnos(id);
	}

	@Override
	public Usuario obtenerMedico(Integer idMedico) {
		return repositorio.obtenerMedico(idMedico);
	}

	@Override
	public void cancelarTurno(Integer idTurno) {
		repositorio.cancelarTurno(idTurno);
		
	}

	@Override
	public TurnoMedico getTurnoByID(Integer idTurno, Integer idUsuario) {
		//aplicar descuento al turno si el usuario lo tiene.
		Usuario usuario = obtenerMedico(idUsuario);
		TurnoMedico turno = repositorio.obtenerTurno(idTurno);	
		
		if (usuario.getPlan() != null) {
			Double descuento = calcularDescuento(turno, usuario);
			turno.setValorDeLaConsulta(descuento);//el descuento aplicado por la consulta nunca se guarda
												// EN LA BD. se aplican los descuentos en tiempo de ejecucion.

		}
		
		return turno;	
	}

	@Override
	public void setPagadoTurno(TurnoMedico turno,Boolean estado) {
		repositorio.setPagadoTurno(turno,estado);	
	}
	
	
	
}
