package consultasHQL;

import java.util.List;
import java.util.Scanner;

import dao.DaoCompanyia;
import hibernate.UtilesHibernate;
import pojosEsther.Companyia;

public class EjercicioF {
	public static void main(String[] args) {
		System.out.println("----- Ejercicio F: Buscar parametrizando, listar el telefono y fax de la companya que da el usuario -----");
		try {
			// Abro la sesion // SIEMPRE
			UtilesHibernate.openSession();

			Scanner sc = new Scanner(System.in);
			
			DaoCompanyia daoCompanyia = new DaoCompanyia();
			
			System.out.println("Introduce el nombre de la companyia:");
			String nombre = sc.nextLine();
			
			// CREO EL METODO PARA BUSCAR POR NOMBRE DE FORMA PARAMETRIZADA
			Object[] companyiaParametrizada = daoCompanyia.buscarPorNombreParametrizado(nombre);
			
			System.out.println("Companyia " + nombre + " | Telefono - " + companyiaParametrizada[0] + " | Fax - " + companyiaParametrizada[1]);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // SIEMPRE
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
	}
}
