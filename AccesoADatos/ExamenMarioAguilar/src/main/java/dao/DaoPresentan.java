package dao;

import java.sql.*;
import java.util.*;
import excepciones.BusinessException;
import jdbc.ConexionJdbc;
import pojos.Presentan;

public class DaoPresentan extends DaoGenerico<Presentan, String> {

    // Clave compuesta: CodAl + CodP

    @Override
    public void grabar(Presentan pr) throws BusinessException {
    	
    
		
        Connection con = ConexionJdbc.getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "INSERT INTO presentan (CodAl, CodP, Nota, Fecha_entrega) VALUES (?, ?, ?, ?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, pr.getCodAl());
            pstm.setString(2, pr.getCodP());
            if (pr.getNota() != null) {
                pstm.setInt(3, pr.getNota());
            } else {
                pstm.setNull(3, Types.INTEGER);
            }
            if (pr.getFechaEntrega() != null) {
                pstm.setDate(4, new java.sql.Date(pr.getFechaEntrega().getTime()));
            } else {
                pstm.setDate(4, null);
            }
            pstm.executeUpdate();
            
        } catch (SQLException ex) {
            throw new BusinessException("Error al insertar entrega de práctica");
        } finally {
            ConexionJdbc.cerrar(pstm);
        }
    }

    @Override
    public void actualizar(Presentan pr) throws BusinessException {
        Connection con = ConexionJdbc.getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "UPDATE presentan SET Nota = ?, Fecha_entrega = ? WHERE CodAl = ? AND CodP = ?";
            pstm = con.prepareStatement(sql);
            if (pr.getNota() != null) {
                pstm.setInt(1, pr.getNota());
            } else {
                pstm.setNull(1, Types.INTEGER);
            }
            if (pr.getFechaEntrega() != null) {
                pstm.setDate(2, new java.sql.Date(pr.getFechaEntrega().getTime()));
            } else {
                pstm.setDate(2, null);
            }
            pstm.setInt(3, pr.getCodAl());
            pstm.setString(4, pr.getCodP());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            throw new BusinessException("Error al actualizar entrega de práctica");
        } finally {
            ConexionJdbc.cerrar(pstm);
        }
    }

    @Override
    public void borrar(Presentan pr) throws BusinessException {
        borrar(pr.getCodAl(), pr.getCodP());
    }

    public void borrar(Integer codAl, String codP) throws BusinessException {
        Connection con = ConexionJdbc.getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "DELETE FROM presentan WHERE CodAl = ? AND CodP = ?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, codAl);
            pstm.setString(2, codP);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            throw new BusinessException("Error al eliminar entrega de práctica");
        } finally {
            ConexionJdbc.cerrar(pstm);
        }
    }

    public Presentan buscarPorId(Integer codAl, String codP) throws BusinessException {
        Presentan pr = null;
        Connection con = ConexionJdbc.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM presentan WHERE CodAl = ? AND CodP = ?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, codAl);
            pstm.setString(2, codP);
            rs = pstm.executeQuery();
            if (rs.first()) {
                pr = new Presentan();
                pr.setCodAl(rs.getInt("CodAl"));
                pr.setCodP(rs.getString("CodP"));
                pr.setNota(rs.getInt("Nota"));
                pr.setFechaEntrega(rs.getDate("Fecha_entrega"));
            }
            return pr;
        } catch (SQLException ex) {
            throw new BusinessException("Error al consultar entrega de práctica");
        } finally {
            ConexionJdbc.cerrar(pstm);
        }
    }

    @Override
    public List<Presentan> buscarTodos() throws BusinessException {
        List<Presentan> result = new ArrayList<>();
        Connection con = ConexionJdbc.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM presentan ORDER BY CodAl, CodP";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
        }catch (Exception e) {
			// TODO: handle exception
		}
		return result;
        }
}