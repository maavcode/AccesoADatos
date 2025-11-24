package dao;

import java.sql.*;
import java.util.*;
import excepciones.BusinessException;
import jdbc.ConexionJdbc;
import pojos.Asignatura;

public class DaoAsignatura extends DaoGenerico<Asignatura, String> {

    @Override
    public void grabar(Asignatura a) throws BusinessException {
        Connection con = ConexionJdbc.getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "INSERT INTO asignatura (CodAsig, descripción, ciclo) VALUES (?, ?, ?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, a.getCodAsig());
            pstm.setString(2, a.getDescripcion());
            pstm.setString(3, a.getCiclo());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            throw new BusinessException("Error al insertar asignatura");
        } finally {
            ConexionJdbc.cerrar(pstm);
        }
    }

    @Override
    public void actualizar(Asignatura a) throws BusinessException {
        Connection con = ConexionJdbc.getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "UPDATE asignatura SET descripción = ?, ciclo = ? WHERE CodAsig = ?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, a.getDescripcion());
            pstm.setString(2, a.getCiclo());
            pstm.setString(3, a.getCodAsig());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            throw new BusinessException("Error al actualizar asignatura");
        } finally {
            ConexionJdbc.cerrar(pstm);
        }
    }

    @Override
    public void borrar(Asignatura a) throws BusinessException {
        borrar(a.getCodAsig());
    }

    @Override
    public void borrar(String id) throws BusinessException {
        Connection con = ConexionJdbc.getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "DELETE FROM asignatura WHERE CodAsig = ?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            throw new BusinessException("Error al eliminar asignatura");
        } finally {
            ConexionJdbc.cerrar(pstm);
        }
    }

    @Override
    public Asignatura buscarPorId(String id) throws BusinessException {
        Asignatura a = null;
        Connection con = ConexionJdbc.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM asignatura WHERE CodAsig = ?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
            rs = pstm.executeQuery();
            if (rs.first()) {
                a = new Asignatura();
                a.setCodAsig(rs.getString("CodAsig"));
                a.setDescripcion(rs.getString("descripción"));
                a.setCiclo(rs.getString("ciclo"));
            }
            return a;
        } catch (SQLException ex) {
            throw new BusinessException("Error al consultar asignatura");
        } finally {
            ConexionJdbc.cerrar(pstm);
        }
    }

    @Override
    public List<Asignatura> buscarTodos() throws BusinessException {
        List<Asignatura> result = new ArrayList<>();
        Connection con = ConexionJdbc.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM asignatura ORDER BY CodAsig";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Asignatura a = new Asignatura();
                a.setCodAsig(rs.getString("CodAsig"));
                a.setDescripcion(rs.getString("descripción"));
                a.setCiclo(rs.getString("ciclo"));
                result.add(a);
            }
            return result;
        } catch (SQLException ex) {
            throw new BusinessException("Error al consultar asignaturas");
        } finally {
            ConexionJdbc.cerrar(pstm);
        }
    }
}
