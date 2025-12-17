package ejerciciosHibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Premios;

public class Ejercicio_06 {
	
	public static void main (String [] args) {
		// Creo la sesion SIEMPRE
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session sesion = factory.getCurrentSession();

		sesion.beginTransaction();

		// Recogo el premio con id 3
		Premios premio = sesion.get(Premios.class, 3);

		// Creo una lista que guarda los ciclistas que han ganado el premio seleccionado
		List<Ciclista> ciclistas = premio.getCiclistas();
		// Muestro los ciclistas ganadores del premio
		System.out.println("Ciclistas ganadores del premio con id 3:");
		for (Ciclista ciclista : ciclistas) {
			System.out.println(ciclista.getNombre());
		}

		sesion.getTransaction().commit();

		factory.close();
	}
	
}
