package dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;
import pojosEsther.Artista;
import pojosEsther.Disco;
import pojosEsther.Grupo;
import pojosEsther.Pertenece;
import pojosEsther.PerteneceId;

public class DaoPertenece extends DaoGenericoHibernate<Pertenece, PerteneceId>{
	private final static Logger
	LOGGER = Logger.getLogger(DaoPertenece.class.getName());
	
	public Pertenece buscarPorGrupoYArtista(Grupo grupo, Artista artista) {
	    Pertenece pertenece = null;
	    Session s = UtilesHibernate.getSessionFactory().getCurrentSession();

	    try {
	        s.beginTransaction();

	        String hql = "from Pertenece p where p.grupo = :gru and p.artista = :art";
	        Query q = s.createQuery(hql);
	        q.setParameter("gru", grupo);
	        q.setParameter("art", artista);

	        pertenece = (Pertenece) q.uniqueResult();

	        s.getTransaction().commit();

	    } catch (Exception e) {
	        

	    } 

	    return pertenece;
	}
	
	public List<Object[]> buscarArtistasYGrupoPorFuncion(String funcion) {
		List<Object[]> result = null;
		// Obtenemos la sesion // SIEMPRE
		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();

		try {
			// Empieza la transaccion // SIEMPRE
			s.beginTransaction();

			// Creo la Query HQL
			String hql = "select p.artista.nombre, p.grupo.nombre from Pertenece p where p.funcion = :fun";
			Query q = s.createQuery(hql);
			q.setParameter("fun", funcion); 

			// El resultado de la Query se inserta en result
			result = q.getResultList();

			s.getTransaction().commit(); // SIEMPRE

		} catch (ConstraintViolationException cve) { // SIEMPRE
			// Si dio error la transaccion, deshace los cambios
			try {
				s.getTransaction().rollback();
				;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}
}