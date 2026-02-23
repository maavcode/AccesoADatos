package repasoHQL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.DaoPertenece;
import hibernate.UtilesHibernate;
import pojos.Pertenece;

// Para una función (que realizan los artistas en los grupos). Listar el nombre de los artistas y el
// grupo en el que tocan realizando esa función.

public class Ejercicio_2 {

	public static void main(String[] args) {
		try {

			UtilesHibernate.openSession();

			DaoPertenece daoPertenece = new DaoPertenece();

			Scanner sc = new Scanner(System.in);

			System.out.print("Introduce la función del artista: ");
			String nombreFuncion = sc.nextLine();

			List<Pertenece> listaArtistasFuncion = new ArrayList();

			listaArtistasFuncion = daoPertenece.buscarPorFuncion(nombreFuncion);

			System.out.println("\nArtistas con la función de " + nombreFuncion + "\n");
			for (Pertenece pertenece : listaArtistasFuncion) {
				System.out.println(pertenece.getArtista().getNombre());
				System.out.println(pertenece.getGrupo().getNombre() + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
	}

}
