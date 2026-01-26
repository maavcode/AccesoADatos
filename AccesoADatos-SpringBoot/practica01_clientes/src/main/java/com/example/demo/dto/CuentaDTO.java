package com.example.demo.dto;

import java.io.Serializable;

import com.example.demo.model.Cliente;
import com.example.demo.model.Cuenta;
import com.example.demo.model.Recomendacion;

import lombok.Data;
import lombok.ToString;

@Data
public class CuentaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long idCuenta;
	private String banco;
	private String sucursal;
	private String dc;
	private String numeroCuenta;
	private float saldoActual;
	@ToString.Exclude	
	private ClienteDTO clientedto;	
	
	public static CuentaDTO convertToDTO(Cuenta cuenta, ClienteDTO cliente) {
		
		CuentaDTO cuentaDTO = new CuentaDTO();
		cuentaDTO.setIdCuenta(cuenta.getId());
		cuentaDTO.setBanco(cuenta.getBanco());
		cuentaDTO.setSucursal(cuenta.getSucursal());
		cuentaDTO.setDc(cuenta.getDc());
		cuentaDTO.setNumeroCuenta(cuenta.getNumeroCuenta());
		cuentaDTO.setSaldoActual(cuenta.getSaldoActual());
		cuentaDTO.setClientedto(cliente);
		
		return cuentaDTO;
	}	
		
	public static Cuenta convertToEntity(CuentaDTO cuentadto) {
		
		Cuenta cuenta = new Cuenta();
		cuenta.setId(cuentadto.getIdCuenta());
		cuenta.setBanco(cuentadto.getBanco());
		cuenta.setSucursal(cuentadto.getSucursal());
		cuenta.setDc(cuentadto.getDc());
		cuenta.setNumeroCuenta(cuentadto.getNumeroCuenta());
		cuenta.setSaldoActual(cuentadto.getSaldoActual());
		
		// Esta linea produce un error de referencia circular, por lo que no
		// mapearemos el cliente a entidad hasta que haga falta
		/*
		Cliente cliente = ClienteDTO.convertToEntity(cuentadto.getClientedto());
		cuenta.setCliente(cliente);*/
		
		return cuenta;
	}	
}

