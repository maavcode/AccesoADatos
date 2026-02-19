package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;
import pojosEsther.Companyia;
import pojosEsther.Disco;
import pojosEsther.Grupo;

public class DaoCompanyia extends DaoGenericoHibernate<Companyia, String>{
	private final static Logger
	LOGGER = Logger.getLogger(DaoCompanyia.class.getName());
	
	// BUSCAR COMPANYIA POR NOMBRE [ PARAMETRIZADO ]
		public Object[] buscarPorNombreParametrizado(String nombre) {
			
			Object [] result = null;
			Session s = UtilesHibernate.getSessionFactory().getCurrentSession();
			
			try {
				// Empieza la transaccion // SIEMPRE
				s.beginTransaction();
				
				// Creo la Query HQL
				String hql = "select c.tfno, c.fax from Companyia c where c.nombre=:nom";
				Query q = s.createQuery(hql);
				q.setParameter("nom", nombre); // nom es la etiqueta, se puede poner ? y luego donde esta o una etiqueta
				
				// El resultado de la Query se inserta en result
				result = (Object[]) q.uniqueResult();
				
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
		
		// REESTRICCION PARA OBTENER COMPAÑIAS PERMITIDAS PARA UN GRUPO | EJERCICIO REESTRICCION - B
		public List<Companyia> obtenerCompaniasPermitidas(Grupo grupo) {
		    
		    List<Companyia> result = null;
		    Session s = UtilesHibernate.getSessionFactory().getCurrentSession();

		    try {
		        s.beginTransaction();

		        // 1. Compañías con las que el grupo ya ha trabajado
		        String hql = "select d.companyia " +
		                     "from Disco d " +
		                     "where d.grupo.cod = :codGrupo " +
		                     "group by d.companyia";

		        Query q = s.createQuery(hql);
		        q.setParameter("codGrupo", grupo.getCod());

		        List<Companyia> companiasUsadas = q.getResultList();

		        // 2. Si no ha trabajado con ninguna → devolver todas
		        if (companiasUsadas.isEmpty()) {

		            String hqlTodas = "from Companyia";
		            Query q2 = s.createQuery(hqlTodas);

		            result = q2.getResultList();
		        } 
		        // 3. Si ya ha trabajado → devolver solo esas
		        else {
		            result = companiasUsadas;
		        }

		        s.getTransaction().commit();

		    } catch (ConstraintViolationException cve) {
		        try {
		            s.getTransaction().rollback();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }

		    return result;
		}
		
		public Companyia buscarPorNombre(String nombre) {
			Companyia companyia = null;
		    Session s = UtilesHibernate.getSessionFactory().getCurrentSession();

		    try {
		        s.beginTransaction();

		        String hql = "from Companyia c where c.nombre = :nom";
		        Query q = s.createQuery(hql);
		        q.setParameter("nom", nombre);

		        companyia = (Companyia) q.uniqueResult();

		        s.getTransaction().commit();

		    } catch (Exception e) {
		        

		    } 

		    return companyia;
		}


}
