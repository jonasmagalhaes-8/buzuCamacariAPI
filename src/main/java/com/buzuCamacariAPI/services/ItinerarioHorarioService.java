package com.buzuCamacariAPI.services;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.buzuCamacariAPI.dtos.InsertUpdateItinerarioHorarioDTO;
import com.buzuCamacariAPI.models.ItinerarioHorarioModel;
import com.buzuCamacariAPI.repositories.ItinerarioHorarioRepository;

@Service
public class ItinerarioHorarioService {
	
	private final ItinerarioHorarioRepository repository;
		
	public ItinerarioHorarioService(ItinerarioHorarioRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public ResponseEntity<?> insert(InsertUpdateItinerarioHorarioDTO novoHorarioItinerario) {
		
		ItinerarioHorarioModel itinerarioHorario = new ItinerarioHorarioModel(novoHorarioItinerario);
		
		String diasSemana = "";
		
		for(String dia : novoHorarioItinerario.getDiasSemana()) {
			diasSemana = dia + "/" + diasSemana;
		}
			
		itinerarioHorario.setDiasSemana(diasSemana.substring(0, diasSemana.length()-1));
		
		if(repository.save(itinerarioHorario)!=null) ResponseEntity.status(HttpStatus.CREATED);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar horario!");
	}
	
	/*@Transactional
	public ResponseInsertUpdateVO update(InsertUpdateItinerarioHorarioDTO horarioItinerarioAtualizado) {
				
		ItinerarioHorarioModel horario = repository.findByItinerarioIdAndHorario(horarioItinerarioAtualizado.getItinerarioId(), horarioItinerarioAtualizado.getHorario());
		
		horario.setHorario(horarioItinerarioAtualizado.getHorario());
		horario.setDestinoCamacari(horarioItinerarioAtualizado.isDestinoCamacari());		
		
		String diasSemana = "";
		
		for(String dia : horarioItinerarioAtualizado.getDiasSemana()) {
			diasSemana = dia + "/" + diasSemana;
		}
					
		horario.setDiasSemana(diasSemana.substring(0, diasSemana.length()-1));
								
		ResponseInsertUpdateVO responseUpdateVO = new ResponseInsertUpdateVO();
		
		if(repository.save(horario)!=null) responseUpdateVO.setSucesso(1);
		
		return responseUpdateVO;
	}*/

	public List<ItinerarioHorarioModel> getHorariosByItinerario(int idItinerario) {
		return repository.findAllByItinerarioIdOrderByHorario(idItinerario);
	}
	
	public void delete(int id) {
		repository.deleteById(id);
	}

}