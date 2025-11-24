package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Articulo;
import excepciones.BusinessException;
import jdbc.ConexionJdbc;


public class DaoArticulo extends DaoGenerico<Articulo, Integer>{
	
	
public void grabar(Articulo a) throws BusinessException {
	Connection con = ConexionJdbc.getConnection();
	PreparedStatement pstm = null;
	try{
		//Preparar para la inserci�n
		String sql = "INSERT INTO articulo "
				+ "(idarticulo, numserie, estado, fechaalta, usuarioalta, "
				+ "modelo, departamento, espacio) "
				+ "VALUES (?,?,?,?,?,?,?,?)";		
		pstm = con.prepareStatement(sql);
		pstm.setInt(1,a.getIdArticulo());
		pstm.setString(2,a.getNumserie());
		pstm.setString(3,"operativo");
		pstm.setDate(4,new java.sql.Date(a.getFechaalta().getTime()));	
		//Opci�n 2 insertar fecha	pstm.setObject(4,a.getFechaalta());
	//Los Integer introducirlos como null utilizar setObject
		pstm.setObject(5,a.getUsuarioalta());
		pstm.setObject(6,a.getModelo());
		pstm.setObject(7,a.getDepartamento());
		pstm.setObject(8,a.getEspacio());
		//insertar
		pstm.executeUpdate();
		
		
	} catch (SQLException e){
		e.printStackTrace();
		throw new BusinessException("Error al insertar");
	} finally{
		ConexionJdbc.cerrar(pstm);
	}
}

	@Override
	public void actualizar(Articulo a) throws BusinessException {

		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		try{
			//Preparar la actualizaci�n.
			String sql = "UPDATE articulo "
					+ " SET numserie= ?, estado = ?, fechaalta= ?, fechabaja= ?,"
					+ " usuarioalta = ?, usuariobaja = ?, modelo = ?, departamento = ?, espacio = ?,"
					+ "dentrode = ?, observaciones = ?"
					+ " WHERE idarticulo = ?";
			
			pstm = con.prepareStatement(sql);
			pstm.setString(1,a.getNumserie());
			pstm.setString(2,a.getEstado());
			pstm.setDate(3,new java.sql.Date(a.getFechaalta().getTime()));
			pstm.setDate(4,new java.sql.Date(a.getFechabaja().getTime()));
			pstm.setInt(5,a.getUsuarioalta());
			pstm.setInt(6,a.getUsuariobaja());
			pstm.setInt(7,a.getModelo());
			pstm.setInt(8,a.getDepartamento());
			pstm.setInt(9,a.getEspacio());
			pstm.setInt(10,a.getDentrode());
			pstm.setString(11,a.getObservaciones());
			pstm.setInt(12,a.getIdArticulo());
			
			//Ejecutar la actualizacion
			pstm.executeUpdate();

		} catch (SQLException e){
			throw new BusinessException("Error al actualizar");
		} finally{
			ConexionJdbc.cerrar(pstm);
		}
	}

	/*@Override
	public void grabarOActualizar(Articulo a) throws BusinessException {
		if(buscarPorId(a.getIdArticulo())!=null) grabar(a);
		else actualizar(a);
	}
*/

	@Override
	public void borrar(Articulo a) throws BusinessException {
		borrar(a.getIdArticulo());
	}

	@Override
	public void borrar(Integer id) throws BusinessException {
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		try{
			String sql = "DELETE FROM articulo WHERE idarticulo= ?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.executeUpdate();
		} catch (SQLException e){
			throw new BusinessException("Error al eliminar");
		} finally{
			ConexionJdbc.cerrar(pstm);
		}
	}

	@Override
	public Articulo buscarPorId(Integer id)  throws BusinessException {
		Articulo a = null;
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			String sql = "SELECT * FROM articulo WHERE idarticulo=?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if (rs.first()){
				a  = new Articulo();
				
				a.setIdArticulo(rs.getInt("idarticulo"));
				a.setNumserie(rs.getString("numserie"));
				a.setEstado(rs.getString("estado"));
				a.setFechaalta(rs.getDate("fechaalta"));
				a.setFechabaja(rs.getDate("fechabaja"));
				a.setUsuarioalta(rs.getInt("usuarioalta"));
				a.setUsuariobaja(rs.getInt("usuariobaja"));
				a.setModelo(rs.getInt("modelo"));
				a.setDepartamento(rs.getInt("departamento"));
				a.setEspacio(rs.getInt("espacio"));
				a.setDentrode(rs.getInt("dentrode"));
				a.setObservaciones(rs.getString("observaciones"));
			}
			return a;
		} catch (SQLException e){
			throw new BusinessException("Error al consultar");
		} finally{
			ConexionJdbc.cerrar(pstm);
		}
	}
	
	
	@Override
	public List<Articulo> buscarTodos()  throws BusinessException {
		List<Articulo> result = new ArrayList<Articulo>();
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			String sql = "SELECT * FROM articulo ORDER BY idarticulo";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				Articulo a  = new Articulo();
				
				a.setIdArticulo(rs.getInt("idarticulo"));
				a.setNumserie(rs.getString("numserie"));
				a.setEstado(rs.getString("estado"));
				a.setFechaalta(rs.getDate("fechaalta"));
				a.setFechabaja(rs.getDate("fechabaja"));
				a.setUsuarioalta(rs.getInt("usuarioalta"));
				a.setUsuariobaja(rs.getInt("usuariobaja"));
				a.setModelo(rs.getInt("modelo"));
				a.setDepartamento(rs.getInt("departamento"));
				a.setEspacio(rs.getInt("espacio"));
				//a.setDentrode(rs.getInt("dentrode"));
				a.setObservaciones(rs.getString("observaciones"));

				
				result.add(a);
			}
			return result;
			
		} catch (SQLException e){
			e.printStackTrace();
			throw new BusinessException("Error al consultar");
		} finally{
			ConexionJdbc.cerrar(pstm);
		}
	}

}