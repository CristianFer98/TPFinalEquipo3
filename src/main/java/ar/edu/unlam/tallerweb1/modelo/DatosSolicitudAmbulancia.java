package ar.edu.unlam.tallerweb1.modelo;

public class DatosSolicitudAmbulancia {
	private String direccion;
	private Usuario user;
	private Ambulancia ambulancia;

	public DatosSolicitudAmbulancia() {
	}

	public DatosSolicitudAmbulancia(String direccion) {
		this.direccion = direccion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public Ambulancia getAmbulancia() {
		return ambulancia;
	}

	public void setAmbulancia(Ambulancia ambulancia) {
		this.ambulancia = ambulancia;
	}

}
