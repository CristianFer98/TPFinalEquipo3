package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Especialidad {

	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEspecialidad;
	
	@Column
	private String especialidad;
	
	@Column
	private String fotoEspecialidad;
	
	
	public Especialidad() {
		
	}

	public Integer getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(Integer idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getFotoEspecialidad() {
		return fotoEspecialidad;
	}

	public void setFotoEspecialidad(String fotoEspecialidad) {
		this.fotoEspecialidad = fotoEspecialidad;
	}


	


}
