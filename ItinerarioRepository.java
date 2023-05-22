package com.buzuCamacariAPI.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.buzuCamacariAPI.models.ItinerarioModel;

@Repository
public interface ItinerarioRepository extends JpaRepository<ItinerarioModel, Integer> {
	public List<ItinerarioModel> findAllByOrderByItinerarioAsc();
}