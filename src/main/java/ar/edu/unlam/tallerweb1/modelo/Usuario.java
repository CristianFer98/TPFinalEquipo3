package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {

	//este va a ser el usuario que se registrara en el sistema
	//va a ser de 3 tipos. cliente, medico y admin. Por el momento
	//la forma de identificarlos va a ser con un valor booleano ya que no 
	//sabemos como joinear tablas para traer su valor especifico. 
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	
	@Column 
	private String contrasenia;
	
	@Column 
	private String email;
	

	@Column
	private boolean isAdmin;
	
	@Column
	private boolean isCliente;
	
	@Column
	private boolean isMedico;
	
	public Usuario() {
		
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean isCliente() {
		return isCliente;
	}

	public void setCliente(boolean isCliente) {
		this.isCliente = isCliente;
	}

	public boolean isMedico() {
		return isMedico;
	}

	public void setMedico(boolean isMedico) {
		this.isMedico = isMedico;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
