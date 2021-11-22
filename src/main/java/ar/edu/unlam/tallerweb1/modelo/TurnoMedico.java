package ar.edu.unlam.tallerweb1.modelo;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


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
	
	@Column
	private Double valorDeLaConsulta;
	 
	@Column
	private Double valorFinal;
	
	@Column
	private LocalTime tiempoDeLaConsulta;
	
	@Column
	private Boolean pagado;
	
 
	
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



	public Double getValorDeLaConsulta() {
		return valorDeLaConsulta;
	}


	public void setValorDeLaConsulta(Double valorDeLaConsulta) {
		this.valorDeLaConsulta = valorDeLaConsulta;
	}


	public LocalTime getTiempoDeLaConsulta() {
		return tiempoDeLaConsulta;
	}

	public void setTiempoDeLaConsulta(LocalTime tiempoDeLaConsulta) {
		this.tiempoDeLaConsulta = tiempoDeLaConsulta;
	}


	public Boolean getPagado() {
		return pagado;
	}

	public void setPagado(Boolean pagado) {
		this.pagado = pagado;
	}



	public Double getValorFinal() {
		return valorFinal;
	}


	public void setValorFinal(Double valorFinal) {
		this.valorFinal = valorFinal;
	}



	

	

	
	
	
	
	
	
}
