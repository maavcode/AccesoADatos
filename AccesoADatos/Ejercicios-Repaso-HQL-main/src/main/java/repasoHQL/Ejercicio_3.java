package repasoHQL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.DaoCancion;
import dao.DaoDisco;
import hibernate.UtilesHibernate;
import pojos.Cancion;
import pojos.Disco;

// 3. Modificar la duración de las canciones de un disco (el usuario te da el nombre), determinado
// sumando a aquellas canciones que duran menos de 2 minutos de dicho disco, un minuto más.

public class Ejercicio_3 {

	public static void main(String[] args) {
		
		try {
			
			UtilesHibernate.openSession();
			
			DaoDisco daoDisco = new DaoDisco();
			DaoCancion daoCancion = new DaoCancion();
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Introduce el nombre del disco: ");
			String nombreDisco = sc.nextLine();
			
			List<Cancion> listaCanciones = new ArrayList();
			
			listaCanciones = daoDisco.aumentarCancionesMenor2Minutos(nombreDisco);
			
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}	

	}

}
