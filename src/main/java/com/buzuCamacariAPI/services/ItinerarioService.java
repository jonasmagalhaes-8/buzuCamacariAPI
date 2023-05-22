package com.buzuCamacariAPI.services;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.buzuCamacariAPI.models.ItinerarioModel;
import com.buzuCamacariAPI.repositories.ItinerarioRepository;
import com.buzuCamacariAPI.responseVOs.ResponseInsertUpdateVO;

@Service
public class ItinerarioService {
	
	@Autowired
	private ItinerarioRepository repository;
	
	@Transactional(readOnly = true)
	public List<ItinerarioModel> getAllItinerarios() { 				
		return repository.findAllByOrderByItinerarioAsc();
	}
	
	@Transactional
	public ResponseInsertUpdateVO insert(ItinerarioModel novoItinerario) {
				
		ResponseInsertUpdateVO responseInsertVO = new ResponseInsertUpdateVO();
		
		if(repository.save(novoItinerario)!=null) responseInsertVO.setSucesso(1);
		
		return responseInsertVO;
	}
	
	@Transactional
	public ResponseInsertUpdateVO update(ItinerarioModel itinerarioAtualizado) {
		
		ItinerarioModel itinerario = repository.getReferenceById(itinerarioAtualizado.getId());
		
		BeanUtils.copyProperties(itinerarioAtualizado, itinerario, "id");
				
		itinerario = repository.save(itinerario);
				
		ResponseInsertUpdateVO responseUpdateVO = new ResponseInsertUpdateVO();
		
		if(itinerario!=null) responseUpdateVO.setSucesso(1);
		
		return responseUpdateVO;
	}

	public void delete(int id) {
		repository.deleteById(id);
	}
}
