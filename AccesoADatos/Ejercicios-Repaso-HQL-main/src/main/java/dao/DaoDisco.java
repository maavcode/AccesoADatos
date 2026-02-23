package dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;
import pojos.Cancion;
import pojos.Disco;

public class DaoDisco 
	extends DaoGenericoHibernate<Disco, Integer> {
	private final static Logger
	LOGGER = Logger.getLogger(DaoDisco.class.getName());
	
	public List<String> buscarCanciones_Disco(String nombre) {

		// Obtenemos la sesion que hemos conectado en la interfaz
		Session sesion = UtilesHibernate.getSessionFactory().getCurrentSession();
		List<String> result = null;

		try {

			sesion.beginTransaction();
			String hql = "select c.titulo from Disco d join d.cancions c where d.nombre=:nom";
			Query query = sesion.createQuery(hql);

			// Asignamos la variable recibida al parametro de la query
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
	
	public List<Cancion> aumentarCancionesMenor2Minutos(String nombre){
		
		Session sesion = UtilesHibernate.getSessionFactory().getCurrentSession();
		List<Cancion> result = null;
		
		try {
			
			sesion.beginTransaction();
			String hql = "select distinct c from Disco d join d.cancions c where c.duracion <= 2 AND d.nombre = :nom";
			Query query = sesion.createQuery(hql);
			
			query.setParameter("nom", nombre);
			result = query.list();
			
			System.out.println("Aumentada la duración de: ");
			
			for (Cancion cancion : result) {
				System.out.println("\n" + cancion.getTitulo() + "(" + cancion.getDuracion() +" minutos)");
				cancion.setDuracion(cancion.getDuracion()+1.0);
				System.out.println("\n-> " + cancion.getTitulo() + "(" + cancion.getDuracion() +" minutos)\n");	
			}
			
			
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
	
	public double obtenerMinutosDisco(String nombre) {
		
		Session sesion = UtilesHibernate.getSessionFactory().getCurrentSession();
		
		double result = 0;
		
		try {
			
			sesion.beginTransaction();
			String hql = "select sum(c.duracion) from Disco d join d.cancions c where d.nombre = :nom";
			
			Query query = sesion.createQuery(hql);
			
			query.setParameter("nom", nombre);
			
			result = (Double) query.uniqueResult();
			
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
	
	public List<Object[]> nombreDuracionDisco(){
		
		Session sesion = UtilesHibernate.getSessionFactory().getCurrentSession();
		List<Object[]> result = null;
		
		try {
			
			sesion.beginTransaction();
			String hql = "select d.nombre, sum(c.duracion) from Disco d join d.cancions c group by d.nombre";
			Query query = sesion.createQuery(hql);
			
			result = query.list();
			sesion.getTransaction().commit();
			
			
		} catch (Exception e) {
			
			sesion.getTransaction().rollback();
	        e.printStackTrace();
		}
		
		return result;
	}
	
	public void aumentarCanciones3MinutosMedioMas(String nombre){
		
		Session sesion = UtilesHibernate.getSessionFactory().getCurrentSession();
		List<Cancion> result = null;
		
		try {
			
			String hql = "select c from Disco d join d.cancions c where d.nombre=:nom and c.duracion > 3";
			Query query = sesion.createQuery(hql);
			query.setParameter("nom", nombre);
			
			result = query.list();
			
			System.out.println("Aumentada la duración de: ");
			
			for (Cancion cancion : result) {
				System.out.println(cancion.getTitulo() + "(" + cancion.getDuracion() + " minutos)");
				cancion.setDuracion(cancion.getDuracion()+0.5);
				System.out.println(" -> " + cancion.getTitulo() + "(" + cancion.getDuracion() + " minutos)");
			}
			
			sesion.getTransaction().commit();
			
		} catch (Exception e) {
			
			sesion.getTransaction().rollback();
	        e.printStackTrace();
		}
		
	}
}