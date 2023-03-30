package com.buzuCamacariAPI.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_itinerario")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ItinerarioModel implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itinerario_generator")
	@SequenceGenerator(name = "itinerario_generator", sequenceName = "public.tb_itinerario_seq", allocationSize = 1)
	Integer id;
	
	String itinerario;
	
	String pontoInicial;
	
	String pontoFinal;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItinerario() {
		return itinerario;
	}

	public void setItinerario(String itinerario) {
		this.itinerario = itinerario;
	}

	public String getPontoInicial() {
		return pontoInicial;
	}

	public void setPontoInicial(String pontoInicial) {
		this.pontoInicial = pontoInicial;
	}

	public String getPontoFinal() {
		return pontoFinal;
	}

	public void setPontoFinal(String pontoFinal) {
		this.pontoFinal = pontoFinal;
	}
}
