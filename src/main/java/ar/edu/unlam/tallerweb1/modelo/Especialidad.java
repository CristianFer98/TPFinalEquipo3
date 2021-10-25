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
	private Boolean precioPorTurno;
	
	
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

	public Boolean getPrecioPorTurno() {
		return precioPorTurno;
	}

	public void setPrecioPorTurno(Boolean precioPorTurno) {
		this.precioPorTurno = precioPorTurno;
	}
	


}
