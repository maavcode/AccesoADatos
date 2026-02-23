package repasoHQL;

import java.util.Scanner;

import dao.DaoDisco;
import hibernate.UtilesHibernate;

// Muestra un listado con la duración total de cada disco (sera la suma de la duración de sus
// canciones)


public class Ejercicio_6 {

	public static void main(String[] args) {
		
		try {
			
			UtilesHibernate.openSession();
			
			Scanner sc = new Scanner(System.in);
			
			DaoDisco daoDisco = new DaoDisco();
			System.out.print("Introduce el nombre del disco: ");
			String nombreDisco = sc.nextLine();
			
			double duracionDisco = daoDisco.obtenerMinutosDisco(nombreDisco);
			
			System.out.println("\nLa duración del disco completo es de " + duracionDisco + " minutos");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
	}
}
