package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ambulancia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAmbulacia;
	
	@Column
	private Integer patenteAmbulancia;

	public Integer getIdAmbulacia() {
		return idAmbulacia;
	}

	public void setIdAmbulacia(Integer idAmbulacia) {
		this.idAmbulacia = idAmbulacia;
	}

	public Integer getPatenteAmbulancia() {
		return patenteAmbulancia;
	}

	public void setPatenteAmbulancia(Integer patenteAmbulancia) {
		this.patenteAmbulancia = patenteAmbulancia;
	}
	
	
	
	
	
	

}
