package repasoHQL;

import java.util.Scanner;

import dao.DaoClub;
import dao.DaoGrupo;
import hibernate.UtilesHibernate;
import pojos.Club;
import pojos.Grupo;

// 4. Comprueba que cuando se añade un grupo que toca en un club, la restricción de que un grupo no
// puede tocar en más de 3 clubs.

public class Ejercicio_4 {

	public static void main(String[] args) {
		
		try {
			
			UtilesHibernate.openSession();
			
			DaoGrupo daoGrupo = new DaoGrupo();
			DaoClub daoClub = new DaoClub();
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Introduce el nombre del grupo al que asociar el club: ");
			String nombreGrupo = sc.nextLine();
			
			Grupo grupo = daoGrupo.buscarPorNombre(nombreGrupo);
			Club club = daoClub.buscarPorId(1);
			
			daoGrupo.insertarGrupoMax3Clubs(nombreGrupo, club);
			
			
			for (Club cluv : grupo.getClubs()) {
				System.out.println(cluv.getNombre());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}	
		
	}

}
