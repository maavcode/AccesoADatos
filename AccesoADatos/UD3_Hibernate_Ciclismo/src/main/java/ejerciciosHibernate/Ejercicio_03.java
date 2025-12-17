package ejerciciosHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Etapa;

public class Ejercicio_03 {

	public static void main(String[] args) {
		// Creo la sesion SIEMPRE
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session sesion = factory.getCurrentSession();

		sesion.beginTransaction();
		
		// Creo la etapa
		Etapa etapa = new Etapa(22, 150, "Madrid", "Madrid", null, null);
		
		// Guardo la etapa
		sesion.save(etapa);
		
		sesion.getTransaction().commit();
		
		factory.close();

	}

}
