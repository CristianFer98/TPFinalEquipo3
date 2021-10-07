package ar.edu.unlam.tallerweb1.modelo;

public class DatosAmbulancia {
	private String patente;
	private Boolean estado;
	
	public DatosAmbulancia(String patente, Boolean estado) {
		this.patente = patente;
		this.estado=estado;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
}
