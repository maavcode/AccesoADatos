package dao;


import java.sql.*;
import java.util.*;
import excepciones.BusinessException;
import jdbc.ConexionJdbc;
import pojos.Alumno;

public class DaoAlumno extends DaoGenerico<Alumno, Integer> {

    @Override
    public void grabar(Alumno a) throws BusinessException {
        Connection con = ConexionJdbc.getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "INSERT INTO alumnos (CodA, Nombre, Domicilio) VALUES (?, ?, ?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, a.getCodA());
            pstm.setString(2, a.getNombre());
            pstm.setString(3, a.getDomicilio());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            throw new BusinessException("Error al insertar alumno");
        } finally {
            ConexionJdbc.cerrar(pstm);
        }
    }

    @Override
    public void actualizar(Alumno a) throws BusinessException {
        Connection con = ConexionJdbc.getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "UPDATE alumnos SET Nombre = ?, Domicilio = ? WHERE CodA = ?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, a.getNombre());
            pstm.setString(2, a.getDomicilio());
            pstm.setInt(3, a.getCodA());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            throw new BusinessException("Error al actualizar alumno");
        } finally {
            ConexionJdbc.cerrar(pstm);
        }
    }

    @Override
    public void borrar(Alumno a) throws BusinessException {
        borrar(a.getCodA());
    }

    @Override
    public void borrar(Integer id) throws BusinessException {
        Connection con = ConexionJdbc.getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "DELETE FROM alumnos WHERE CodA = ?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            throw new BusinessException("Error al eliminar alumno");
        } finally {
            ConexionJdbc.cerrar(pstm);
        }
    }

    @Override
    public Alumno buscarPorId(Integer id) throws BusinessException {
        Alumno a = null;
        Connection con = ConexionJdbc.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM alumnos WHERE CodA = ?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.first()) {
                a = new Alumno();
                a.setCodA(rs.getInt("CodA"));
                a.setNombre(rs.getString("Nombre"));
                a.setDomicilio(rs.getString("Domicilio"));
            }
            return a;
        } catch (SQLException ex) {
            throw new BusinessException("Error al consultar alumno");
        } finally {
            ConexionJdbc.cerrar(pstm);
        }
    }

    @Override
    public List<Alumno> buscarTodos() throws BusinessException {
        List<Alumno> result = new ArrayList<>();
        Connection con = ConexionJdbc.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM alumnos ORDER BY CodA";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Alumno a = new Alumno();
                a.setCodA(rs.getInt("CodA"));
                a.setNombre(rs.getString("Nombre"));
                a.setDomicilio(rs.getString("Domicilio"));
                result.add(a);
            }
            return result;
        } catch (SQLException ex) {
            throw new BusinessException("Error al consultar alumnos");
        } finally {
            ConexionJdbc.cerrar(pstm);
        }
    }
}