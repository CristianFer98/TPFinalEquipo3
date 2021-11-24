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
	private String nombre;

	@Column
	private Double descuento;

	@Column
<<<<<<< HEAD
=======

>>>>>>> main
	private Float precioDelPlan;

	public PlanSalud() {

	} 
<<<<<<< HEAD
=======

>>>>>>> main

	public Integer getIdPlanSalud() {
		return idPlanSalud;
	}

	public void setIdPlanSalud(Integer idPlanSalud) {
		this.idPlanSalud = idPlanSalud;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	public Float getPrecioDelPlan() {
		return precioDelPlan;
	}

	public void setPrecioDelPlan(Float precioDelPlan) {
		this.precioDelPlan = precioDelPlan;
	}

}