package repasoHQL;

import java.util.Scanner;

import dao.DaoDisco;
import hibernate.UtilesHibernate;

public class Ejercicio03 {

	public static void main(String[] args) {
		System.out.println("----- Ejercicio 3: Modificar duracion de Canciones de un Disco sumando 1 minuto a las que duran menos de 2 minutos -----");
		
		try {
			// Abro la sesion // SIEMPRE
			UtilesHibernate.openSession();
			
			DaoDisco daoDisco = new DaoDisco();
			
			Scanner sc = new Scanner(System.in); 
			
			System.out.println("Introduce el nombre del disco");
			String nomDisco = sc.nextLine();
			
			daoDisco.ModificarDuracionCanciones(nomDisco);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally { // SIEMPRE
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}

	}

}
