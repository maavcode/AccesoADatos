package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pojos.Articulo;
import excepciones.BusinessException;
import jdbc.ConexionJdbc;

public class DaoArticulo extends DaoGenerico<Articulo, Integer>{

    public void grabar(Articulo a) throws BusinessException {
    	
        // REESTRICCION: Modelo y Espacio son obligatorios
        if (a.getModelo() == null)
            throw new BusinessException("El modelo es obligatorio");
        if (a.getEspacio() == null)
            throw new BusinessException("El espacio es obligatorio");
        
        // REESTRICCION: Estado operativo
        a.setEstado("operativo");
        
        // Obtener conexión desde clase de conexión JDBC
        Connection con = ConexionJdbc.getConnection();
        PreparedStatement pstm = null;

        try{
            // SQL para insertar un artículo
            String sql = "INSERT INTO articulo "
                    + "(idarticulo, numserie, estado, fechaalta, usuarioalta, modelo, departamento, espacio) "
                    + "VALUES (?,?,?,?,?,?,?,?)";        

            pstm = con.prepareStatement(sql);

            // Asignar valores al PreparedStatement
            pstm.setInt(1,a.getIdArticulo());
            pstm.setString(2,a.getNumserie());
            pstm.setString(3,a.getEstado());
            pstm.setDate(4,new java.sql.Date(System.currentTimeMillis())); // FECHA DE HOY
            pstm.setObject(5,a.getUsuarioalta());
            pstm.setObject(6,a.getModelo());
            pstm.setObject(7,a.getDepartamento()); 
            pstm.setObject(8,a.getEspacio()); 

            // Ejecutar inserción en BD
            pstm.executeUpdate();

        } catch (SQLException e){
            // Capturar cualquier error de SQL y lanzar excepción de negocio
            throw new BusinessException("Error al insertar");
        } finally{
            // Cerrar recursos JDBC
            ConexionJdbc.cerrar(pstm);
        }
    }

    // Método para actualizar el estado de un artículo (Práctica 2)
    public void actualizarEstado(int idArticulo, String nuevoEstado, int usuario) throws BusinessException {

        // Buscar artículo por ID
        Articulo a = buscarPorId(idArticulo);
        if (a == null)
            throw new BusinessException("El artículo no existe");

        String actual = a.getEstado();

        // Validaciones de negocio según restricción 2
        if (actual.equals("retirado"))
            throw new BusinessException("No se puede cambiar el estado de un artículo retirado");

        if (actual.equals("operativo") && nuevoEstado.equals("retirado"))
            throw new BusinessException("No se puede retirar desde actualización, use baja");

        if (actual.equals("mantenimiento") && nuevoEstado.equals("retirado"))
            throw new BusinessException("No se puede retirar desde actualización, use baja");

        if (!(nuevoEstado.equals("operativo") || nuevoEstado.equals("mantenimiento")))
            throw new BusinessException("Estado inválido");

        // Actualizar en BD
        Connection con = ConexionJdbc.getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "UPDATE articulo SET estado=?, usuarioalta=? WHERE idarticulo=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, nuevoEstado);
            pstm.setInt(2, usuario);
            pstm.setInt(3, idArticulo);
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new BusinessException("Error al actualizar estado");
        } finally {
            ConexionJdbc.cerrar(pstm);
        }
    }

    // Método para dar de baja (retirar) un artículo
    public void darDeBaja(int idArticulo, int usuario) throws BusinessException {

        // Buscar artículo
        Articulo a = buscarPorId(idArticulo);
        if (a == null)
            throw new BusinessException("El artículo no existe");

        // Validación: si ya está retirado, no se puede
        if (a.getEstado().equals("retirado"))
            throw new BusinessException("El artículo ya está retirado");

        // Actualizar en BD: estado = retirado, registrar usuario y fecha de baja
        Connection con = ConexionJdbc.getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "UPDATE articulo SET estado='retirado', usuariobaja=?, fechabaja=? WHERE idarticulo=?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, usuario);
            pstm.setDate(2, new java.sql.Date(new java.util.Date().getTime())); // fecha actual
            pstm.setInt(3, idArticulo);
            pstm.executeUpdate();

        } catch (SQLException e) {
            throw new BusinessException("Error al dar de baja");
        } finally {
            ConexionJdbc.cerrar(pstm);
        }
    }

    // Método para actualizar masivamente todos los artículos que tienen fecha_baja a retirado
    public void actualizarRetiradosMasivo() throws BusinessException {
        Connection con = ConexionJdbc.getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "UPDATE articulo SET estado='retirado' WHERE fechabaja IS NOT NULL";
            pstm = con.prepareStatement(sql);
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new BusinessException("Error en la actualización masiva");
        } finally {
            ConexionJdbc.cerrar(pstm);
        }
    }

    // Método genérico para actualizar un artículo completo
    @Override
    public void actualizar(Articulo a) throws BusinessException {

        Connection con = ConexionJdbc.getConnection();
        PreparedStatement pstm = null;
        try{
            // SQL de actualización de todos los campos
            String sql = "UPDATE articulo "
                    + " SET numserie= ?, estado = ?, fechaalta= ?, fechabaja= ?,"
                    + " usuarioalta = ?, usuariobaja = ?, modelo = ?, departamento = ?, espacio = ?,"
                    + "dentrode = ?, observaciones = ?"
                    + " WHERE idarticulo = ?";

            // Asignar valores
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

            // Ejecutar actualización
            pstm.executeUpdate();

        } catch (SQLException e){
            throw new BusinessException("Error al actualizar");
        } finally{
            ConexionJdbc.cerrar(pstm);
        }
    }

    // Método para borrar un artículo por objeto
    @Override
    public void borrar(Articulo a) throws BusinessException {
        borrar(a.getIdArticulo());
    }

    // Método para borrar un artículo por ID
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

    // Buscar un artículo por su ID
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

            // Si existe, mapear datos al objeto Articulo
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

    // Buscar todos los artículos en la tabla
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

            // Mapear cada fila a un objeto Articulo y agregar a la lista
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
                // a.setDentrode(rs.getInt("dentrode")); // opcional
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
