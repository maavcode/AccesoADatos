package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Parque;

public interface ParqueRepository extends JpaRepository<Parque, Integer> {
	@Query("SELECT p FROM Parque p WHERE p.comunidadAutonoma.nombre= :comunidadnombre")
    List<Parque> findParquesByComunidadAutonoma(String comunidadnombre);
}
