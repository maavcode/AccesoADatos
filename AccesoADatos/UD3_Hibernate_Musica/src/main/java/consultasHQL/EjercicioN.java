package consultasHQL;

import java.util.List;
import java.util.Scanner;

import dao.DaoCancion;
import dao.DaoClub;
import dao.DaoDisco;
import dao.DaoGrupo;
import hibernate.UtilesHibernate;

public class EjercicioN {

	public static void main(String[] args) {
		System.out.println("----- Ejercicio N: Listar los clubs(nombre) en los que tocan grupos (nombre) del país que indique el usuario.  -----");
		try {
			// Abro la sesion // SIEMPRE
			UtilesHibernate.openSession();
			
			Scanner sc = new Scanner(System.in);
			
			// Recogo los daos correspondientes
			DaoClub daoClub = new DaoClub();
			
			System.out.println("Introduce el pais: ");
			String pais = sc.nextLine();
			
			List<Object[]> listaGrupos = daoClub.buscarClubsYGruposPorPais(pais);
			
			for (Object[] object : listaGrupos) {
				System.out.println("Club: " + object[0]);
				System.out.println("Grupo: " + object[1]);
				System.out.println("");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // SIEMPRE
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
	}

}
