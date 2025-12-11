package ejerciciosEjemplo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Etapa;
import pojos.Puerto;

public class Ejercicio_04 {
	public static void main(String[] args) {
		// Creo la sesion SIEMPRE
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session sesion = factory.getCurrentSession();

		sesion.beginTransaction();

		Ciclista ciclista8 = sesion.get(Ciclista.class, 8);

		Puerto puerto = sesion.get(Puerto.class, "AMPRIU");
		puerto.setCiclista(ciclista8); // MODIFICAR, NO UPDATE

		sesion.getTransaction().commit();

		factory.close();
	}
}
