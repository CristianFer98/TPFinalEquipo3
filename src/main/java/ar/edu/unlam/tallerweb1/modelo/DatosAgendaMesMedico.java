package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;

public class DatosAgendaMesMedico {

	private ArrayList<Integer> diasDeLaSemanaElegidos;

	private String horarioComienzoJornada;
	private String horarioFinJornada;
	private Double valorPorConsultaNormal;
	private String duracionTurno;
	public DatosAgendaMesMedico() {

	}

	public ArrayList<Integer> getDiasDeLaSemanaElegidos() {
		return diasDeLaSemanaElegidos;
	}

	public void setDiasDeLaSemanaElegidos(ArrayList<Integer> diasDeLaSemanaElegidos) {
		this.diasDeLaSemanaElegidos = diasDeLaSemanaElegidos;
	}

	public String getHorarioComienzoJornada() {
		return horarioComienzoJornada;
	}

	public void setHorarioComienzoJornada(String horarioComienzoJornada) {
		this.horarioComienzoJornada = horarioComienzoJornada;
	}

	public String getHorarioFinJornada() {
		return horarioFinJornada;
	}

	public void setHorarioFinJornada(String horarioFinJornada) {
		this.horarioFinJornada = horarioFinJornada;
	}




	public Double getValorPorConsultaNormal() {
		return valorPorConsultaNormal;
	}

	public void setValorPorConsultaNormal(Double valorPorConsultaNormal) {
		this.valorPorConsultaNormal = valorPorConsultaNormal;
	}

	public String getDuracionTurno() {
		return duracionTurno;
	}

	public void setDuracionTurno(String duracionTurno) {
		this.duracionTurno = duracionTurno;
	}
	
	

}
