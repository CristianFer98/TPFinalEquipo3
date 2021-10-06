package ar.edu.unlam.tallerweb1.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Turno {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTurno;
	
//	@OneToMany()
//	private Doctor doctorACargo;
	
		
//	@Column()
//	private Paciente pacienteDelTurno;
	
	@Column()
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date fechaTurno;
	
	@Column()
	private Integer precioConsulta;
	
//	@Column()
//	private EstadoConsulta estadoConsulta;

	public Integer getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(Integer idTurno) {
		this.idTurno = idTurno;
	}

//	public Doctor getDoctorACargo() {
//		return doctorACargo;
//	}
//
//	public void setDoctorACargo(Doctor doctorACargo) {
//		this.doctorACargo = doctorACargo;
//	}

	public Date getFechaTurno() {
		return fechaTurno;
	}

	public void setFechaTurno(Date fechaTurno) {
		this.fechaTurno = fechaTurno;
	}

	public Integer getPrecioConsulta() {
		return precioConsulta;
	}

	public void setPrecioConsulta(Integer precioConsulta) {
		this.precioConsulta = precioConsulta;
	}
//
//	public EstadoConsulta getEstadoConsulta() {
//		return estadoConsulta;
//	}
//
//	public void setEstadoConsulta(EstadoConsulta estadoConsulta) {
//		this.estadoConsulta = estadoConsulta;
//	}
//	
//	
	
	
	
	
	
	
	

}
