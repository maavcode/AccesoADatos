package dao;

import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;
import pojos.Artista;

public class DaoArtista 
	extends DaoGenericoHibernate<Artista, String> {
	private final static Logger
	LOGGER = Logger.getLogger(DaoArtista.class.getName());
	
	// Buscar un artista por nombre
	public Artista buscarPorNombre(String nombre) {

		Artista result = new Artista();

		// Obtenemos la sesion que hemos conectado en la interfaz
		Session sesion = UtilesHibernate.getSessionFactory().getCurrentSession();

		try {

			sesion.beginTransaction();
			String hql = "select a from Artista a where a.nombre=:nom";
			Query query = sesion.createQuery(hql);

			// Asignamos la variable recibida al parametro de la query
			query.setParameter("nom", nombre);

			result = (Artista) query.uniqueResult();
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
