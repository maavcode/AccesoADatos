package interfaz;

import java.util.List;
import java.util.Scanner;

import dao.DaoArticulo;
import dao.DaoDepartamento;
import hibernate.UtilesHibernate;

public class Ejercicio1 {

	public static void main(String[] args) {
		try {
			UtilesHibernate.openSession();
			
			// Ejercicio A
			DaoDepartamento daoDepartamento = new DaoDepartamento();

			Scanner sc = new Scanner(System.in);

			System.out.println("Introduce el nombre de un departamento (Ejemplo: Comunicacion Imagen y Sonido)");
			String nomDepartamento = sc.nextLine();
			
			List<Object[]>listaInforme =daoDepartamento.obtenerInformeArticulosDadosAltaPorDepartamento(nomDepartamento);
			
			for (Object[] object : listaInforme) {
				System.out.println("Estado: " + object[0] + " | "  + object[1] + " " + object[2]);
			}
			
			// Ejercicio B
			DaoArticulo daoArticulo = new DaoArticulo();
			
			System.out.println("Introduce el id de articulo (Ejemplo: 679)");
			Integer id = sc.nextInt();
			
			Integer numPrestado = daoArticulo.obtenerVecesPrestadoPorArticulo(id);
			if (numPrestado != null) {
				System.out.println("El articulo ha sido prestado " + numPrestado + " veces.");
			}
			
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
		

	}

}
