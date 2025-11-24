package dao;

import java.sql.*;
import java.util.*;
import excepciones.BusinessException;
import jdbc.ConexionJdbc;
import pojos.Practica;

public class DaoPractica extends DaoGenerico<Practica, String> {

    @Override
    public void grabar(Practica p) throws BusinessException {
        Connection con = ConexionJdbc.getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "INSERT INTO practicas (CodP, Puntos, Curso, Fecha_limite) VALUES (?, ?, ?, ?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, p.getCodP());
            pstm.setInt(2, p.getPuntos());
            pstm.setInt(3, p.getCurso());
            if (p.getFechaLimite() != null) {
                pstm.setDate(4, new java.sql.Date(p.getFechaLimite().getTime()));
            } else {
                pstm.setDate(4, null);
            }
            pstm.executeUpdate();
        } catch (SQLException ex) {
            throw new BusinessException("Error al insertar práctica");
        } finally {
            ConexionJdbc.cerrar(pstm);
        }
    }

    @Override
    public void actualizar(Practica p) throws BusinessException {
        Connection con = ConexionJdbc.getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "UPDATE practicas SET Puntos = ?, Curso = ?, Fecha_limite = ? WHERE CodP = ?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, p.getPuntos());
            pstm.setInt(2, p.getCurso());
            if (p.getFechaLimite() != null) {
                pstm.setDate(3, new java.sql.Date(p.getFechaLimite().getTime()));
            } else {
                pstm.setDate(3, null);
            }
            pstm.setString(4, p.getCodP());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            throw new BusinessException("Error al actualizar práctica");
        } finally {
            ConexionJdbc.cerrar(pstm);
        }
    }

    @Override
    public void borrar(Practica p) throws BusinessException {
        borrar(p.getCodP());
    }

    @Override
    public void borrar(String codP) throws BusinessException {
        Connection con = ConexionJdbc.getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "DELETE FROM practicas WHERE CodP = ?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, codP);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            throw new BusinessException("Error al eliminar práctica");
        } finally {
            ConexionJdbc.cerrar(pstm);
        }
    }

    @Override
    public Practica buscarPorId(String codP) throws BusinessException {
        Practica p = null;
        Connection con = ConexionJdbc.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM practicas WHERE CodP = ?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, codP);
            rs = pstm.executeQuery();
            if (rs.first()) {
                p = new Practica();
                p.setCodP(rs.getString("CodP"));
                p.setPuntos(rs.getInt("Puntos"));
                p.setCurso(rs.getInt("Curso"));
                p.setFechaLimite(rs.getDate("Fecha_limite"));
            }
            return p;
        } catch (SQLException ex) {
            throw new BusinessException("Error al consultar práctica");
        } finally {
            ConexionJdbc.cerrar(pstm);
        }
    }

    @Override
    public List<Practica> buscarTodos() throws BusinessException {
        List<Practica> result = new ArrayList<>();
        Connection con = ConexionJdbc.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM practicas ORDER BY CodP";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Practica p = new Practica();
                p.setCodP(rs.getString("CodP"));
                p.setPuntos(rs.getInt("Puntos"));
                p.setCurso(rs.getInt("Curso"));
                p.setFechaLimite(rs.getDate("Fecha_limite"));
                result.add(p);
            }
            return result;
        } catch (SQLException ex) {
            throw new BusinessException("Error al consultar prácticas");
        } finally {
            ConexionJdbc.cerrar(pstm);
        }
    }
}
