package dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;
import pojos.Artista;
import pojos.Club;
import pojos.Disco;
import pojos.Grupo;


public class DaoGrupo 
	extends DaoGenericoHibernate<Grupo, Integer> {
	private final static Logger
	LOGGER = Logger.getLogger(DaoGrupo.class.getName());
	
	public List<String> buscarGrupos_Sin_Clubs(List<Grupo> listaGrupos){
		
		// Obtenemos la sesion que hemos conectado en la interfaz
		Session sesion = UtilesHibernate.getSessionFactory().getCurrentSession();
		List<String> result = null;
		
		try {
			sesion.beginTransaction();
			String hql = "select g.nombre from Grupo g left join g.clubs c where c is null";
			Query query = sesion.createQuery(hql);
			
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
	
	public Grupo buscarPorNombre(String nombre) {
		
		Grupo result = new Grupo();
		
		// Obtenemos la sesion que hemos conectado en la interfaz
		Session sesion = UtilesHibernate.getSessionFactory().getCurrentSession();
		
		try {
			
			sesion.beginTransaction();
			String hql = "select g from Grupo g where g.nombre=:nom";
			Query query = sesion.createQuery(hql);
			
			// Asignamos la variable recibida al parametro de la query
			query.setParameter("nom", nombre);
			
			result = (Grupo) query.uniqueResult();
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
	
	public void insertarGrupoMax3Clubs(String nombre, Club club) {
		
		Session sesion = UtilesHibernate.getSessionFactory().getCurrentSession();
		
		try {
			
			sesion.beginTransaction();
			
			// Busco el grupo en la misma sesion con un hql
			String hql = "from Grupo g where g.nombre = :nom";
			Grupo grupo = sesion.createQuery(hql, Grupo.class)
					.setParameter("nom", nombre)
					.uniqueResult();
			
			// Valido que el grupo exista
			if(grupo == null) {
				throw new RuntimeException("El grupo no exixte");
			}
			
			// Valido la restriccion
			if(grupo.getClubs().size() >= 3) {
				throw new RuntimeException(
						"No se puede añadir el club. El grupo ya tiene 3 clubs."
						);
			}
			
			
			
			// Asocio
			grupo.getClubs().add(club);
			
			sesion.getTransaction().commit();
			
			
		} catch (Exception e) {
			sesion.getTransaction().rollback();
	        e.printStackTrace();
		}
	}
	
	public void insertarDiscoFechaAnteriorAGrupo(String nombre, Disco disco) {
		
		Session sesion = UtilesHibernate.getSessionFactory().getCurrentSession();
		
		try {
			
			sesion.beginTransaction();
			
			// Busco el grupo en la misma sesion con un hql
			String hql = "from Grupo g where g.nombre = :nom";
			Grupo grupo = sesion.createQuery(hql, Grupo.class)
					.setParameter("nom", nombre)
					.uniqueResult();			
			
			// Valido que el grupo exista
			if(grupo == null) {
				throw new RuntimeException("El grupo no exixte");
			}
			
			// Valido la restriccion
			if(!grupo.getFecha().after(disco.getFecha())) {
				throw new RuntimeException(
						"La fecha de creacion del disco no puede ser"
						+ " posterior a la fecha de creacion del grupo");
			}
			
			// Asocio
			grupo.getDiscos().add(disco);
			
			// Guardo
			sesion.getTransaction().commit();
			
			
		} catch (Exception e) {
			sesion.getTransaction().rollback();
	        e.printStackTrace();
		}
	}
	
	public List<Object[]> listarNombrePaisDescFecha(){
		
		Session sesion = UtilesHibernate.getSessionFactory().getCurrentSession();
		List<Object[]> result = null;
		
		try {
			
			sesion.beginTransaction();
			String hql = "select g.nombre, g.pais from Grupo g order by g.fecha desc";
			
			Query query = sesion.createQuery(hql);
			
			result = query.list();
			sesion.getTransaction().commit();
			
		} catch (Exception e) {
			sesion.getTransaction().rollback();
	        e.printStackTrace();
		}
		
		return result;
	}
	
	public List<Object[]> listarDiscosAñoPorNombre(String nombre){
		
		Session sesion = UtilesHibernate.getSessionFactory().getCurrentSession();
		List<Object[]> result = null;
		
		try {
			
			sesion.beginTransaction();
			String hql = "select d.nombre, d.fecha from Grupo g join g.discos d where g.nombre=:nom";
			
			Query query = sesion.createQuery(hql);
			query.setParameter("nom", nombre);
			
			result = query.list();
			sesion.getTransaction().commit();
			
		} catch (Exception e) {
			
			sesion.getTransaction().rollback();
	        e.printStackTrace();
		}
		
		return result;
		
	}
}

