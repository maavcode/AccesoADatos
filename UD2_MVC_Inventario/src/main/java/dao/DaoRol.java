package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Rol;
import jdbc.ConexionJdbc;
import excepciones.BusinessException;

public class DaoRol  extends DaoGenerico<Rol, Integer>{
	@Override
	public void grabar(Rol r) throws BusinessException {
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			//Preparar para la inserci�n
			String sql = "INSERT INTO rol "
					+ "(nombre,descripcion ) "
					+ "VALUES (?,?)";
			
			pstm = con.prepareStatement(sql);
			pstm.setString(1,r.getNombre());
			pstm.setString(2,r.getDescripcion());

			//insertar
			pstm.executeUpdate();
			
			//obtener clave generada
			rs= pstm.getGeneratedKeys();
			if (rs.first()) {
				Integer id = rs.getInt(1);
				r.setIdrol(id);
			}
		} catch (SQLException e){
			throw new BusinessException("Error al insertar");
		} finally{
			ConexionJdbc.cerrar(pstm);
		}
	}
	@Override
	public void actualizar(Rol r) throws BusinessException {
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		try{
			//Preparar la actualizaci�n.
			String sql = "UPDATE rol"
					+ " SET nombre = ?, descripcion = ? "
					+ " WHERE idrol = ?";			
			pstm = con.prepareStatement(sql);
			pstm.setString(1,r.getNombre());
			pstm.setString(2,r.getDescripcion());
			pstm.setInt(3,r.getIdrol());			
			//Ejecutar la actualizacion
			if(pstm.executeUpdate()==0) 
				throw new BusinessException("Elemento no encontrado");
		} catch (SQLException e){
			throw new BusinessException("Error al actualizar");
		} finally{
			ConexionJdbc.cerrar(pstm);
		}
	}
	@Override
	public void grabarOActualizar(Rol r) throws BusinessException {
		if(buscarPorId(r.getIdrol())!=null) grabar(r);
		else actualizar(r);
	}
	@Override
	public void borrar(Rol r) throws BusinessException {
		borrar(r.getIdrol());
	}
	@Override
	public void borrar(Integer id) throws BusinessException {
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		try{
			String sql = "DELETE FROM rol WHERE idrol = ?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			if(pstm.executeUpdate()==0) throw new BusinessException("Elemento no encontrado");
		} catch (SQLException e){
			throw new BusinessException("Error al eliminar");
		} finally{
			ConexionJdbc.cerrar(pstm);
		}
	}
	@Override
	public Rol buscarPorId(Integer id) throws BusinessException {
		Rol result = null;
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			String sql = "SELECT * FROM rol WHERE idrol = ?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if(rs.first()){
				result = new Rol(id, rs.getString("nombre"),rs.getString("descripcion"));
			}
			return result;
			
		} catch (SQLException e){
			throw new BusinessException("Error al consultar");
		} finally{
			ConexionJdbc.cerrar(pstm);
		}
	}

	@Override
	public List<Rol> buscarTodos() throws BusinessException {
		List<Rol> result = new ArrayList<Rol>();
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			String sql = "SELECT * FROM rol ORDER BY idrol";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				Rol d = new Rol(rs.getInt("idrol"), rs.getString("nombre"), rs.getString("descripcion"));
				result.add(d);
			}
			return result;
			
		} catch (SQLException e){
			throw new BusinessException("Error al consultar");
		} finally{
			ConexionJdbc.cerrar(pstm);
		}
	}
}
