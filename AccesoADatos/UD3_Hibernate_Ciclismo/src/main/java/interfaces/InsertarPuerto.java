package interfaces;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Etapa;
import pojos.Puerto;

public class InsertarPuerto {

	public static void main(String[] args) {
		
		Etapa e= new Etapa(); 
		SessionFactory factory=UtilesHibernate.getSessionFactory();
		Session sesion=factory.getCurrentSession();
		
		//empieza transaccion fichero objetos persistentes
		
		sesion.beginTransaction();
		
		//Buscar la etapa con numetapa 9
		e=sesion.get(Etapa.class,9);
		
		Puerto pu = new Puerto ("Penyagolosa",1823, "E", 10.0, e ,null);
		// sesion.save(pu); // Para guardar el puerto en la base de datos
		System.out.println("Nombre del director del ciclista que ganó la etapa 9"+e.getCiclista().getEquipo().getDirector());
		sesion.getTransaction().commit();
		factory.close();
		
	}

}


