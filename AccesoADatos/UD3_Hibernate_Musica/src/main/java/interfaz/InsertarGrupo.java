package interfaz;

import java.util.List;
import java.util.Scanner;

import dao.DaoDisco;
import dao.DaoGrupo;
import hibernate.UtilesHibernate;
import pojosEsther.Disco;
import pojosEsther.Grupo;

public class InsertarGrupo {

	public static void main(String[] args) {
		try {
			// Abro la sesion y declaro el dao a usar // SIEMPRE
			UtilesHibernate.openSession();
			DaoGrupo daoGrupo = new DaoGrupo();
			
			Scanner sc = new Scanner(System.in);
			
			// Leo el nombre del grupo
			System.out.println("Introduce el nombre del Grupo");
			String nombre = sc.nextLine();
			
			// Creo el grupo con los datos aportados
			Grupo grupoNuevo = new Grupo(nombre);
			
			// Inserto el grupo
			daoGrupo.grabar(grupoNuevo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // SIEMPRE
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
	}

}
