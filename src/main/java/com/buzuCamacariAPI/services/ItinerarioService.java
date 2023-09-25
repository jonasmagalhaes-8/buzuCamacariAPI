package com.buzuCamacariAPI.services;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.buzuCamacariAPI.models.ItinerarioModel;
import com.buzuCamacariAPI.repositories.ItinerarioRepository;

@Service
public class ItinerarioService {
		
	private final ItinerarioRepository repository;
			
	public ItinerarioService(ItinerarioRepository repository) {
		this.repository = repository;
	}
	 
	public List<ItinerarioModel> listaItinerariosAtual = null;
	
	private void atualizaListaIntinerarios() {
		listaItinerariosAtual = repository.findAllByOrderByItinerarioAsc();
	}
	
	@Transactional(readOnly = true)
	public List<ItinerarioModel> getAllItinerarios() { 		
		if(listaItinerariosAtual==null) atualizaListaIntinerarios();
		return listaItinerariosAtual;
	}
	
	@Transactional
	public ResponseEntity<?> insert(ItinerarioModel novoItinerario) {		
		if(repository.save(novoItinerario)!=null) {
			atualizaListaIntinerarios();
			return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro realizado com sucesso!");
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar itinerario!");
	}
	
	@Transactional
	public ResponseEntity<?> update(ItinerarioModel itinerarioAtualizado) {
		
		ItinerarioModel itinerario = repository.getReferenceById(itinerarioAtualizado.getId());
		
		BeanUtils.copyProperties(itinerarioAtualizado, itinerario, "id");
				
		itinerario = repository.save(itinerario);
						
		if(itinerario!=null) {
			atualizaListaIntinerarios();
			ResponseEntity.status(HttpStatus.OK).body("Itinerario atualizado com sucesso!");
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar itinerario!");
	}

	public ResponseEntity<?> delete(int id) {
		try {
			repository.deleteById(id);
			atualizaListaIntinerarios();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deletado com sucesso!");
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID informado invalido!");
		}
	}
}
