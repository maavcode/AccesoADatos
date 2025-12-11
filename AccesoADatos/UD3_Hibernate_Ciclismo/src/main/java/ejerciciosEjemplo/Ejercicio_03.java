package ejerciciosEjemplo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Etapa;
import pojos.Puerto;

public class Ejercicio_03 {
	public static void main(String[] args) {
		// Creo la sesion SIEMPRE
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session sesion = factory.getCurrentSession();

		sesion.beginTransaction();
		
		// Creo la etapa y el ciclista necesarios para añadir
		Etapa etapa12 = sesion.get(Etapa.class, 12);
		Ciclista ciclista10 = sesion.get(Ciclista.class, 10);
		
		Puerto puerto = new Puerto("AMPRIU", 1911, "E", 8.0, etapa12, ciclista10);
		sesion.save(puerto);
		
		sesion.getTransaction().commit();
		
		factory.close();
	}
}
