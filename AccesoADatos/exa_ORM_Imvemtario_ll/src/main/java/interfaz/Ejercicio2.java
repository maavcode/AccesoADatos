package interfaz;

import java.util.Scanner;

import dao.DaoArticulo;
import hibernate.UtilesHibernate;

public class Ejercicio2 {

	public static void main(String[] args) {
		try {
			UtilesHibernate.openSession();
			
			DaoArticulo daoArticulo = new DaoArticulo();
			
			daoArticulo.ModificarArticulosTipo36();

		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}

	}

}
