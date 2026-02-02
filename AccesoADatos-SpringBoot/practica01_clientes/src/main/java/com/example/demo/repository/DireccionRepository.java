package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Direccion;

public interface DireccionRepository extends JpaRepository<Direccion, Long>){
	
	@Query(value="select d from Cliente c join c.listaDirecciones d where c.id=:idCliente")
	public List<Direccion> getDireccionesByCliente(@Param("idCliente")Long idCliente);
	
}
