package ejerciciosHibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Ciclista;
import pojos.Premios;

public class Ejercicio_05 {

	public static void main(String[] args) {
		// Creo la sesion SIEMPRE
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session sesion = factory.getCurrentSession();

		sesion.beginTransaction();
		
		// Selecciono al ciclista 5
		Ciclista ciclista = sesion.get(Ciclista.class, 5);
		
		// Selecciono el premio 1
		Premios premio = sesion.get(Premios.class, 1);
		
		// Añado al premio el ciclista, por lo que genera una relacion en la tabla intermedia
		premio.getCiclistas().add(ciclista); // IMPORTANTE, PROPIETARIO EL QUE TIENE EL JOINCOLUMN
		
		sesion.getTransaction().commit();

		factory.close();
	}

}
