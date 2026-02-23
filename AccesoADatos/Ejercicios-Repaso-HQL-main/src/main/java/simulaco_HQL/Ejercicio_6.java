package simulaco_HQL;

import java.util.Scanner;

import dao.DaoClub;
import hibernate.UtilesHibernate;
import pojos.Club;

// Crear un nuevo club:

// El nombre y sede los introduce el usuario.
// El grupo que toca en ese club debe existir.

public class Ejercicio_6 {

	public static void main(String[] args) {
		
		try {
			
			UtilesHibernate.openSession();
			
			DaoClub daoClub = new DaoClub();
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("\n-- CREAR NUEVO CLUB --\n");
			System.out.print("Introduce el nombre del nuevo club: ");
			String nombreClub = sc.nextLine();
			
			System.out.print("\nIntroduce el nombre de la sede: ");
			String nombreSede = sc.nextLine();
			
			System.out.print("\nIntroduce el nombre del grupo: ");
			String nombreGrupo = sc.nextLine();
			
			Club club = new Club();
			
			club.setNombre(nombreClub);
			club.setSede(nombreSede);
			
			daoClub.insertarClubGrupoExistente(club, nombreGrupo);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
	}

}
