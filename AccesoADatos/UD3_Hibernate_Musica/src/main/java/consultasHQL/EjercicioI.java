package consultasHQL;

import java.util.List;
import java.util.Scanner;

import dao.DaoCancion;
import dao.DaoDisco;
import hibernate.UtilesHibernate;

public class EjercicioI {
	public static void main(String[] args) {
		System.out.println("----- Ejercicio I: Listar canciones y su titulo de un disco que te diga el usuario -----");
		try {
			// Abro la sesion // SIEMPRE
			UtilesHibernate.openSession();

			Scanner sc = new Scanner(System.in);
			
			DaoCancion daoCancion = new DaoCancion();
			DaoDisco daoDisco = new DaoDisco();
			
			System.out.println("Introduce el nombre del disco: ");
			String nombre = sc.nextLine();
			
			List<String> discoTitulosCanciones = daoDisco.buscarPorNombreParametrizado(nombre);
			
			
			for (String tituloCancion : discoTitulosCanciones) {
				System.out.println("Cancion: " + tituloCancion);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // SIEMPRE
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
	}
}
