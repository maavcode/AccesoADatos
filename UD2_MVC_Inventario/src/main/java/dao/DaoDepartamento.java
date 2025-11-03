package dao;

import java.awt.Insets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import excepciones.BusinessException;
import jdbc.ConexionJdbc;
import pojo.Departamento;

public class DaoDepartamento extends DaoGenerico<Departamento, Integer>{
	@Override
	public void grabar(Departamento d) throws BusinessException { // Inserta en la tabla departamento
		// Clase que conecta la base de datos
		PreparedStatement pstm = null;
		// Query
		String sql = null;
		//
		ResultSet rs = null;
		
		try {
		// Obtengo la conexion que ha creado la interfaz utilizando la clase utiles ConexionJdbc
		Connection con = ConexionJdbc.getConnection();
		
		// id es autoincremental, no se pone en el insert
		sql = "insert into departamento(nombre)values(?)";
		
		pstm = con.prepareStatement(sql);
		pstm.setString(1, d.getNombre());
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al insertar");
		}finally {
			ConexionJdbc.cerrar(pstm);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
