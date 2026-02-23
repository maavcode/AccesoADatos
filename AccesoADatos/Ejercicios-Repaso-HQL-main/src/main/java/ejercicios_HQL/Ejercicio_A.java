package ejercicios_HQL;

import java.util.Scanner;

import dao.DaoCompanyia;
import hibernate.UtilesHibernate;
import pojos.Companyia;

public class Ejercicio_A {

	public static void main(String[] args) {
		// Crea una nueva compañía, los valores de los datos que
		// necesites (nombre,dir, fax, tlf…) los introduce el usuario, al
		// ser una compañía nueva no tendrá lista de discos.
		
		try {
			UtilesHibernate.openSession();
			DaoCompanyia daoCompanyia = new DaoCompanyia();
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("-- INSERTAR NUEVA COMPANYIA --\n");
			
			System.out.print("Nombre: ");
			String nombre = sc.nextLine();
			System.out.print("Direccion: ");
			String direccion = sc.nextLine();
			System.out.print("Fax: ");
			String fax = sc.nextLine();
			System.out.print("Telefono: ");
			String telefono = sc.nextLine();
			
			Companyia companyia = new Companyia(nombre, direccion, fax, telefono, null);
			
			daoCompanyia.grabar(companyia);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
	}

}
