package consultasHQL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.DaoCancion;
import dao.DaoClub;
import dao.DaoDisco;
import dao.DaoGrupo;
import hibernate.UtilesHibernate;
import pojosEsther.Artista;
import pojosEsther.Club;
import pojosEsther.Grupo;
import pojosEsther.Pertenece;

public class EjercicioM {

	public static void main(String[] args) {
		System.out.println("----- Ejercicio M: Listar los nombres de los artistas y su función en un grupo que introduzca el usuario. -----");
		try {
			// Abro la sesion // SIEMPRE
			UtilesHibernate.openSession();
			
			Scanner sc = new Scanner(System.in);
			// Recogo los daos correspondientes
			DaoGrupo daoGrupo = new DaoGrupo();
			
			
			// Recogo el grupo 
			System.out.println("Introduce el nombre del grupo: ");
			String nombre = sc.nextLine();
			List<Object[]> listaArtistas = daoGrupo.buscarNombreYFuncionArtistaPorGrupo(nombre);
			
			for (Object[] object : listaArtistas) {
				System.out.println("Nombre: " + object[0]);
				System.out.println("Funcion: " + object[1]);
				System.out.println("");
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // SIEMPRE
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
	}

}
