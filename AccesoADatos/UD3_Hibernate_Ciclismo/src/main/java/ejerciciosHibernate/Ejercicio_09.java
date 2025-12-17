package ejerciciosHibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Etapa;
import pojos.Premios;
import pojos.Puerto;

public class Ejercicio_09 {

	public static void main(String[] args) {
		// Creo la sesion SIEMPRE
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session sesion = factory.getCurrentSession();

		sesion.beginTransaction();

		// Recogo el ciclista con dorsal 10
		Ciclista ciclista = sesion.get(Ciclista.class, 10);
		// Obyengo la lista de puertos ganados del ciclista
		List<Etapa> etapas = ciclista.getEtapas();
		
		// Recorro la lista de etapas
		for (Etapa etapa : etapas) {
			// Por cada etapa recorro su lista de puertos
			for (Puerto puerto : etapa.getPuertos()) {
				// Compruebo que tenga nombre, como dice el ejercicio
		        if (puerto.getNompuerto() != null) {
		            System.out.println("Etapa: " + etapa.getNetapa() + " | Puerto: " + puerto.getNompuerto());
		        }
		    }
		}
		
		sesion.getTransaction().commit();

		factory.close();
	}

}
