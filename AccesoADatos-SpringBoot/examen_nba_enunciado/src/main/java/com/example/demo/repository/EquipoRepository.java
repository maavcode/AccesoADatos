package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Equipo;

@Repository
@Transactional
public interface EquipoRepository extends JpaRepository<Equipo, String> {
	
	@Query(value="select e from Equipo e where e.nombre=:n")
	public Optional<Equipo> getEquipoByNombre(@Param("n")String n);
	
}
