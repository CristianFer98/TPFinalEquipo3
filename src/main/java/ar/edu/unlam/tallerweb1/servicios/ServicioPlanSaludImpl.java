package ar.edu.unlam.tallerweb1.servicios;

import java.time.LocalDate;
import java.time.Period;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		

	}

	@Override
	public void suscribirseAPlanMedico(Integer id, Double descuento) {
		repositorio.suscribirseAPlanMedico(id,descuento);
	}

}
