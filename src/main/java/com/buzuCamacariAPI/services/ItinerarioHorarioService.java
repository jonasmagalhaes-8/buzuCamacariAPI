package com.buzuCamacariAPI.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.buzuCamacariAPI.dtos.InsertUpdateItinerarioHorarioDTO;
import com.buzuCamacariAPI.models.ItinerarioHorarioModel;
import com.buzuCamacariAPI.repositories.ItinerarioHorarioRepository;
import com.buzuCamacariAPI.responseVOs.ResponseInsertUpdateVO;

@Service
public class ItinerarioHorarioService {
	
	@Autowired
	private ItinerarioHorarioRepository repository;
		
	@Transactional
	public ResponseInsertUpdateVO insert(InsertUpdateItinerarioHorarioDTO novoHorarioItinerario) {
		
		ResponseInsertUpdateVO responseInsertVO = new ResponseInsertUpdateVO();
		ItinerarioHorarioModel itinerarioHorario = new ItinerarioHorarioModel(novoHorarioItinerario);
		
		String diasSemana = "";
		
		for(String dia : novoHorarioItinerario.getDiasSemana()) {
			diasSemana = dia + "/" + diasSemana;
		}
			
		itinerarioHorario.setDiasSemana(diasSemana.substring(0, diasSemana.length()-1));
		
		if(repository.save(itinerarioHorario)!=null) responseInsertVO.setSucesso(1);
		
		return responseInsertVO;
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