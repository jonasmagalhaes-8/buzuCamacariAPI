package com.buzuCamacariAPI.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.buzuCamacariAPI.dtos.InsertUpdateItinerarioHorarioDTO;
import com.buzuCamacariAPI.services.ItinerarioHorarioService;

@RestController
@CrossOrigin
@RequestMapping(value = "/horarioitinerario")
public class ItinerarioHorarioController {

	private final ItinerarioHorarioService service;
				
	public ItinerarioHorarioController(ItinerarioHorarioService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<?> insert(@RequestBody InsertUpdateItinerarioHorarioDTO itinerarioHorarioDTO) {
		return ResponseEntity.ok().body(service.insert(itinerarioHorarioDTO));
	}
	
	/*@PutMapping
	public ResponseEntity<?> update(@RequestBody InsertUpdateItinerarioHorarioDTO itinerarioHorarioDTO) {
		return ResponseEntity.ok().body(service.update(itinerarioHorarioDTO));
	}*/
		
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) { 
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{idItinerario}")
	public ResponseEntity<?> getHorariosByItinerario(@PathVariable int idItinerario) { 
		return ResponseEntity.ok().body(service.getHorariosByItinerario(idItinerario));
	}
}