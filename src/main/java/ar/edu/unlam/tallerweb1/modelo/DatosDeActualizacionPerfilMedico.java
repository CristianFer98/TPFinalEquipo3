package ar.edu.unlam.tallerweb1.modelo;


public class DatosDeActualizacionPerfilMedico {

	private Integer id;

	private Integer especialidad;

	private String telefono;

	private String paginaPersonal;

	public DatosDeActualizacionPerfilMedico() {

	}

	public Integer getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Integer especialidad) {
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer idUsuario) {
		this.id = idUsuario;
	}

}
