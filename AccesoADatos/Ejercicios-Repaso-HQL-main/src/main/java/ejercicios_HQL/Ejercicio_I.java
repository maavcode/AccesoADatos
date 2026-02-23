package ejercicios_HQL;

import java.util.List;
import java.util.Scanner;

import dao.DaoCompanyia;
import dao.DaoDisco;
import hibernate.UtilesHibernate;
import pojos.Companyia;

public class Ejercicio_I {

	public static void main(String[] args) {
		// DaoDisco Listar las canciones (titulo) de un disco cuyo
		// nombre te diga el usuario 
		
		try {
			UtilesHibernate.openSession();
			DaoDisco daoDisco = new DaoDisco();
			
			Scanner sc = new Scanner(System.in);
			System.out.print("Nombre del disco: ");
			String nombre = sc.nextLine();
			
			List<String> listaTitulos = daoDisco.buscarCanciones_Disco(nombre);
			
			for (String string : listaTitulos) {
				System.out.println(string);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
	}

}
