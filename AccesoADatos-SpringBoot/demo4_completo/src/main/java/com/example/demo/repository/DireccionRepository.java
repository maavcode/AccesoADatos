package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Direccion;

@Repository
@Transactional
public interface DireccionRepository extends JpaRepository<Direccion, Long> {
	
	@Query(value = "SELECT d FROM Cliente c join c.listaDirecciones d  "
			+ "WHERE c.id = :idcliente")
	public List<Direccion> getDireccionesByCliente(@Param("idcliente") Long idCliente);
}
