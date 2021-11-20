package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public enum EstadoConsulta {
	ATENTIDA("Atendida"),
	FINALIZADA("Finalizada");
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEstadoConsulta;
	
	@Column()
	private String estadoConsulta;
	
	EstadoConsulta(String estado) {
		this.estadoConsulta = estado;
	}
	
	

	public Integer getIdEstadoConsulta() {
		return idEstadoConsulta;
	}



	public void setIdEstadoConsulta(Integer idEstadoConsulta) {
		this.idEstadoConsulta = idEstadoConsulta;
	}



	public String getEstadoConsulta() {
		return estadoConsulta;
	}

	public void setEstadoConsulta(String estadoConsulta) {
		this.estadoConsulta = estadoConsulta;
	};
	
	
	

}
