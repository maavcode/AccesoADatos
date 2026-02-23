package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Cuenta;

@Repository
@Transactional
public interface CuentaRepository extends JpaRepository<Cuenta, Long>, CustomCuentaRepository {
	
	  @Query(value = "SELECT c FROM Cuenta c WHERE c.cliente.id = :idcliente")
	  public List<Cuenta> getCuentasByCliente(@Param("idcliente") Long idCliente);
}

