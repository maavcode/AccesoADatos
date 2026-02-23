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
import pojos.Espacio;
import pojos.Usuario;

public class DaoEspacio extends DaoGenericoHibernate<Espacio,String> {
	
	private final static Logger LOGGER=Logger.getLogger(DaoArticulo.class.getName());

    /**
     * Cuenta cuantos artículos tiene
     */
	public Integer contarArticulos(String nombreEspacio) throws BusinessException {
		Integer cantidad = 0;

        Session session = UtilesHibernate.getSessionFactory().getCurrentSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            String hql =  "SELECT a "
            			+ "FROM Espacio e "
            			+ "JOIN e.articulos a "
            			+ "WHERE e.nombre = :nombreEspacio";
            Query<Articulo> query = session.createQuery(hql, Articulo.class);
            query.setParameter("nombreEspacio", nombreEspacio);

            List<Articulo> articulos = query.list();
            for (Articulo a : articulos) {
            	System.out.println(a);
            }
            
            cantidad = query.list().size();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (Exception ex) {
                    LOGGER.log(Level.WARNING, "Fallo en rollback", ex);
                }
            }
            LOGGER.log(Level.SEVERE, "Error al buscar grupos", e);
        }
        return cantidad;
    }

}