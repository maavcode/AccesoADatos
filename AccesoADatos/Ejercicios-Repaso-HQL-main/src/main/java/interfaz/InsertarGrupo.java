package interfaz;

import java.util.Scanner;

import dao.DaoDisco;
import dao.DaoGenericoHibernate;
import dao.DaoGrupo;
import hibernate.UtilesHibernate;
import pojos.Disco;
import pojos.Grupo;

public class InsertarGrupo {

	public static void main(String[] args) { 
		try {
			UtilesHibernate.openSession();
			DaoGrupo daoGrupo = new DaoGrupo();
		
			Scanner sc = new Scanner(System.in);
			System.out.print("Nombre del grupo: ");
			String nombre = sc.nextLine();
			
			Grupo grupo = new Grupo(nombre);
			
			daoGrupo.grabar(grupo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
	}

}
