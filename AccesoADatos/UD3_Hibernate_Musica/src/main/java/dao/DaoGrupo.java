package dao;

import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;
import pojosEsther.Grupo;

public class DaoGrupo extends DaoGenericoHibernate<Grupo, String>{
	private final static Logger
	LOGGER = Logger.getLogger(DaoGrupo.class.getName());
	
	// BUSCAR GRUPO POR NOMBRE
	public Grupo buscarPorNombre(String nombre) {
		Grupo result = new Grupo();
		
		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();
		
		try {
			// Empieza la transaccion // SIEMPRE
			s.beginTransaction();
			
			// Creo la Query HQL
			String hql = "select g from Grupo g where g.nombre=:nom";
			Query q = s.createQuery(hql);
			q.setParameter("nom", nombre); // nom es la etiqueta, se puede poner ? y luego donde esta o una etiqueta
			
			// El resultado de la Query se inserta en result
			result = (Grupo) q.uniqueResult();
			
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