package com.buzuCamacariAPI.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.buzuCamacariAPI.models.ItinerarioHorarioModel;

@Repository
public interface ItinerarioHorarioRepository extends JpaRepository<ItinerarioHorarioModel, Integer> {
	
	List<ItinerarioHorarioModel> findAllByItinerarioIdOrderByHorario(int itinerarioId);
}