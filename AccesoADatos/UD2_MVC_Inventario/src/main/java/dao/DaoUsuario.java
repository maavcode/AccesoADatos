package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Usuario;
import jdbc.ConexionJdbc;
import excepciones.BusinessException;

public class DaoUsuario extends DaoGenerico<Usuario, Integer> {

	/*
	 * private void comprobarTipoUsuario(Usuario u) throws BusinessException{
	 * Integer tipo = u.getTipo(); if(tipo == DaoTipoUsuario.PROFESOR){ if
	 * (u.getGrupo()!= null) throw new
	 * BusinessException("Profesor tiene asignado grupo"); if (u.getDepartamento()
	 * == null) throw new
	 * BusinessException("Profesor no tiene asignado departamento"); } else if (tipo
	 * == DaoTipoUsuario.ALUMNO){ if (u.getGrupo()== null) throw new
	 * BusinessException("Alumno no tiene asignado grupo"); if (u.getDepartamento()
	 * != null) throw new BusinessException("Alumno tiene asignado departamento"); }
	 * else { if (u.getGrupo() != null) throw new
	 * BusinessException("PAS tiene asignado grupo"); if (u.getDepartamento() !=
	 * null) throw new BusinessException("PAS tiene asignado departamento"); } }
	 */

	@Override
	public void grabar(Usuario u) throws BusinessException {

		// comprobarTipoUsuario(u);

		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			// Preparar para la inserci�n
			String sql = "INSERT INTO usuario " + "(username, password, tipo, rol, grupo, departamento, "
					+ "nombre, apellido1, apellido2,domicilio, poblacion, codpostal, " + "email, telefono ) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			pstm = con.prepareStatement(sql);
			pstm.setString(1, u.getUserName());
			pstm.setString(2, u.getPassword());
			pstm.setInt(3, u.getTipo());
			pstm.setInt(4, u.getRol());
			pstm.setString(5, u.getGrupo());
			pstm.setInt(6, u.getDepartamento());
			pstm.setString(7, u.getNombre());
			pstm.setString(8, u.getApellido1());
			pstm.setString(9, u.getApellido2());
			pstm.setString(10, u.getDomicilio());
			pstm.setString(11, u.getPoblacion());
			pstm.setString(12, u.getCodPostal());
			pstm.setString(13, u.getEmail());
			pstm.setString(14, u.getTelefono());

			// insertar
			pstm.executeUpdate();

			// obtener clave generada
			rs = pstm.getGeneratedKeys();
			if (rs.first()) {
				Integer id = rs.getInt(1);
				u.setIdUsuario(id);
			}
		} catch (SQLException e) {
			throw new BusinessException("Error al insertar");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}

	@Override
	public void actualizar(Usuario u) throws BusinessException {

		// comprobarTipoUsuario(u);

		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		try {
			// Preparar la actualizaci�n.
			String sql = "UPDATE usuario " + " SET username= ?, password = ?, tipo= ?, rol= ?,"
					+ " grupo= ?, departamento= ?, nombre= ?, apellido1= ?, apellido2= ?,"
					+ "domicilio= ?, poblacion= ?, codpostal= ?, email= ?, telefono = ? " + " WHERE idusuario = ?";

			pstm = con.prepareStatement(sql);
			pstm.setString(1, u.getUserName());
			pstm.setString(2, u.getPassword());
			pstm.setInt(3, u.getTipo());
			pstm.setInt(4, u.getRol());
			pstm.setString(5, u.getGrupo());
			pstm.setInt(6, u.getDepartamento());
			pstm.setString(7, u.getNombre());
			pstm.setString(8, u.getApellido1());
			pstm.setString(9, u.getApellido2());
			pstm.setString(10, u.getDomicilio());
			pstm.setString(11, u.getPoblacion());
			pstm.setString(12, u.getCodPostal());
			pstm.setString(13, u.getEmail());
			pstm.setString(14, u.getTelefono());
			pstm.setInt(15, u.getIdUsuario());

			// Ejecutar la actualizacion
			if (pstm.executeUpdate() == 0)
				throw new BusinessException("Elemento no encontrado");

		} catch (SQLException e) {
			throw new BusinessException("Error al actualizar");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}

	/*
	 * @Override public void grabarOActualizar(Usuario u) throws BusinessException {
	 * if(buscarPorId(u.getIdUsuario())!=null) grabar(u); else actualizar(u); }
	 */

	@Override
	public void borrar(Usuario u) throws BusinessException {
		borrar(u.getIdUsuario());
	}

	@Override
	public void borrar(Integer id) throws BusinessException {
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "DELETE FROM usuario WHERE idusuario= ?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			if (pstm.executeUpdate() == 0)
				throw new BusinessException("Elemento no encontrado");
		} catch (SQLException e) {
			throw new BusinessException("Error al eliminar");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}

	@Override
	public Usuario buscarPorId(Integer id) throws BusinessException {
		Usuario u = null;
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM usuario WHERE idusuario=?";
			pstm = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if (rs.first()) {
				u = new Usuario();

				u.setIdUsuario(rs.getInt("idusuario"));
				u.setUserName(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setTipo(rs.getInt("tipo"));
				u.setRol(rs.getInt("rol"));
				u.setGrupo(rs.getString("grupo"));
				u.setDepartamento(rs.getInt("departamento"));
				u.setNombre(rs.getString("nombre"));
				u.setApellido1(rs.getString("apellido1"));
				u.setApellido2(rs.getString("apellido2"));
				u.setDomicilio(rs.getString("domicilio"));
				u.setPoblacion(rs.getString("poblacion"));
				u.setCodPostal(rs.getString("codpostal"));
				u.setEmail(rs.getString("email"));
				u.setTelefono(rs.getString("telefono"));

			}
			return u;
		} catch (SQLException e) {
			throw new BusinessException("Error al consultar");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}

	@Override
	public List<Usuario> buscarTodos() throws BusinessException {
		List<Usuario> result = new ArrayList<Usuario>();
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM usuario ORDER BY idusuario";
			pstm = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = pstm.executeQuery();

			while (rs.next()) {
				Usuario u = new Usuario();

				u.setIdUsuario(rs.getInt("idusuario"));
				u.setUserName(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setTipo(rs.getInt("tipo"));
				u.setRol(rs.getInt("rol"));
				u.setGrupo(rs.getString("grupo"));
				u.setDepartamento(rs.getInt("departamento"));
				u.setNombre(rs.getString("nombre"));
				u.setApellido1(rs.getString("apellido1"));
				u.setApellido2(rs.getString("apellido2"));
				u.setDomicilio(rs.getString("domicilio"));
				u.setPoblacion(rs.getString("poblacion"));
				u.setCodPostal(rs.getString("codpostal"));
				u.setEmail(rs.getString("email"));
				u.setTelefono(rs.getString("telefono"));

				result.add(u);
			}
			return result;

		} catch (SQLException e) {
			throw new BusinessException("Error al consultar");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}
	
	public List<Integer> filtrar_nombre_apell(String nombre, String ape1, String ape2) throws BusinessException {
		List<Integer> result = new ArrayList<Integer>();
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT idusuario FROM usuario WHERE nombre = ? AND apellido1 = ? AND apellido2 = ?";
			pstm = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			pstm.setString(1, nombre);
			pstm.setString(2, ape1);
			pstm.setString(3, ape2);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				Integer id = rs.getInt(1);
				result.add(id);
			}
			return result;
		} catch (SQLException e) {
			throw new BusinessException("Error al filtrar por nombre y apellido");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}
	
	public List<Usuario> buscarPorDepartamento(Integer id) throws BusinessException {
		List<Usuario> result = new ArrayList<Usuario>();
		Usuario u = null;
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT nombre, apellido1, apellido2 FROM usuario WHERE departamento=?";
			pstm = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				u = new Usuario();

				u.setNombre(rs.getString("nombre"));
				u.setApellido1(rs.getString("apellido1"));
				u.setApellido2(rs.getString("apellido2"));

				result.add(u);
			}
			return result;
		} catch (SQLException e) {
			throw new BusinessException("Error al consultar");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}
	
	public List<Usuario> buscarPorGrupo(String nombreGrupo) throws BusinessException {
		List<Usuario> result = new ArrayList<Usuario>();
		Usuario u = null;
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT nombre, apellido1, apellido2 FROM usuario WHERE grupo=?";
			pstm = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstm.setString(1, nombreGrupo);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				u = new Usuario();

				u.setNombre(rs.getString("nombre"));
				u.setApellido1(rs.getString("apellido1"));
				u.setApellido2(rs.getString("apellido2"));

				result.add(u);
			}
			return result;
		} catch (SQLException e) {
			throw new BusinessException("Error al consultar");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}

}
