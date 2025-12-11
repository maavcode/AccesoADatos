package ejerciciosEjemplo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Etapa;
import pojos.Puerto;

public class Ejercicio_02 {
	public static void main(String[] args) {
		// Creo la sesion SIEMPRE
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session sesion = factory.getCurrentSession();

		sesion.beginTransaction();

		// Ciclista con dorsal 4
		Ciclista ciclista = sesion.get(Ciclista.class, 4);

		// Lista para guardar las etapas
		List<Etapa> etapas = ciclista.getEtapas();

		System.out.println("Etapas ganadas por el ciclista con dorsal 4: ");
		Integer i = 0;
		for (Etapa etapa : etapas) {
			System.out.println("Etapa " + i);
			System.out.println("Salida: " + etapa.getSalida());
			System.out.println("Llegada " + etapa.getLlegada());
			i++;
		}

		// Lista para guardar las etapas
		List<Puerto> puertos = ciclista.getPuertos();

		System.out.println("Puertos ganadas por el ciclista con dorsal 4: ");
		i = 0;
		for (Puerto puerto : puertos) {
			System.out.println("Puerto " + i);
			System.out.println("Nombre del puerto: " + puerto.getNompuerto());
			i++;
		}

		sesion.getTransaction().commit();
	}
}
