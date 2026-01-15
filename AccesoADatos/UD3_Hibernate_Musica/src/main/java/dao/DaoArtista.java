package dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;
import pojosEsther.Artista;

public class DaoArtista extends DaoGenericoHibernate<Artista, String>{
	private final static Logger
	LOGGER = Logger.getLogger(DaoArtista.class.getName());
	
	// BUSCAR ARTISTA POR NOMBRE
	public Artista buscarPorNombre(String nombre) {
		Artista result = new Artista();
		// Obtenemos la sesion // SIEMPRE
		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();
		
		try {
			// Empieza la transaccion // SIEMPRE
			s.beginTransaction();
			
			// Creo la Query HQL
			String hql = "select a from Artista a where a.nombre=:nom";
			Query q = s.createQuery(hql);
			q.setParameter("nom", nombre); // nom es la etiqueta, se puede poner ? y luego donde esta o una etiqueta
			
			// El resultado de la Query se inserta en result
			result = (Artista) q.uniqueResult();
			
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
