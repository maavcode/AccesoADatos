package simulaco_HQL;

import java.util.List;
import java.util.Scanner;

import dao.DaoCancion;
import hibernate.UtilesHibernate;

// Dada una canción (título), mostrar:

// Nombre de los discos en los que está
// Nombre del grupo de cada disco
// País del grupo

public class Ejercicio_5 {

	public static void main(String[] args) {
		try {
			
			UtilesHibernate.openSession();
			
			DaoCancion daoCancion = new DaoCancion();
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Introduce el nombre de la cancion: ");
			String nombreCancion = sc.nextLine();
			
			List<Object[]> lista = daoCancion.discoGrupoPaisPorNombre(nombreCancion);
			
			for (Object[] fila : lista) {
				System.out.println("\nNombre del disco: " + fila[0]);
				System.out.println("Nombre del grupo: " + fila[1]);
				System.out.println("Pais del grupo: " + fila[2] + "\n");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}

	}

}
