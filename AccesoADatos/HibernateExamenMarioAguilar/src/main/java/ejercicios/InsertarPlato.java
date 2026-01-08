package ejercicios;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Ingrediente;
import pojos.Plato;

public class InsertarPlato {

	public static void main(String[] args) {
		
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session sesion = factory.getCurrentSession();

		sesion.beginTransaction();

		Ingrediente ingrediente = sesion.get(Ingrediente.class, 3);
		
		Plato plato = new Plato(null, "Huevos Rellenos", "Huevos", ingrediente, null, null);
		
		// Comprueba si existe el plato
		if (sesion.get(Plato.class, 17) == null) {
			// Comprobar que el ingrediente exista
			if (ingrediente != null) {
				 sesion.save(plato);
			} else {
				System.out.println("El ingrediente no existe");
			}
		}else {
			System.out.println("Ya existe");
		}
		
		
		sesion.getTransaction().commit();

		factory.close();
	}

}
