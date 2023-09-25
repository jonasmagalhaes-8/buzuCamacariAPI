package com.buzuCamacariAPI.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.buzuCamacariAPI.models.ItinerarioModel;
import com.buzuCamacariAPI.services.ItinerarioService;

@RestController
@CrossOrigin
@RequestMapping(value = "/itinerarios")
public class ItinerarioController {

	private final ItinerarioService service;
					
	public ItinerarioController(ItinerarioService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<?> insert(@RequestBody ItinerarioModel itinerario) {
		return service.insert(itinerario);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody ItinerarioModel itinerario) {
		return service.update(itinerario);
	}
		
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) { 
		return service.delete(id);
	}
	
	@GetMapping
	public List<ItinerarioModel> getAllItinerarios() { 
		return service.getAllItinerarios();
	}
}