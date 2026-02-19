package repasoHQL;

import java.util.List;
import java.util.Scanner;

import dao.DaoCancion;
import hibernate.UtilesHibernate;

public class Ejercicio07 {

	public static void main(String[] args) {
		System.out.println("----- Ejercicio 7: Obtener el nombre de los Discos en que esta una Cancion y el nombre del Grupo del Disco -----");
		
		try {
			// Abro la sesion // SIEMPRE
			UtilesHibernate.openSession();
			

			DaoCancion daoCancion = new DaoCancion();
			Scanner sc = new Scanner(System.in);

			System.out.println("Introduce el título de la canción:");
			String titulo = sc.nextLine();

			List<Object[]> lista = daoCancion.discosYGruposDeCancion(titulo);

			if (lista.isEmpty()) {
			    System.out.println("Esa canción no está en ningún disco.");
			} else {
			    System.out.println("La canción aparece en:");
			    for (Object[] fila : lista) {
			        String disco = (String) fila[0];
			        String grupo = (String) fila[1];
			        System.out.println("- Disco: " + disco + " | Grupo: " + grupo);
			    }
			}


		}catch (Exception e) {
			e.printStackTrace();
		} finally { // SIEMPRE
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}

	}

}
