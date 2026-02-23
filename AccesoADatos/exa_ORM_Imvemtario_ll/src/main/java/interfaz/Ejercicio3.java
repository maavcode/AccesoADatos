package interfaz;

import java.util.List;
import java.util.Scanner;

import dao.DaoArticulo;
import hibernate.UtilesHibernate;
import pojos.Articulo;

public class Ejercicio3 {

	public static void main(String[] args) {
		try {
			UtilesHibernate.openSession();

			DaoArticulo daoArticulo = new DaoArticulo();

			Scanner sc = new Scanner(System.in);

			System.out.println("Introduce el numSerie (Ejemplo: 2222222)");
			String numSerie = sc.nextLine();

			System.out.println("Introduce el id de un usuario para dar de alta el articulo (Ejemplo: 1)");
			String nomUsuario = sc.nextLine();

			System.out.println("Introduce el id del modelo articulo (Ejemplo: 2600)");
			Integer modelo = sc.nextInt();

			System.out.println("Introduce el espacio (Ejemplo: E209)");
			String espacio = sc.nextLine();

			daoArticulo.addArticulo(numSerie, nomUsuario, modelo, espacio);

		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}

	}

}
