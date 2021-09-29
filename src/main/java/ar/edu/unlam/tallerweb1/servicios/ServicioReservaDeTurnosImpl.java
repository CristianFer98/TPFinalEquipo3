package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.repositorios.RepoReservaINTERFAZ;

@Service
@Transactional
public class ServicioReservaDeTurnosImpl implements ServicioReservaDeTurnoInterfaz {

	private RepoReservaINTERFAZ repositorio;

	@Autowired
	public ServicioReservaDeTurnosImpl(RepoReservaINTERFAZ repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public void reservarTurno(Integer idMedico, Integer idUsuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancelarTurno(Integer idMedico, Integer idUsuario) {
		// TODO Auto-generated method stub

	}


}
