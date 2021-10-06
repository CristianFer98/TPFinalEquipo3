package ar.edu.unlam.tallerweb1.servicios;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;



public class DoctorServicioTest {
	//1. cargar Calificacion
	//2. obtener calificacion
	//3. que no cargue la calificacion si no esta entre 0 y 5
//	@Autowired
//	ServicioDoctor servicioDoc= new ServicioDoctorINTERFACE();

//	@Test
//	@Transactional @Rollback
//	public void cargarCalificacion() {
//			
//		Doctor doc= givenDoctor();
//		
//		servicioDoc.calificarDoctor(doc, 3);
//		
//		Double actual= servicioDoc.obtenerCalificaionDoctor(doc);
//		Double esperado= 3.0;
//		
//		assertEquals(esperado, actual);
//	}
//	
//	@Test
//	@Transactional @Rollback
//	public void queCalculeBienelPromedioConUnSoloDecimal() {
//		Doctor doc =  givenDoctor();
//		
//		servicioDoc.calificarDoctor(doc, 3);
//		servicioDoc.calificarDoctor(doc, 5);
//		servicioDoc.calificarDoctor(doc, 2);
//		
//		Double esperado= 3.3;
//		Double obtenido= servicioDoc.obtenerCalificaionDoctor(doc);
//		
//		
//		assertEquals(esperado, obtenido);	
//	}
//	
//	@Test
//	@Transactional @Rollback
//	public void queNoCargueLaCalificaionSiNoEstaEntre0o5() {
//		Doctor doc= givenDoctor();
//		
//		Boolean obt1= servicioDoc.calificarDoctor(doc, -1);
//		Boolean obt2= servicioDoc.calificarDoctor(doc, 6);
//		
//		assertFalse(obt1);
//		assertFalse(obt2);
//		assertEquals(doc.getCalificacion().size(),0);
//		
//	}
//	
//
//	//CREO DOCTOR CON UN ARRAYLIST PREDEFINIDA
//
//	private Doctor givenDoctor() {
//		Doctor doc= new Doctor();
//		
//		ArrayList<Integer> array = new ArrayList<Integer>();
//		doc.setCalificacion(array);
//				
//		return doc;
//	}
//	
//	
	
	
}
