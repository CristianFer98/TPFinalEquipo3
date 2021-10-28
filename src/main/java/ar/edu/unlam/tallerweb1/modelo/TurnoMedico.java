package ar.edu.unlam.tallerweb1.modelo;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class TurnoMedico {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column 
	private LocalDateTime fecha;
	
	@ManyToOne
	private Usuario clienteAsignado;
	
	@ManyToOne
	private Usuario medicoAsignado;
	
	@Column
	private Boolean estado = true;
	
 
	
	public TurnoMedico() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}




	public Usuario getMedicoAsignado() {
		return medicoAsignado;
	}

	public void setMedicoAsignado(Usuario medicoAsignado) {
		this.medicoAsignado = medicoAsignado;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Usuario getClienteAsignado() {
		return clienteAsignado;
	}

	public void setClienteAsignado(Usuario clienteAsignado) {
		this.clienteAsignado = clienteAsignado;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}


	
	
	
	
	
	
}
