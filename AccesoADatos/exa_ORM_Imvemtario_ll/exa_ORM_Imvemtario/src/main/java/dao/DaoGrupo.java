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

public class DaoGrupo extends DaoGenericoHibernate<Articulo,String> {
	
	private final static Logger LOGGER=Logger.getLogger(DaoArticulo.class.getName());
	

    /**
     * Busca todos los grupos, de cada uno muestra los alumnos con salidas de artículos, y de cada 
     * alumno la fecha de salida y el número de serie del artículo.
     */
	public List<Object[]> buscarSalidasAlumnosGrupos() throws BusinessException {
		List<Object[]> resultados = null;

        Session session = UtilesHibernate.getSessionFactory().getCurrentSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            String hql =  "SELECT g.nombre, u.nombre, s.fechasalida, s.articulo.numserie "
            			+ "FROM Grupo g "
            			+ "JOIN g.usuarios u "
            			+ "JOIN u.salidas s "
            			+ "WHERE u.salidas.size > 0";
            Query<Object[]> query = session.createQuery(hql, Object[].class);

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
            LOGGER.log(Level.SEVERE, "Error al buscar grupos", e);
        }
        return resultados;
    }
}
