package interfaz;

import java.util.Scanner;

import dao.DaoArtista;
import hibernate.UtilesHibernate;
import pojos.Artista;

public class buscarPorNombre {

	public static void main(String[] args) {
		
		Artista artista =  new Artista();
		
		try { // Conectamos a la BD
			UtilesHibernate.openSession();
			DaoArtista daoArtista = new DaoArtista();
			
			// Leemos datos de la interfaz
			Scanner sc = new Scanner(System.in);
			System.out.println("Introduce el nombre del Artista");
			String nombre = sc.nextLine();
			
			// Buscar en la BD
			artista = daoArtista.buscarPorNombre(nombre);
			
			// Mostrar resultado
			System.out.println(artista.getDni());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
		
	}
}
