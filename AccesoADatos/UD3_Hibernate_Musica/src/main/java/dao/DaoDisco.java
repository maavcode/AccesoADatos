package dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;
import pojosEsther.Cancion;
import pojosEsther.Disco;
import pojosEsther.Grupo;

public class DaoDisco extends DaoGenericoHibernate<Disco, String> {
	private final static Logger LOGGER = Logger.getLogger(DaoDisco.class.getName());

	// BUSCAR DISCO POR NOMBRE [ PARAMETRIZADO ] | EjercicioI
	public List<String> buscarPorNombreParametrizado(String nombre) {

		List<String> result = null;
		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();

		try {
			// Empieza la transaccion // SIEMPRE
			s.beginTransaction();

			// Creo la Query HQL
			String hql = "select c.titulo from Disco d join d.cancions c where d.nombre=:nom";
			Query q = s.createQuery(hql);
			q.setParameter("nom", nombre); // nom es la etiqueta, se puede poner ? y luego donde esta o una etiqueta

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
	
	// REESTRICCION PARA QUE UN DISCO NO SUPERE LOS 60 MINUTOS | EJERCICIO REESTRICCIONES - A
	public void addCancionADisco(Disco disco, Cancion cancionNueva) throws Exception {

	    // Calcular duración actual del disco
	    int duracionActual = 0;
	    for (Cancion cancion : disco.getCancions()) {
	        duracionActual += cancion.getDuracion();
	    }

	    // Duración de la nueva canción
	    Double duracionCancion = cancionNueva.getDuracion();

	    // Comprobar límite de 60 minutos
	    if (duracionActual + duracionCancion > 60) {
	    	System.out.println("Duracion total de " + disco.getNombre() +" = " + duracionActual);
	        throw new Exception("El disco no puede superar los 60 minutos");
	    }

	    // Si no supera el límite, se añade la canción
	    disco.getCancions().add(cancionNueva);
	}
	
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
	        

	    } 

	    return disco;
	}
	
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
	        

	    } 
	}
	
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
		    
		    // Añadir el disco al grupo
		    

		    

		    s.getTransaction().commit();
		    System.out.println("Disco creado correctamente.");

		} catch (Exception e) {
		    try { s.getTransaction().rollback(); } catch (Exception ex) {}
		    System.out.println("ERROR: " + e.getMessage());
		} finally {
		    UtilesHibernate.closeSession();
		    UtilesHibernate.closeSessionFactory();
		}

	}
	
	public List<Object[]> obtenerDuracionTotalDeTodos() {

	    Session s = UtilesHibernate.getSessionFactory().getCurrentSession();
	    List<Object[]> resultados = null;

	    try {
	        s.beginTransaction();

	        String hql = 
	            "select d.nombre, sum(c.duracion) " +
	            "from Disco d join d.cancions c " +
	            "group by d.nombre";

	        Query q = s.createQuery(hql);
	        resultados = q.getResultList();

	        s.getTransaction().commit();

	    } catch (Exception e) {
	        try { s.getTransaction().rollback(); } catch (Exception ex) {}
	        throw e;
	    }

	    return resultados;
	}


}
