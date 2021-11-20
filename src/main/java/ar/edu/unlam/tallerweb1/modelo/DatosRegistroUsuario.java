package ar.edu.unlam.tallerweb1.modelo;


public class DatosRegistroUsuario {

	private String email;
	
	private String nombre; //y el repiteclave

	private String edad;
	
	private String contrasenia1; //seria el clave
	
	private String contrasenia2; //y el repiteclave

	private Integer numeroDeTipoDeUsuario;
	
	private String sexo;
<<<<<<< HEAD
=======
	

>>>>>>> ramaEsteban
	//va a ser el admin quien pueda registrar en su cuenta nuevos medicos que accedan.
	//el unico que va a registrarse como tal. es el usuario comun
	

	public String getEmail() {
		return email;
	}
	
	public DatosRegistroUsuario() {
		
	}

	public DatosRegistroUsuario(String email, String contrasenia1, String contrasenia2) {
		super();
		this.email = email;
		this.contrasenia1 = contrasenia1;
		this.contrasenia2 = contrasenia2;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenia1() {
		return contrasenia1;
	}

	public void setContrasenia1(String contrasenia1) {
		this.contrasenia1 = contrasenia1;
	}

	public String getContrasenia2() {
		return contrasenia2;
	}

	public void setContrasenia2(String contrasenia2) {
		this.contrasenia2 = contrasenia2;
	}

	public Integer getNumeroDeTipoDeUsuario() {
		return numeroDeTipoDeUsuario;
	}

	public void setNumeroDeTipoDeUsuario(Integer numeroDeDeTipoDeUsuario) {
		this.numeroDeTipoDeUsuario = numeroDeDeTipoDeUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	

	
	
	
	 
	


	
	
	
	
}
