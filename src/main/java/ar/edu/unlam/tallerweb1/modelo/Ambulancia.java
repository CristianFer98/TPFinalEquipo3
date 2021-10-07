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
	private String patenteAmbulancia;
	
	@Column
	private Boolean disponible;

	
	public Ambulancia() {
	}

	public Ambulancia(String patenteAmbulancia, Boolean disponible) {
		super();
		this.patenteAmbulancia = patenteAmbulancia;
		this.disponible = disponible;
	}

	public Integer getIdAmbulacia() {
		return idAmbulacia;
	}

	public void setIdAmbulacia(Integer idAmbulacia) {
		this.idAmbulacia = idAmbulacia;
	}

	public String getPatenteAmbulancia() {
		return patenteAmbulancia;
	}

	public void setPatenteAmbulancia(String patenteAmbulancia) {
		this.patenteAmbulancia = patenteAmbulancia;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}


	
	
	
	
	
	
	
	

}
