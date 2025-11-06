package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pojo.Departamento;
import dao.DaoGenerico;
import excepciones.BusinessException;
import jdbc.ConexionJdbc;

public class DaoDepartamento extends DaoGenerico<Departamento,Integer> {

	@Override
	public void grabar(Departamento d) throws BusinessException{
		// Inserta en la tabla departamento
		
		PreparedStatement pstmt = null;
		String sql = null;
		ResultSet rs = null;
		Integer id = null;
		
		// Obtenemos la conexión que ha creado la interfaz utilizando 
		// la clase de utiles ConexionJdbc
		
		try {
			Connection con = ConexionJdbc.getConnection();
			sql = "insert into departamento (nombre) values (?)";
			pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, d.getNombre());
			pstmt.executeUpdate();
			// Devuelve el valor de la clave primaria
			rs = pstmt.getGeneratedKeys();
			if(rs.first()) {
				id=rs.getInt(1);
				d.setIdDepartamento(id);
				System.out.println("El id: "+ id);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al insertar");
		} finally {
			ConexionJdbc.cerrar(pstmt);
		}	
	}	
	
	@Override
	public void actualizar(Departamento d) throws BusinessException{
		// Inserta en la tabla departamento
		
		PreparedStatement pstmt = null;
		String sql = null;
		ResultSet rs = null;
		Integer id = null;
		
		// Obtenemos la conexión que ha creado la interfaz utilizando 
		// la clase de utiles ConexionJdbc
		
		try {
			Connection con = ConexionJdbc.getConnection();
			sql = "update departamento set nombre=? where iddepartamento=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, d.getNombre());
			pstmt.setInt(2, d.getIdDepartamento());
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al borrar");
		} finally {
			ConexionJdbc.cerrar(pstmt);
		}	
	}	
	
	@Override
	public void borrar(Integer id) throws BusinessException{
		// Inserta en la tabla departamento
		
		PreparedStatement pstmt = null;
		String sql = null;
		
		// Obtenemos la conexión que ha creado la interfaz utilizando 
		// la clase de utiles ConexionJdbc
		
		try {
			Connection con = ConexionJdbc.getConnection();
			sql = "delete from departamento where iddepartamento=?";
			pstmt = con.prepareStatement(sql);
		
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al borrar");
		} finally {
			ConexionJdbc.cerrar(pstmt);
		}	
	}	
	
	@Override
	public void borrar(Departamento d) throws BusinessException{
		borrar(d.getIdDepartamento());
	}
	
	@Override
	public Departamento buscarPorId(Integer id) throws BusinessException{
		// Inserta en la tabla departamento
		
		PreparedStatement pstmt = null;
		String sql = null;
		
		// Obtenemos la conexión que ha creado la interfaz utilizando 
		// la clase de utiles ConexionJdbc
		
		try {
			Connection con = ConexionJdbc.getConnection();
			sql = "delete from departamento where iddepartamento=?";
			pstmt = con.prepareStatement(sql);
		
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al borrar");
		} finally {
			ConexionJdbc.cerrar(pstmt);
		}	
	}
}
