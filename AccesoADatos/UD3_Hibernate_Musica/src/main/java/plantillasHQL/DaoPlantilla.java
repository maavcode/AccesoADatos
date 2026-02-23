package plantillasHQL;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import dao.DaoCancion;
import dao.DaoGenericoHibernate;
import hibernate.UtilesHibernate;
import pojosEsther.Cancion;
import pojosEsther.Disco;
import pojosEsther.Grupo;

public class DaoPlantilla extends DaoGenericoHibernate<Disco, String> { // Poner modelo correspondiente

	Session s = UtilesHibernate.getSessionFactory().getCurrentSession();

	// Obtener lista String [ PARAMETRIZADO ]
	public List<String> buscarPorNombreParametrizado(String nombre) {

		List<String> result = null;
		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();

		try {
			// Empieza la transaccion // SIEMPRE
			s.beginTransaction();

			// Creo la Query HQL
			String hql = "select c.titulo from Disco d join d.cancions c where d.nombre=:nom";
			Query q = s.createQuery(hql);
			q.setParameter("nom", nombre);
			
			// El resultado de la Query se inserta en result
			result = (List<String>) q.getResultList();

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

	// Obtener lista con varios parametros (nombre, edad, etc)
	public List<Object[]> obtenerDuracionTotalDeTodos() {

		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();
		List<Object[]> resultados = null;

		try {
			s.beginTransaction();

			String hql = "select d.nombre, sum(c.duracion) " + "from Disco d join d.cancions c " + "group by d.nombre";

			Query q = s.createQuery(hql);
			resultados = q.getResultList();

			s.getTransaction().commit();

		} catch (Exception e) {
			s.getTransaction().rollback();
			e.printStackTrace();
		}

		return resultados;
	}
	
	// Modificar
	public void ModificarDuracionCanciones(String nombre) {
		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();

	    try {
	        s.beginTransaction();
	        
	        DaoCancion daoCancion = new DaoCancion();

	        String hql = "select c from Disco d join d.cancions c where d.nombre = :nom";
	        Query q = s.createQuery(hql);
	        q.setParameter("nom", nombre);

	        List<Cancion> listaCanciones = q.getResultList();
	        
	        for (Cancion cancion : listaCanciones) {
				if (cancion.getDuracion()<2) {
					cancion.setDuracion(cancion.getDuracion() + 1);
				}
			}

	        s.getTransaction().commit();

	    } catch (Exception e) {
			s.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	
	// Insertar con REESTRICCION
	public void addDiscoAGrupo(Grupo grupo, Disco nuevoDisco) {
		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();

		try {
		    s.beginTransaction();
		    
		    if (grupo.getFecha().getDate() >  nuevoDisco.getFecha().getDate()) {
		    	grupo.getDiscos().add(nuevoDisco);
		    	// Guardar el disco
			    s.save(nuevoDisco);
			} else {
				throw new Exception("La fecha de salida del disco debe ser mayor a la de creacion del grupo");
			}

		    s.getTransaction().commit();
		    System.out.println("Disco creado correctamente.");

		} catch (Exception e) {
			s.getTransaction().rollback();
			e.printStackTrace();
		}

	}
	
	// Tipico Buscar por Nombre
	public Disco buscarPorNombre(String nombre) {
	    Disco disco = null;
	    Session s = UtilesHibernate.getSessionFactory().getCurrentSession();

	    try {
	        s.beginTransaction();

	        String hql = "from Disco d where d.nombre = :nom";
	        Query q = s.createQuery(hql);
	        q.setParameter("nom", nombre);

	        disco = (Disco) q.uniqueResult();

	        s.getTransaction().commit();

	    } catch (Exception e) {
			s.getTransaction().rollback();
			e.printStackTrace();
		}

	    return disco;
	}

}
