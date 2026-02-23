package dao;

import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;
import pojos.Companyia;

public class DaoCompanyia extends DaoGenericoHibernate<Companyia, Integer> {
	private final static Logger LOGGER = Logger.getLogger(DaoCompanyia.class.getName());

	public Object[] buscarPorNombre(String nombre) {

		// Obtenemos la sesion que hemos conectado en la interfaz
		Session sesion = UtilesHibernate.getSessionFactory().getCurrentSession();
		Object[] result = null;

		try {

			sesion.beginTransaction();
			String hql = "select c.tfno, c.fax from Companyia c where c.nombre=:nom";
			Query query = sesion.createQuery(hql);

			// Asignamos la variable recibida al parametro de la query
			query.setParameter("nom", nombre);

			result = (Object[]) query.uniqueResult();
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
