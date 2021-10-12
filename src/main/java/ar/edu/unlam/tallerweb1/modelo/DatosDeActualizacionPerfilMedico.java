package ar.edu.unlam.tallerweb1.modelo;

import java.io.InputStream;

public class DatosDeActualizacionPerfilMedico {

	
	
	private Integer id;

	private String especialidad;
	
	private String telefono;
	
	private String foto;
	
	private String paginaPersonal;
	
	public DatosDeActualizacionPerfilMedico() {
		
	}
	


	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
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
