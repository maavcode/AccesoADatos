package ejercicios_HQL;

import java.util.Scanner;

import dao.DaoClub;
import dao.DaoCompanyia;
import dao.DaoGrupo;
import hibernate.UtilesHibernate;
import pojos.Club;
import pojos.Companyia;
import pojos.Grupo;

public class Ejercicio_B {

	public static void main(String[] args) {
		// Crea un nuevo club, los valores de los datos que necesites
		// (nombre, sede …) los introduce el usuario, el grupo que toca
		// en el club será un grupo que ya exista en la Base de Datos.
		// HQL
		
		try {
			UtilesHibernate.openSession();
			DaoClub daoClub = new DaoClub();
			DaoGrupo daoGrupo = new DaoGrupo();
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("-- INSERTAR NUEVO CLUB --\n");
			
			System.out.print("Nombre: ");
			String nombre = sc.nextLine();
			System.out.print("Sede: ");
			String sede = sc.nextLine();
			System.out.print("Num: ");
			Short num = sc.nextShort();
			System.out.print("ID del grupo: ");
			Integer idGrupo = sc.nextInt();
			
			Grupo grupo = daoGrupo.buscarPorId(idGrupo);
			
			Club club = new Club(grupo, nombre, sede, num);
			
			daoClub.grabar(club);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
	}

}
