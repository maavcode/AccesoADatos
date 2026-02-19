package repasoHQL;

import java.util.Scanner;

import dao.DaoArtista;
import dao.DaoGrupo;
import dao.DaoPertenece;
import hibernate.UtilesHibernate;
import pojosEsther.Artista;
import pojosEsther.Grupo;
import pojosEsther.Pertenece;

public class Ejercicio01 {

	public static void main(String[] args) {
		System.out.println("----- Ejercicio 1: Modificar Funcion a Artista de un Grupo -----");
		
		try {
			// Abro la sesion // SIEMPRE
			UtilesHibernate.openSession();
			
			DaoPertenece daoPertenece = new DaoPertenece();
			DaoGrupo daoGrupo = new DaoGrupo();
			DaoArtista daoArtista = new DaoArtista();
			
			Scanner sc = new Scanner(System.in); 
			
			System.out.println("Introduce el nombre del grupo");
			String nomGrupo = sc.nextLine();
			Grupo grupo = daoGrupo.buscarPorNombre(nomGrupo);
			
			System.out.println("Introduce el nombre del artista");
			String nomArtista = sc.nextLine();
			Artista artista = daoArtista.buscarPorNombre(nomArtista);
			
			Pertenece pertenece = daoPertenece.buscarPorGrupoYArtista(grupo, artista);
			if (pertenece == null) { 
				System.out.println("Ese artista NO pertenece a ese grupo."); 
				return; 
			}
			
			System.out.println("Introduce la funcion nueva");
			String funcion = sc.nextLine();
			
			pertenece.setFuncion(funcion);
			
			daoPertenece.actualizar(pertenece);
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally { // SIEMPRE
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}

	}

}
