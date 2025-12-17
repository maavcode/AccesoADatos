package ejerciciosHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Ciclista;

public class Ejercicio_08 {

	public static void main(String[] args) {
		// Creo la sesion SIEMPRE
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session sesion = factory.getCurrentSession();

		sesion.beginTransaction();

		Integer numEtapas = 0;
		
		// Recogo el ciclista con dorsal 2
		Ciclista ciclista = sesion.get(Ciclista.class, 2);
		// Relleno el numero de etapas con la longitud de la lista
		numEtapas = ciclista.getEtapas().size();
		
		// Muestro el resultado
		System.out.println("El total de etapas ganadas por el ciclista con dorsal 2 es de: " + numEtapas);
		
		sesion.getTransaction().commit();

		factory.close();
	}

}
