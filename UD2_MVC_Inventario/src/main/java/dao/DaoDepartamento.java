package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import excepciones.BusinessException;
import jdbc.ConexionJdbc;
import pojos.Departamento;

public class DaoDepartamento extends DaoGenerico<Departamento, Integer> {

	@Override
	public void grabar(Departamento d) throws BusinessException {
		PreparedStatement pstmt = null;
		String sql = null;
		Integer id = null;
		ResultSet rs = null;
		try {
			Connection con = ConexionJdbc.getConnection();

			sql = "INSERT INTO departamento (nombre) VALUES (?)";
			pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, d.getNombre());
			pstmt.executeUpdate();

			rs = pstmt.getGeneratedKeys();
			if (rs.first()) {
				id = rs.getInt(1);
				d.setIddepartamento(id);
				System.out.println("El id: " + id);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("ERROR AL INSERTAR");
		} finally {
			ConexionJdbc.cerrar(pstmt);
		}

	}

	@Override
	public void actualizar(Departamento d) throws BusinessException {
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			Connection con = ConexionJdbc.getConnection();

			sql = "UPDATE departamento SET nombre = ? WHERE iddepartamento = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, d.getNombre());
			pstmt.setInt(2, d.getIddepartamento());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("ERROR AL ACTUALIZAR");
		} finally {
			ConexionJdbc.cerrar(pstmt);
		}

	}

	@Override
	public void borrar(Integer id) throws BusinessException {
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			Connection con = ConexionJdbc.getConnection();

			sql = "DELETE FROM departamento WHERE iddepartamento = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("ERROR AL BORRAR");
		} finally {
			ConexionJdbc.cerrar(pstmt);
		}

	}

	@Override
	public void borrar(Departamento d) throws BusinessException {
		borrar(d.getIddepartamento());
	}

	@Override
	public Departamento buscarPorId(Integer id) throws BusinessException {
		PreparedStatement pstmt = null;
		String sql = null;
		ResultSet rs = null;
		Departamento result = null;

		try {
			Connection con = ConexionJdbc.getConnection();

			sql = "SELECT * FROM departamento WHERE iddepartamento = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.first()) {
				result = new Departamento();
				result.setIddepartamento(id);
				result.setNombre(rs.getString("nombre"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("ERROR AL BUSCAR POR ID");
		} finally {
			ConexionJdbc.cerrar(pstmt);
		}
		return result;

	}
	
	@Override
	public List<Departamento> buscarTodos() throws BusinessException {
		PreparedStatement pstmt = null;
		String sql = null;
		ResultSet rs = null;
		List<Departamento> result = new ArrayList<Departamento>();

		try {
			Connection con = ConexionJdbc.getConnection();

			sql = "SELECT * FROM departamento";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Departamento d = new Departamento();
				d.setIddepartamento(rs.getInt("iddepartamento"));
				d.setNombre(rs.getString("nombre"));
				result.add(d);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("ERROR AL BUSCAR TODOS");
		} finally {
			ConexionJdbc.cerrar(pstmt);
		}
		return result;

	}

}
