package dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;
import pojosEsther.Disco;

public class DaoDisco extends DaoGenericoHibernate<Disco, String> {
	private final static Logger LOGGER = Logger.getLogger(DaoDisco.class.getName());

	// BUSCAR DISCO POR NOMBRE [ PARAMETRIZADO ] | EjercicioI
	public List<String> buscarPorNombreParametrizado(String nombre) {

		List<String> result = null;
		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();

		try {
			// Empieza la transaccion // SIEMPRE
			s.beginTransaction();

			// Creo la Query HQL
			String hql = "select c.titulo from Disco d join d.cancions c where d.nombre=:nom";
			Query q = s.createQuery(hql);
			q.setParameter("nom", nombre); // nom es la etiqueta, se puede poner ? y luego donde esta o una etiqueta

			// El resultado de la Query se inserta en result
			result = (List<String>) q.getResultList();

			s.getTransaction().commit(); // SIEMPRE

		} catch (ConstraintViolationException cve) { // SIEMPRE
			// Si dio error la transaccion, deshace los cambios
			try {
				s.getTransaction().rollback();
				;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

}
