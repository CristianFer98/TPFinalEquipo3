package ar.edu.unlam.tallerweb1.servicios;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServicioOperacionesMatmeticaIMPL implements ServicioOperacionesMatematica{

	@Override
	public int sumarNumeros(int n1, int n2) {
		int suma= n1+n2;
		return suma;
	}

	@Override
	public int restarNumeros(int n1, int n2) {
		int resta= n1-n2;
		return resta;
	}
	
	
	
	

}
