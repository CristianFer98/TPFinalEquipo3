package ar.edu.unlam.tallerweb1.servicios;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioPlanSalud;

@Service
@Transactional
public class ServicioPlanSaludImpl implements ServicioPlanSalud {

	private RepositorioPlanSalud repositorio;
	
	@Autowired
	public  ServicioPlanSaludImpl(RepositorioPlanSalud repositorio) {
		this.repositorio=repositorio;
	}
	
	@Override
	public Double cotizarbasico(Integer id) {
		
		Integer edad = this.repositorio.recuperarEdad(id);
		
		Double monto = 5000.0;
		
		if(edad<30) {
			return monto*0.60;
		}
		
		if(edad>80) {
			return monto; 
		}
		
		return monto*0.30;
	}
	
	@Override
	public Double cotizaravanzado(Integer id) {
		
		Integer edad = this.repositorio.recuperarEdad(id);
		
		Double monto = 5000.0;
		
		if(edad<30) {
			return monto*0.50;
		}
	
		if(edad>80)
			return monto;
		
		return monto*0.20;
	}
	


}
