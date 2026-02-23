package ejercicios_HQL;

import java.util.List;
import java.util.Scanner;

import dao.DaoCompanyia;
import hibernate.UtilesHibernate;
import pojos.Companyia;

public class Ejercicio_F {

	public static void main(String[] args) {
		// DaoCompañia (buscar parametrizando la búsqueda) Listar
		// el teléfono y el fax de la compañía cuyo nombre te da el
		// usuario
		
		try {
			UtilesHibernate.openSession();
			DaoCompanyia daoCompanyia = new DaoCompanyia();
			
			
			Scanner sc = new Scanner(System.in);
			System.out.print("Nombre de la companyia: ");
			String nombre = sc.nextLine();
			
			Object[] parametrosCompanyia = daoCompanyia.buscarPorNombre(nombre);
					
			System.out.println("Telefono: " + parametrosCompanyia[0]);
			System.out.println("Fax: " + parametrosCompanyia[1]);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
		
	}

}
