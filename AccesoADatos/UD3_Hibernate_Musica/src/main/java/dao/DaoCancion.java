package dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.query.Query;
import org.hibernate.Session;

import hibernate.UtilesHibernate;
import pojosEsther.Cancion;

public class DaoCancion extends DaoGenericoHibernate<Cancion, String>{
	private final static Logger
	LOGGER = Logger.getLogger(DaoCancion.class.getName());
	
	public Cancion buscarPorNombre(String nombre) {
	    Cancion cancion = null;
	    Session s = UtilesHibernate.getSessionFactory().getCurrentSession();

	    try {
	        s.beginTransaction();

	        String hql = "from Cancion c where c.titulo = :titulo";
	        Query q = s.createQuery(hql);
	        q.setParameter("titulo", nombre);

	        cancion = (Cancion) q.uniqueResult();

	        s.getTransaction().commit();

	    } catch (Exception e) {
	        
	    }

	    return cancion;
	}
	
	public List<Object[]> discosYGruposDeCancion(String titulo) {

	    Session s = UtilesHibernate.getSessionFactory().getCurrentSession();
	    List<Object[]> lista = null;

	    try {
	        s.beginTransaction();

	        String hql = "select d.nombre, g.nombre " +
	                     "from Cancion c " +
	                     "join c.discos d " +
	                     "join d.grupo g " +
	                     "where c.titulo = :tit";

	        Query q = s.createQuery(hql);
	        q.setParameter("tit", titulo);

	        lista = q.getResultList();

	        s.getTransaction().commit();

	    } catch (Exception e) {
	        try { s.getTransaction().rollback(); } catch (Exception ex) {}
	        throw e;
	    }

	    return lista;
	}



}


