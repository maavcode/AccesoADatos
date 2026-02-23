package dao;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;
import pojosEsther.Artista;
import pojosEsther.Club;
import pojosEsther.Grupo;
import pojosEsther.Pertenece;

public class DaoGrupo extends DaoGenericoHibernate<Grupo, String> {
	private final static Logger LOGGER = Logger.getLogger(DaoGrupo.class.getName());

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
				s.getTransaction().rollback();
				;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	// BUSCAR GRUPOS SIN CLUB | EjercicioK
	public List<String> buscarGruposSinClub() {
		List<String> result = null;

		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();

		try {
			// Empieza la transaccion // SIEMPRE
			s.beginTransaction();

			// Creo la Query HQL
			String hql = "select g.nombre from Grupo g left join g.clubs c where c is null"; // Left join porque quiero
																								// poder comprobar TODOS
																								// LOS GRUPOS
			Query q = s.createQuery(hql);

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

	// BUSCAR NOMBRE DE ARTISTA Y SU FUNCION EN UN GRUPO | EjercicioM
	public List<Object[]> buscarNombreYFuncionArtistaPorGrupo(String nombre) {
		List<Object[]> result = null;
		// Obtenemos la sesion // SIEMPRE
		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();

		try {
			// Empieza la transaccion // SIEMPRE
			s.beginTransaction();

			// Creo la Query HQL
			String hql = "select p.artista.nombre, p.funcion from Pertenece p where p.grupo.nombre=:nom";
			Query q = s.createQuery(hql);
			q.setParameter("nom", nombre); // nom es la etiqueta, se puede poner ? y luego donde esta o una etiqueta

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

	// BUSCAR DISCOS DE UN GRUPO EN UN AÑO | EjercicioO
	public List<String> buscarDiscosAñoPorGrupo(String grupo, Integer fecha) {

		List<String> result = null;
		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();

		try {
			// Empieza la transaccion // SIEMPRE
			s.beginTransaction();

			// Creo la Query HQL
			String hql = "select d.nombre from Grupo g join g.discos d where g.nombre=:grupo and year(d.fecha)=:fecha";
			Query q = s.createQuery(hql);
			q.setParameter("grupo", grupo); // nom es la etiqueta, se puede poner ? y luego donde esta o una etiqueta
			q.setParameter("fecha", fecha);

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

	// RESTRICCIÓN PARA QUE UN GRUPO NO TENGA MÁS DE 8 INTEGRANTES | EJERCICIO
	// RESTRICCIONES - C
	public void addArtistaAGrupo(String nomGrupo, String nomArtista, String funcion) throws Exception {

		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();

		try {
			s.beginTransaction();

			// Creo la Query HQL
			String hqlGrupo = "select g from Grupo g where g.nombre=:nom";
			Query qGrupo = s.createQuery(hqlGrupo);
			qGrupo.setParameter("nom", nomGrupo);
			
			Grupo grupo = (Grupo) qGrupo.uniqueResult();
			
			String hqlArtista = "select a from Artista a where a.nombre=:nom";
			Query qArtista = s.createQuery(hqlArtista);
			qArtista.setParameter("nom", nomArtista);
			
			Artista artista = (Artista) qArtista.uniqueResult();

			// Número de grupos a los que pertenece el artista
			int gruposArtista = artista.getPerteneces().size();

			// Restricción C: máximo 8 grupos
			if (gruposArtista >= 8) {
				throw new Exception("El artista no puede pertenecer a más de 8 grupos");
			}

			// Crear la relación
			Pertenece p = new Pertenece();

			// Añadir a las colecciones
			grupo.getPerteneces().add(p);
			artista.getPerteneces().add(p);

			// Guardar la relación
			s.save(p);

			s.getTransaction().commit();

		} catch (Exception e) {
			try {
				s.getTransaction().rollback();
			} catch (Exception ex) {
			}
			throw e;
		}
	}

	public void addClubAGrupo(Grupo grupo, Club club) throws Exception {

		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();

		try {
			s.beginTransaction();

			int clubsGrupo = grupo.getClubs().size();

			// Restricción B: máximo 3 clubes
			if (clubsGrupo >= 3) {
				throw new Exception("El grupo no puede tener más de 3 clubes");
			}

			// Añadir el club
			grupo.getClubs().add(club);

			// Actualizar el grupo
			s.update(grupo);

			s.getTransaction().commit();

		} catch (Exception e) {
			s.getTransaction().rollback();
			e.printStackTrace();
		}
	}

}