package com.example.demo.repository;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.dto.CuentaDTO;
import com.example.demo.model.Cliente;
import com.example.demo.model.Cuenta;

@Repository
@Transactional
public class CustomCuentaRepositoryImpl implements CustomCuentaRepository{
	
	// Inyectamos el gestor de entidades
    @PersistenceContext
    private EntityManager entityManager;	
    
	@Autowired
	private ClienteRepository clienteRepository;    

	@Override
	public void saveCustomCuenta(CuentaDTO cuentadto) {
	
		Optional<Cliente> cliente = clienteRepository.findById(cuentadto.getClientedto().getIdCliente());
		// Mapeamos el dto a una entidad 
		Cuenta cuenta = CuentaDTO.convertToEntity(cuentadto);
		cuenta.setCliente(cliente.get());
		// Mandamos persistir el objeto
		entityManager.persist(cuenta);		
	}
}

