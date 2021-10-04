package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {

	// este va a ser el usuario que se registrara en el sistema
	// va a ser de 3 tipos. cliente, medico y admin. Por el momento
	// la forma de identificarlos va a ser con un valor booleano ya que no
	// sabemos como joinear tablas para traer su valor especifico.

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;

	@Column
	private String contrasenia;

	@Column
	private String email;

	

	public Usuario(String contrasenia, String email, Integer numeroDeDeTipoDeUsuario) {
		super();
		this.contrasenia = contrasenia;
		this.email = email;
		this.numeroDeDeTipoDeUsuario = numeroDeDeTipoDeUsuario;
	}

	// si es 1 = usuario comun. Si es 2 = medico. Si es 3 = admin.
	@Column
	private Integer numeroDeDeTipoDeUsuario;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getNumeroDeDeTipoDeUsuario() {
		return numeroDeDeTipoDeUsuario;
	}

	public void setNumeroDeDeTipoDeUsuario(Integer numeroDeDeTipoDeUsuario) {
		this.numeroDeDeTipoDeUsuario = numeroDeDeTipoDeUsuario;

}

}