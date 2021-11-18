package ar.edu.unlam.tallerweb1.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Usuario {

	// este va a ser el usuario que se registrara en el sistema
	// va a ser de 3 tipos. cliente, medico y admin. Por el momento
	// la forma de identificarlos va a ser con un valor booleano ya que no
	// sabemos como joinear tablas para traer su valor especifico.
	// hay campos compartidos, la foto, la especialidad, etc. Son campos que solo
	// los medicos
	// van a ocupar. Vi innesesario hacer un mapeo entre tablas para esto.

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;

	@Column
	private String contrasenia;

	@Column
	private String nombre;

	@ManyToOne
	private Especialidad especialidad;

	@Column
	private String telefono;

	@Column
	private String paginaPersonal;

	@Column
	private String email;

    @Column
	private LocalDate fechaNacimiento;

	@Column
	private Integer numeroDeTipoDeUsuario;

	@Column
	private Double descuentoPorPlanMedico;
	
	@Column
	private String avatar;

	public Usuario(String contrasenia, String email, Integer numeroDeTipoDeUsuario) {
		super();
		this.contrasenia = contrasenia;
		this.email = email;
		this.numeroDeTipoDeUsuario = numeroDeTipoDeUsuario;
	}

	// si es 1 = usuario comun. Si es 2 = medico. Si es 3 = admin.

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

	public Integer getNumeroDeTipoDeUsuario() {
		return numeroDeTipoDeUsuario;
	}

	public void setNumeroDeTipoDeUsuario(Integer numeroDeDeTipoDeUsuario) {
		this.numeroDeTipoDeUsuario = numeroDeDeTipoDeUsuario;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getEdad() {
		return fechaNacimiento;
	}

	public void setEdad(LocalDate edad) {
		this.fechaNacimiento = edad;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPaginaPersonal() {
		return paginaPersonal;
	}

	public void setPaginaPersonal(String paginaPersonal) {
		this.paginaPersonal = paginaPersonal;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Double getDescuentoPorPlanMedico() {
		return descuentoPorPlanMedico;
	}

	public void setDescuentoPorPlanMedico(Double descuentoPorPlanMedico) {
		this.descuentoPorPlanMedico = descuentoPorPlanMedico;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	

}