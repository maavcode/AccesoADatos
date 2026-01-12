package consultasHQL;

import java.util.Scanner;

import dao.DaoClub;
import dao.DaoCompanyia;
import dao.DaoGrupo;
import hibernate.UtilesHibernate;
import pojosEsther.Club;
import pojosEsther.Companyia;
import pojosEsther.Grupo;

public class EjercicioB {

	public static void main(String[] args) {
		System.out.println("----- Ejercicio A: Insertar un nuevo Club con un grupo ya existente -----");
		try {
			// Abro la sesion // SIEMPRE
			UtilesHibernate.openSession();
			
			Scanner sc = new Scanner(System.in);
			
			// Recojo los DAOs correspondientes
			DaoClub daoClub = new DaoClub();
			DaoGrupo daoGrupo = new DaoGrupo();
			
			
			// Creo la nueva companyia
			System.out.println("Introduce el nombre del club");
			String nombre = sc.nextLine();
			System.out.println("Introduce la sede del club");
			String sede = sc.nextLine();
			System.out.println("Introduce el num del club");
			Short num = sc.nextShort();
			
			System.out.println("Como grupo se insertara: Mala Gestion");
			
			// CREAR UN METODO DaoGrupo BuscarPorNombre y obtener un grupo
			Grupo grupo = daoGrupo.buscarPorNombre("MalaGestion");
			// Creo el club
			Club club = new Club(grupo, nombre, sede, num);
			
			// Inserto la nueva companyia
			daoClub.grabar(club);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // SIEMPRE
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
	}
}
