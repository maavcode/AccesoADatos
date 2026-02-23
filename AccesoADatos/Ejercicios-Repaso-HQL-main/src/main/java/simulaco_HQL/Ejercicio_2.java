package simulaco_HQL;

import dao.DaoCancion;
import hibernate.UtilesHibernate;

// Mostrar el número total de canciones que hay en la base de datos.

public class Ejercicio_2 {
	
	public static void main(String[] args) {
		
		try {
			
			UtilesHibernate.openSession();
			
			DaoCancion daoCancion = new DaoCancion();
			
			System.out.println("Hay un total de " + daoCancion.totalCanciones() + " canciones en la base de datos.");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
	}
}
