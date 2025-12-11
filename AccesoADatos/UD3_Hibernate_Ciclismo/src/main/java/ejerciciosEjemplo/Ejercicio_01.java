package ejerciciosEjemplo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Equipo;

public class Ejercicio_01 {
	// EJERCICIO 1: BORRAR DE LA BASE DE DATOS EL EQUIPO CON ID = "dam55"
	public static void main(String[] args) {
		// Creo la sesion SIEMPRE
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session sesion = factory.getCurrentSession();
		
		// INSERTAR EQUIPO --> Como no esta, primero lo insertamos
		sesion.beginTransaction();
		
		// Creo un equipo con nombre dam55 y con director Mario Aguilar, lo demas nulo
		Equipo eqDam55 = new Equipo("dam55", "Mario Aguilar", null, null, null);
		// Uso metodo save ya que es un nuevo equipo, no modifico uno
		sesion.save(eqDam55);
		
//		System.out.println("Equipo " + eqDam55.getNomeq() + " añadido");
		
		sesion.getTransaction().commit();
		
		// ELIMINAR EQUIPO
		sesion.beginTransaction(); // Inicia la sesion
		
		// Recogo el equipo con ID = "dam55"
		Equipo eq = sesion.get(Equipo.class, "dam55");
		// Elimino el equipo recogido
		sesion.delete(eq); // <-------
		
//		System.out.println("Equipo " + eq.getNomeq() + " eliminado");
		
		sesion.getTransaction().commit(); // Termina la sesion
		
		factory.close();
		
	}
}
