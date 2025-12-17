package ejerciciosHibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Etapa;
import pojos.Puerto;

public class Ejercicio_01 {

	public static void main(String[] args) {
		// Creo la sesion SIEMPRE
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session sesion = factory.getCurrentSession();
		
		sesion.beginTransaction();
		
		// Obtengo la etapa 10
		Etapa etapa = sesion.get(Etapa.class, 10);
		
		System.out.println("------------- La etapa " + etapa.getNetapa() + " -------------");
		
		// Obtengo la lista de puertos
		List<Puerto> listaPuertos = etapa.getPuertos();
		
		// Recorro la lista de puertos
		for (Puerto puerto : listaPuertos) {
			// Recogo al ciclista ganador del puerto
			Ciclista ciclista = puerto.getCiclista();
			// Imprimo la informacion pedida
			System.out.println("Puerto: " +puerto.getNompuerto() + " | Ciclista ganador: " + ciclista.getNombre());
			
		}
		
		sesion.getTransaction().commit();
		
		factory.close();
	}

}
