package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Column;

public class DatosRegistroMedico {

	private String email;
	
	private String nombre;

	private Integer edad;
	
	private String contrasenia1; //seria el clave
	
	private String contrasenia2; //y el repiteclave

	private Integer numeroDeDeTipoDeUsuario = 2;

	//va a ser el admin quien pueda registrar en su cuenta nuevos medicos que accedan.
	//el unico que va a registrarse como tal. es el usuario comun
	

	public String getEmail() {
		return email;
	}
	
	public DatosRegistroMedico() {
		
	}

	public DatosRegistroMedico(String email, String contrasenia1, String contrasenia2) {
		super();
		this.email = email;
		this.contrasenia1 = contrasenia1;
		this.contrasenia2 = contrasenia2;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenia1() {
		return contrasenia1;
	}

	public void setContrasenia1(String contrasenia1) {
		this.contrasenia1 = contrasenia1;
	}

	public String getContrasenia2() {
		return contrasenia2;
	}

	public void setContrasenia2(String contrasenia2) {
		this.contrasenia2 = contrasenia2;
	}

	public Integer getNumeroDeDeTipoDeUsuario() {
		return numeroDeDeTipoDeUsuario;
	}

	public void setNumeroDeDeTipoDeUsuario(Integer numeroDeDeTipoDeUsuario) {
		this.numeroDeDeTipoDeUsuario = numeroDeDeTipoDeUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	
	


	
	
	
	
}