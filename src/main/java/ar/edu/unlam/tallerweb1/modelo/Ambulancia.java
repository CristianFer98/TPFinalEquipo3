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
	private Integer idAmbulancia;

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

	


	public Integer getIdAmbulancia() {
		return idAmbulancia;
	}

	public void setIdAmbulancia(Integer idAmbulancia) {
		this.idAmbulancia = idAmbulancia;
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
