package ejerciciosHibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Premios;

public class Ejercicio_07 {

	public static void main(String[] args) {
		// Creo la sesion SIEMPRE
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session sesion = factory.getCurrentSession();

		sesion.beginTransaction();

		Integer total = 0;
		
		// Recogo el ciclista con dorsal 2
		Ciclista ciclista = sesion.get(Ciclista.class, 2);
		// Recogo la lista de premios ganados por el ciclista seleccionado
		List <Premios> premios_ganados = ciclista.getPremios();
		
		// Calculo la cantidad total y la muestro
		for (Premios premio : premios_ganados) {
			total += premio.getCantidad();
		}
		System.out.println("El total de cantidad ganado de el ciclista 2: " + total + "€");

		sesion.getTransaction().commit();

		factory.close();
	}

}
