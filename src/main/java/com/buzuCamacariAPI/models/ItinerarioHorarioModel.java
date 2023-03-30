package com.buzuCamacariAPI.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.buzuCamacariAPI.dtos.InsertUpdateItinerarioHorarioDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_itinerarioHorario")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ItinerarioHorarioModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itinerarioHorario_generator")
	@SequenceGenerator(name = "itinerarioHorario_generator", sequenceName = "public.tb_itinerarioHorario_seq", allocationSize = 1)
	Integer id;
		
	int itinerarioId;
	
	String horario;
	
	boolean destinoCentroCamacari;
	
	String diasSemana;
	
	public ItinerarioHorarioModel() {
		
	}
	
	public ItinerarioHorarioModel(InsertUpdateItinerarioHorarioDTO dto) {
		this.itinerarioId = dto.getItinerarioId();
		this.horario = dto.getHorario();
		this.destinoCentroCamacari = dto.isDestinoCentroCamacari();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
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

	public void setDestinoCentroCamacari(boolean destinoCentroCamacari) {
		this.destinoCentroCamacari = destinoCentroCamacari;
	}

	public String getDiasSemana() {
		return diasSemana;
	}

	public void setDiasSemana(String diasSemana) {
		this.diasSemana = diasSemana;
	}
}
