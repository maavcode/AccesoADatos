package simulaco_HQL;

import java.util.List;
import java.util.Scanner;

import dao.DaoGrupo;
import hibernate.UtilesHibernate;

// Dado el nombre de un grupo (introducido por el usuario), mostrar: 

// El nombre de sus discos y el año de creación de cada disco

public class Ejercicio_3 {

	public static void main(String[] args) {
		
		try {
			
			UtilesHibernate.openSession();
			
			DaoGrupo daoGrupo = new DaoGrupo();
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Introduce el nombre del grupo: ");
			String nombreGrupo = sc.nextLine();
			
			List<Object[]> lista = daoGrupo.listarDiscosAñoPorNombre(nombreGrupo);
			
			System.out.println("\nDiscos del grupo " + nombreGrupo);
			
			for (Object[] fila : lista) {
				System.out.println("\nNombre disco: " + fila[0]);
				System.out.println("Fecha: " + fila[1].toString()+ "\n");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
	}

}
