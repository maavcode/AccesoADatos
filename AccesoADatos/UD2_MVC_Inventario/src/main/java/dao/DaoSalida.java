package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pojos.Articulo;
import pojos.Salida;
import pojos.Usuario;
import excepciones.BusinessException;
import jdbc.ConexionJdbc;

public class DaoSalida extends DaoGenerico<Salida, Integer> {

	// Buscar una salida por su ID
    @Override
    public Salida buscarPorId(Integer id)  throws BusinessException {
        Salida s = null;
        Connection con = ConexionJdbc.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try{
            String sql = "SELECT * FROM salida WHERE idsalida=?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            // Si existe, mapear datos al objeto Articulo
            if (rs.next()){
                s  = new Salida();
                s.setIdSalida(rs.getInt("idsalida"));
                s.setArticulo(rs.getInt("articulo"));
                s.setUsuario(rs.getInt("usuario"));
                s.setFechaSalida(rs.getTimestamp("fechasalida").toLocalDateTime());
                s.setFechaDevolucion(rs.getTimestamp("fechadevolucion").toLocalDateTime());
            }
            return s;
        } catch (SQLException e){
            throw new BusinessException("Error al consultar");
        } finally{
            ConexionJdbc.cerrar(pstm);
        }
    }
	
	
	// Practica 3 Ejercicio C1
	public void realizarPrestamo(int idArticulo, int idUsuario) throws BusinessException {
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// Busco el articulo
		DaoArticulo daoArticulo = new DaoArticulo();

		Articulo a = daoArticulo.buscarPorId(idArticulo);
		// REESTRICCION: El articulo debe existir
		if (a == null) {
			throw new BusinessException("El articulo con id +" + idArticulo + " no existe");
		}
		// REESTRICCION: El articulo DEBE ser operativo
		if (!a.getEstado().equals("operativo")) {
			throw new BusinessException("El articulo tiene estado " + a.getEstado() + " y deberia de ser operativo");
		}
		
		try {
			// REESTRICCION: El articulo NO tiene que estar prestado
			String sql1 = "select * from salida where articulo=? and fechadevolucion is null";
			pstm = con.prepareStatement(sql1);
			pstm.setInt(1, idArticulo);
			rs = pstm.executeQuery();
			if (rs.next()) {
				throw new BusinessException("El articulo ya esta prestado");
			}
			
			// REESTRICCION: El usuario no puede tener un préstamo activo
			String sql2 = "select * from salida where usuario=? and fechadevolucion is null";
			pstm = con.prepareStatement(sql2);
			pstm.setInt(1, idUsuario);
			rs = pstm.executeQuery();
			if (rs.next()) {
				throw new BusinessException("El usuario ya tiene un prestamo activo");
			}
			
			// Insertar el prestamo con fecha actual
			String sql3 = "insert into salida "
					+ "(articulo, usuario, fechasalida) "
					+ "values (?,?,?)";
			pstm = con.prepareStatement(sql3);
			pstm.setInt(1, idArticulo);
			pstm.setInt(2, idUsuario);
			pstm.setDate(3, new java.sql.Date(System.currentTimeMillis()));
			pstm.executeUpdate(); // Importante
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al obtener");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}

	// Practica 3 Ejercicio C2
	public void actualizarFechaDevolucion(int idSalida, Date fechaDevol) throws BusinessException {

	    Connection con = ConexionJdbc.getConnection();
	    PreparedStatement pstm = null;
	    ResultSet rs = null;

	    // 1. Buscar la salida
	    Salida s = buscarPorId(idSalida);
	    if (s == null) {
	        throw new BusinessException("La salida con id " + idSalida + " no existe");
	    }

	    // 2. Obtener la fecha de salida (LocalDateTime)
	    LocalDateTime fechaSalida = s.getFechaSalida();

	    // Convertir LocalDateTime → milisegundos (forma más simple)
	    long msSalida = fechaSalida.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

	    // Convertir fechaDevol (Date) → milisegundos
	    long msDevol = fechaDevol.getTime();

	    // RESTRICCIÓN 1: No puede ser anterior a la fecha de salida
	    if (msDevol < msSalida) {
	        throw new BusinessException(
	            "La fecha de devolución " + fechaDevol +
	            " es anterior a la fecha de salida " + fechaSalida
	        );
	    }

	    // RESTRICCIÓN 2: No puede superar 30 días
	    long treintaDias = 30L * 24 * 60 * 60 * 1000;

	    if (msDevol > msSalida + treintaDias) {
	        throw new BusinessException("La devolución supera los 30 días permitidos");
	    }

	    try {
	        // 3. Actualizar en BD
	        String sql = "UPDATE salida SET fechadevolucion=? WHERE idsalida=?";
	        pstm = con.prepareStatement(sql);
	        pstm.setDate(1, new java.sql.Date(msDevol));
	        pstm.setInt(2, idSalida);

	        pstm.executeUpdate();

	    } catch (SQLException e) {
	        throw new BusinessException("Error al actualizar la devolución");
	    } finally {
	        ConexionJdbc.cerrar(rs);
	        ConexionJdbc.cerrar(pstm);
	    }
	}
	
	// Practica 3 Ejercicio D1
	public List<Salida> listarPrestamosActivos() throws BusinessException{
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<Salida>listaPrestamosActivos = new ArrayList<Salida>();
		try {
			// Preparar para la insercion
			String sql = "select * from salida where fechadevolucion is null";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				// Creo la salida
				Salida salida = new Salida();
				salida.setIdSalida(rs.getInt("idsalida"));
				salida.setArticulo(rs.getInt("articulo"));
				salida.setUsuario(rs.getInt("usuario"));
				salida.setFechaSalida(rs.getTimestamp("fechasalida").toLocalDateTime());
				salida.setFechaDevolucion(rs.getTimestamp("fechadevolucion").toLocalDateTime());
				// Añado la salida
				listaPrestamosActivos.add(salida);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al insertar");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
		return listaPrestamosActivos;
	}
	
	// Practica 3 Ejercicio D2
	public List<Salida> listarPrestamosDevueltos() throws BusinessException {

	    Connection con = ConexionJdbc.getConnection();
	    PreparedStatement pstm = null;
	    ResultSet rs = null;

	    List<Salida> lista = new ArrayList<>();

	    try {
	        String sql = "SELECT * FROM salida WHERE fechadevolucion IS NOT NULL";
	        pstm = con.prepareStatement(sql);
	        rs = pstm.executeQuery();

	        while (rs.next()) {
	            Salida s = new Salida();
	            s.setIdSalida(rs.getInt("idsalida"));
	            s.setArticulo(rs.getInt("articulo"));
	            s.setUsuario(rs.getInt("usuario"));

	            Timestamp tsSalida = rs.getTimestamp("fechasalida");
	            s.setFechaSalida(tsSalida.toLocalDateTime());

	            Timestamp tsDev = rs.getTimestamp("fechadevolucion");
	            s.setFechaDevolucion(tsDev.toLocalDateTime());

	            lista.add(s);
	        }

	    } catch (SQLException e) {
	        throw new BusinessException("Error al listar préstamos devueltos");
	    } finally {
	        ConexionJdbc.cerrar(rs);
	        ConexionJdbc.cerrar(pstm);
	    }

	    return lista;
	}

	// Practica 3 Ejercicio D3
	public List<Salida> listarPrestamosPorUsuario(int idUsuario) throws BusinessException {

	    Connection con = ConexionJdbc.getConnection();
	    PreparedStatement pstm = null;
	    ResultSet rs = null;

	    List<Salida> lista = new ArrayList<>();

	    try {
	        String sql = "SELECT * FROM salida WHERE usuario = ?";
	        pstm = con.prepareStatement(sql);
	        pstm.setInt(1, idUsuario);
	        rs = pstm.executeQuery();

	        while (rs.next()) {
	            Salida s = new Salida();
	            s.setIdSalida(rs.getInt("idsalida"));
	            s.setArticulo(rs.getInt("articulo"));
	            s.setUsuario(rs.getInt("usuario"));

	            Timestamp tsSalida = rs.getTimestamp("fechasalida");
	            s.setFechaSalida(tsSalida.toLocalDateTime());

	            Timestamp tsDev = rs.getTimestamp("fechadevolucion");
	            if (tsDev != null) {
	                s.setFechaDevolucion(tsDev.toLocalDateTime());
	            }

	            lista.add(s);
	        }

	    } catch (SQLException e) {
	        throw new BusinessException("Error al listar préstamos del usuario");
	    } finally {
	        ConexionJdbc.cerrar(rs);
	        ConexionJdbc.cerrar(pstm);
	    }

	    return lista;
	}

	// Practica 3 Ejercicio D4
	public List<Usuario> listarUsuariosConPrestamosEntreFechas(Date inicio, Date fin) throws BusinessException {

		Connection con = ConexionJdbc.getConnection();
	    PreparedStatement pstm = null;
	    ResultSet rs = null;

	    List<Usuario> lista = new ArrayList<>();

	    try {
	        String sql = 
	            "SELECT DISTINCT u.nombre, u.grupo " +
	            "FROM salida s " +
	            "JOIN usuario u ON s.usuario = u.idusuario " +
	            "WHERE s.fechasalida BETWEEN ? AND ?";

	        pstm = con.prepareStatement(sql);

	        // Convertir java.util.Date → java.sql.Timestamp
	        pstm.setTimestamp(1, new java.sql.Timestamp(inicio.getTime()));
	        pstm.setTimestamp(2, new java.sql.Timestamp(fin.getTime()));

	        rs = pstm.executeQuery();

	        while (rs.next()) {
	            Usuario u = new Usuario();
	            u.setNombre(rs.getString("nombre"));
	            u.setGrupo(rs.getString("grupo"));
	            lista.add(u);
	        }

	    } catch (SQLException e) {
	        throw new BusinessException("Error al listar usuarios entre fechas");
	    } finally {
	        ConexionJdbc.cerrar(rs);
	        ConexionJdbc.cerrar(pstm);
	    }

	    return lista;
	}


	
	@Override
	public void grabar(Salida s) throws BusinessException {
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			// Preparar para la insercion
			String sql = "INSERT INTO salida " + "(usuario,articulo,fechasalida) " + "VALUES (?,?,?)";

			pstm = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pstm.setInt(1, s.getUsuario());
			pstm.setInt(2, s.getArticulo());
			pstm.setTimestamp(3, java.sql.Timestamp.valueOf(s.getFechaSalida()));
			// La fecha de devoluci�n se actualiza al devolvel el art�culo
			// pstm.setTimestamp(4,java.sql.Timestamp.valueOf(o.getFechaDevolucion()));

			// insertar
			pstm.executeUpdate();

			// obtener clave generada
			rs = pstm.getGeneratedKeys();
			if (rs.first()) {
				Integer id = rs.getInt(1);
				s.setIdSalida(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al insertar");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}

	@Override
	public void actualizar(Salida o) throws BusinessException {
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		try {
			// Preparar la actualizacion.
			String sql = "UPDATE salida" + " SET  usuario = ?, articulo = ? , fechasalida = ? , fechadevolucion = ? "
					+ " WHERE idsalida = ?";

			pstm = con.prepareStatement(sql);
			pstm.setInt(1, o.getUsuario());
			pstm.setInt(2, o.getArticulo());
			pstm.setTimestamp(3, java.sql.Timestamp.valueOf(o.getFechaSalida()));
			pstm.setTimestamp(4, java.sql.Timestamp.valueOf(o.getFechaDevolucion()));
			pstm.setInt(5, o.getIdSalida());

			// Ejecutar la actualizacion
			int actualizados = pstm.executeUpdate();
			if (actualizados == 0)
				throw new BusinessException("La salida a modificar no existe");

		} catch (SQLException e) {
			throw new BusinessException("Error al actualizar");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}

	}

	@Override
	public List<Salida> buscarTodos() throws BusinessException {
		List<Salida> result = new ArrayList<Salida>();
		Connection con = ConexionJdbc.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM salida";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				Salida s = new Salida();
				s.setIdSalida(rs.getInt(1));
				s.setUsuario(rs.getInt(2));
				LocalDateTime fechaSal = rs.getTimestamp("fechaSalida").toLocalDateTime();
				s.setFechaSalida(fechaSal);

				result.add(s);
			}
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al consultar");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}
}
