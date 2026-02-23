package repasoHQL;

import java.util.Scanner;

import dao.DaoCancion;
import hibernate.UtilesHibernate;

// 7. Mostrar dada una cación (título), el nombre de los discos en que está y el nombre del grupo del
// disco,

public class Ejercicio_7 {

	public static void main(String[] args) {
		
		try {
			
			UtilesHibernate.openSession();
			
			Scanner sc = new Scanner(System.in);
			
			DaoCancion daoCancion = new DaoCancion();
			
			System.out.print("Introduce el nombre de la cancion: ");
			String nombreCancion = sc.nextLine();
			
			daoCancion.buscarOrigenPorNombre(nombreCancion);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
	}

}
