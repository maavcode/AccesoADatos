package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Grupo;
import jdbc.ConexionJdbc;
import excepciones.BusinessException;

public class DaoGrupo extends DaoGenerico<Grupo, String> {
	@Override
	/**
	 * Persiste el grupo dado. El identificador no se genera autom�ticamente
	 * sino que esta incluido en el objeto dado.
	 */
	public void grabar(Grupo g) throws BusinessException {
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		try {
			// Preparar para la inserci�n
			String sql = "INSERT INTO grupo " + 
			"(idgrupo, nombre )VALUES (?,?)";

			pstm = con.prepareStatement(sql);
			pstm.setString(1, g.getIdgrupo());
			pstm.setString(2, g.getNombre());

			// insertar
			pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al insertar");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}

	@Override
	public void actualizar(Grupo g) throws BusinessException {
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		try {
			// Preparar la actualizaci�n.
			String sql = "UPDATE grupo" + " SET nombre = ? " + " WHERE idgrupo = ?";

			pstm = con.prepareStatement(sql);
			pstm.setString(1, g.getNombre());
			pstm.setString(2, g.getIdgrupo());

			// Ejecutar la actualizacion
			if (pstm.executeUpdate() == 0)
				throw new BusinessException("Elemento no encontrado");

		} catch (SQLException e) {
			throw new BusinessException("Error al actualizar");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}

	@Override
	public void grabarOActualizar(Grupo g) throws BusinessException {
		if (buscarPorId(g.getIdgrupo()) != null)
			grabar(g);
		else
			actualizar(g);
	}

	@Override
	public void borrar(Grupo g) throws BusinessException {
		borrar(g.getIdgrupo());
	}

	@Override
	public void borrar(String id) throws BusinessException {
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "DELETE FROM grupo WHERE idgrupo = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			if (pstm.executeUpdate() == 0)
				throw new BusinessException("Elemento no encontrado");
		} catch (SQLException e) {
			throw new BusinessException("Error al eliminar");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}
	@Override
	public Grupo buscarPorId(String id) throws BusinessException {
		Grupo result = null;
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM grupo WHERE idgrupo = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			if (rs.first()) {//select me devuelve la fila de ese id
				result = new Grupo(id, rs.getString("nombre"));
			}else //no ha encontrado ninguna fila con ese id la select
				throw new BusinessException("Elemento no encontrado");
			return result;

		} catch (SQLException e) {
			throw new BusinessException("Error al consultar");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}

	@Override
	public List<Grupo> buscarTodos() throws BusinessException {
		List<Grupo> result = new ArrayList<Grupo>();
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM grupo ORDER BY idgrupo";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Grupo g = new Grupo(rs.getString("idgrupo"), rs.getString("nombre"));
				result.add(g);
			}
			return result;

		} catch (SQLException e) {
			throw new BusinessException("Error al consultar");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}

}

	