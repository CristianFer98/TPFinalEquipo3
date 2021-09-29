package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Doctor {

	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idDoctor;
	
	@Column
	private String especialidad; //como puedo hacerlo un enum?
	
	@Column 
	private String nombre;
	
	
	
	
	//PREGUNTAR COMO ASIGNARLE UNA AGENDA.
	
	
	public Doctor (){
		
	}

	public Integer getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(Integer idDoctor) {
		this.idDoctor = idDoctor;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	
}
