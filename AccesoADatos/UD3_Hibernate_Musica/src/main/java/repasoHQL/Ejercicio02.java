package repasoHQL;


import java.util.List;
import java.util.Scanner;

import dao.DaoPertenece;
import hibernate.UtilesHibernate;

public class Ejercicio02 {

	public static void main(String[] args) {
		System.out.println("----- Ejercicio 2: Listar nombres de artistas que realizan una funcion y el nombre de su grupo -----");
		
		try {
			// Abro la sesion // SIEMPRE
			UtilesHibernate.openSession();
			
			DaoPertenece daoPertenece = new DaoPertenece();
			
			Scanner sc = new Scanner(System.in); 
			
			System.out.println("Introduce la funcion");
			String funcion = sc.nextLine();
			
			List<Object[]> listaArtistasYGrupo = daoPertenece.buscarArtistasYGrupoPorFuncion(funcion);
			
			System.out.println("Artistas con la funcion " + funcion);
			for (Object[] object : listaArtistasYGrupo) {
				System.out.println("Artista: " + object[0] + " | Grupo: " + object[1]);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally { // SIEMPRE
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}

	}

}
