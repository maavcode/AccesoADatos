package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import excepciones.BusinessException;
import jdbc.ConexionJdbc;
import pojos.Horarios;

public class DaoHorarios extends DaoGenerico<Horarios, String> {

    @Override
    public void grabar(Horarios h) throws BusinessException {
        Connection con = ConexionJdbc.getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "INSERT INTO horarios (CodH, horario) VALUES (?, ?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, h.getCodH());
            pstm.setString(2, h.getHorario());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new BusinessException("Error al insertar horario");
        } finally {
            ConexionJdbc.cerrar(pstm);
        }
    }

    @Override
    public void actualizar(Horarios h) throws BusinessException {
        Connection con = ConexionJdbc.getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "UPDATE horarios SET horario = ? WHERE CodH = ?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, h.getHorario());
            pstm.setString(2, h.getCodH());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            throw new BusinessException("Error al actualizar horario");
        } finally {
            ConexionJdbc.cerrar(pstm);
        }
    }

    @Override
    public void borrar(Horarios h) throws BusinessException {
        borrar(h.getCodH());
    }

    @Override
    public void borrar(String codH) throws BusinessException {
        Connection con = ConexionJdbc.getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "DELETE FROM horarios WHERE CodH = ?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, codH);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            throw new BusinessException("Error al eliminar horario");
        } finally {
            ConexionJdbc.cerrar(pstm);
        }
    }

    @Override
    public Horarios buscarPorId(String codH) throws BusinessException {
        Horarios h = null;
        Connection con = ConexionJdbc.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM horarios WHERE CodH = ?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, codH);
            rs = pstm.executeQuery();
            if (rs.first()) {
                h = new Horarios();
                h.setCodH(rs.getString("CodH"));
                h.setHorario(rs.getString("horario"));
            }
            return h;
        } catch (SQLException ex) {
            throw new BusinessException("Error al consultar horario");
        } finally {
            ConexionJdbc.cerrar(pstm);
        }
    }

    @Override
    public List<Horarios> buscarTodos() throws BusinessException {
        List<Horarios> result = new ArrayList<>();
        Connection con = ConexionJdbc.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM horarios ORDER BY CodH";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Horarios h = new Horarios();
                h.setCodH(rs.getString("CodH"));
                h.setHorario(rs.getString("horario"));
                result.add(h);
            }
            return result;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new BusinessException("Error al consultar horarios");
        } finally {
            ConexionJdbc.cerrar(pstm);
        }
    }
}
