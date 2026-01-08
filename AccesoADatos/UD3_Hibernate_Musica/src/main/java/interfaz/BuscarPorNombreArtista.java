package interfaz;

import java.util.Scanner;

import dao.DaoArtista;
import hibernate.UtilesHibernate;
import pojosEsther.Artista;

public class BuscarPorNombreArtista {

	public static void main(String[] args) {
		
		try {
			// Abro la sesion y declaro el dao a usar // SIEMPRE
			UtilesHibernate.openSession();
			DaoArtista daoArtista = new DaoArtista();
			
			// Leo el nombre del artista seleccionado
			Scanner sc = new Scanner(System.in);
			System.out.println("Introduce el nombre del Artista");
			String nombre = sc.nextLine();
			
			// Busco en la BD usando el metodo buscarPorNombre y lo muestro
			Artista artista= daoArtista.buscarPorNombre(nombre);
			System.out.println("Artista " + artista.getNombre() + " con DNI " + artista.getDni());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // SIEMPRE
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}

	}

}
