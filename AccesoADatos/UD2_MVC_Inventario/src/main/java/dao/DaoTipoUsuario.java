package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.TipoUsuario;
import jdbc.ConexionJdbc;
import excepciones.BusinessException;
public class DaoTipoUsuario  extends DaoGenerico<TipoUsuario, Integer>{
	public final static Integer PROFESOR = 1;
	public final static Integer ALUMNO = 2;
	public final static Integer PAS = 3;

	public TipoUsuario buscarPorId(Integer id) throws BusinessException {
		TipoUsuario result = null;
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			String sql = "SELECT * FROM tipousuario WHERE idtipousuario = ?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if(rs.first()){
				result = new TipoUsuario(id, rs.getString("nombre"));
			}
			return result;
			
		} catch (SQLException e){
			throw new BusinessException("Error al consultar");
		} finally{
			ConexionJdbc.cerrar(pstm);
		}
	}

	@Override
	public List<TipoUsuario> buscarTodos() throws BusinessException {
		List<TipoUsuario> result = new ArrayList<TipoUsuario>();
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			String sql = "SELECT * FROM tipousuario ORDER BY idtipousuario";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				TipoUsuario t = new TipoUsuario(rs.getInt("idtipousuario"), rs.getString("nombre"));
				result.add(t);
			}
			return result;
		} catch (SQLException e){
			throw new BusinessException("Error al consultar");
		} finally{
			ConexionJdbc.cerrar(pstm);
		}
	}

}
