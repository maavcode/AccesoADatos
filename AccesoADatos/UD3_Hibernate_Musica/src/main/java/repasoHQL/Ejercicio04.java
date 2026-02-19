package repasoHQL;

import java.util.Scanner;

import dao.DaoClub;
import dao.DaoGrupo;
import hibernate.UtilesHibernate;
import pojosEsther.Club;
import pojosEsther.Grupo;

public class Ejercicio04 {

	public static void main(String[] args) {
		System.out.println("----- Ejercicio 4: : Comprobar al añadir Grupo en un Club, que un Grupo no pueda tocar en más de 3 Clubs -----");
		
		try {
			// Abro la sesion // SIEMPRE
			UtilesHibernate.openSession();
			
			DaoGrupo daoGrupo = new DaoGrupo();
			DaoClub daoClub = new DaoClub();
			
			Scanner sc = new Scanner(System.in); 
			
			System.out.println("Introduce el nombre del grupo");
			String nomGrupo = sc.nextLine();
			Grupo grupo = daoGrupo.buscarPorNombre(nomGrupo);
			
			System.out.println("Introduce el nombre del club en el que va a empezar a tocar");
			String nomClub = sc.nextLine();
			Club club = daoClub.buscarPorNombre(nomClub);
			
			daoGrupo.addClubAGrupo(grupo, club);
			
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally { // SIEMPRE
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}

	}

}
