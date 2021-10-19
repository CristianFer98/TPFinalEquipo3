package ar.edu.unlam.tallerweb1.repositorio;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Ambulancia;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAmbulancia;

public class RepositorioAmbulanciaTest extends SpringTest{
	
	@Inject
	private RepositorioAmbulancia repositorio;
	
	
	
	//1. que registre ambulancia correctamente
	//2. que me actualize el estado de la ambulancia en la BBDD

	
	//1
	@Test
	@Transactional
	@Rollback
	public void testQueRegistreLaAmbulancia() {
		Ambulancia amb= givenAmbulanciaExistente();
		Integer idAmbRegistrada = whereRegistroAmbulancia(amb);
		
		//VERIFICACION
		Ambulancia ambRegistrada=repositorio.buscarAmbulancia(amb.getPatenteAmbulancia());
		Integer idAmbObtenida=amb.getIdAmbulancia();
		
		assertEquals(idAmbRegistrada, idAmbObtenida);		
	}
	
	//2.
	@Test
	@Transactional
	@Rollback
	public void queCambieElEstadoDeLaAmbEnLaBBDD() {
		Ambulancia amb= givenAmbulanciaExistente(); //devuelve ambulancia con disponible TRUE
		whereRegistroAmbulancia(amb);
		
		Boolean estadoActual= amb.getDisponible();
		
		//error
		repositorio.actualizarEstadoAmbulancia(amb, false);
		
		Boolean estadoObtenido= repositorio.buscarAmbulancia(amb.getPatenteAmbulancia()).getDisponible();
		Boolean estadoEsperado= false;
		
		assertNotEquals(estadoActual, estadoObtenido);
		assertEquals(estadoEsperado, estadoObtenido);
		
	}

	
	
	
	
	
	private Integer whereRegistroAmbulancia(Ambulancia amb) {
		repositorio.agregarAmbulancia(amb);
		return amb.getIdAmbulancia();
	}

	private Ambulancia givenAmbulanciaExistente() {
		Ambulancia amb= new Ambulancia("AAA222", true);
		return amb;
	}

}
