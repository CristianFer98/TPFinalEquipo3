package ar.edu.unlam.tallerweb1.repositorio;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.modelo.PlanBasico;
import ar.edu.unlam.tallerweb1.persistencia.SpringTest;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPlanSalud;

public class RepositorioPlanSaludTest extends SpringTest {
	
	@Autowired
    private RepositorioPlanSalud repositorio;
	
	@Test
	@Transactional
	@Rollback
	public void recuperarEdadDeberiaPersistirla() {
		PlanBasico basico = givenExisteUnPlanBasico();
		
//		Integer edad = whenRecuperoEdad(basico);
//		thenRecuperoEdadExitoso(edad);
	}
	
	private PlanBasico givenExisteUnPlanBasico() {
		PlanBasico basico = new PlanBasico();
		return basico;
	}
	
//	private Integer whenRecuperoEdad(PlanBasico basico) {
//		repositorio.recuperarEdad(id);
//		return ;
//	}
//
//	private void thenRecuperoEdadExitoso(Integer edad) {
//		
//	}





}
