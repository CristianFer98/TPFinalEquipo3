package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Table;

@Entity
public class Especialidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoEspecialidad;
	
	@Column()
	private String nombreEspecialidad;

	public Integer getCodigoEspecialidad() {
		return codigoEspecialidad;
	}

	public void setCodigoEspecialidad(Integer codigoEspecialidad) {
		this.codigoEspecialidad = codigoEspecialidad;
	}

	public String getNombreEspecialidad() {
		return nombreEspecialidad;
	}

	public void setNombreEspecialidad(String nombreEspecialidad) {
		this.nombreEspecialidad = nombreEspecialidad;
	}
	

}
