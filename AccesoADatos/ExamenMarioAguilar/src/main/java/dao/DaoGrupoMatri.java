package dao;

import java.sql.*;
import java.util.*;
import excepciones.BusinessException;
import jdbc.ConexionJdbc;
import pojos.Grupo;
import pojos.GrupoMatri;

public class DaoGrupoMatri extends DaoGenerico<GrupoMatri, String> {

	public List<Object[]> consultarEstadoOcupacionPorAsignatura(String CodAsig) throws BusinessException {
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Object[]> resultado = new ArrayList<Object[]>();
		try {
			// RESTRICCION: Compruebo que el grupo con la asignatura exista
			String sql = "select * from grupos where CodAsig=?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, CodAsig);
			rs = pstm.executeQuery();
			if (!rs.next()) {
				throw new BusinessException("No existen grupos con la asignatura " + CodAsig);
			}
			// 
			String sql1 = "select g.CodG, count(*), h.horario from grupos g " 
					+ "join gruposmatri gm on g.CodG = gm.CodG " 
					+ "join horarios h on g.CodH = h.CodH "
					+ "where g.CodAsig=? "
					+ "group by g.CodG, g.CodH";
			pstm = con.prepareStatement(sql1);
			pstm.setString(1, CodAsig);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Object[] object = new Object[3];
				object[0] = rs.getString(1);
				object[1] = rs.getInt(2);
				object[2] = rs.getString(3);
				
				resultado.add(object);
			}
			
		} catch (SQLException ex) {
			throw new BusinessException("Error al consultar");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
		return resultado;
	}

	// En este caso, la PK es compuesta (CodG + CodAl).
	// Para simplificar, usaremos un objeto GrupoMatri en los métodos de
	// búsqueda/borrado.

	@Override
	public void grabar(GrupoMatri gm) throws BusinessException {
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "INSERT INTO gruposmatri (CodG, CodAl, CodH) VALUES (?, ?, ?)";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, gm.getCodG());
			pstm.setInt(2, gm.getCodAl());
			pstm.setString(3, gm.getCodH());
			pstm.executeUpdate();
		} catch (SQLException ex) {
			throw new BusinessException("Error al insertar matrícula de grupo");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}

	@Override
	public void actualizar(GrupoMatri gm) throws BusinessException {
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "UPDATE gruposmatri SET CodH = ? WHERE CodG = ? AND CodAl = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, gm.getCodH());
			pstm.setString(2, gm.getCodG());
			pstm.setInt(3, gm.getCodAl());
			pstm.executeUpdate();
		} catch (SQLException ex) {
			throw new BusinessException("Error al actualizar matrícula de grupo");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}

	@Override
	public void borrar(GrupoMatri gm) throws BusinessException {
		borrar(gm.getCodG(), gm.getCodAl());
	}

	// Método específico para clave compuesta
	public void borrar(String codG, Integer codAl) throws BusinessException {
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "DELETE FROM gruposmatri WHERE CodG = ? AND CodAl = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, codG);
			pstm.setInt(2, codAl);
			pstm.executeUpdate();
		} catch (SQLException ex) {
			throw new BusinessException("Error al eliminar matrícula de grupo");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}

	// Buscar por clave compuesta
	public GrupoMatri buscarPorId(String codG, Integer codAl) throws BusinessException {
		GrupoMatri gm = null;
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM gruposmatri WHERE CodG = ? AND CodAl = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, codG);
			pstm.setInt(2, codAl);
			rs = pstm.executeQuery();
			if (rs.first()) {
				gm = new GrupoMatri();
				gm.setCodG(rs.getString("CodG"));
				gm.setCodAl(rs.getInt("CodAl"));
				gm.setCodH(rs.getString("CodH"));
			}
			return gm;
		} catch (SQLException ex) {
			throw new BusinessException("Error al consultar matrícula de grupo");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}

	@Override
	public List<GrupoMatri> buscarTodos() throws BusinessException {
		List<GrupoMatri> result = new ArrayList<>();
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM gruposmatri ORDER BY CodG, CodAl";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				GrupoMatri gm = new GrupoMatri();
				gm.setCodG(rs.getString("CodG"));
				gm.setCodAl(rs.getInt("CodAl"));
				gm.setCodH(rs.getString("CodH"));
				result.add(gm);
			}
			return result;
		} catch (SQLException ex) {
			throw new BusinessException("Error al consultar matrículas de grupos");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}
}
