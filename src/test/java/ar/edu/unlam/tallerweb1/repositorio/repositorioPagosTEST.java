package ar.edu.unlam.tallerweb1.repositorio;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

import ar.edu.unlam.tallerweb1.modelo.Pagos;
import ar.edu.unlam.tallerweb1.modelo.TurnoMedico;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.persistencia.SpringTest;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPagos;

public class repositorioPagosTEST extends SpringTest{
	@Inject
	RepositorioPagos repositorio;


	
	@Test
	@Transactional
	@Rollback
	public void registrarPago() {
		TurnoMedico turno= new TurnoMedico();
		Usuario user= new Usuario();
		Pagos pago1 = new Pagos(123, user, turno, (float)1500);
		repositorio.registrarPago(pago1);
		
		Pagos pagoObtenido = repositorio.getPagoByIdPago(pago1.getIdPago());
		
		assertNotNull(pagoObtenido);
		
		
	}

}
