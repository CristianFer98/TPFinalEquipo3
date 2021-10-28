package ar.edu.unlam.tallerweb1.modelo;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class DatosAgendaMesMedico {

	private ArrayList<Integer> diasDeLaSemanaElegidos;

	private String horarioComienzoJornada;
	private String horarioFinJornada;



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







}
