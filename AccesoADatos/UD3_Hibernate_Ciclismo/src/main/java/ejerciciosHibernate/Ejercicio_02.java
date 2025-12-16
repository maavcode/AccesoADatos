package ejerciciosHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;

public class Ejercicio_02 {

	public static void main(String[] args) {
		// Creo la sesion SIEMPRE
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session sesion = factory.getCurrentSession();

	}

}
