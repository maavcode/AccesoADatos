package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.dto.CuentaDTO;
import com.example.demo.dto.DireccionDTO;
import com.example.demo.model.Cliente;
import com.example.demo.model.Cuenta;
import com.example.demo.model.Direccion;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.CuentaRepository;

@Service
public class CuentaServiceImpl implements CuentaService{
	
	@Autowired
	private CuentaRepository cuentaRepository;	

	@Override
	public List<CuentaDTO> listAllCuentas(ClienteDTO clientedto) {
		
		// Obtenemos la lista de cuentas del cliente
		List<Cuenta> lista = (List<Cuenta>) cuentaRepository.getCuentasByCliente(clientedto.getIdCliente());
		// Creamos una lista de CuentaDTO que será la que devolvamos al controlador
		List<CuentaDTO> listaResultado = new ArrayList<CuentaDTO>();
		// Recorremos la lista de cuentas y las mapeamos a DTO
		for (int i = 0; i < lista.size(); ++i) {
		    listaResultado.add(CuentaDTO.convertToDTO(lista.get(i), clientedto));
		}
		// Devolvemos la lista de DTO's
		return listaResultado;
	}

	@Override
	public void saveCuenta(CuentaDTO cuentadto) {
			cuentaRepository.saveCustomCuenta(cuentadto);		
	}
}
