package ejerciciosHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Etapa;

public class Ejercicio_04 {

	public static void main(String[] args) {
		// Creo la sesion SIEMPRE
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session sesion = factory.getCurrentSession();

		sesion.beginTransaction();

		// Recogo el ciclista 8
		Ciclista ciclista = sesion.get(Ciclista.class, 5);
		// Recogo la etapa creada en el ejercicio 4
		Etapa etapa = sesion.get(Etapa.class, 22);
		
		// Añado el ciclista 5 a la etapa 22
		etapa.setCiclista(ciclista);

		sesion.getTransaction().commit();

		factory.close();
	}

}
