package simulaco_HQL;

import java.util.List;
import java.util.Scanner;

import dao.DaoDisco;
import hibernate.UtilesHibernate;
import pojos.Cancion;

// Dado el nombre de un disco:

// Aumentar en 0.5 minutos la duración de todas las canciones que duren menos de 3 minutos.

public class Ejercicio_7 {

	public static void main(String[] args) {
		
		try {
			
			UtilesHibernate.openSession();
			
			DaoDisco daoDisco = new DaoDisco();
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Introduce el nombre del disco: ");
			String nombreDisco = sc.nextLine();
			
			daoDisco.aumentarCanciones3MinutosMedioMas(nombreDisco);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}

	}

}
