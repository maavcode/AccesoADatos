package restriccionesHQL;

import java.util.Scanner;

import dao.DaoClub;
import dao.DaoGrupo;
import hibernate.UtilesHibernate;
import pojosEsther.Club;
import pojosEsther.Grupo;

public class EjercicioB {

	public static void main(String[] args) {
		try {
			UtilesHibernate.openSession();

			DaoGrupo daoGrupo = new DaoGrupo();
			DaoClub daoClub = new DaoClub();

			Scanner sc = new Scanner(System.in);

			System.out.println("Introduce el nombre del grupo:");
			String nomGrupo = sc.nextLine();
			Grupo grupo = daoGrupo.buscarPorNombre(nomGrupo);

			if (grupo == null) {
				System.out.println("No existe ese grupo.");
				return;
			}

			System.out.println("Introduce el nombre del club:");
			String nomClub = sc.nextLine();
			Club club = daoClub.buscarPorNombre(nomClub);

			if (club == null) {
				System.out.println("No existe ese club.");
				return;
			}

			daoGrupo.addClubAGrupo(grupo, club);
			
			System.out.println("Club añadido correctamente.");

		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}

	}

}
