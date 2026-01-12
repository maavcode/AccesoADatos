package dao;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;
import pojosEsther.Companyia;
import pojosEsther.Grupo;

public class DaoCompanyia extends DaoGenericoHibernate<Companyia, String>{
	private final static Logger
	LOGGER = Logger.getLogger(DaoCompanyia.class.getName());
	
	// BUSCAR COMPANYIA POR NOMBRE [ PARAMETRIZADO ]
		public Object[] buscarPorNombreParametrizado(String nombre) {
			
			Object [] result = null;
			Session s = UtilesHibernate.getSessionFactory().getCurrentSession();
			
			try {
				// Empieza la transaccion // SIEMPRE
				s.beginTransaction();
				
				// Creo la Query HQL
				String hql = "select c.tfno, c.fax from Companyia c where c.nombre=:nom";
				Query q = s.createQuery(hql);
				q.setParameter("nom", nombre); // nom es la etiqueta, se puede poner ? y luego donde esta o una etiqueta
				
				// El resultado de la Query se inserta en result
				result = (Object[]) q.uniqueResult();
				
				s.getTransaction().commit(); // SIEMPRE
				
			} catch (ConstraintViolationException cve) { // SIEMPRE
				// Si dio error la transaccion, deshace los cambios
				try {
					s.getTransaction().rollback();;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return result;
		}
}
