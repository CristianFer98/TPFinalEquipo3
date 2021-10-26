package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class PlanBasico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPlanBasico;

	@Column
	private String descripcion;

	@Column
	private Float monto;
	
	@Column
	private Float descuento;
	
	

	public PlanBasico() {
	}

	public Integer getIdPlanBasico() {
		return idPlanBasico;
	}

	public void setIdPlanBasico(Integer idPlanBasico) {
		this.idPlanBasico = idPlanBasico;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getMonto() {
		return monto;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}

	public Float getDescuento() {
		return descuento;
	}

	public void setDescuento(Float descuento) {
		this.descuento = descuento;
	}
	
	
}
