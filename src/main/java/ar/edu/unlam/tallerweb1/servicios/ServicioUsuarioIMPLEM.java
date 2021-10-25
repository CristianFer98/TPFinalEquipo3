package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;

@Service()
public class ServicioUsuarioIMPLEM implements ServicioUsuario{
	private RepositorioUsuario repositorio;
	
	@Autowired
	public ServicioUsuarioIMPLEM(RepositorioUsuario repositorio) {
		this.repositorio = repositorio;
	}
	
	
	

	@Override
	public Usuario obtenerUsuarioPorId(Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}


	
	

}
