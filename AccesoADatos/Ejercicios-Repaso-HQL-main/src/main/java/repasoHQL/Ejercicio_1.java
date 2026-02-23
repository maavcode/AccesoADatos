package repasoHQL;

import java.util.Scanner;

import dao.DaoArtista;
import dao.DaoGrupo;
import dao.DaoPertenece;
import hibernate.UtilesHibernate;
import pojos.Artista;
import pojos.Grupo;
import pojos.Pertenece;
import pojos.PerteneceId;

// 1. Dale una nueva función a un artista en un grupo. El usuario te facilitará el nombre del grupo al
// que va a pertenecer el artista, el nombre del artista y la función.

public class Ejercicio_1 {
	public static void main(String[] args) {

		try {
			
			UtilesHibernate.openSession();
			
			DaoGrupo daoGrupo = new DaoGrupo();
			DaoArtista daoArtista = new DaoArtista();
			DaoPertenece daoPertenece = new DaoPertenece();

			Scanner sc = new Scanner(System.in);
			
			System.out.print("Introduce el nombre del grupo: ");
			String nombreGrupo = sc.nextLine();
			Grupo grupo = new Grupo();
			grupo = daoGrupo.buscarPorNombre(nombreGrupo);
			
			System.out.print("Introduce el nombre del artista: ");
			String nombreArtista = sc.nextLine();
			Artista artista = new Artista();
			artista = daoArtista.buscarPorNombre(nombreArtista);
			
			PerteneceId perteneceId = new PerteneceId();
			perteneceId.setCod(grupo.getCod());
			perteneceId.setDni(artista.getDni());
			
			System.out.print("Introduce el nombre de la función: ");
			String nombreFuncion = sc.nextLine();
			
			Pertenece pertenece = new Pertenece();
			pertenece.setArtista(artista);
			pertenece.setGrupo(grupo);
			pertenece.setId(perteneceId);	
			pertenece.setFuncion(nombreFuncion);
			
			daoPertenece.grabarOActualizar(pertenece);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
	}
}
