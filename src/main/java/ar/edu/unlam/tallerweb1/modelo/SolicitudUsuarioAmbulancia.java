package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SolicitudUsuarioAmbulancia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSolicitud;
	
	@Column
	private String direccion;
	

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="idUsuario")
	private Usuario usuarioSolicitante;

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="patenteAmbulancia")
	private Ambulancia ambulanciaEnCamino;
	

	public SolicitudUsuarioAmbulancia() {
	}

	public Integer getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Integer idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Usuario getUsuarioSolicitante() {
		return usuarioSolicitante;
	}

	public void setUsuarioSolicitante(Usuario usuarioSolicitante) {
		this.usuarioSolicitante = usuarioSolicitante;
	}

	public Ambulancia getAmbulanciaEnCamino() {
		return ambulanciaEnCamino;
	}

	public void setAmbulanciaEnCamino(Ambulancia ambulanciaEnCamino) {
		this.ambulanciaEnCamino = ambulanciaEnCamino;
	}
	
	
	
	
	
	
	
	

}
