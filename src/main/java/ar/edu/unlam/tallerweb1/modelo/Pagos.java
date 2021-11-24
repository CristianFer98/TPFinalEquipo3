package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Pagos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPago;
	
	@Column
	private Integer paymentId;
	
	@ManyToOne
	private Usuario cliente;
	
	@ManyToOne
	private TurnoMedico turno;
	
	@Column
	private Float montoPagado;
	
	@Column 
	private String estado;
	
	public Pagos() {
		
	}
	
	

	public Pagos(Integer paymentId, Usuario cliente, TurnoMedico turno ,Float montoPagado) {
		this.paymentId = paymentId;
		this.cliente = cliente;
		this.turno= turno;
		this.montoPagado = montoPagado;
	}



	public Integer getIdPago() {
		return idPago;
	}

	public void setIdPago(Integer idPago) {
		this.idPago = idPago;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public Float getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(Float montoPagado) {
		this.montoPagado = montoPagado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}



	public TurnoMedico getTurno() {
		return turno;
	}



	public void setTurno(TurnoMedico turno) {
		this.turno = turno;
	}
	
	
	
	
	
	
	
	
	
	

}
