package com.buzuCamacariAPI.dtos;

import java.util.ArrayList;
import java.util.List;

public class InsertUpdateItinerarioHorarioDTO {
	
	int itinerarioId;
	
	String horario;
	
	boolean destinoCentroCamacari;
	
	List<String> diasSemana = new ArrayList<>();
	
	public int getItinerarioId() {
		return itinerarioId;
	}

	public void setItinerarioId(int itinerarioId) {
		this.itinerarioId = itinerarioId;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public boolean isDestinoCentroCamacari() {
		return destinoCentroCamacari;
	}

	public void setDestinoCentroCamacari(boolean destinoCamacari) {
		this.destinoCentroCamacari = destinoCamacari;
	}

	public List<String> getDiasSemana() {
		return diasSemana;
	}

	public void setDiasSemana(List<String> diasSemana) {
		this.diasSemana = diasSemana;
	}	
}
