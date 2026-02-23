package restriccionesHQL;

import java.util.Scanner;

import dao.DaoArtista;
import dao.DaoClub;
import dao.DaoGrupo;
import dao.DaoPertenece;
import hibernate.UtilesHibernate;
import pojosEsther.Artista;
import pojosEsther.Club;
import pojosEsther.Grupo;

public class EjercicioC {

	public static void main(String[] args) {
		
		try {
			UtilesHibernate.openSession();

			DaoGrupo daoGrupo = new DaoGrupo();
			DaoArtista daoArtista = new DaoArtista();

			Scanner sc = new Scanner(System.in);

			System.out.println("Introduce el nombre del grupo:");
			String nomGrupo = sc.nextLine();

			System.out.println("Introduce el nombre del artista:");
			String nomArtista = sc.nextLine();

			System.out.println("Introduce la función del artista en el grupo:");
			String funcion = sc.nextLine();
			
			daoGrupo.addArtistaAGrupo(nomGrupo, nomArtista, funcion);
		    System.out.println("Artista añadido correctamente.");

		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}

	}

}
