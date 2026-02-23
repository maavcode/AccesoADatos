package dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;
import pojos.Cancion;
import pojos.Disco;
import pojos.Grupo;

public class DaoCancion extends DaoGenericoHibernate<Cancion, Integer> {
	private final static Logger LOGGER = Logger.getLogger(DaoCancion.class.getName());

	public void buscarOrigenPorNombre(String nombre) {

		Session sesion = UtilesHibernate.getSessionFactory().getCurrentSession();
		List<Object[]> result = null;

		try {

			sesion.beginTransaction();
			String hql = "select distinct d.nombre, g.nombre" + " from Cancion c " + "join c.discos d "
					+ "join d.grupo g " + "where c.titulo =:nom";

			Query query = sesion.createQuery(hql);
			query.setParameter("nom", nombre);

			result = query.list();

			for (Object[] fila : result) {
				System.out.println(fila[0] + " - " + fila[1]);

			}

		} catch (ConstraintViolationException cve) {
			try {
				sesion.getTransaction().rollback();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Object totalCanciones() {

		Session sesion = UtilesHibernate.getSessionFactory().getCurrentSession();
		Object result = null;

		try {

			sesion.beginTransaction();

			String hql = "select count(c) from Cancion c";
			Query query = sesion.createQuery(hql);

			result = (Object) query.uniqueResult();
			sesion.getTransaction().commit();

		} catch (ConstraintViolationException cve) {

			try {
				sesion.getTransaction().rollback();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public List<Object[]> discoGrupoPaisPorNombre(String nombre) {
		Session sesion = UtilesHibernate.getSessionFactory().getCurrentSession();
		List<Object[]> result = null;

		try {

			sesion.beginTransaction();
			
			String hql = "select d.nombre, g.nombre, g.pais from Cancion c "
					+ "join c.discos d "
					+ "join d.grupo g "
					+ "where c.titulo =:nom";
			
			Query query = sesion.createQuery(hql);
			query.setParameter("nom", nombre);
			
			result = query.list();
			sesion.getTransaction().commit();
			
			
		} catch (ConstraintViolationException cve) {
			try {
				sesion.getTransaction().rollback();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}
