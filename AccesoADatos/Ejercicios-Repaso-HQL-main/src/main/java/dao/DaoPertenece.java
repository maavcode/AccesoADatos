package dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;
import pojos.Grupo;
import pojos.Pertenece;
import pojos.PerteneceId;

public class DaoPertenece 
	extends DaoGenericoHibernate<Pertenece, PerteneceId> {
	private final static Logger
	LOGGER = Logger.getLogger(DaoGrupo.class.getName());
	
	
	public List<Pertenece> buscarPorFuncion(String nombre){
		
		// Obtenemos la sesion que hemos conectado en la interfaz
		Session sesion = UtilesHibernate.getSessionFactory().getCurrentSession();
		List<Pertenece> result = null;
		
		try {
			
			sesion.beginTransaction();
			String hql = "select p from Pertenece p where p.funcion=:funcion";
			Query query = sesion.createQuery(hql);
			
			query.setParameter("funcion", nombre);
			
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
