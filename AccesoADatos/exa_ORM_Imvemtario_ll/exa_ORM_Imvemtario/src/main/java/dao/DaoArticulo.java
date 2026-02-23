package dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import excepciones.BusinessException;
import hibernate.UtilesHibernate;
import pojos.Articulo;

public class DaoArticulo extends DaoGenericoHibernate<Articulo,String> {
	
	private final static Logger LOGGER=Logger.getLogger(DaoArticulo.class.getName());
	

    /**
     * Busca artículos por nombre de su departamento.
     */
	public List<Object[]> buscarArticulosPorNombreDepartamento(String nombreDepartamento) throws BusinessException {
		List<Object[]> resultados = null;

        Session session = UtilesHibernate.getSessionFactory().getCurrentSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            String hql =  "SELECT a.usuarioByUsuariobaja.nombre, a.idarticulo, a.fechabaja, a.modeloarticulo "
            			+ "FROM Articulo a "
            			+ "WHERE a.departamento.nombre = :nombreDepartamento AND fechabaja IS NOT NULL";
            Query<Object[]> query = session.createQuery(hql, Object[].class);
            query.setParameter("nombreDepartamento", nombreDepartamento);

            resultados = query.list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (Exception ex) {
                    LOGGER.log(Level.WARNING, "Fallo en rollback", ex);
                }
            }
            LOGGER.log(Level.SEVERE, "Error al buscar", e);
        }
        return resultados;
    }
	

    /**
     * Modifica las observaciones de artículos de un modelo.
     */
	public void modificarObservacionesArticulosPorModelo(String nombreModelo, String nuevasObservaciones) throws BusinessException {
		List<Articulo> articulos = null;

        Session session = UtilesHibernate.getSessionFactory().getCurrentSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            String hql =  "SELECT a "
            			+ "FROM Articulo a "
            			+ "WHERE a.modeloarticulo.modelo = :nombreModelo";
            Query<Articulo> query = session.createQuery(hql, Articulo.class);
            query.setParameter("nombreModelo", nombreModelo);

            articulos = query.list();
            
            for(Articulo articulo : articulos) {
            	articulo.setObservaciones(nuevasObservaciones);
            	session.save(articulo);
            }
            

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (Exception ex) {
                    LOGGER.log(Level.WARNING, "Fallo en rollback", ex);
                }
            }
            LOGGER.log(Level.SEVERE, "Error al buscar", e);
        }
    }
}
