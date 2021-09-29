package ar.edu.unlam.tallerweb1.controladores;

public class DatosRegistro {

	private Integer NombreUsuario;
	
	private String contraseña;
	
	
	

	public DatosRegistro() {
		super();
	}

	public Integer getNombreUsuario() {
		return NombreUsuario;
	}

	public void setNombreUsuario(Integer nombreUsuario) {
		NombreUsuario = nombreUsuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
	
	
}
