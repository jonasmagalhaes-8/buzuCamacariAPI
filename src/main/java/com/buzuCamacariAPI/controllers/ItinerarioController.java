package com.buzuCamacariAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private ItinerarioService service;
				
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody ItinerarioModel itinerario) {
		return ResponseEntity.ok().body(service.insert(itinerario));
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody ItinerarioModel itinerario) {
		return ResponseEntity.ok().body(service.update(itinerario));
	}
		
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) { 
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<?> getAllItinerarios() { 
		return ResponseEntity.ok().body(service.getAllItinerarios());
	}
}