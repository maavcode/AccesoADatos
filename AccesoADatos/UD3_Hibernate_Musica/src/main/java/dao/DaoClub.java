package dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;
import pojosEsther.Club;

public class DaoClub extends DaoGenericoHibernate<Club, String>{
	private final static Logger
	LOGGER = Logger.getLogger(DaoClub.class.getName());
	
	// BUSCAR CLUBS DE GRUPOS DE UN PAIS INDICADO
		public List<Object[]> buscarClubsYGruposPorPais(String pais) {
			List<Object[]> result = null;
			// Obtenemos la sesion // SIEMPRE
			Session s = UtilesHibernate.getSessionFactory().getCurrentSession();

			try {
				// Empieza la transaccion // SIEMPRE
				s.beginTransaction();

				// Creo la Query HQL
				String hql = "select c.nombre, c.grupo.nombre FROM Club c where c.grupo.pais=:pais";
				Query q = s.createQuery(hql);
				q.setParameter("pais", pais); // nom es la etiqueta, se puede poner ? y luego donde esta o una etiqueta

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
		
		public Club buscarPorNombre(String nombre) {
			Club result = null;
			// Obtenemos la sesion // SIEMPRE
			Session s = UtilesHibernate.getSessionFactory().getCurrentSession();

			try {
				// Empieza la transaccion // SIEMPRE
				s.beginTransaction();

				// Creo la Query HQL
				String hql = "from Club c where c.nombre =: nom";
				Query q = s.createQuery(hql);
				q.setParameter("nom", nombre); 

				// El resultado de la Query se inserta en result
				result = (Club) q.uniqueResult();

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
