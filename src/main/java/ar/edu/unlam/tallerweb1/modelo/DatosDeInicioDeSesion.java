package ar.edu.unlam.tallerweb1.modelo;

public class DatosDeInicioDeSesion {

	private String email;
	private String contrasenia;

	public DatosDeInicioDeSesion(String email2, String clave) {
		this.email = email2;
		this.contrasenia = clave;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	
}
