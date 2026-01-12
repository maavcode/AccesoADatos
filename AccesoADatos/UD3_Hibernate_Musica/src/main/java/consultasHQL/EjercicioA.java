package consultasHQL;

import java.util.Scanner;

import dao.DaoCompanyia;
import hibernate.UtilesHibernate;
import pojosEsther.Companyia;

public class EjercicioA {

	public static void main(String[] args) {
		System.out.println("----- Ejercicio A: Insertar una nueva Companyia -----");
		try {
			// Abro la sesion // SIEMPRE
			UtilesHibernate.openSession();
			
			Scanner sc = new Scanner(System.in);
			
			// Recojo el daoCompanyia
			DaoCompanyia daoCompanyia = new DaoCompanyia();
			
			// Creo la nueva companyia
			System.out.println("Introduce el nombre de la companyia");
			String nombre = sc.nextLine();
			System.out.println("Introduce el dir de la companyia");
			String dir = sc.nextLine();
			System.out.println("Introduce el fax de la companyia");
			String fax = sc.nextLine();
			System.out.println("Introduce el telefono de la companyia");
			String telefono = sc.nextLine();
			Companyia companyia = new Companyia(nombre, dir, fax, telefono, null);
			
			// Inserto la nueva companyia
			daoCompanyia.grabar(companyia);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // SIEMPRE
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
	}

}
