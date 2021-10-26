package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class PlanSalud {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPlanSalud;

	@Column
	private String descripcion;

	public PlanSalud(Integer idPlanSalud, String descripcion) {
		this.idPlanSalud = idPlanSalud;
		this.descripcion = descripcion;
	}

	public Integer getIdPlanSalud() {
		return idPlanSalud;
	}

	public void setIdPlanSalud(Integer idPlanSalud) {
		this.idPlanSalud = idPlanSalud;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	

}
