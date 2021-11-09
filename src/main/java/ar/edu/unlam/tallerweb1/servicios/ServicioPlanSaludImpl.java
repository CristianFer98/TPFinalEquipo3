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
	public Double cotizarPlanMedico(Integer id) {

		// comprobar que no tenga una suscripcion

		Boolean tienePlanMedico = this.repositorio.corroborarExistenciaDePlan(id);

		if (tienePlanMedico == true) {
			throw new cotizacionExistenteException();
		} else {
			LocalDate fechaNaciemiento = this.repositorio.recuperarEdad(id);
			LocalDate ahora = LocalDate.now();
			Period periodo = Period.between(fechaNaciemiento, ahora);

			Integer edad = periodo.getYears();

			Double porcentajeDescuento;

			if (edad < 30) {
				porcentajeDescuento = 50.0; // si es menor a 30 años se le descuenta 50% por consulta
				return porcentajeDescuento;
			}
			if (edad > 80) {
				porcentajeDescuento = 20.0; // si es mayor a 80 el plan le cubre un 20% por consulta
				return porcentajeDescuento;
			} else {
				porcentajeDescuento = 35.0; // si es mayor de 30 y menor de 80 un descuento del 35%
				return porcentajeDescuento;
			}
		}

	}

	@Override
	public void suscribirseAPlanMedico(Integer id, Double descuento) {
		repositorio.suscribirseAPlanMedico(id,descuento);
	}

}
