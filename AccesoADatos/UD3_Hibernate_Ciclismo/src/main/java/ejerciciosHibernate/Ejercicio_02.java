package ejerciciosHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Coche;
import pojos.Equipo;

public class Ejercicio_02 {

	public static void main(String[] args) {
		// Creo la sesion SIEMPRE
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session sesion = factory.getCurrentSession();

		sesion.beginTransaction();
		
		// Recogo el equipo Euskadi
		Equipo equipo = sesion.get(Equipo.class, "Euskadi");
		// Creo un nuevo coche con el equipo seleccionado
		Coche coche = new Coche(null, null, "23434342F", "Druni", "Juan Mari", "Carreras", null, equipo);
		
		// Guardo primero el coche
		sesion.save(coche);
		// Se lo asigno al equipo
		//equipo.setCoche(coche); // Modificar, no UPDATE
		
		sesion.getTransaction().commit();
		
		factory.close();
		
	}

}
