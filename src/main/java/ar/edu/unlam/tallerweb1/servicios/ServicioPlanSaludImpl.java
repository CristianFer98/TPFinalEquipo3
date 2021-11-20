package ar.edu.unlam.tallerweb1.servicios;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.PlanSalud;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.cotizacionExistenteException;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPlanSalud;

@Service
@Transactional
public class ServicioPlanSaludImpl implements ServicioPlanSalud {

	private RepositorioPlanSalud repositorio;

	@Autowired
	public ServicioPlanSaludImpl(RepositorioPlanSalud repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Boolean comprobarExistenciaDePlan(Integer id) {

		// comprobar que no tenga una suscripcion

		Boolean tienePlanMedico = this.repositorio.corroborarExistenciaDePlan(id);

		if (tienePlanMedico == true) {
			throw new cotizacionExistenteException();
		}
		
		return true;
		

		return true;

	}

	

	@Override
	public PlanSalud obtenerPlan(Integer idPlan) {
		return repositorio.obtenerPlanMedico(idPlan);
	}

	@Override
	public void registrarSubscripcion(Integer idPlan, Integer idUsuario) {
		repositorio.registrarSubscripcion(idPlan, idUsuario);
		
	}

	@Override
	public Usuario obtenerUsuario(Integer idUsuario) {
		return repositorio.obtenerUsuario(idUsuario);
	}

}